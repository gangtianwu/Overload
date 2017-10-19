package cn.org.tpri.www.overload.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 
 *
 */
public class SharedPreferencesTool {

	private static SharedPreferences sp;

	//保存和获取boolean值
	/**
	 * 
	 * @Description：保存boolean值
	 */
	public static void saveBoolean(Context context,String key,boolean value){
		//name : 保存信息的xml文件的名称
		//mode : 操作权限
		if (sp==null) {
			sp = context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);
		}
		//直接保存数据
		sp.edit().putBoolean(key, value).commit();
	}
	
	/**
	 * 
	 * @Description：获取boolean值
	 */
	public static boolean getBoolean(Context context,String key,boolean defValue){
		//name : 保存信息的xml文件的名称
		//mode : 操作权限
		if (sp==null) {
			sp = context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);
		}
		//获取保存的数据
		//defValue : 默认的值，表示当没有获取到数据时返回的值
		return sp.getBoolean(key, defValue);
	}
	
	/**
	 * 
	 * @Description：保存String值
	 */
	public static void saveString(Context context,String key,String value){
		//name : 保存信息的xml文件的名称
		//mode : 操作权限
		if (sp==null) {
			sp = context.getSharedPreferences("user_login_info", Context.MODE_PRIVATE);
		}
		//直接保存数据
		sp.edit().putString(key, value).commit();
	}
	
	/**
	 * 
	 * @Description：获取String值
	 */
	public static String getString(Context context,String key,String defValue){
		//name : 保存信息的xml文件的名称
		//mode : 操作权限
		if (sp==null) {
			sp = context.getSharedPreferences("user_login_info", Context.MODE_PRIVATE);
		}
		//获取保存的数据
		//defValue : 默认的值，表示当没有获取到数据时返回的值
		return sp.getString(key, defValue);
	}
	public static void saveString_token(Context context,String key,String value){
		//name : 保存信息的xml文件的名称
		//mode : 操作权限
		if (sp==null) {
			sp = context.getSharedPreferences("token", Context.MODE_PRIVATE);
		}
		//直接保存数据
		sp.edit().putString(key, value).commit();
	}

	/**
	 *
	 * @Description：获取String值
	 */
	public static String getString_token(Context context,String key,String defValue){
		//name : 保存信息的xml文件的名称
		//mode : 操作权限
		if (sp==null) {
			sp = context.getSharedPreferences("token", Context.MODE_PRIVATE);
		}
		//获取保存的数据
		//defValue : 默认的值，表示当没有获取到数据时返回的值
		return sp.getString(key, defValue);
	}



	
	/**
	 * 
	 * @Description：保存int值
	 */
	public static void saveInt(Context context,String key,int value){
		//name : 保存信息的xml文件的名称
		//mode : 操作权限
		if (sp==null) {
			sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		}
		//直接保存数据
		sp.edit().putInt(key, value).commit();
	}
	
	/**
	 * 
	 * @Description：获取Int值
	 */
	public static int getInt(Context context,String key,int defValue){
		//name : 保存信息的xml文件的名称
		//mode : 操作权限
		if (sp==null) {
			sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		}
		//获取保存的数据
		//defValue : 默认的值，表示当没有获取到数据时返回的值
		return sp.getInt(key, defValue);
	}
//	public static void saveByte(Context context,String key,byte[] value){
//		if (sp==null) {
//			sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
//		}
//		//直接保存数据
//		sp.edit().put(key, value).commit();
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
