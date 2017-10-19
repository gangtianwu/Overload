package cn.org.tpri.www.overload.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.org.tpri.www.overload.R;
import cn.org.tpri.www.overload.bean.Cell;
import cn.org.tpri.www.overload.bean.ColTitle;
import cn.org.tpri.www.overload.bean.LoginBean;
import cn.org.tpri.www.overload.bean.NetWorkBean;
import cn.org.tpri.www.overload.bean.RowTitle;
import cn.org.tpri.www.overload.bean.StationBean;
import cn.org.tpri.www.overload.utils.Constant;
import cn.org.tpri.www.overload.utils.JsonUtil;
import cn.org.tpri.www.overload.utils.LogUtils;
import cn.org.tpri.www.overload.utils.SharedPreferencesTool;
import cn.zhouchaoyuan.excelpanel.BaseExcelPanelAdapter;
import cn.zhouchaoyuan.excelpanel.ExcelPanel;
import cn.zhouchaoyuan.excelpanel.RecyclerViewAdapter;
import okhttp3.Call;

import static cn.org.tpri.www.overload.utils.JsonUtil.parseObject;

/**
 * 作者:丁文 on 2017/3/27.
 * copyright: www.tpri.org.cn
 */
public class NetworkingFragment extends android.support.v4.app.Fragment {

    private ExcelPanel excelPanel;
    private NetCustomAdapter2 adapter;

    private ArrayList<RowTitle> rowTitles;
    private ArrayList<ColTitle> colTitles;
    private List<List<Cell>> cells;
    private static String[] rowtitle = new String[]{"状态", "数据时间", "联网时间", "车辆数"};

    private String user_login_info;
    private LoginBean user_info_bean;
    private ProgressDialog progressDialog;
    private String orgID;
    private String siteID;
    private String xzqh;
    private static int COUNT = 0;
    private StationBean station;
    private NetWorkBean netWorkBean;
    private ArrayList<String> xzqhLev;
    private boolean isFirstcreat;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_network, null);
        isFirstcreat = true;
        excelPanel = (ExcelPanel) view.findViewById(R.id.id_networkfragment_content_container);
        adapter = new NetCustomAdapter2(getContext());
        excelPanel.setAdapter(adapter);
        adapter.disableHeader();
        initData();
    /*
    下拉刷新实现
     */
        return view;
    }

    public void refreshData(String orgID, String siteID, String xzqh) {
        if (isFirstcreat) {
            isFirstcreat = false;
        } else {
            if (progressDialog != null && progressDialog.isShowing()) {
                return;
            } else {
                (progressDialog = new ProgressDialog(getContext())).setMessage("数据加载中");
            }
            progressDialog.show();
        }

        //orgid 和siteID的限制筛选
        this.orgID = orgID;
        this.siteID = siteID;
        this.xzqh = xzqh;

//        OkHttpUtils.get()
//                .url(SharedPreferencesTool.getString(getContext(),"SERVER_PATH","") + Constant.QUERY_STATION)
//                .addParams("orgid", this.orgID)
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        station = JsonUtil.parseObject(response, StationBean.class);
//
//                    }
//                });

        OkHttpUtils.get()
//                .url(Constant.SERVER_PATH + Constant.SITE_RUNNING_STATE)
                .url(SharedPreferencesTool.getString(getContext(), "SERVER_PATH", "") + Constant.SITE_RUNNING_STATE)
                .addParams("xzqh", this.xzqh)
                .addParams("orgid", this.orgID)
                .addParams("siteid", this.siteID)
                .addParams("token", user_info_bean.getData().getToken())  //接口调整需要token和userID
                .addParams("userid", user_info_bean.getData().getUser_id())//接口调整需要token和userID
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Toast.makeText(getContext(), "网络访问错误", Toast.LENGTH_SHORT).show();
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    progressDialog = null;
                }
            }

            @Override
            public void onResponse(String response, int id) {

                LogUtils.i("token", user_info_bean.getData().getToken() + "  ++" + user_info_bean.getData().getUser_id());
                cells.clear();
                colTitles.clear();
                netWorkBean = JsonUtil.parseObject(response, NetWorkBean.class);

                if (netWorkBean.getCode().equals("E001")) {
                    if (COUNT == 0) {
                        COUNT++;
                    } else {
                        new AlertDialog.Builder(getContext()).setTitle("信息提示:").setMessage("账号信息验证已过期,此账号可能已在另一处登录,请退出重新登录试试")
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                    }
                    if (progressDialog != null && progressDialog.isShowing()) {
                        progressDialog.dismiss();
                        progressDialog = null;
                    }
                    return;
                }
                if (netWorkBean.getCode().equals("0000")) {
                    for (int i = 0; i < netWorkBean.getData().size(); i++) {
                        ColTitle colTitle1 = new ColTitle();
                        if (netWorkBean.getData().get(i).getSJMC() == null) {
                            colTitle1.setRoomNumber(netWorkBean.getData().get(i).getSITE_NAME());
                        } else {
                            colTitle1.setRoomNumber(netWorkBean.getData().get(i).getSJMC() + "-" + netWorkBean.getData().get(i).getSITE_NAME());
                        }
                        //站点名称前添加市级名称
                        colTitles.add(colTitle1);
                    }
                    for (int i = 0; i < netWorkBean.getData().size(); i++) {
                        List<Cell> cellList = new ArrayList<>();
                        for (int j = 0; j < rowtitle.length; j++) {
                            Cell cell = new Cell();
                            if (j == 0) {
                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                Date curDate = new Date(System.currentTimeMillis());
                                if (netWorkBean.getData().get(i).getRECENTLY_CONN_TIME() != null) {
                                    try {
                                        Date date1 = dateFormat.parse(netWorkBean.getData().get(i).getRECENTLY_CONN_TIME());

                                        long diff = curDate.getTime() - date1.getTime();
                                        if (!(diff / (1000 * 60 * 30) < 1)) {
                                            cell.setBookingName("离线");
                                        } else {
                                            cell.setBookingName("在线");
                                        }
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    cell.setBookingName("");
                                }

                            }
                            if (j == 1) {
                                if (netWorkBean.getData().get(i).getRECENTLY_CHECK_TIME() != null) {
                                    if ((netWorkBean.getData().get(i).getRECENTLY_CHECK_TIME()).length() > 20) {
                                        cell.setBookingName(netWorkBean.getData().get(i).getRECENTLY_CHECK_TIME().substring(0, 19));
                                    } else {
                                        cell.setBookingName(netWorkBean.getData().get(i).getRECENTLY_CHECK_TIME());
                                    }
                                } else {
                                    cell.setBookingName(netWorkBean.getData().get(i).getRECENTLY_CHECK_TIME());
                                }


                            }
                            if (j == 2) {
                                if (netWorkBean.getData().get(i).getRECENTLY_CONN_TIME() != null) {
                                    if ((netWorkBean.getData().get(i).getRECENTLY_CONN_TIME()).length() > 20) {
                                        cell.setBookingName(netWorkBean.getData().get(i).getRECENTLY_CONN_TIME().substring(0, 19));
                                    } else {
                                        cell.setBookingName(netWorkBean.getData().get(i).getRECENTLY_CONN_TIME());
                                    }
                                } else {
                                    cell.setBookingName(netWorkBean.getData().get(i).getRECENTLY_CONN_TIME());
                                }
                            }
                            if (j == 3) {
                                if (netWorkBean.getData().get(i).getCHECK_COUNT() != null) {
                                    cell.setBookingName(netWorkBean.getData().get(i).getCHECK_COUNT());
                                } else {
                                    cell.setBookingName("");
                                }
                            }
                            cellList.add(cell);
                        }
                        cells.add(cellList);
                    }
                    adapter.setAllData(colTitles, rowTitles, cells);
                }
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    progressDialog = null;
                }
            }
        });
    }


    private void initData() {
        xzqhLev = new ArrayList<String>();

        rowTitles = new ArrayList<>();
        colTitles = new ArrayList<>();
        cells = new ArrayList<>();
        for (int i = 0; i < rowtitle.length; i++) {
            RowTitle rowTitle1 = new RowTitle();
            rowTitle1.setDateString(rowtitle[i]);
            rowTitles.add(rowTitle1);
        }

        user_login_info = SharedPreferencesTool.getString(getContext(), "user_login_info", "");
        user_info_bean = parseObject(user_login_info, LoginBean.class);

        orgID = user_info_bean.getData().getOrg_id();
        siteID = "";
        xzqh = user_info_bean.getData().getDist_code();
        refreshData(orgID, siteID, xzqh);
    }

    public boolean onbackRefresh() {
        LogUtils.i("回退", "点击此按钮");
        if (xzqhLev != null && xzqhLev.size() > 1) {
            LogUtils.i("回退1", xzqhLev.size() + "");

            refreshData(orgID, "", xzqhLev.get(xzqhLev.size() - 1 - 1));
            xzqhLev.remove(xzqhLev.size() - 1);
            LogUtils.i("回退2", xzqhLev.size() + "");
            return false;
        }
        if (xzqhLev != null && xzqhLev.size() == 1 && xzqhLev.get(0).equals(user_info_bean.getData().getDist_code())) {
            return true;
        }
        if (xzqhLev != null && xzqhLev.size() == 0) {
            return true;
        }
        return false;

    }

    public String getXzqh() {

        return xzqh;
    }

    public void putXzqh(String xzqh) {
        this.xzqh = xzqh;
    }


    public class NetCustomAdapter2 extends BaseExcelPanelAdapter<RowTitle, ColTitle, Cell> {
        private Context context;

        public NetCustomAdapter2(Context context) {
            super(context);
            this.context = context;
        }

        @Override
        public RecyclerViewAdapter getTopRecyclerViewAdapter() {
            return super.getTopRecyclerViewAdapter();
        }

        //           ============================================= content's cell  ==================================
        @Override
        public RecyclerView.ViewHolder onCreateCellViewHolder(ViewGroup parent, int viewType) {
            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_status_normal_cell_network, parent, false);
            NetCustomAdapter2.CellHolder cellHolder = new NetCustomAdapter2.CellHolder(layout);
            return cellHolder;
        }

        @Override
        public void onBindCellViewHolder(RecyclerView.ViewHolder holder, int verticalPosition, int horizontalPosition) {
            Cell cell = getMajorItem(verticalPosition, horizontalPosition);
            if (holder == null || !(holder instanceof NetCustomAdapter2.CellHolder) || cell == null) {
                return;
            }
            NetCustomAdapter2.CellHolder viewHolder = (NetCustomAdapter2.CellHolder) holder;
            viewHolder.bookingName.setText(cell.getBookingName());
            if (horizontalPosition == 1 || horizontalPosition == 2) {
                Date curDate = new Date(System.currentTimeMillis());
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    Date date1 = dateFormat.parse(String.valueOf(viewHolder.bookingName.getText()));

                    long diff = curDate.getTime() - date1.getTime();
                    if (diff >= 30 * 1000 * 60) {
                        viewHolder.bookingName.setTextColor(Color.RED);
                    }
                    if (10 * 1000 * 60 < diff && diff < 30 * 1000 * 60) {
                        viewHolder.bookingName.setTextColor(Color.YELLOW);
                    }
                    if (diff <= 10 * 1000 * 60) {
                        viewHolder.bookingName.setTextColor(Color.GREEN);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if (horizontalPosition == 0) {
                if (viewHolder.bookingName.getText().equals("离线")) {
                    viewHolder.bookingName.setTextColor(Color.RED);
                } else {
                    viewHolder.bookingName.setTextColor(Color.GREEN);
                }
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((CellHolder) holder).bookingName.getLayoutParams();
            if (horizontalPosition == 0) {
                layoutParams.width = 140;
            }
            if (horizontalPosition == 1) {
                layoutParams.width = 236;
            }
            if (horizontalPosition == 2) {
                layoutParams.width = 236;
            }
            if (horizontalPosition == 3) {
                layoutParams.width = 168;
            }
            ((CellHolder) holder).bookingName.setLayoutParams(layoutParams);

        }

        class CellHolder extends RecyclerView.ViewHolder {

            private TextView bookingName;

            public CellHolder(View itemView) {
                super(itemView);
                bookingName = (TextView) itemView.findViewById(R.id.booking_name_network);
            }
        }

        //================================================top cell===================================
        @Override
        public RecyclerView.ViewHolder onCreateTopViewHolder(ViewGroup parent, int viewType) {
            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_status_top_header_network, parent, false);
            NetCustomAdapter2.TopHolder topHolder = new NetCustomAdapter2.TopHolder(layout);


            return topHolder;
        }

        class TopHolder extends RecyclerView.ViewHolder {

            private TextView roomDate;

            public TopHolder(View layout) {
                super(layout);
                roomDate = (TextView) itemView.findViewById(R.id.data_label_network);

            }
        }

        @Override
        public void onBindTopViewHolder(RecyclerView.ViewHolder holder, int position) {
            RowTitle rowTitle = getTopItem(position);
            if (holder == null || !(holder instanceof NetCustomAdapter2.TopHolder) || rowTitle == null) {
                return;
            }
            NetCustomAdapter2.TopHolder viewHolder = (NetCustomAdapter2.TopHolder) holder;
            viewHolder.roomDate.setText(rowTitle.getDateString());

            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((TopHolder) holder).roomDate.getLayoutParams();
            if (position == 0) {
                layoutParams.width = 140;
            }
            if (position == 1) {
                layoutParams.width = 236;
            }
            if (position == 2) {
                layoutParams.width = 236;
            }
            if (position == 3) {
                layoutParams.width = 168;
            }
            ((TopHolder) holder).roomDate.setLayoutParams(layoutParams);

        }
//=====================================left cell==============================

        @Override
        public RecyclerView.ViewHolder onCreateLeftViewHolder(ViewGroup parent, int viewType) {
            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_status_left_header_network_item, parent, false);
            NetCustomAdapter2.LeftHolder leftHolder = new NetCustomAdapter2.LeftHolder(layout);
            return leftHolder;
        }


        class LeftHolder extends RecyclerView.ViewHolder {

            private TextView roomNumberLabel;

            public LeftHolder(View itemView) {
                super(itemView);
                roomNumberLabel = (TextView) itemView.findViewById(R.id.room_number_label_network);
            }
        }

        @Override
        public void onBindLeftViewHolder(RecyclerView.ViewHolder holder, final int position) {
            ColTitle colTitle = getLeftItem(position);
            if (null == holder || !(holder instanceof NetCustomAdapter2.LeftHolder) || colTitle == null) {
                return;
            }
            NetCustomAdapter2.LeftHolder viewHolder = (NetCustomAdapter2.LeftHolder) holder;
            viewHolder.roomNumberLabel.setText(colTitle.getRoomNumber());
            viewHolder.roomNumberLabel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (xzqh.equals(user_info_bean.getData().getDist_code())) {
                        xzqhLev.clear();
                        xzqhLev.add(user_info_bean.getData().getDist_code());
                        LogUtils.i("回退3", xzqhLev.size() + "");
                    }

                    if (netWorkBean.getData() != null && netWorkBean.getData().get(position) != null && netWorkBean.getData().get(position).getXZQH() != null) {
                        refreshData(orgID, "", netWorkBean.getData().get(position).getXZQH());
                        xzqhLev.add(netWorkBean.getData().get(position).getXZQH());
                        LogUtils.i("回退4", xzqhLev.get(0) + "");
                    }
                }
            });

        }

        //===========================left-top cell================================
        @Override
        public View onCreateTopLeftView() {
            View view = LayoutInflater.from(context).inflate(R.layout.room_status_normal_cell_network, null);
            TextView tv = (TextView) view.findViewById(R.id.booking_name_network);
            tv.setTextColor(Color.YELLOW);
            return view;
        }
    }


}
