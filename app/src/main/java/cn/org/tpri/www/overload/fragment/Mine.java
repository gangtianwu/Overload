package cn.org.tpri.www.overload.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.org.tpri.www.overload.R;
import cn.org.tpri.www.overload.activity.LoginActivity;
import cn.org.tpri.www.overload.utils.SharedPreferencesTool;

/**
 * 作者:丁文 on 2017/2/8.
 * copyright: www.tpri.org.cn
 */
public class Mine extends android.support.v4.app.Fragment {

    private View view;
    private TextView login_out;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = View.inflate(getActivity(), R.layout.fragment_mine, null);
        login_out = (TextView) view.findViewById(R.id.login_out);
        login_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesTool.saveString(getContext(),"token","");
                SharedPreferencesTool.saveBoolean(getContext(),"isLogin",false);
                SharedPreferencesTool.saveString(getContext(),"SERVER_PATH","http://221.238.152.00:9090");
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });
        return view;
    }


    
}
