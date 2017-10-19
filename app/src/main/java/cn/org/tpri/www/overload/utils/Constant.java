package cn.org.tpri.www.overload.utils;

/**
 * 作者:丁文 on 2017/2/13.
 * copyright: www.tpri.org.cn
 */

public class Constant {
    public static final String base_url = "http://221.238.152.34:9090/zcedi/dat/vehicles.json";
//    public static final String current_url = "http://221.238.152.34:9090";
//    public static final String image_url = "/zcedi/sys/file/get.edi";//高清图片地址
    public static final String image_url = "/zcedi/sys/file/getByTime.edi";//高清图片地址

//    public static final String scal_image_url = "http://221.238.152.34:9090/zcedi/sys/file/getCompress.edi";//压缩图片地址
    public static final String scal_image_url = "/zcedi/sys/file/getCompress.edi";//压缩图片地址
    //日期选择查询地址
//    public static final String query_url = "http://221.238.152.34:9090/zcedi/dat/query.json";
    public static final String query_url = "/zcedi/dat/query.json";

    public static final String sysCode = "0000" ;

    public static final String authCert = "zc0000";
    //部级服务器地址
    public static final String SERVER_PATH_MINISTRY = "http://219.141.223.137:6060";
    //北京服务器地址
    public static final String SERVER_PATH_BEIJING = "http://114.251.208.67";

    //基础路径 天津服务器

    public static final String SERVER_PATH_TIANJIN = "http://221.238.152.34:9090";
    //基础服务器
    public static  final String SERVER_PATH = "http://221.238.152.34:9090";
    public static  String SERVER_PATH1 = "";

    public static final String LOGIN_ACTION = "/zcedi/app/mst/login.json";
    //查询下级组织机构信息
    public static final String QUERY_STATION = "/zcedi/app/mst/orgorsite/sub.json";
    //查询按日统计超限车辆数据

    public static final String STATISTICS_BY_DAY = "/zcedi/dat/StatisticsByDay.json";
    //查询站点运行情况

    public static final String SITE_RUNNING_STATE = "/zcedi/dat/SiteRunningState.json";

}
