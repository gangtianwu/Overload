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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import cn.org.tpri.www.overload.R;
import cn.org.tpri.www.overload.activity.Statistic_StationActivity;
import cn.org.tpri.www.overload.bean.LoginBean;
import cn.org.tpri.www.overload.utils.SharedPreferencesTool;

import static cn.org.tpri.www.overload.utils.JsonUtil.parseObject;

/**
 * 作者:丁文 on 2017/2/8.
 * copyright: www.tpri.org.cn
 */
public class Statistical extends android.support.v4.app.Fragment {


    private static final int STATISTICAL_CODE = 1;
    private static int NETWORKBUTTONCHECKED = 0;
    private static int INDEXBUTTONCHECKED = 0;
    private boolean ISFIRSTCLICK = true;
    private ArrayList<Fragment> listFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private View view;
    private RadioGroup radioGroup;
    private ImageView iv_button;
    private RadioButton networkRb;
    private RadioButton indexRb;
    private NetworkingFragment networkingFragment;
    private IndexFragment indexFragment;
    private String user_login_info;
    private LoginBean user_info_bean;
    private String orgID;
    private String siteID;
    private String xzqh;
    private RadioButton id_indexfragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.fragment_statistical, null);
        initFragement();
        setFragemntIndicator();
        ISFIRSTCLICK = true;

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == STATISTICAL_CODE && resultCode == 0) {
            siteID = data.getStringExtra("site_id");
//            orgID = data.getStringExtra("org_id");
            xzqh = data.getStringExtra("xzqh");
            networkingFragment.putXzqh(data.getStringExtra("xzqh"));
            indexFragment.putXzqh(data.getStringExtra("xzqh"));

            if (networkingFragment == null) {
                networkingFragment = (NetworkingFragment) listFragment.get(0);
            }
            networkingFragment.refreshData(orgID, siteID, xzqh);
            if (indexFragment == null) {
                indexFragment = (IndexFragment) listFragment.get(1);
            }
            indexFragment.refreshData(orgID, siteID, xzqh);
        }
    }

    private void setFragemntIndicator() {


        iv_button = (ImageView) view.findViewById(R.id.statistical_button_station);
        iv_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), Statistic_StationActivity.class);
                startActivityForResult(intent, STATISTICAL_CODE);
            }
        });

        radioGroup = (RadioGroup) view.findViewById(R.id.rg_group_statistiaclfragment);
        id_indexfragment = (RadioButton) view.findViewById(R.id.id_indexfragment);
        if (user_info_bean != null && user_info_bean.getData() != null &&
                user_info_bean.getData().getRole_code()!= null &&user_info_bean.getData().getRole_code().equals("EQUIP_TEST")){
            id_indexfragment.setText("");
            id_indexfragment.setCompoundDrawables(null,null,null,null);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.id_networkfragment: {
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.show(listFragment.get(0));
                        fragmentTransaction.hide(listFragment.get(1));
                        fragmentTransaction.commit();
                        NETWORKBUTTONCHECKED++;
                        INDEXBUTTONCHECKED = 0;
                        break;
                    }
                    case R.id.id_indexfragment: {
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.show(listFragment.get(1));
                        fragmentTransaction.hide(listFragment.get(0));
                        fragmentTransaction.commit();
                        NETWORKBUTTONCHECKED = 0;
                        INDEXBUTTONCHECKED++;
                        break;
                    }
                    default: {

                    }
                }
            }
        });
        networkRb = (RadioButton) view.findViewById(R.id.id_networkfragment);
        indexRb = (RadioButton) view.findViewById(R.id.id_indexfragment);
        if (networkingFragment == null) {
            networkingFragment = (NetworkingFragment) listFragment.get(0);
        }
        if (indexFragment == null) {
            indexFragment = (IndexFragment) listFragment.get(1);
        }
        networkRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String  xzqh1 = networkingFragment.getXzqh();
                if (ISFIRSTCLICK) {
                    ISFIRSTCLICK = false;
                    NETWORKBUTTONCHECKED = NETWORKBUTTONCHECKED + 2;
                    networkingFragment.refreshData(orgID, siteID, xzqh1);
                } else {
                    if (NETWORKBUTTONCHECKED == 1) {
                        NETWORKBUTTONCHECKED++;
                        return;
                    }
                    if (NETWORKBUTTONCHECKED > 1) {

                        networkingFragment.refreshData(orgID, siteID, xzqh1);
                    }
                }

            }
        });

        indexRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xzqh2 = indexFragment.getXzqh();
                if (INDEXBUTTONCHECKED == 1) {
                    INDEXBUTTONCHECKED++;
                    return;
                }
                if (INDEXBUTTONCHECKED > 1) {
                    indexFragment.refreshData(orgID, siteID, xzqh2);
                }
            }
        });

    }

    private void initFragement() {
        user_login_info = SharedPreferencesTool.getString(getContext(), "user_login_info", "");
        user_info_bean = parseObject(user_login_info, LoginBean.class);
        orgID = user_info_bean.getData().getOrg_id();
        siteID = "";
        xzqh = user_info_bean.getData().getDist_code();


        listFragment = new ArrayList<Fragment>();
        fragmentManager = getChildFragmentManager();

        listFragment.add(new NetworkingFragment());
        listFragment.add(new IndexFragment());
        fragmentTransaction = fragmentManager.beginTransaction();
        for (int i = listFragment.size() - 1; i >= 0; --i) {
            fragmentTransaction.add(R.id.id_vediofragment_container_station, listFragment.get(i));
        }
        fragmentTransaction.show(listFragment.get(0)).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean refresh() {
        if (!networkingFragment.isHidden()){
            if( networkingFragment.onbackRefresh()){
                return true;
            }else {
                return false;
            }
        }else {
            if (indexFragment.onbackRefresh()){
                return true;
            }else {
                return false;
            }
        }
    }
}
