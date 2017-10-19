package cn.org.tpri.www.overload.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import cn.org.tpri.www.overload.R;
import cn.org.tpri.www.overload.bean.LoginBean;
import cn.org.tpri.www.overload.fragment.Mine;
import cn.org.tpri.www.overload.fragment.OverrunFragment;
import cn.org.tpri.www.overload.fragment.Statistical;
import cn.org.tpri.www.overload.utils.JsonUtil;
import cn.org.tpri.www.overload.utils.SharedPreferencesTool;

import static cn.org.tpri.www.overload.manager.MyApplication.getContext;

public class MainActivity extends FragmentActivity {
        /*
        主界面Activity
         */

    private ArrayList<Fragment> listFragment;
    private FragmentTransaction fragmentTransaction;
    private RadioGroup rgGroup;
    private FragmentManager fragmentManager;
    private Statistical statistical;
    private LoginBean user_info_bean;
    private RadioButton activity_main_overrun_vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        setFragmentIndicator();
    }


    private void setFragmentIndicator() {
        rgGroup = (RadioGroup) findViewById(R.id.activity_main_rg_group);
        activity_main_overrun_vehicle = (RadioButton) findViewById(R.id.activity_main_overrun_vehicle);
        if (user_info_bean != null && user_info_bean.getData() != null &&
                user_info_bean.getData().getRole_code()!= null &&user_info_bean.getData().getRole_code().equals("EQUIP_TEST")){
            activity_main_overrun_vehicle.setText("");
            activity_main_overrun_vehicle.setCompoundDrawables(null,null,null,null);
        }
        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.activity_main_overrun_vehicle:
                        setShowFragment(0);
                        break;
                    case R.id.activity_main_statistical:
                        setShowFragment(1);
                        break;
                    case R.id.activity_main_mine:
                        setShowFragment(2);
                        break;
                    default: {
                    }
                }
            }
        });

    }

    private void setShowFragment(int n) {
        fragmentTransaction = fragmentManager.beginTransaction();
        for (int i = 0; i < listFragment.size(); i++) {
            if (n == i) {
                fragmentTransaction.show(listFragment.get(i));
            } else {
                fragmentTransaction.hide(listFragment.get(i));
            }
        }
        fragmentTransaction.commit();
    }

    private void initFragment() {

        String user_login_info = SharedPreferencesTool.getString(getContext(), "user_login_info", "");
        user_info_bean = JsonUtil.parseObject(user_login_info, LoginBean.class);

        listFragment = new ArrayList<>();
        fragmentManager = getSupportFragmentManager();
        listFragment.add(new OverrunFragment());
        listFragment.add(new Statistical());
        listFragment.add(new Mine());

        fragmentTransaction = fragmentManager.beginTransaction();
        for (int i = listFragment.size() - 1; i >= 0; --i) {
            fragmentTransaction.add(R.id.container, listFragment.get(i));
        }
        fragmentTransaction.show(listFragment.get(0)).commit();
        if (statistical == null){
            statistical = (Statistical) listFragment.get(1);
        }
    }

    @Override
    public void onBackPressed() {
        if (statistical != null && !(statistical.isHidden())){
            if (statistical.refresh()){
                super.onBackPressed();
            }else {
                return;
            }
            return;
        }
        super.onBackPressed();
    }
}
