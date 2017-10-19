package cn.org.tpri.www.overload.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import cn.org.tpri.www.overload.R;

/**
 * 作者:丁文 on 2017/3/14.
 * copyright: www.tpri.org.cn
 */

public class refreshlistviewUtils extends ListView {
    private static final int PULLDOWN_STATE = 0;
    private static final int RELSEASE_STATE = 1;// 松开刷新状态
    private static final int REFRESHING_STATE = 2;// 下拉刷新状态
    private View header;
    private RotateAnimation up;
    private RotateAnimation down;
    private View footer;
    private int footerMeasuredHeight;
    private boolean isloadMore = false;
    private OnRefreshingListener listener;
    private int down_y = -1;
    private int headerMeasuredHeight;
    private int current_state = PULLDOWN_STATE;
    private ProgressBar pbHeaderProgress;

    private ImageView ivHeaderArrow;
    private TextView tvHeaderState;
    private TextView tvHeaderTime;

    public refreshlistviewUtils(Context context, AttributeSet attrs) {
        super(context, attrs);
        addHeader();
        initanimate();
        addFooter();
    }
    private void addFooter() {
        footer = View.inflate(getContext(), R.layout.refresh_footer, null);
        footer.measure(0, 0);
        footerMeasuredHeight = footer.getMeasuredHeight();
        footer.setPadding(0, -footerMeasuredHeight, 0, 0);
        addFooterView(footer);
        setOnScrollListener(new MyOnScrollListener());
    }
    private void initanimate() {
        up = new RotateAnimation(0, -180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        up.setDuration(500);
        up.setFillAfter(true);
        down = new RotateAnimation(-180, -360, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        down.setDuration(500);
        down.setFillAfter(true);
    }
    private void addHeader() {
        header = View.inflate(getContext(), R.layout.refresh_header, null);
        pbHeaderProgress = (ProgressBar) header.findViewById(R.id.pb_header_progress);
        ivHeaderArrow = (ImageView) header.findViewById(R.id.iv_header_arrow);
        tvHeaderState = (TextView) header.findViewById(R.id.tv_header_state);
        tvHeaderTime = (TextView) header.findViewById(R.id.tv_header_time);

        header.measure(0, 0);
        headerMeasuredHeight = header.getMeasuredHeight();
        header.setPadding(0, -headerMeasuredHeight, 0, 0);
        addHeaderView(header);
    }
    private class MyOnScrollListener implements OnScrollListener {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (OnScrollListener.SCROLL_STATE_IDLE == scrollState
                    || OnScrollListener.SCROLL_STATE_FLING == scrollState) {

                if (getLastVisiblePosition() == getCount() - 1 && !isloadMore) {
                    isloadMore = true;
                    footer.setPadding(0, 0, 0, 0);
                    setSelection(getCount());
                    if (listener != null) {
                        listener.onLoadingMore();
                    }
                }
            }
        }
        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        }
    }
    public interface OnRefreshingListener {
        void onRefreshing();

        void onLoadingMore();
    }
    public void setOnrefreshingListener(OnRefreshingListener listener) {
        this.listener = listener;
    }
    public void refreshFinished(boolean b) {
        current_state = PULLDOWN_STATE;
        pbHeaderProgress.setVisibility(View.INVISIBLE);
        ivHeaderArrow.setVisibility(View.VISIBLE);
        tvHeaderState.setText("下拉刷新");
        header.setPadding(0, -headerMeasuredHeight, 0, 0);
        if (b) {
            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = dateFormat.format(new Date());
            tvHeaderTime.setText("正在刷新"+time);
        } else {
            Toast.makeText(getContext(), "网络访问出错了", Toast.LENGTH_SHORT).show();
        }
    }
    public void loadMoreFinished() {
        isloadMore = false;
        footer.setPadding(0, -footerMeasuredHeight, 0, 0);
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                down_y = (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) ev.getY();
                if (down_y == -1) {
                    down_y = (int) ev.getY();
                }
                // 计算手指移动的距离
                int diffY = moveY - down_y;
                // 当轮播图完全展示时，才能处理事件
                if (getFirstVisiblePosition() != 0) {
                    down_y = (int) ev.getY();
                    break;
                }
                if (diffY > 0) {// 只处理从上往下滑动
                    // 计算头布局距离顶部的Padding值 topPadding = 手指移动的距离 - 头布局的高度
                    int topPadding = diffY - headerMeasuredHeight;

                    // 根据topPadding，判断控件是否完全展示
                    if (topPadding < 0 && current_state != PULLDOWN_STATE) {// 切换到下拉刷新状态
                        current_state = PULLDOWN_STATE;
                        changeState();
                    } else if (topPadding > 0 && current_state != RELSEASE_STATE) {// 切换到松开刷新
                        current_state = RELSEASE_STATE;
                        changeState();
                    }

                    // 通过设置头布局的顶部Padding值，达到移动头布局的效果
                    header.setPadding(0, topPadding, 0, 0);
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                down_y = -1;
                if (current_state == PULLDOWN_STATE) {
                    header.setPadding(0, -headerMeasuredHeight, 0, 0);
                } else if (current_state == RELSEASE_STATE) {
                    // 切换到正在刷新状态
                    header.setPadding(0, 0, 0, 0);
                    current_state = REFRESHING_STATE;
                    changeState();
                    // 当处于正在刷新时，调用外界监听器的刷新方法
                    if (listener != null) {
                        listener.onRefreshing();
                    }
                }
                break;
            default:
                break;
        }
        return super.onTouchEvent(ev);
    }
    private void changeState() {
        switch (current_state) {
            case PULLDOWN_STATE:
                pbHeaderProgress.setVisibility(View.INVISIBLE);
                ivHeaderArrow.setVisibility(View.VISIBLE);
                tvHeaderState.setText("下拉刷新");
                ivHeaderArrow.startAnimation(down);
                break;
            case RELSEASE_STATE:
                tvHeaderState.setText("松开刷新");
                ivHeaderArrow.startAnimation(up);
                break;
            case REFRESHING_STATE:
                // 清除动画
                ivHeaderArrow.clearAnimation();
                pbHeaderProgress.setVisibility(View.VISIBLE);
                ivHeaderArrow.setVisibility(View.INVISIBLE);
                tvHeaderState.setText("正在刷新");
                break;
            default:
                break;
        }
    }
}