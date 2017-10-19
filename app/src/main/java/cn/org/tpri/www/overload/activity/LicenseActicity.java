package cn.org.tpri.www.overload.activity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.io.FileOutputStream;

import cn.org.tpri.www.overload.R;
import cn.org.tpri.www.overload.bean.MapBean;
import cn.org.tpri.www.overload.utils.Constant;
import cn.org.tpri.www.overload.utils.JsonUtil;
import cn.org.tpri.www.overload.utils.LogUtils;
import cn.org.tpri.www.overload.utils.SharedPreferencesTool;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.utils.StringUtils;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import okhttp3.Call;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * 作者:丁文 on 2017/2/8.
 * copyright: www.tpri.org.cn
 */
public class LicenseActicity extends AppCompatActivity {
    private static final int ISFIRST = 3;
    private OnShownListener mShownListener;
    private OnHiddenListener mHiddenListener;
    private static final int sDefaultTimeout = 3000;
    private static final int SHOW_PROGRESS = 2;
    private static final int FADE_OUT = 1;
    private TextView site_name;
    private TextView number;
    private TextView check_weight;
    private TextView limitweight;
    private TextView overload;
    private TextView checked_time;
    private PhotoView iv1;
    private PhotoView iv2;
    private PhotoView iv3;
    private PhotoView iv4;
    private PhotoViewAttacher pv1;
    private PhotoViewAttacher pv2;
    private PhotoViewAttacher pv3;
    private PhotoViewAttacher pv4;
    private VideoView videoView;
    private TextView tv;
    private View view;
    private FrameLayout rl_videoview;
    private ImageView videoIV;
    private ImageView back_img;
    private LinearLayout media_control_linear;
    private ImageButton start;
    private TextView mCurrentTime;
    private SeekBar mProgress;
    private TextView mEndTime;
    private Boolean isFirststart = true;
    private long mDuration;
    private boolean mDragging;
    private boolean mFromXml;
    private AudioManager mAM;
    private boolean mShowing;
    private MediaController mediaController;
    private ProgressBar pb;

    @Override
    protected void onDestroy() {
        videoView.stopPlayback();
        super.onDestroy();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(this);
        setContentView(R.layout.activity_license);
        initView();
        initData();
    }

    private void initData() {
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Intent intent = getIntent();
        String mapKey = intent.getStringExtra("mapKey");
        String tv_car_license1 = intent.getStringExtra("tv_car_license");
        String check_address1 = intent.getStringExtra("check_address");
        String check_time1 = intent.getStringExtra("check_time");
        String check_weight1 = intent.getStringExtra("check_weight");
        String limit_weight1 = intent.getStringExtra("limit_weight");
        String overload_rate1 = intent.getStringExtra("overload_rate");
        String video = intent.getStringExtra("video");


        site_name.setText("站点名称:" + "    " + check_address1);
        number.setText(tv_car_license1 == null ? "" : tv_car_license1);
        check_weight.setText("初检车重:" + "    " + check_weight1 + "kg");
        limitweight.setText("车辆限重:" + "    " + limit_weight1 + "kg");
        overload.setText(overload_rate1 + "%");
        checked_time.setText("初检时间:" + "    " + check_time1);

//        ForegroundColorSpan red = new ForegroundColorSpan(Color.BLACK);
//        SpannableString builder1 = new SpannableString(site_name.getText());
//        builder1.setSpan(red, 0, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        site_name.setText(builder1);


        if (mapKey == null) {
            iv1.setImageResource(R.mipmap.nodata_pic);
            pb.setVisibility(View.GONE);
            iv2.setImageResource(R.mipmap.nodata_pic);
            iv3.setImageResource(R.mipmap.nodata_pic);
            iv4.setImageResource(R.mipmap.nodata_pic);

        } else {
            final ImageView[] iv = new ImageView[]{iv1, iv2, iv3, iv4};

            int length = mapKey.split(",").length;
            if (length < 4) {
                for (int j = 0; j < (4 - length); j++) {
                    mapKey = mapKey + ",abc";
                }
            }
            for (int i = 0; i < 4; i++) {
                final int finalI = i;
                OkHttpUtils.post()
                        .url(SharedPreferencesTool.getString(this, "SERVER_PATH", "") + Constant.image_url)
                        .addParams("key", mapKey.split(",")[i])
                        .addParams("sysCode", Constant.sysCode)
                        .addParams("authCert", Constant.authCert)
                        .addParams("startTime", check_time1)
                        .build().execute(new StringCallback() {

                    private byte[] decodeMap;

                    @Override
                    public void onError(Call call, Exception e, int id) {
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        MapBean map = JsonUtil.parseObject(response, MapBean.class);
                        if (map.getCode().equals("0000")) {
                            decodeMap = Base64.decode(map.getData().getData(), Base64.DEFAULT);
                        } else {
                            decodeMap = new byte[]{1, 2, 3};
                        }
                        Glide.with(getApplicationContext())
                                .load(decodeMap)
                                .error(R.mipmap.nodata_pic)
                                .centerCrop()
                                .into(iv[finalI]);
                        if (finalI == 0){
                            pb.setVisibility(View.GONE);
                        }
                    }
                });
            }
        }

        /*
        视频数据加载
         */
        if (video != null) {
            videoView.setVisibility(View.VISIBLE);
            tv.setVisibility(View.GONE);
            LogUtils.i("视频", SharedPreferencesTool.getString(this, "SERVER_PATH", "") + Constant.image_url);
            LogUtils.i("key", video);
            LogUtils.i("sysCode", Constant.sysCode);
            LogUtils.i("authCert", Constant.authCert);
            LogUtils.i("startTime", check_time1);

            OkHttpUtils.post()
                    .url(SharedPreferencesTool.getString(this, "SERVER_PATH", "") + Constant.image_url)
                    .addParams("key", video)
                    .addParams("sysCode", Constant.sysCode)
                    .addParams("authCert", Constant.authCert)
                    .addParams("startTime", check_time1)
                    .build().execute(new StringCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                }

                @Override
                public void onResponse(String response, int id) {
                    MapBean map = JsonUtil.parseObject(response, MapBean.class);
                    if (map.getData() != null) {
                        byte[] decodeMap = Base64.decode(map.getData().getData(), Base64.DEFAULT);
                        try {

//                            String filename = "/rec" + "_" + "video.mp4";
                            String filename = "站点视频.mp4";
                            String root = Environment.getExternalStorageDirectory().toString();
                            File myDir = new File(root + "/ZhiChao");
                            if (!myDir.exists()) {
                                myDir.mkdir();
                            }
                            File file = new File(myDir, filename);
                            FileOutputStream out = new FileOutputStream(file);
                            out.write(decodeMap);
                            out.close();

                            final Uri video = Uri.parse(file.getPath());
                            videoView.setVideoURI(video);
//                            mediaController = new MediaController(LicenseActicity.this);
                            videoView.setMediaController(mediaController);
//                            videoView.setMediaController(mediaController);

                            setInstantSeeking(true);

                            videoView.setVideoLayout(VideoView.VIDEO_LAYOUT_SCALE, 0);
//                        videoView.requestFocus();
                            videoView.setFocusable(false);
                            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                @Override
                                public void onPrepared(MediaPlayer mp) {
                                    mp.setPlaybackSpeed(1.0f);
                                    videoIV.setVisibility(View.VISIBLE);

                                }
                            });

                            //==========图片点击播放

                            videoIV.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
//                                    videoView.start();
                                    videoIV.setVisibility(View.GONE);
                                    start.setBackgroundResource(R.mipmap.vedio_pause);
                                    doPauseResume();
                                    show(sDefaultTimeout);
                                }
                            });

                            //=======视频播放完成监听事件
                            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    setBeginView();
                                    mp.seekTo(0L);
                                    videoIV.setVisibility(View.VISIBLE);
                                    isFirststart = true;
                                    mHandler.removeMessages(SHOW_PROGRESS);
                                    mHandler.removeMessages(FADE_OUT);
                                }
                            });

                            videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                                @Override
                                public boolean onInfo(MediaPlayer mp, int what, int extra) {

                                    return false;
                                }
                            });

                            /**
                             * 视频点击效果
                             */
                            videoView.setOnTouchListener(new View.OnTouchListener() {
                                @Override
                                public boolean onTouch(View v, MotionEvent event) {

                                    show(sDefaultTimeout);

                                    return false;
                                }
                            });

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        rl_videoview.setVisibility(View.GONE);
                        tv.setVisibility(View.VISIBLE);
                    }

                }
            });
        } else {
            rl_videoview.setVisibility(View.GONE);
            tv.setVisibility(View.VISIBLE);
        }
        site_name.setFocusable(true);
        site_name.setFocusableInTouchMode(true);
        site_name.requestFocus();
    }

    public void show(int timeout) {
        if (!mShowing) {
            if (start != null) {
                start.requestFocus();
            }
            if (mFromXml) {
                media_control_linear.setVisibility(View.VISIBLE);
            }
            mShowing = true;
            if (mShownListener != null) {
                mShownListener.onShown();
            }
        }
        updatePausePlay();
        mHandler.sendEmptyMessage(SHOW_PROGRESS);

        if (timeout != 0) {
            mHandler.removeMessages(FADE_OUT);
            mHandler.sendMessageDelayed(mHandler.obtainMessage(FADE_OUT), timeout);
        }
    }

    private void updatePausePlay() {
        if (start == null)
            return;
        if (videoView.isPlaying())
            start.setBackgroundResource(R.mipmap.vedio_pause);
        else
            start.setBackgroundResource(R.mipmap.vedio_play);
    }

    public interface OnShownListener {
        public void onShown();
    }

    public interface OnHiddenListener {
        public void onHidden();
    }

    private void setBeginView() {
        videoView.pause();
        mProgress.setProgress(0);
        mCurrentTime.setText("00:00");
        start.setBackgroundResource(R.mipmap.vedio_play);
    }

    public void setInstantSeeking(boolean seeking) {
        boolean mInstantSeeking = seeking;

    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            long pos;
            switch (msg.what) {
                case FADE_OUT:
                    hide();
                    break;
                case ISFIRST:
                    isFirststart = false;
                    break;
                case SHOW_PROGRESS:
                    pos = setProgress();
                    if (!mDragging && mShowing) {
                        msg = obtainMessage(SHOW_PROGRESS);
                        sendMessageDelayed(msg, 1000 - (pos % 1000));
                        updatePausePlay();
                    }
                    break;
            }
        }
    };

    private void hide() {
        if (mShowing) {

            try {
                mHandler.removeMessages(SHOW_PROGRESS);

                if (mFromXml) {
                    media_control_linear.setVisibility(View.GONE);
                } else
                    media_control_linear.setVisibility(View.GONE);
            } catch (IllegalArgumentException ex) {
            }
            mShowing = false;
            if (mHiddenListener != null)
                mHiddenListener.onHidden();
        }
    }

    private long setProgress() {
        if (videoView == null || mDragging) {
            return 0;
        }
        long position = videoView.getCurrentPosition();
        long duration = videoView.getDuration();
        if (mProgress != null) {
            if (duration > 0) {
                long pos = 1000L * position / duration;
                mProgress.setProgress((int) pos);
            }
            int percent = videoView.getBufferPercentage();
            mProgress.setSecondaryProgress(percent * 10);
        }
        mDuration = duration;

        if (mEndTime != null)
            if (StringUtils.generateTime(mDuration).endsWith("00:00")) {
                mEndTime.setVisibility(View.INVISIBLE);
            } else {
                mEndTime.setVisibility(View.VISIBLE);
                mEndTime.setText(StringUtils.generateTime(mDuration));
            }
        if (mCurrentTime != null)
            mCurrentTime.setText(StringUtils.generateTime(position));

        return position;
    }


    private void initView() {
        view = View.inflate(this, R.layout.activity_license, null);
        tv = (TextView) findViewById(R.id.activity_license_tv);
        videoView = (VideoView) findViewById(R.id.activity_license_surface_view);
        site_name = (TextView) findViewById(R.id.activity_license_site_name);
        number = (TextView) findViewById(R.id.activity_license_number);
        check_weight = (TextView) findViewById(R.id.activity_license_check_weight);
        limitweight = (TextView) findViewById(R.id.activity_license_limitweight);
        overload = (TextView) findViewById(R.id.activity_license_overload);
        checked_time = (TextView) findViewById(R.id.activity_license_checked_time);
        rl_videoview = (FrameLayout) findViewById(R.id.activity_license_rl_videoview);
        videoIV = (ImageView) findViewById(R.id.activity_license_videoIV);
        back_img = (ImageView) findViewById(R.id.activity_license_iv);
        pb = (ProgressBar) findViewById(R.id.activity_license_pb1);

        mediaController = (MediaController) findViewById(R.id.meia_controller);
/*
视频播放进度条
 */
        media_control_linear = (LinearLayout) findViewById(R.id.media_control_linear);
        start = (ImageButton) findViewById(R.id.start);
        mCurrentTime = (TextView) findViewById(R.id.load_rate);
        mProgress = (SeekBar) findViewById(R.id.mediacontroller_progress);
        mEndTime = (TextView) findViewById(R.id.load_total);
        mEndTime.setVisibility(View.INVISIBLE);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFirststart) {
                    videoIV.setVisibility(View.GONE);
                    mHandler.sendEmptyMessage(ISFIRST);
                }
                doPauseResume();
                show(sDefaultTimeout);
            }
        });
        mProgress.setOnSeekBarChangeListener(mSeekListener);
        mProgress.setMax(1000);
        mFromXml = true;
        mAM = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


        iv1 = (PhotoView) findViewById(R.id.activity_license_iv1);
        pv1 = new PhotoViewAttacher(iv1);
        iv2 = (PhotoView) findViewById(R.id.activity_license_iv2);
        pv2 = new PhotoViewAttacher(iv2);
        iv3 = (PhotoView) findViewById(R.id.activity_license_iv3);
        pv3 = new PhotoViewAttacher(iv3);
        iv4 = (PhotoView) findViewById(R.id.activity_license_iv4);
        pv4 = new PhotoViewAttacher(iv4);

        pv1.update();
        pv2.update();
        pv3.update();
        pv4.update();
    }

    private void doPauseResume() {
        if (videoView.isPlaying()) {
            videoView.pause();
        } else {
            videoView.start();
        }
        updatePausePlay();
    }

    private boolean mInstantSeeking = false;
    /**
     * 这个类是有关seekBar的监听接口
     */
    private SeekBar.OnSeekBarChangeListener mSeekListener = new SeekBar.OnSeekBarChangeListener() {
        public void onStartTrackingTouch(SeekBar bar) {
            mDragging = true;
            show(3600000);
            mHandler.removeMessages(SHOW_PROGRESS);
            if (mInstantSeeking)
                mAM.setStreamMute(AudioManager.STREAM_MUSIC, true);
        }

        public void onProgressChanged(SeekBar bar, int progress, boolean fromuser) {
            if (!fromuser)
                return;
            long newposition = (mDuration * progress) / 1000;
            String time = StringUtils.generateTime(newposition);
            if (mInstantSeeking)
                videoView.seekTo(newposition);
            if (mCurrentTime != null)
                mCurrentTime.setText(time);
        }

        public void onStopTrackingTouch(SeekBar bar) {
            if (!mInstantSeeking)
                videoView.seekTo((mDuration * bar.getProgress()) / 1000);
            show(sDefaultTimeout);
            mHandler.removeMessages(SHOW_PROGRESS);
            mAM.setStreamMute(AudioManager.STREAM_MUSIC, false);
            mDragging = false;
            mHandler.sendEmptyMessageDelayed(SHOW_PROGRESS, 1000);
        }
    };
}
