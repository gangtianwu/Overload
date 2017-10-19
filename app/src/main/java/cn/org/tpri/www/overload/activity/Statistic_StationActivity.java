package cn.org.tpri.www.overload.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import cn.org.tpri.www.overload.R;
import cn.org.tpri.www.overload.bean.City_CountyBean;
import cn.org.tpri.www.overload.bean.LoginBean;
import cn.org.tpri.www.overload.bean.StationBean;
import cn.org.tpri.www.overload.utils.Constant;
import cn.org.tpri.www.overload.utils.JsonUtil;
import cn.org.tpri.www.overload.utils.SharedPreferencesTool;
import okhttp3.Call;

import static cn.org.tpri.www.overload.manager.MyApplication.getContext;
import static cn.org.tpri.www.overload.utils.JsonUtil.parseObject;

/**
 * 作者:丁文 on 2017/4/12.
 * copyright: www.tpri.org.cn
 */

public class Statistic_StationActivity extends AppCompatActivity {
    private TextView tv_all;
    private ListView lv_city;
    private ListView lv_province;
    private ListView lv_thread;
    private City_CountyBean cityStationBean;
    private City_CountyBean station_info_bean;
    private RelativeLayout rl_back;
    private StationBean station;
    private StationBean stationBean;
    private StationBean station_info_bean2;
    private StationBean station_info_bean4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_choose);
        initView();
        initUserData();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            setResult(3);
            finish();
        }
        return false;
    }

    private void initView() {
        rl_back = (RelativeLayout) findViewById(R.id.rl_back_distric_choosecity);
        tv_all = (TextView) this.findViewById(R.id.tv_all_distric_choosecity);
        lv_city = (ListView) this.findViewById(R.id.lv_city_distric_choosecity);
        lv_province = (ListView) this.findViewById(R.id.lv_province_distric_choosecity);
        lv_thread = (ListView) this.findViewById(R.id.lv_thread_distric_choosecity);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(Statistic_StationActivity.this, MainActivity.class));
                setResult(2);
                finish();
            }
        });
    }

    private void initUserData() {
        String user_login_info = SharedPreferencesTool.getString(getContext(), "user_login_info", "");
        LoginBean user_info_bean = parseObject(user_login_info, LoginBean.class);

        OkHttpUtils.get()
//                .url(Constant.SERVER_PATH + Constant.QUERY_STATION)
                .url(SharedPreferencesTool.getString(getContext(), "SERVER_PATH", "") + Constant.QUERY_STATION)
                .addParams("orgid", user_info_bean.getData().getOrg_id())
//                .addParams("orgid", "12000000000000000000000000000000")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(Statistic_StationActivity.this, "网络访问错误", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        station = JsonUtil.parseObject(response, StationBean.class);
                        if (station.getCode().equals("0000")) {
                            if (station.getXzqh_lev().equals("1")) {
                                tv_all.setText("全国");
                                OkHttpUtils.get()
//                                        .url(Constant.SERVER_PATH + Constant.QUERY_STATION)
                                        .url(SharedPreferencesTool.getString(getContext(), "SERVER_PATH", "") + Constant.QUERY_STATION)
                                        .addParams("orgid", station.getData().get(0).getORG_ID())
                                        .build().execute(new StringCallback() {
                                    @Override
                                    public void onError(Call call, Exception e, int id) {
                                        Toast.makeText(Statistic_StationActivity.this, "网络访问错误", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onResponse(String response, int id) {
                                        cityStationBean = JsonUtil.parseObject(response, City_CountyBean.class);
                                        if (cityStationBean.getCode().equals("0000")) {
                                            Statistic_StationActivity.MyCityAdapter myadapter = new Statistic_StationActivity.MyCityAdapter();
                                            lv_city.setAdapter(myadapter);
                                            lv_city.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                    if (position == 0) {
                                                        Intent intent = new Intent();
//                                                        intent.putExtra("xzqhLev",cityStationBean.getXzqh_lev());
                                                        intent.putExtra("xzqh", cityStationBean.getData().get(position).getDIST_CODE());
                                                        intent.putExtra("site_id", "");
                                                        intent.putExtra("org_id", cityStationBean.getData().get(position).getORG_ID());
                                                        setResult(RESULT_CANCELED, intent);
                                                        finish();
                                                    } else {
                                                        OkHttpUtils.get()
//                                                            .url(Constant.SERVER_PATH + Constant.QUERY_STATION)
                                                                .url(SharedPreferencesTool.getString(getContext(), "SERVER_PATH", "") + Constant.QUERY_STATION)
                                                                .addParams("orgid", cityStationBean.getData().get(position).getORG_ID())
                                                                .build().execute(new StringCallback() {
                                                            @Override
                                                            public void onError(Call call, Exception e, int id) {
                                                                Toast.makeText(Statistic_StationActivity.this, "网络访问错误", Toast.LENGTH_SHORT).show();
                                                            }

                                                            @Override
                                                            public void onResponse(String response, int id) {
                                                                station_info_bean = JsonUtil.parseObject(response, City_CountyBean.class);
                                                                if (station_info_bean.getCode().equals("0000")) {
                                                                    if (station_info_bean.getData() != null) {
                                                                        Statistic_StationActivity.MyCityAdapter2 my = new Statistic_StationActivity.MyCityAdapter2();
                                                                        lv_province.setAdapter(my);
                                                                        lv_province.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                                            @Override
                                                                            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                                                                                if (position == 0) {
                                                                                    Intent intent = new Intent();
//                                                                                    intent.putExtra("xzqhLev",cityStationBean.getXzqh_lev());
                                                                                    intent.putExtra("xzqh", station_info_bean.getData().get(position).getDIST_CODE());
                                                                                    intent.putExtra("site_id", "");
                                                                                    intent.putExtra("org_id", station_info_bean.getData().get(position).getORG_ID());
                                                                                    setResult(RESULT_CANCELED, intent);
                                                                                    finish();
                                                                                } else {
                                                                                    OkHttpUtils.get()
                                                                                            .url(SharedPreferencesTool.getString(getContext(), "SERVER_PATH", "") + Constant.QUERY_STATION)
                                                                                            .addParams("orgid", station_info_bean.getData().get(position).getORG_ID())
                                                                                            .build().execute(new StringCallback() {
                                                                                        @Override
                                                                                        public void onError(Call call, Exception e, int id) {
                                                                                            Toast.makeText(Statistic_StationActivity.this, "网络访问错误", Toast.LENGTH_SHORT).show();
                                                                                        }

                                                                                        @Override
                                                                                        public void onResponse(String response, int id) {
//                                                                                            if (position == 9) {
//                                                                                                stationBean = JsonUtil.parseObject(response, StationBean.class);
//                                                                                            }
                                                                                            stationBean = JsonUtil.parseObject(response, StationBean.class);
                                                                                            if (stationBean.getCode().equals("0000")) {
                                                                                                if (stationBean.getData() != null) {
                                                                                                    MyStatiomAdapter3 adapter3 = new MyStatiomAdapter3();
                                                                                                    lv_thread.setAdapter(adapter3);
                                                                                                    lv_thread.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                                                                        @Override
                                                                                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                                                                            Intent intent = new Intent();
//                                                                                                           intent.putExtra("xzqhLev",cityStationBean.getXzqh_lev());
                                                                                                            intent.putExtra("xzqh", stationBean.getData().get(position).getDIST_CODE());
                                                                                                            intent.putExtra("org_id", stationBean.getData().get(position).getORG_ID());
                                                                                                            intent.putExtra("site_id", stationBean.getData().get(position).getSITE_ID());
                                                                                                            setResult(RESULT_CANCELED, intent);


                                                                                                            finish();
                                                                                                        }
                                                                                                    });
                                                                                                    adapter3.notifyDataSetChanged();
                                                                                                } else {
                                                                                                    lv_thread.setAdapter(null);
                                                                                                }
                                                                                            } else {
                                                                                                lv_thread.setAdapter(null);
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                }
                                                                            }
                                                                        });
                                                                        my.notifyDataSetChanged();
                                                                    }
                                                                } else {
                                                                    lv_province.setAdapter(null);
                                                                }
                                                            }
                                                        });
                                                    }

                                                }
                                            });
                                            myadapter.notifyDataSetChanged();
                                        }
                                    }
                                });
                            }
                            if (station.getXzqh_lev().equals("2")) {

                                cityStationBean = JsonUtil.parseObject(response, City_CountyBean.class);
                                if (cityStationBean.getCode().equals("0000")) {
                                    Statistic_StationActivity.MyCityAdapter myadapter = new Statistic_StationActivity.MyCityAdapter();
                                    lv_city.setAdapter(myadapter);
                                    lv_city.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                            if (position == 0) {
                                                Intent intent = new Intent();
//                                                intent.putExtra("xzqhLev",cityStationBean.getXzqh_lev());
                                                intent.putExtra("xzqh", cityStationBean.getData().get(position).getDIST_CODE());
                                                intent.putExtra("site_id", "");
                                                intent.putExtra("org_id", cityStationBean.getData().get(position).getORG_ID());
                                                setResult(RESULT_CANCELED, intent);
                                                finish();
                                            } else {
                                                OkHttpUtils.get()
//                                                    .url(Constant.SERVER_PATH + Constant.QUERY_STATION)
                                                        .url(SharedPreferencesTool.getString(getContext(), "SERVER_PATH", "") + Constant.QUERY_STATION)
                                                        .addParams("orgid", cityStationBean.getData().get(position).getORG_ID())
                                                        .build().execute(new StringCallback() {
                                                    @Override
                                                    public void onError(Call call, Exception e, int id) {
                                                        Toast.makeText(Statistic_StationActivity.this, "网络访问错误", Toast.LENGTH_SHORT).show();
                                                    }

                                                    @Override
                                                    public void onResponse(String response, int id) {
                                                        station_info_bean2 = JsonUtil.parseObject(response, StationBean.class);
                                                        if (station_info_bean2.getCode().equals("0000")) {
                                                            if (station_info_bean2.getData() != null) {
                                                                Statistic_StationActivity.MyCityAdapter2_1 my = new Statistic_StationActivity.MyCityAdapter2_1();
                                                                lv_province.setAdapter(my);
                                                                lv_province.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                                    @Override
                                                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                                        if (station_info_bean2.getData().get(position).getSITE_ID() != null) {
//                                                                        Intent intent = new Intent(Statistic_StationActivity.this, StationDetails.class);
//                                                                        intent.putExtra("site_id", station_info_bean.getData().get(position).getSITE_ID());
//                                                                        startActivity(intent);
                                                                            Intent intent = new Intent();
//                                                                            intent.putExtra("xzqhLev",station_info_bean2.getXzqh_lev());
                                                                            intent.putExtra("xzqh", station_info_bean2.getData().get(position).getDIST_CODE());
                                                                            intent.putExtra("site_id", station_info_bean2.getData().get(position).getSITE_ID());
                                                                            intent.putExtra("org_id", station_info_bean2.getData().get(position).getORG_ID());
                                                                            setResult(RESULT_CANCELED, intent);
                                                                            finish();
                                                                        } else {
                                                                            Toast.makeText(getContext(), "暂无此站点信息", Toast.LENGTH_SHORT).show();
                                                                        }
                                                                    }
                                                                });
                                                                my.notifyDataSetChanged();
                                                            }
                                                        } else {
                                                            lv_province.setAdapter(null);
                                                        }
                                                    }
                                                });
                                            }

                                        }
                                    });
                                    myadapter.notifyDataSetChanged();
                                }
                            }
                            if (station.getXzqh_lev().equals("3")) {
                                station_info_bean4 = JsonUtil.parseObject(response, StationBean.class);
                                if (station_info_bean4.getCode().equals("0000")) {
                                    if (station_info_bean4.getData() != null) {
                                        Statistic_StationActivity.MyCityAdapter4 my = new Statistic_StationActivity.MyCityAdapter4();
                                        lv_city.setAdapter(my);
                                        lv_city.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                if (station_info_bean4.getData().get(position).getSITE_ID() != null) {
//                                                    Intent intent = new Intent(Statistic_StationActivity.this, StationDetails.class);
//                                                    intent.putExtra("site_id", station_info_bean.getData().get(position).getSITE_ID());
//                                                    startActivity(intent);
                                                    Intent intent = new Intent();
//                                                    intent.putExtra("xzqhLev",station_info_bean2.getXzqh_lev());
                                                    intent.putExtra("xzqh", station_info_bean4.getData().get(position).getDIST_CODE());
                                                    intent.putExtra("site_id", station_info_bean4.getData().get(position).getSITE_ID());
                                                    intent.putExtra("org_id", station_info_bean4.getData().get(position).getORG_ID());
                                                    setResult(RESULT_CANCELED, intent);
                                                    finish();
                                                } else {
                                                    Toast.makeText(getContext(), "暂无此站点信息", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                        my.notifyDataSetChanged();
                                    }
                                } else {
                                    lv_city.setAdapter(null);
                                }
                            }
                        } else {
                            tv_all.setText(station.getMessage());
                            lv_city.setAdapter(null);
                            lv_province.setAdapter(null);
                            lv_thread.setAdapter(null);
                        }
                    }
                });
    }


    private class MyCityAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return cityStationBean.getData().size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Statistic_StationActivity.MyCityAdapter.MyCityViewHolder tag;
            if (convertView == null) {
                tag = new Statistic_StationActivity.MyCityAdapter.MyCityViewHolder();
                convertView = View.inflate(getContext(), R.layout.item_distric_choosecity, null);
                tag.tv = (TextView) convertView.findViewById(R.id.item_distric_choose_tv_distric);
                tag.ll_choose_all = (LinearLayout) convertView.findViewById(R.id.Item_distric_choose_ll_choose_all);
                convertView.setTag(tag);
            } else {
                tag = (Statistic_StationActivity.MyCityAdapter.MyCityViewHolder) convertView.getTag();
            }
            tag.tv.setText(cityStationBean.getData().get(position).getDIST_SHORT_NAME());


            return convertView;
        }

        class MyCityViewHolder {
            private LinearLayout ll_choose_all;
            private TextView tv;
        }
    }

    private class MyCityAdapter2 extends BaseAdapter {
        @Override
        public int getCount() {
            return station_info_bean.getData().size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Statistic_StationActivity.MyCityAdapter2.MyCityViewHolder2 tag;
            if (convertView == null) {
                tag = new Statistic_StationActivity.MyCityAdapter2.MyCityViewHolder2();
                convertView = View.inflate(getContext(), R.layout.item_distric_choosecity, null);
                tag.tv = (TextView) convertView.findViewById(R.id.item_distric_choose_tv_distric);
                tag.ll_choose_all = (LinearLayout) convertView.findViewById(R.id.Item_distric_choose_ll_choose_all);
                convertView.setTag(tag);
            } else {
                tag = (Statistic_StationActivity.MyCityAdapter2.MyCityViewHolder2) convertView.getTag();
            }
            tag.tv.setText(station_info_bean.getData().get(position).getDIST_SHORT_NAME());


            return convertView;
        }

        class MyCityViewHolder2 {
            private LinearLayout ll_choose_all;
            private TextView tv;
        }
    }

    private class MyStatiomAdapter3 extends BaseAdapter {
        @Override
        public int getCount() {
            return stationBean.getData() == null ? 0 : stationBean.getData().size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            StationViewHolder tag;
            if (convertView == null) {
                tag = new StationViewHolder();
                convertView = View.inflate(getContext(), R.layout.item_distric_choosecity, null);
                tag.tv = (TextView) convertView.findViewById(R.id.item_distric_choose_tv_distric);
                convertView.setTag(tag);
            } else {
                tag = (StationViewHolder) convertView.getTag();
            }
            tag.tv.setText(stationBean.getData().get(position).getSITE_NAME());
            return convertView;
        }

        class StationViewHolder {
            private TextView tv;

        }
    }

    private class MyCityAdapter2_1 extends BaseAdapter {
        @Override
        public int getCount() {
            return station_info_bean2.getData() == null ? 0 : station_info_bean2.getData().size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            StationViewHolder tag;
            if (convertView == null) {
                tag = new StationViewHolder();
                convertView = View.inflate(getContext(), R.layout.item_distric_choosecity, null);
                tag.tv = (TextView) convertView.findViewById(R.id.item_distric_choose_tv_distric);
                convertView.setTag(tag);
            } else {
                tag = (StationViewHolder) convertView.getTag();
            }
            tag.tv.setText(station_info_bean2.getData().get(position).getSITE_NAME());
            return convertView;
        }

        class StationViewHolder {
            private TextView tv;

        }
    }

    private class MyCityAdapter4 extends BaseAdapter {
        @Override
        public int getCount() {
            return station_info_bean4.getData() == null ? 0 : station_info_bean4.getData().size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            StationViewHolder tag;
            if (convertView == null) {
                tag = new StationViewHolder();
                convertView = View.inflate(getContext(), R.layout.item_distric_choosecity, null);
                tag.tv = (TextView) convertView.findViewById(R.id.item_distric_choose_tv_distric);
                convertView.setTag(tag);
            } else {
                tag = (StationViewHolder) convertView.getTag();
            }
            tag.tv.setText(station_info_bean4.getData().get(position).getSITE_NAME());
            return convertView;
        }

        class StationViewHolder {
            private TextView tv;

        }
    }
}
