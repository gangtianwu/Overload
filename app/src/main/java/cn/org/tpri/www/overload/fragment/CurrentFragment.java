package cn.org.tpri.www.overload.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
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
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.org.tpri.www.overload.R;
import cn.org.tpri.www.overload.activity.LicenseActicity;
import cn.org.tpri.www.overload.bean.Car;
import cn.org.tpri.www.overload.bean.CarInformation;
import cn.org.tpri.www.overload.bean.LoginBean;
import cn.org.tpri.www.overload.bean.MapBean;
import cn.org.tpri.www.overload.utils.Constant;
import cn.org.tpri.www.overload.utils.JsonUtil;
import cn.org.tpri.www.overload.utils.Order;
import cn.org.tpri.www.overload.utils.SharedPreferencesTool;
import okhttp3.Call;

import static cn.org.tpri.www.overload.utils.JsonUtil.parseObject;

/**
 * 作者:丁文 on 2017/2/8.
 * copyright: www.tpri.org.cn
 */
public class CurrentFragment extends android.support.v4.app.Fragment {
    private View view;
    private XRecyclerView recycle;
    private LinearLayoutManager manager;
    private List<Car> mData;
    private View header;
    private CurrentFragment.MyrecycleAdapter myAdapter;
    private TextView tv_header;
    private TextView check_address_header;
    private TextView check_time_header;
    private TextView check_weight_header;
    private ImageView car_picture_header;
    private List<Car> mapBean;
    private Handler handler;
    private CarInformation jsonbean;
    private LoginBean user_info_bean;
    private ProgressBar pb;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_currentfragment, null);
        header = LayoutInflater.from(getContext()).inflate(R.layout.xrecycleview_header, container, false);
        initData();
        initView();


        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 1) {
                    Bundle b = msg.getData();
                    Car car1 = new Car();
                    car1.setCar_license(b.getString("car_license"));//车牌号
                    car1.setCheck_address(b.getString("Check_address"));//检测地点
                    car1.setCheck_time(b.getString("Check_time"));//检测时间
                    car1.setImg_id(b.getString("setImg_id"));//图片信息
                    car1.setCheck_weight(b.getInt("Check_weight"));//检测重量
                    car1.setDay_data("超限幅度");//item的textview设置:超限幅度
                    car1.setOverload_rate(b.getString("over_rate"));//超限幅度值
                    car1.setOvertotal(b.getInt("Overtotal"));//超重
                    car1.setLimittotal(b.getInt("Limittotal"));//限重
                    car1.setCar_map(b.getByteArray("car_Map"));//base64解码的图片byte[]值,在adapter中无法进行此耗时解析操作.试了
                    car1.setIndex(b.getInt("index"));//为集合重新排序添加的索引
                    car1.setVideo(b.getString("video"));//视频的key值
                    mData.add(car1);
                    if (mData.size() == 19) {
                        Collections.sort(mData, new Order());
                     /*
                     header视图
                             */
                        tv_header.setText("车牌号码: " + (jsonbean.getData().get(0).getVEHICLE_NO() == null ? "" : jsonbean.getData().get(0).getVEHICLE_NO()));
                        check_address_header.setText("检测地点: " + jsonbean.getData().get(0).getSITE_NAME());
                        check_time_header.setText("检测时间: " + jsonbean.getData().get(0).getCHECK_TIME().substring(0, 19));
                        check_weight_header.setText("重量(kg): " + jsonbean.getData().get(0).getTOTAL() + "   " + "限重(kg): " + jsonbean.getData().get(0).getLIMIT_TOTAL() +
                                "  " + "超限:" + new DecimalFormat("#0.00").format(jsonbean.getData().get(0).getCXL()) + "%");
                /*
                图片加载
                 */
                        if (jsonbean.getData().get(0).getIMAGES() != null) {
                            String imageKey = jsonbean.getData().get(0).getIMAGES().split(",")[0];
                            OkHttpUtils.post()
                                    .url(SharedPreferencesTool.getString(getContext(), "SERVER_PATH", "") + Constant.image_url)
                                    .addParams("key", imageKey)
                                    .addParams("sysCode", Constant.sysCode)
                                    .addParams("authCert", Constant.authCert)
                                    .addParams("noData", "false")
                                    .addParams("startTime", mapBean.get(0).getCheck_time())
                                    .build().execute(new StringCallback() {

                                private byte[] decodeMap;

                                @Override
                                public void onError(Call call, Exception e, int id) {
                                    pb.setVisibility(View.GONE);
                                }

                                @Override
                                public void onResponse(String response, int id) {
                                    MapBean map = JsonUtil.parseObject(response, MapBean.class);
                                    if (map.getCode().equals("0000")) {
                                        decodeMap = Base64.decode(map.getData().getData(), Base64.DEFAULT);
                                    } else {
                                        decodeMap = new byte[]{1, 2, 3};
                                    }

                                    Glide.with(getContext())
                                            .load(decodeMap)
                                            .error(R.mipmap.nodata_pic)
                                            .fitCenter()
                                            .into(car_picture_header);
                                }
                            });
                        } else {
                            Glide.with(getContext())
                                    .load(new byte[]{1, 2, 3})
                                    .error(R.mipmap.nodata_pic)
                                    .fitCenter()
                                    .into(car_picture_header);
                        }

                        check_weight_header.setTextColor(Color.RED);
                        header.invalidate();
                        pb.setVisibility(View.GONE);
                        recycle.setVisibility(View.VISIBLE);
//                        header.setVisibility(View.VISIBLE);


                        myAdapter.notifyDataSetChanged();
                        header.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent();
                                intent.putExtra("mapKey", jsonbean.getData().get(0).getIMAGES());
                                intent.putExtra("tv_car_license", jsonbean.getData().get(0).getVEHICLE_NO());
                                intent.putExtra("check_address", jsonbean.getData().get(0).getSITE_NAME());
                                intent.putExtra("check_time", jsonbean.getData().get(0).getCHECK_TIME().substring(0, 19));
                                intent.putExtra("check_weight", String.valueOf(jsonbean.getData().get(0).getTOTAL()));
                                intent.putExtra("limit_weight", String.valueOf(jsonbean.getData().get(0).getLIMIT_TOTAL()));
                                intent.putExtra("overload_rate", new DecimalFormat("#0.00").format(jsonbean.getData().get(0).getCXL()));
                                intent.putExtra("video", jsonbean.getData().get(0).getVIDEOS());

                                intent.setClass(getContext(), LicenseActicity.class);
                                startActivity(intent);
                            }
                        });
                    }
                }
                if (msg.what == 0) {
//                    for (int i = 1; i < jsonbean.size(); i++) {
                    for (int i = 1; i < 20; i++) {
                        final int finalI = i;
                        if (mapBean.get(i).getImg_id() != null) {
                            OkHttpUtils.post()
                                    .url(SharedPreferencesTool.getString(getContext(), "SERVER_PATH", "") + Constant.scal_image_url)
                                    .addParams("key", mapBean.get(i).getImg_id().split(",")[0])
                                    .addParams("startTime", mapBean.get(i).getCheck_time())
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
                                    Bundle b = new Bundle();
                                    b.putString("car_license", jsonbean.getData().get(finalI).getVEHICLE_NO());
                                    b.putString("Check_address", jsonbean.getData().get(finalI).getSITE_NAME());
                                    b.putString("Check_time", jsonbean.getData().get(finalI).getCHECK_TIME().substring(0, 19));
                                    b.putString("setImg_id", jsonbean.getData().get(finalI).getIMAGES());
                                    b.putInt("Check_weight", jsonbean.getData().get(finalI).getTOTAL());
                                    b.putInt("Overtotal", jsonbean.getData().get(finalI).getOVER_TOTAL());
                                    b.putInt("Limittotal", jsonbean.getData().get(finalI).getLIMIT_TOTAL());
                                    if (map2.getCode().equals("0000")) {
                                        b.putByteArray("car_Map", Base64.decode(map2.getData().getData(), Base64.DEFAULT));
                                    } else {
                                        b.putByteArray("car_Map", new byte[]{1, 2, 3});
                                    }

                                    b.putString("over_rate", new DecimalFormat("#0.00").format(jsonbean.getData().get(finalI).getCXL()));
                                    b.putInt("index", finalI);
                                    b.putString("video", jsonbean.getData().get(finalI).getVIDEOS());
                                    msg.what = 1;
                                    msg.setData(b);
                                    handler.sendMessage(msg);
                                }
                            });
                        }
                        if (mapBean.get(i).getImg_id() == null) {
                            byte[] decodeMap = new byte[]{1, 2, 3};
                            Message msg1 = Message.obtain();
                            Bundle b = new Bundle();
                            b.putString("car_license", jsonbean.getData().get(finalI).getVEHICLE_NO());
                            b.putString("Check_address", jsonbean.getData().get(finalI).getSITE_NAME());
                            b.putString("Check_time", jsonbean.getData().get(finalI).getCHECK_TIME().substring(0, 19));
                            b.putString("setImg_id", jsonbean.getData().get(finalI).getIMAGES());
                            b.putInt("Check_weight", jsonbean.getData().get(finalI).getTOTAL());
                            b.putInt("Overtotal", jsonbean.getData().get(finalI).getOVER_TOTAL());
                            b.putInt("Limittotal", jsonbean.getData().get(finalI).getLIMIT_TOTAL());
                            b.putByteArray("car_Map", decodeMap);
                            b.putString("over_rate", new DecimalFormat("#0.00").format(jsonbean.getData().get(finalI).getCXL()));
                            b.putInt("index", finalI);
                            b.putString("video", jsonbean.getData().get(finalI).getVIDEOS());
                            msg1.what = 1;
                            msg1.setData(b);
                            handler.sendMessage(msg1);
                        }
                    }
                }
                super.handleMessage(msg);
            }
        };

        return view;
    }

    private void initData() {
        mData = new ArrayList<Car>();
        mapBean = new ArrayList<Car>();
        String user_login_info = SharedPreferencesTool.getString(getContext(), "user_login_info", "");
        user_info_bean = parseObject(user_login_info, LoginBean.class);

    }


    public void getHttpData() {
//        OkHttpUtils.post().url(Constant.base_url)
        OkHttpUtils.post().url(SharedPreferencesTool.getString(getContext(), "SERVER_PATH", "") + Constant.query_url)
                .addParams("start", "0")
                .addParams("limit", "20")
                .addParams("orgid", user_info_bean.getData().getOrg_id())
                .addParams("token", user_info_bean.getData().getToken())  //接口调整需要token和userID
                .addParams("userid", user_info_bean.getData().getUser_id())//接口调整需要token和userID
                .build().execute(new StringCallback() {

            @Override
            public void onError(Call call, Exception e, int id) {
                new AlertDialog.Builder(getContext()).setTitle("信息提示:").setMessage("网络访问错误,请检查网络设置")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                pb.setVisibility(View.GONE);
                recycle.setVisibility(View.VISIBLE);
                return;
            }

            @Override
            public void onResponse(String response, int id) {
                jsonbean = JsonUtil.parseObject(response, CarInformation.class);
                if (mData != null) {
                    mData.clear();
                }
                if (mapBean != null) {
                    mapBean.clear();
                }
                if (jsonbean != null && jsonbean.getCode().equals("0000")) {

                    if (jsonbean.getData().size() == 0) {
                        new AlertDialog.Builder(getContext()).setTitle("信息提示:").setMessage("数据信息异常,可能服务器出现问题,可及时联系管理员")
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                        pb.setVisibility(View.GONE);
                        recycle.setVisibility(View.VISIBLE);
                        return;
                    }

                    for (int i = 0; i < jsonbean.getData().size(); i++) {
                        Car car1 = new Car();
                        car1.setCar_license(jsonbean.getData().get(i).getVEHICLE_NO());
                        car1.setCheck_address(jsonbean.getData().get(i).getSITE_NAME());
                        car1.setCheck_time(jsonbean.getData().get(i).getCHECK_TIME().substring(0, 19));
                        car1.setImg_id(jsonbean.getData().get(i).getIMAGES());
                        car1.setCheck_weight(jsonbean.getData().get(i).getTOTAL());
                        car1.setDay_data("超限幅度");
                        car1.setOverload_rate("wu");
                        car1.setOvertotal(jsonbean.getData().get(i).getOVER_TOTAL());
                        car1.setLimittotal(jsonbean.getData().get(i).getLIMIT_TOTAL());
                        car1.setVideo(jsonbean.getData().get(i).getVIDEOS());
                        car1.setVideo(jsonbean.getData().get(i).getVIDEOS());
                        mapBean.add(car1);
                    }
                }
                if (jsonbean.getCode().equals("E001")) {
                    new AlertDialog.Builder(getContext()).setTitle("信息提示:").setMessage("账号信息验证已过期,此账号可能已在另一处登录,请退出重新登录试试")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .show();
                    pb.setVisibility(View.GONE);
                    recycle.setVisibility(View.VISIBLE);
                    return;
                }
                if (jsonbean.getCode().equals("W001")) {
                    new AlertDialog.Builder(getContext()).setTitle("信息提示:").setMessage(jsonbean.getMessage())
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .show();
                    pb.setVisibility(View.GONE);
                    recycle.setVisibility(View.VISIBLE);
                    return;
                }
                Message msg = Message.obtain();
                msg.what = 0;
                handler.sendMessage(msg);
            }
        });
    }

    private void initView() {
        /*
          header的view初始化
         */
        tv_header = (TextView) header.findViewById(R.id.car_license);
        check_address_header = (TextView) header.findViewById(R.id.check_address);
        check_time_header = (TextView) header.findViewById(R.id.check_time);
        check_weight_header = (TextView) header.findViewById(R.id.check_weight);
        car_picture_header = (ImageView) header.findViewById(R.id.car_picture);

        pb = (ProgressBar) view.findViewById(R.id.currentfragment_pb);
        /*
        XRecyclerView的view初始化
         */
        recycle = (XRecyclerView) view.findViewById(R.id.currentfragment_rv);
        manager = new LinearLayoutManager(getActivity());
        recycle.setLayoutManager(manager);
        myAdapter = new CurrentFragment.MyrecycleAdapter();
        recycle.setAdapter(myAdapter);
        recycle.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recycle.setLoadingMoreEnabled(false);
//        recycle.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
//        header.setVisibility(View.INVISIBLE);
        recycle.addHeaderView(header);
//        recycle.setVisibility(View.INVISIBLE);
        getHttpData();

        recycle.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        getHttpData();
                        myAdapter.notifyDataSetChanged();
                        recycle.refreshComplete();
                        if (mData != null) {
                            mData.clear();
                        }

                    }
                }, 500);            //refresh data here
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        recycle.loadMoreComplete();
//                        myAdapter.notifyDataSetChanged();
                    }
                }, 1000);
//                recycle.loadMoreComplete();
            }
        });
    }

    private class MyrecycleAdapter extends RecyclerView.Adapter<CurrentFragment.MyrecycleAdapter.MyViewHolder> {

        @Override
        public CurrentFragment.MyrecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            CurrentFragment.MyrecycleAdapter.MyViewHolder holder = new CurrentFragment.MyrecycleAdapter.MyViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.item_license, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final CurrentFragment.MyrecycleAdapter.MyViewHolder holder, final int position) {

            Glide.with(getContext())
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