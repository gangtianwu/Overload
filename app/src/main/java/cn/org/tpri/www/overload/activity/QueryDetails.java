package cn.org.tpri.www.overload.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import cn.org.tpri.www.overload.R;
import cn.org.tpri.www.overload.bean.Car;
import cn.org.tpri.www.overload.bean.CarInformation;
import cn.org.tpri.www.overload.bean.LoginBean;
import cn.org.tpri.www.overload.bean.MapBean;
import cn.org.tpri.www.overload.utils.Constant;
import cn.org.tpri.www.overload.utils.JsonUtil;
import cn.org.tpri.www.overload.utils.SharedPreferencesTool;
import okhttp3.Call;

import static cn.org.tpri.www.overload.manager.MyApplication.getContext;
import static cn.org.tpri.www.overload.utils.JsonUtil.parseObject;

/**
 * 作者:丁文 on 2017/3/9.
 * copyright: www.tpri.org.cn
 */
public class QueryDetails extends AppCompatActivity {

    private XRecyclerView recyclerView;
    private LinearLayoutManager manager;
    private List<Car> mData;
    private MyrecycleAdapter myAdapter;
    private CarInformation jsonbean;
    private ImageView activity_querydetail_iv;
    private ProgressBar pb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_querydetails);
        initView();
        initData();
    }

    private void initData() {
        activity_querydetail_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();
        String vehicleNo = intent.getStringExtra("vehicleNo");
        String begin = intent.getStringExtra("begin");
        String end = intent.getStringExtra("end");
        mData = new ArrayList<>();

        String user_login_info = SharedPreferencesTool.getString(getContext(), "user_login_info", "");
        LoginBean user_info_bean = parseObject(user_login_info, LoginBean.class);
        OkHttpUtils.post().url(SharedPreferencesTool.getString(QueryDetails.this,"SERVER_PATH","") + Constant.query_url)
                .addParams("vehicleNo", vehicleNo)
                .addParams("startTime", begin)
                .addParams("endTime", end)
                .addParams("orgid", user_info_bean.getData().getOrg_id())
                .addParams("token", user_info_bean.getData().getToken())  //接口调整需要token和userID
                .addParams("userid", user_info_bean.getData().getUser_id())//接口调整需要token和userID
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onAfter(int id) {
                        super.onAfter(id);
                        if (jsonbean != null) {
                            if (jsonbean.getData() != null) {
                                if (jsonbean.getData().size() != 0) {
                                    final int[] j = {0};
                                    for (int i = 0; i < jsonbean.getData().size(); i++) {
                                        if (jsonbean.getData().get(i).getIMAGES() != null) {
                                            final int finalI = i;
                                            OkHttpUtils.post()
                                                    .url(SharedPreferencesTool.getString(QueryDetails.this, "SERVER_PATH", "") + Constant.image_url)
                                                    .addParams("key", jsonbean.getData().get(i).getIMAGES().split(",")[0])
                                                    .addParams("sysCode", Constant.sysCode)
                                                    .addParams("authCert", Constant.authCert)
                                                    .addParams("noData", "false")
                                                    .build().execute(new StringCallback() {
                                                @Override
                                                public void onError(Call call, Exception e, int id) {
                                                }

                                                @Override
                                                public void onResponse(String response, int id) {
                                                    MapBean map2 = JsonUtil.parseObject(response, MapBean.class);
                                                    Message msg = Message.obtain();
                                                    if (map2.getCode().equals("0000")) {
                                                        mData.get(finalI).setCar_map(Base64.decode(map2.getData().getData(), Base64.DEFAULT));
                                                    } else {
                                                        mData.get(finalI).setCar_map(new byte[]{1, 2, 3});
                                                    }
                                                    j[0]++;
                                                    if (j[0] == jsonbean.getData().size()) {
                                                        myAdapter.notifyDataSetChanged();
                                                    }

                                                }
                                            });
                                        }
                                    }
                                }
                            }else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(QueryDetails.this).setTitle("信息提示:").setMessage("未查到相关数据")
                                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                                onBackPressed();
                                            }
                                        });
                                builder.show();
                                return;

                            }
                        }


                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        pb.setVisibility(View.GONE);
                        AlertDialog.Builder builder = new AlertDialog.Builder(QueryDetails.this).setTitle("信息提示:").setMessage("网络访问错误,请检查网络设置")
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        onBackPressed();
                                    }
                                });
                        builder.show();
                        return;

                    }

                    @Override
                    public void onResponse(String response, int id) {
//                        Type fooType = new TypeToken<ArrayList<CarInformation>>() {
//                        }.getType();
//                        Gson gson = new Gson();
                        jsonbean = JsonUtil.parseObject(response, CarInformation.class);
                        mData.clear();
                        if (jsonbean != null && jsonbean.getCode().equals("0000")) {
                            for (int i = 0; i < jsonbean.getData().size(); i++) {
                                Car car1 = new Car();
                                car1.setCar_license(jsonbean.getData().get(i).getVEHICLE_NO());
                                car1.setCheck_address(jsonbean.getData().get(i).getSITE_NAME());
                                car1.setCheck_time(jsonbean.getData().get(i).getCHECK_TIME().substring(0, 19));
                                car1.setImg_id(jsonbean.getData().get(i).getIMAGES());
                                car1.setCheck_weight(jsonbean.getData().get(i).getTOTAL());
                                car1.setDay_data("超限幅度");
                                car1.setCar_map(new byte[]{1, 2, 3});
                                car1.setOverload_rate(new DecimalFormat("#0.00").format(jsonbean.getData().get(i).getCXL()));
                                car1.setOvertotal(jsonbean.getData().get(i).getOVER_TOTAL());
                                car1.setLimittotal(jsonbean.getData().get(i).getLIMIT_TOTAL());
                                car1.setVideo(jsonbean.getData().get(i).getVIDEOS());
                                car1.setVideo(jsonbean.getData().get(i).getVIDEOS());
                                mData.add(car1);
                            }
                            myAdapter.notifyDataSetChanged();
                            pb.setVisibility(View.GONE);

                        } else {
                            pb.setVisibility(View.GONE);
                            AlertDialog.Builder builder = new AlertDialog.Builder(QueryDetails.this).setTitle("信息提示:").setMessage("未查到相关数据")
                                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                            onBackPressed();
                                        }
                                    });
                            builder.show();
                            return;
                        }
                    }
                });

    }

    private void initView() {
        activity_querydetail_iv = (ImageView) findViewById(R.id.activity_querydetail_iv);
        recyclerView = (XRecyclerView) findViewById(R.id.activity_querydetails_rv);
        pb = (ProgressBar) findViewById(R.id.activity_query_pb);

        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        myAdapter = new MyrecycleAdapter();
        recyclerView.setAdapter(myAdapter);
        recyclerView.setPullRefreshEnabled(false);
        recyclerView.setLoadingMoreEnabled(false);
//        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));


    }

    private class MyrecycleAdapter extends RecyclerView.Adapter<QueryDetails.MyrecycleAdapter.MyViewHolder> {

        @Override
        public QueryDetails.MyrecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            QueryDetails.MyrecycleAdapter.MyViewHolder holder = new QueryDetails.MyrecycleAdapter.MyViewHolder(LayoutInflater.from(QueryDetails.this).inflate(R.layout.item_license, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final QueryDetails.MyrecycleAdapter.MyViewHolder holder, final int position) {

            Glide.with(QueryDetails.this)
                    .load(mData.get(position).getCar_map())
                    .error(R.mipmap.nodata_pic)
                    .fitCenter()
                    .into(holder.iv);
            holder.tv_car_license.setText("车牌号码: " + (mData.get(position).getCar_license() == null ? "" : mData.get(position).getCar_license()));
            holder.check_address.setText("检测地点:" + mData.get(position).getCheck_address());
            holder.check_time.setText("检测时间:" + mData.get(position).getCheck_time());
            holder.check_weight.setText("重量(kg):" + mData.get(position).getCheck_weight() + "    " + "限重(kg):" + mData.get(position).getLimittotal());
//            重量
            holder.day_data.setText(mData.get(position).getDay_data());
            holder.check_weight.setTextColor(Color.RED);
            holder.overload_rate.setText(mData.get(position).getOverload_rate() + "%");
//            holder.overload_rate.setTextColor(Color.RED);
            holder.content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("mapKey", mData.get(position).getImg_id());
                    intent.putExtra("tv_car_license", mData.get(position).getCar_license());
                    intent.putExtra("check_address", mData.get(position).getCheck_address());
                    intent.putExtra("check_time", mData.get(position).getCheck_time());
                    intent.putExtra("check_weight", String.valueOf(mData.get(position).getCheck_weight()));
                    intent.putExtra("limit_weight", String.valueOf(mData.get(position).getLimittotal()));
                    intent.putExtra("overload_rate", mData.get(position).getOverload_rate());
                    intent.putExtra("video", mData.get(position).getVideo());
                    intent.setClass(getContext(), LicenseActicity.class);
                    startActivity(intent);

                }
            });
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView iv;
            TextView tv_car_license;
            TextView check_address;
            TextView check_time;
            TextView check_weight;
            TextView day_data;
            TextView overload_rate;
            View content;

            public MyViewHolder(View itemView) {
                super(itemView);
                iv = (ImageView) itemView.findViewById(R.id.iv);
                tv_car_license = (TextView) itemView.findViewById(R.id.car_license);
                check_address = (TextView) itemView.findViewById(R.id.check_address);
                check_time = (TextView) itemView.findViewById(R.id.check_time);
                check_weight = (TextView) itemView.findViewById(R.id.check_weight);
                day_data = (TextView) itemView.findViewById(R.id.day_data);
                overload_rate = (TextView) itemView.findViewById(R.id.overload_rate);
                content = itemView.findViewById(R.id.content);
            }
        }
    }
}
