package cn.org.tpri.www.overload.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.org.tpri.www.overload.R;

/**
 * 作者:丁文 on 2017/2/8.
 * copyright: www.tpri.org.cn
 */
public class HistoryFragment extends android.support.v4.app.Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_statistical, null);
        return view;
    }
}
