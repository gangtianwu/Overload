package cn.org.tpri.www.overload.utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * 作者:丁文 on 2016/12/7.
 * copyright: www.tpri.org.cn
 */

public class JsonUtil {
    /***
     * 方法  碰到{}json对象数据要解析成一个JavaBean
     */
    public static <T> T parseObject(Object data, Class clz) {
//        RequestInfo info = (RequestInfo) data;
//        // 获取json
        String json = (String)data;
//        System.out.println(json);
        // 3。解析json-->bean
        Gson gson = new Gson();
        T bean = (T) gson.fromJson(json, clz);
        return bean;
    }

    /***
     * 方法  碰到[]json数组,要解析成一个List.
     *
     * @param data
     * @param type
     * @return
//     */
    public static <T> ArrayList<T> parseJSONArray(Object data, Type type) {
//        // 正常
//        RequestInfo info = (RequestInfo) data;
        String json = (String) data;
//        // 碰到{}json对象数据要解析成一个JavaBean
//        // 碰到[]json数组,要解析成一个List.
        Gson gson = new Gson();
//        // Gson Class上面带有泛型<T>,提供了TypeToken可以让Gson传入带泛型的class
//        // 3。解析json
        return gson.fromJson(json, type);
    }
//    public static <T> T parseHashMap(Object data, Type type) {
// 正常
//        RequestInfo info = (RequestInfo) data;

    public static <T> ArrayList<T> parseJsonarry(Object data ,Type type){
        String jsonData = (String) data;
        Gson gson = new Gson();


        return gson.fromJson(jsonData,type);
    }
//        String json = info.getJson();
//        碰到{}json对象数据要解析成一个JavaBean
//        碰到[]json数组,要解析成一个List.
//        Gson gson = new Gson();
//        Gson Class上面带有泛型<T>,提供了TypeToken可以让Gson传入带泛型的class
//        3。解析json
//        return gson.fromJson(json, type);
//    }
}
