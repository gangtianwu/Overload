package cn.org.tpri.www.overload.manager;

import android.app.Application;
import android.content.Context;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * 作者:丁文 on 2016/12/7.
 * copyright: www.tpri.org.cn
 */

public class MyApplication extends Application {

    private static Context context ;
    private static MyApplication instance;


    public static Context getContext(){
        return MyApplication.context;
    }
    public static MyApplication getInstance() {
        synchronized (MyApplication.class) {
            if (MyApplication.instance == null) {
                MyApplication.instance = new MyApplication();
            }
            return MyApplication.instance;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(15000L, TimeUnit.MILLISECONDS)
                .readTimeout(15000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);



    }
}
