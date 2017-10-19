package cn.org.tpri.www.overload.utils;

import java.util.Comparator;

import cn.org.tpri.www.overload.bean.Car;

/**
 * 作者:丁文 on 2017/2/22.
 * copyright: www.tpri.org.cn
 */

public class Order implements Comparator<Car>{

    @Override
    public int compare(Car index1, Car index2) {
        return index1.getIndex()- index2.getIndex();
    }
}
