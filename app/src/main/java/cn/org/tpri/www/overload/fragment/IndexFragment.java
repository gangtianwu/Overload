package cn.org.tpri.www.overload.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import cn.org.tpri.www.overload.R;
import cn.org.tpri.www.overload.bean.Cell;
import cn.org.tpri.www.overload.bean.ColTitle;
import cn.org.tpri.www.overload.bean.IndexBean;
import cn.org.tpri.www.overload.bean.LoginBean;
import cn.org.tpri.www.overload.bean.RowTitle;
import cn.org.tpri.www.overload.utils.Constant;
import cn.org.tpri.www.overload.utils.JsonUtil;
import cn.org.tpri.www.overload.utils.SharedPreferencesTool;
import cn.zhouchaoyuan.excelpanel.BaseExcelPanelAdapter;
import cn.zhouchaoyuan.excelpanel.ExcelPanel;
import okhttp3.Call;

import static cn.org.tpri.www.overload.R.id.booking_name;
import static cn.org.tpri.www.overload.utils.JsonUtil.parseObject;

/**
 * 作者:丁文 on 2017/3/27.
 * copyright: www.tpri.org.cn
 */
public class IndexFragment extends android.support.v4.app.Fragment {

    private static int COUNT = 0;
    private ExcelPanel excelPanel;
    private CustomAdapter2 adapter;

    private ArrayList<RowTitle> rowTitles;
    private ArrayList<ColTitle> colTitles;
    private List<List<Cell>> cells;
    private static String[] rowtitle = new String[]{"检测车辆数", "超限车辆数", "超限率%", "卸载数", "卸载量kg", "2轴", "3轴", "4轴", "5轴", "6轴"
            , "6轴以上", "超限大于100%", "小于55吨", "55-100吨", "百吨王"};
    private String user_login_info;
    private LoginBean user_info_bean;
    private ProgressDialog progressDialog;
    private String orgID;
    private String siteID;
    private String xzqh;
    private ArrayList<String> xzqhLev;
    private IndexBean index;
    private View view;
    private boolean isFirstcreat;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.fragment_index, null);
        excelPanel = (ExcelPanel) view.findViewById(R.id.content_container);
        isFirstcreat = true;
        adapter = new CustomAdapter2(getContext());
        excelPanel.setAdapter(adapter);
        initData();
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
        if (user_info_bean != null && user_info_bean.getData() != null &&
                user_info_bean.getData().getRole_code() != null && user_info_bean.getData().getRole_code().equals("EQUIP_TEST")) {
            excelPanel.setVisibility(View.GONE);
        }
        OkHttpUtils.get()
//                .url(Constant.SERVER_PATH + Constant.STATISTICS_BY_DAY)
                .url(SharedPreferencesTool.getString(getContext(), "SERVER_PATH", "") + Constant.STATISTICS_BY_DAY)
                .addParams("xzqh", this.xzqh)
                .addParams("orgid", this.orgID)
                .addParams("siteid", this.siteID)
                .addParams("token", user_info_bean.getData().getToken())  //接口调整需要token和userID
//                .addParams("token","123")  //接口调整需要token和userID
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
                cells.clear();
                colTitles.clear();

                index = JsonUtil.parseObject(response, IndexBean.class);
                if (index.getCode().equals("0000")) {
                    for (int i = 0; i < index.getData().size(); i++) {
                        ColTitle colTitle1 = new ColTitle();
                        if (index.getData().get(i).getSJMC() == null) {
                            colTitle1.setRoomNumber(index.getData().get(i).getSITE_NAME());
                        } else {
                            colTitle1.setRoomNumber(index.getData().get(i).getSJMC() + "-" + index.getData().get(i).getSITE_NAME());
                        }

                        colTitles.add(colTitle1);
                    }

                    for (int i = 0; i < index.getData().size(); i++) {
                        List<Cell> cellList = new ArrayList<>();
                        for (int j = 0; j < rowtitle.length; j++) {
                            Cell cell = new Cell();
                            if (j == 0) {
                                if (index.getData().get(i).getCHECK_COUNT() == null) {
                                    cell.setBookingName("");
                                } else {
                                    cell.setBookingName(index.getData().get(i).getCHECK_COUNT());
                                }
                            }
                            if (j == 1) {
                                if (index.getData().get(i).getOVER_COUNT() == null) {
                                    cell.setBookingName("");
                                } else {
                                    cell.setBookingName(index.getData().get(i).getOVER_COUNT());
                                }
                            }
                            if (j == 2) {
                                if (index.getData().get(i).getCXL() == null) {
                                    cell.setBookingName("");
                                } else {
                                    cell.setBookingName(index.getData().get(i).getCXL() + "%");
                                }
                            }
                            if (j == 3) {
                                if (index.getData().get(i).getUNLOAD_COUNT() == null) {
                                    cell.setBookingName("");
                                } else {
                                    cell.setBookingName(index.getData().get(i).getUNLOAD_COUNT() + "");
                                }
                            }
                            if (j == 4) {
                                if (index.getData().get(i).getUNLOAD_TOTAL() == null) {
                                    cell.setBookingName("");
                                } else {
                                    cell.setBookingName(index.getData().get(i).getUNLOAD_TOTAL() + "kg");
                                }
                            }
                            if (j == 5) {
                                if (index.getData().get(i).getZS_2() == null) {
                                    cell.setBookingName("");
                                } else {
                                    cell.setBookingName(index.getData().get(i).getZS_2() + "");
                                }
                            }
                            if (j == 6) {
                                if (index.getData().get(i).getZS_3() == null) {
                                    cell.setBookingName("");
                                } else {
                                    cell.setBookingName(index.getData().get(i).getZS_3() + "");
                                }
                            }
                            if (j == 7) {
                                if (index.getData().get(i).getZS_4() == null) {
                                    cell.setBookingName("");
                                } else {
                                    cell.setBookingName(index.getData().get(i).getZS_4() + "");
                                }
                            }
                            if (j == 8) {
                                if (index.getData().get(i).getZS_5() == null) {
                                    cell.setBookingName("");
                                } else {
                                    cell.setBookingName(index.getData().get(i).getZS_5() + "");
                                }
                            }
                            if (j == 9) {
                                if (index.getData().get(i).getZS_6() == null) {
                                    cell.setBookingName("");
                                } else {
                                    cell.setBookingName(index.getData().get(i).getZS_6() + "");
                                }
                            }
                            if (j == 10) {
                                if (index.getData().get(i).getZS_6YS() == null) {
                                    cell.setBookingName("");
                                } else {
                                    cell.setBookingName(index.getData().get(i).getZS_6YS() + "");
                                }
                            }
                            if (j == 11) {
                                if (index.getData().get(i).getCX100_() == null) {
                                    cell.setBookingName("");
                                } else {
                                    cell.setBookingName(index.getData().get(i).getCX100_() + "");
                                }
                            }
                            if (j == 12) {
                                if (index.getData().get(i).getCXL55YX() == null) {
                                    cell.setBookingName("");
                                } else {
                                    cell.setBookingName(index.getData().get(i).getCXL55YX() + "");
                                }
                            }
                            if (j == 13) {
                                if (index.getData().get(i).getCXL55YS() == null) {
                                    cell.setBookingName("");
                                } else {
                                    cell.setBookingName(index.getData().get(i).getCXL55YS() + "");
                                }
                            }
                            if (j == 14) {
                                if (index.getData().get(i).getBIG_OVER_COUNT() == null) {
                                    cell.setBookingName("");
                                } else {
                                    cell.setBookingName(index.getData().get(i).getBIG_OVER_COUNT() + "");
                                }
                            }
                            cellList.add(cell);
                        }
                        cells.add(cellList);
                    }
                    adapter.setAllData(colTitles, rowTitles, cells);
                }

                if (index.getCode().equals("E001")) {
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
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    progressDialog = null;
                }
            }
        });
    }

    private void initData() {

        xzqhLev = new ArrayList<>();

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

//
        if (user_info_bean != null && user_info_bean.getData() != null &&
                user_info_bean.getData().getRole_code() != null && user_info_bean.getData().getRole_code().equals("EQUIP_TEST")) {
            excelPanel.setVisibility(View.GONE);
            return;
        }

        orgID = user_info_bean.getData().getOrg_id();
        siteID = "";
        xzqh = user_info_bean.getData().getDist_code();
        refreshData(orgID, siteID, xzqh);
    }

    public boolean onbackRefresh() {
        if (xzqhLev != null && xzqhLev.size() > 1) {

            refreshData(orgID, "", xzqhLev.get(xzqhLev.size() - 1 - 1));
            xzqhLev.remove(xzqhLev.size() - 1);
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

    public void putXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    public String getXzqh() {
        return xzqh;
    }


    public class CustomAdapter2 extends BaseExcelPanelAdapter<RowTitle, ColTitle, Cell> {
        private Context context;

        public CustomAdapter2(Context context) {
            super(context);
            this.context = context;
        }

        /*
        content's cell
         */
        @Override
        public RecyclerView.ViewHolder onCreateCellViewHolder(ViewGroup parent, int viewType) {
            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_status_normal_cell, parent, false);
            CustomAdapter2.CellHolder cellHolder = new CustomAdapter2.CellHolder(layout);
            return cellHolder;
        }

        @Override
        public void onBindCellViewHolder(RecyclerView.ViewHolder holder, int verticalPosition, int horizontalPosition) {
            Cell cell = getMajorItem(verticalPosition, horizontalPosition);
            if (holder == null || !(holder instanceof CustomAdapter2.CellHolder) || cell == null) {
                return;
            }
            CustomAdapter2.CellHolder viewHolder = (CustomAdapter2.CellHolder) holder;
            viewHolder.bookingName.setText(cell.getBookingName());
            if (horizontalPosition == 2) {

                if (!TextUtils.isEmpty(viewHolder.bookingName.getText())) {
                    if (Double.parseDouble((viewHolder.bookingName.getText()).subSequence(0, viewHolder.bookingName.getText().length() - 1) + "") > 5) {
                        viewHolder.bookingName.setTextColor(Color.RED);
                    } else {
                        viewHolder.bookingName.setTextColor(Color.GREEN);
                    }
                }
            }
        }

        //================================================top cell===================================
        @Override
        public RecyclerView.ViewHolder onCreateTopViewHolder(ViewGroup parent, int viewType) {
            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_status_top_header_item, parent, false);
            CustomAdapter2.TopHolder topHolder = new CustomAdapter2.TopHolder(layout);
            return topHolder;
        }

        @Override
        public void onBindTopViewHolder(RecyclerView.ViewHolder holder, int position) {
            RowTitle rowTitle = getTopItem(position);
            if (holder == null || !(holder instanceof CustomAdapter2.TopHolder) || rowTitle == null) {
                return;
            }
            CustomAdapter2.TopHolder viewHolder = (CustomAdapter2.TopHolder) holder;
            viewHolder.roomDate.setText(rowTitle.getDateString());
//            viewHolder.roomDate.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    refreshData(orgID,siteID);
//                }
//            });

        }
//=====================================left cell==============================

        @Override
        public RecyclerView.ViewHolder onCreateLeftViewHolder(ViewGroup parent, int viewType) {
            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_status_left_header_item, parent, false);
            CustomAdapter2.LeftHolder leftHolder = new CustomAdapter2.LeftHolder(layout);
            return leftHolder;
        }

        @Override
        public void onBindLeftViewHolder(RecyclerView.ViewHolder holder, final int position) {
            ColTitle colTitle = getLeftItem(position);
            if (null == holder || !(holder instanceof CustomAdapter2.LeftHolder) || colTitle == null) {
                return;
            }
            CustomAdapter2.LeftHolder viewHolder = (CustomAdapter2.LeftHolder) holder;
            viewHolder.roomNumberLabel.setText(colTitle.getRoomNumber());
            viewHolder.roomNumberLabel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (xzqh.equals(user_info_bean.getData().getDist_code())) {
                        xzqhLev.clear();
                        xzqhLev.add(user_info_bean.getData().getDist_code());
                    }
                    if (index.getData() != null && index.getData().get(position) != null && index.getData().get(position).getXZQH() != null) {
                        refreshData(orgID, "", index.getData().get(position).getXZQH());
                        xzqhLev.add(index.getData().get(position).getXZQH());
                    }
                }
            });


            //test different height
        }

        //===========================left-top cell================================
        @Override
        public View onCreateTopLeftView() {
            View view = LayoutInflater.from(context).inflate(R.layout.room_status_normal_cell, null);
            TextView tv = (TextView) view.findViewById(R.id.booking_name);
            tv.setTextColor(Color.YELLOW);
            return view;
        }

        class CellHolder extends RecyclerView.ViewHolder {

            private final TextView bookingName;

            public CellHolder(View itemView) {
                super(itemView);
                bookingName = (TextView) itemView.findViewById(booking_name);
            }
        }

        class TopHolder extends RecyclerView.ViewHolder {

            private final TextView roomDate;

            public TopHolder(View layout) {
                super(layout);
                roomDate = (TextView) itemView.findViewById(R.id.data_label);

            }
        }

        class LeftHolder extends RecyclerView.ViewHolder {

            private final TextView roomNumberLabel;

            public LeftHolder(View itemView) {
                super(itemView);
                roomNumberLabel = (TextView) itemView.findViewById(R.id.room_number_label);
            }
        }
    }
}
