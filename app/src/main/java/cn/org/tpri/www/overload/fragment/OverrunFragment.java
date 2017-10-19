package cn.org.tpri.www.overload.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import cn.org.tpri.www.overload.R;
import cn.org.tpri.www.overload.activity.QueryActicity;
import cn.org.tpri.www.overload.activity.StationChooseActivity;
import cn.org.tpri.www.overload.bean.LoginBean;
import cn.org.tpri.www.overload.utils.JsonUtil;
import cn.org.tpri.www.overload.utils.SharedPreferencesTool;

/**
 * 作者:丁文 on 2017/2/8.
 * copyright: www.tpri.org.cn
 */
public class OverrunFragment extends android.support.v4.app.Fragment  {

    private View view;
    private Fragment mFragments;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RadioGroup radioGroup;
    private ImageView nav_back_button_station;
    private TextView textView;
    private LoginBean user_info_bean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_overrun, null);
//        初始化view
        initData();
        initView();
//        初始化数据,等待接口数据的接入
        return view;
    }
//数据接入初始化
    private void initData() {
        String user_login_info = SharedPreferencesTool.getString(getContext(), "user_login_info", "");
        user_info_bean = JsonUtil.parseObject(user_login_info, LoginBean.class);
//        LogUtils.i("用户信息",user_info_bean.getData().getOrg_id().get(0));
    }
//初始化视图
    private void initView() {

        if (user_info_bean != null && user_info_bean.getData() != null &&
                user_info_bean.getData().getRole_code()!= null &&user_info_bean.getData().getRole_code().equals("EQUIP_TEST")){
            return;
        }else {
            //        初始化Fragment
            initFragment();
//        初始化ID
            initListener();
        }
////        初始化Fragment
//        initFragment();
////        初始化ID
//        initListener();
    }

    private void initListener() {
        nav_back_button_station = (ImageView) view.findViewById(R.id.nav_back_button_station);
        textView = (TextView) view.findViewById(R.id.search_input_station);
        nav_back_button_station.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), StationChooseActivity.class);
                startActivity(intent);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setClass(getActivity(), QueryActicity.class);
                startActivity(intent2);
            }
        });

    }

    private void initFragment() {
        fragmentManager = getFragmentManager();
        if (mFragments == null){
            mFragments = new CurrentFragment();
        }
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.id_container, mFragments);
        fragmentTransaction.show(mFragments).commit();
    }




}
