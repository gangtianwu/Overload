package cn.org.tpri.www.overload.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者:丁文 on 2017/2/13.
 * copyright: www.tpri.org.cn
 */
public class CarInformation implements Serializable {
    /**
     * message : 处理成功
     * data : [{"LIMIT_TOTAL":18000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 15:22:33.175","SORTING":"0","OLD_CHECK_NO":"TJ210131709101522301257","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":19020,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":5.666666666666667,"UNLOAD_WEIGHT":0,"OVER_TOTAL":1020,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"5840,13180","AXLES":2,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":4,"CHECK_TIME":"2017-09-10 15:22:30.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 15:22:33.175","SPEED":0,"CHECK_NO":"1200201709101522308597FAB0098F41","WEIGHT5":0,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":0,"DSMC":"宁河县","WEIGHT6":0,"WEIGHT1":5840,"SJMC":"天津市","WEIGHT3":0,"WEIGHT2":13180,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":1},{"LIMIT_TOTAL":27000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 14:52:09.593","SORTING":"0","OLD_CHECK_NO":"TJ210131709101452101215","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":28940,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":7.185185185185185,"UNLOAD_WEIGHT":0,"OVER_TOTAL":1940,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"7040,10780,11120","AXLES":3,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":6,"CHECK_TIME":"2017-09-10 14:52:10.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 14:52:09.593","SPEED":0,"CHECK_NO":"12002017091014521031E4CC7D1234BD","WEIGHT5":0,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":0,"DSMC":"宁河县","WEIGHT6":0,"WEIGHT1":7040,"SJMC":"天津市","WEIGHT3":11120,"WEIGHT2":10780,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":2},{"LIMIT_TOTAL":49000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 14:37:13.535","SORTING":"0","OLD_CHECK_NO":"TJ210131709101437131198","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":52720,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":7.591836734693878,"UNLOAD_WEIGHT":0,"OVER_TOTAL":3720,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"3300,4380,14100,8880,8460,13600","AXLES":6,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":12,"CHECK_TIME":"2017-09-10 14:37:13.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 14:37:13.535","SPEED":0,"CHECK_NO":"120020170910143713C5F807A1ABA98C","WEIGHT5":8460,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":8880,"DSMC":"宁河县","WEIGHT6":13600,"WEIGHT1":3300,"SJMC":"天津市","WEIGHT3":14100,"WEIGHT2":4380,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":3},{"LIMIT_TOTAL":49000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 13:17:29.198","SORTING":"0","OLD_CHECK_NO":"TJ210131709101317301105","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":50220,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":2.489795918367347,"UNLOAD_WEIGHT":0,"OVER_TOTAL":1220,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"5000,4620,15380,10640,7560,7020","AXLES":6,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":12,"CHECK_TIME":"2017-09-10 13:17:30.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 13:17:29.198","SPEED":0,"CHECK_NO":"120020170910131730ED8DC708699E4A","WEIGHT5":7560,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":10640,"DSMC":"宁河县","WEIGHT6":7020,"WEIGHT1":5000,"SJMC":"天津市","WEIGHT3":15380,"WEIGHT2":4620,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":4},{"LIMIT_TOTAL":43000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 13:13:40.936","SORTING":"0","OLD_CHECK_NO":"TJ210131709101311271101","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":52860,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":22.930232558139537,"UNLOAD_WEIGHT":0,"OVER_TOTAL":9860,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"9460,9740,12320,10360,10980","AXLES":5,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":10,"CHECK_TIME":"2017-09-10 13:11:27.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 13:13:40.936","SPEED":0,"CHECK_NO":"120020170910131127247F3AA2A9C709","WEIGHT5":10980,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":10360,"DSMC":"宁河县","WEIGHT6":0,"WEIGHT1":9460,"SJMC":"天津市","WEIGHT3":12320,"WEIGHT2":9740,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":5},{"LIMIT_TOTAL":49000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 12:05:44.737","SORTING":"0","OLD_CHECK_NO":"TJ210131709101205421013","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":52900,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":7.959183673469388,"UNLOAD_WEIGHT":0,"OVER_TOTAL":3900,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"3160,4080,12800,8560,10780,13520","AXLES":6,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":12,"CHECK_TIME":"2017-09-10 12:05:42.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 12:05:44.737","SPEED":0,"CHECK_NO":"120020170910120542F77111ABCEB0EB","WEIGHT5":10780,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":8560,"DSMC":"宁河县","WEIGHT6":13520,"WEIGHT1":3160,"SJMC":"天津市","WEIGHT3":12800,"WEIGHT2":4080,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":6},{"LIMIT_TOTAL":27000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 11:56:42.257","SORTING":"0","OLD_CHECK_NO":"TJ210131709101156410997","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":32440,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":20.14814814814815,"UNLOAD_WEIGHT":0,"OVER_TOTAL":5440,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"7280,12380,12780","AXLES":3,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":6,"CHECK_TIME":"2017-09-10 11:56:41.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 11:56:42.257","SPEED":0,"CHECK_NO":"120020170910115641BC63082480D0FA","WEIGHT5":0,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":0,"DSMC":"宁河县","WEIGHT6":0,"WEIGHT1":7280,"SJMC":"天津市","WEIGHT3":12780,"WEIGHT2":12380,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":7},{"LIMIT_TOTAL":27000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 10:18:14.536","SORTING":"0","OLD_CHECK_NO":"TJ210131709101018110865","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":31380,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":16.22222222222222,"UNLOAD_WEIGHT":0,"OVER_TOTAL":4380,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"7800,11840,11740","AXLES":3,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":6,"CHECK_TIME":"2017-09-10 10:18:11.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 10:18:14.536","SPEED":0,"CHECK_NO":"120020170910101811BDC0DEB085BB6B","WEIGHT5":0,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":0,"DSMC":"宁河县","WEIGHT6":0,"WEIGHT1":7800,"SJMC":"天津市","WEIGHT3":11740,"WEIGHT2":11840,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":8},{"LIMIT_TOTAL":49000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 09:30:22.998","SORTING":"0","OLD_CHECK_NO":"TJ210131709100930230819","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":53800,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":9.795918367346939,"UNLOAD_WEIGHT":0,"OVER_TOTAL":4800,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"3120,4080,14160,9520,9560,13360","AXLES":6,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":12,"CHECK_TIME":"2017-09-10 09:30:23.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 09:30:22.998","SPEED":0,"CHECK_NO":"120020170910093023EBB2B7F76138A3","WEIGHT5":9560,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":9520,"DSMC":"宁河县","WEIGHT6":13360,"WEIGHT1":3120,"SJMC":"天津市","WEIGHT3":14160,"WEIGHT2":4080,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":9},{"LIMIT_TOTAL":49000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 09:05:04.509","SORTING":"0","OLD_CHECK_NO":"TJ210131709100905020801","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":50420,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":2.8979591836734695,"UNLOAD_WEIGHT":0,"OVER_TOTAL":1420,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"4780,5360,13560,7700,8920,10100","AXLES":6,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":12,"CHECK_TIME":"2017-09-10 09:05:02.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 09:05:04.509","SPEED":0,"CHECK_NO":"120020170910090502B6BE0F691ABF3F","WEIGHT5":8920,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":7700,"DSMC":"宁河县","WEIGHT6":10100,"WEIGHT1":4780,"SJMC":"天津市","WEIGHT3":13560,"WEIGHT2":5360,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":10},{"LIMIT_TOTAL":49000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 07:36:54.009","SORTING":"0","OLD_CHECK_NO":"TJ210131709100736520737","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":51380,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":4.857142857142857,"UNLOAD_WEIGHT":0,"OVER_TOTAL":2380,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"3860,4020,15080,11240,7620,9560","AXLES":6,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":12,"CHECK_TIME":"2017-09-10 07:36:52.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 07:36:54.009","SPEED":0,"CHECK_NO":"1200201709100736527F98F66B30ED33","WEIGHT5":7620,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":11240,"DSMC":"宁河县","WEIGHT6":9560,"WEIGHT1":3860,"SJMC":"天津市","WEIGHT3":15080,"WEIGHT2":4020,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":11},{"LIMIT_TOTAL":49000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 07:26:42.95","SORTING":"0","OLD_CHECK_NO":"TJ210131709100726450729","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":52140,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":6.408163265306122,"UNLOAD_WEIGHT":0,"OVER_TOTAL":3140,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"3200,4040,11900,8600,10940,13460","AXLES":6,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":12,"CHECK_TIME":"2017-09-10 07:26:45.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 07:26:42.95","SPEED":0,"CHECK_NO":"120020170910072645864AF338B99E0E","WEIGHT5":10940,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":8600,"DSMC":"宁河县","WEIGHT6":13460,"WEIGHT1":3200,"SJMC":"天津市","WEIGHT3":11900,"WEIGHT2":4040,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":12},{"LIMIT_TOTAL":18000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 06:21:19.524","SORTING":"0","OLD_CHECK_NO":"TJ210131709100621200657","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":20840,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":15.777777777777779,"UNLOAD_WEIGHT":0,"OVER_TOTAL":2840,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"6160,14680","AXLES":2,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":4,"CHECK_TIME":"2017-09-10 06:21:20.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 06:21:19.524","SPEED":0,"CHECK_NO":"1200201709100621209A4951672514A1","WEIGHT5":0,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":0,"DSMC":"宁河县","WEIGHT6":0,"WEIGHT1":6160,"SJMC":"天津市","WEIGHT3":0,"WEIGHT2":14680,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":13},{"LIMIT_TOTAL":49000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 05:57:34.277","SORTING":"0","OLD_CHECK_NO":"TJ210131709100557310630","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":51140,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":4.36734693877551,"UNLOAD_WEIGHT":0,"OVER_TOTAL":2140,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"3340,3880,12280,13040,10740,7860","AXLES":6,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":12,"CHECK_TIME":"2017-09-10 05:57:31.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 05:57:34.277","SPEED":0,"CHECK_NO":"12002017091005573164E2E98F9882C6","WEIGHT5":10740,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":13040,"DSMC":"宁河县","WEIGHT6":7860,"WEIGHT1":3340,"SJMC":"天津市","WEIGHT3":12280,"WEIGHT2":3880,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":14},{"LIMIT_TOTAL":49000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 05:52:36.376","SORTING":"0","OLD_CHECK_NO":"TJ210131709100552340620","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":52760,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":7.673469387755102,"UNLOAD_WEIGHT":0,"OVER_TOTAL":3760,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"3280,4220,14500,8600,9020,13140","AXLES":6,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":12,"CHECK_TIME":"2017-09-10 05:52:34.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 05:52:36.376","SPEED":0,"CHECK_NO":"1200201709100552340C09BB7170E0CA","WEIGHT5":9020,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":8600,"DSMC":"宁河县","WEIGHT6":13140,"WEIGHT1":3280,"SJMC":"天津市","WEIGHT3":14500,"WEIGHT2":4220,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":15},{"LIMIT_TOTAL":49000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 05:49:53.417","SORTING":"0","OLD_CHECK_NO":"TJ210131709100549540617","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":51440,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":4.979591836734694,"UNLOAD_WEIGHT":0,"OVER_TOTAL":2440,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"4200,8880,9320,9120,8000,11920","AXLES":6,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":12,"CHECK_TIME":"2017-09-10 05:49:54.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 05:49:53.417","SPEED":0,"CHECK_NO":"1200201709100549540BC718A9200BFC","WEIGHT5":8000,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":9120,"DSMC":"宁河县","WEIGHT6":11920,"WEIGHT1":4200,"SJMC":"天津市","WEIGHT3":9320,"WEIGHT2":8880,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":16},{"LIMIT_TOTAL":49000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 05:49:19.065","SORTING":"0","OLD_CHECK_NO":"TJ210131709100549170616","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":50320,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":2.693877551020408,"UNLOAD_WEIGHT":0,"OVER_TOTAL":1320,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"2960,2760,13280,9820,9420,12080","AXLES":6,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":12,"CHECK_TIME":"2017-09-10 05:49:17.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 05:49:19.065","SPEED":0,"CHECK_NO":"12002017091005491703CBE37F0C9CF6","WEIGHT5":9420,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":9820,"DSMC":"宁河县","WEIGHT6":12080,"WEIGHT1":2960,"SJMC":"天津市","WEIGHT3":13280,"WEIGHT2":2760,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":17},{"LIMIT_TOTAL":49000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 05:41:05.71","SORTING":"0","OLD_CHECK_NO":"TJ210131709100541030608","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":51020,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":4.122448979591836,"UNLOAD_WEIGHT":0,"OVER_TOTAL":2020,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"3160,2520,12260,11260,9780,12040","AXLES":6,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":12,"CHECK_TIME":"2017-09-10 05:41:03.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 05:41:05.71","SPEED":0,"CHECK_NO":"120020170910054103027E69887E1F1A","WEIGHT5":9780,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":11260,"DSMC":"宁河县","WEIGHT6":12040,"WEIGHT1":3160,"SJMC":"天津市","WEIGHT3":12260,"WEIGHT2":2520,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":18},{"LIMIT_TOTAL":49000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 05:08:00.573","SORTING":"0","OLD_CHECK_NO":"TJ210131709100508020571","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":53380,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":8.938775510204081,"UNLOAD_WEIGHT":0,"OVER_TOTAL":4380,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"3700,4420,15540,10680,8640,10400","AXLES":6,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":12,"CHECK_TIME":"2017-09-10 05:08:02.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 05:08:00.573","SPEED":0,"CHECK_NO":"120020170910050802F4E67ADF012277","WEIGHT5":8640,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":10680,"DSMC":"宁河县","WEIGHT6":10400,"WEIGHT1":3700,"SJMC":"天津市","WEIGHT3":15540,"WEIGHT2":4420,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":19},{"LIMIT_TOTAL":49000,"ROAD_CODE":"S205","CREATE_TIME":"2017-04-10 04:57:53.274","SORTING":"0","OLD_CHECK_NO":"TJ210131709100457540561","CREATE_BY":"DATA_RECV","SITE_ID":"12002015111971C45125FA9D4019B60F","TOTAL":50580,"SHORT_NAME":"芦台桥治超检测站","ROAD_NAME":"宝芦线","FLOAT_TOTAL":0,"CXL":3.2244897959183674,"UNLOAD_WEIGHT":0,"OVER_TOTAL":1580,"CHECK_RESULT":"2","UPDATE_BY":"DATA_RECV","CHECK_TYPE":"1","WEIGHT":"3260,3840,14460,7020,8820,13180","AXLES":6,"LINE":"3","SITE_NAME":"芦台桥治超检测站","TYRES":12,"CHECK_TIME":"2017-09-10 04:57:54.0","VEHICLE_NO":"无车牌","UPDATE_TIME":"2017-04-10 04:57:53.274","SPEED":0,"CHECK_NO":"120020170910045754FA02CB26F81E86","WEIGHT5":8820,"VEHICLE_TOTAL":0,"CHECK_BY":"106","WEIGHT4":7020,"DSMC":"宁河县","WEIGHT6":13180,"WEIGHT1":3260,"SJMC":"天津市","WEIGHT3":14460,"WEIGHT2":3840,"VEHICLE_LOAD":0,"WEIGHT_OTHER":0,"DATA":"","ROW_SEQ_NO":20}]
     * code : 0000
     */

    private String message;
    private String code;
    /**
     * LIMIT_TOTAL : 18000
     * ROAD_CODE : S205
     * CREATE_TIME : 2017-04-10 15:22:33.175
     * SORTING : 0
     * OLD_CHECK_NO : TJ210131709101522301257
     * CREATE_BY : DATA_RECV
     * SITE_ID : 12002015111971C45125FA9D4019B60F
     * TOTAL : 19020
     * SHORT_NAME : 芦台桥治超检测站
     * ROAD_NAME : 宝芦线
     * FLOAT_TOTAL : 0
     * CXL : 5.666666666666667
     * UNLOAD_WEIGHT : 0
     * OVER_TOTAL : 1020
     * CHECK_RESULT : 2
     * UPDATE_BY : DATA_RECV
     * CHECK_TYPE : 1
     * WEIGHT : 5840,13180
     * AXLES : 2
     * LINE : 3
     * SITE_NAME : 芦台桥治超检测站
     * TYRES : 4
     * CHECK_TIME : 2017-09-10 15:22:30.0
     * VEHICLE_NO : 无车牌
     * UPDATE_TIME : 2017-04-10 15:22:33.175
     * SPEED : 0
     * CHECK_NO : 1200201709101522308597FAB0098F41
     * WEIGHT5 : 0
     * VEHICLE_TOTAL : 0
     * CHECK_BY : 106
     * WEIGHT4 : 0
     * DSMC : 宁河县
     * WEIGHT6 : 0
     * WEIGHT1 : 5840
     * SJMC : 天津市
     * WEIGHT3 : 0
     * WEIGHT2 : 13180
     * VEHICLE_LOAD : 0
     * WEIGHT_OTHER : 0
     * DATA :
     * ROW_SEQ_NO : 1
     */

    private List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    /*
        private String IMAGES;
        private String VIDEOS;
        private String VEHICLE_TYPE;
     */
    public static class DataBean {
        private String IMAGES;
        private String VIDEOS;
        private String VEHICLE_TYPE;

        public String getIMAGES() {
            return IMAGES;
        }

        public void setIMAGES(String IMAGES) {
            this.IMAGES = IMAGES;
        }

        public String getVIDEOS() {
            return VIDEOS;
        }

        public void setVIDEOS(String VIDEOS) {
            this.VIDEOS = VIDEOS;
        }

        public String getVEHICLE_TYPE() {
            return VEHICLE_TYPE;
        }

        public void setVEHICLE_TYPE(String VEHICLE_TYPE) {
            this.VEHICLE_TYPE = VEHICLE_TYPE;
        }

        private int LIMIT_TOTAL;
        private String ROAD_CODE;
        private String CREATE_TIME;
        private String SORTING;
        private String OLD_CHECK_NO;
        private String CREATE_BY;
        private String SITE_ID;
        private int TOTAL;
        private String SHORT_NAME;
        private String ROAD_NAME;
        private int FLOAT_TOTAL;
        private double CXL;
        private int UNLOAD_WEIGHT;
        private int OVER_TOTAL;
        private String CHECK_RESULT;
        private String UPDATE_BY;
        private String CHECK_TYPE;
        private String WEIGHT;
        private int AXLES;
        private String LINE;
        private String SITE_NAME;
        private int TYRES;
        private String CHECK_TIME;
        private String VEHICLE_NO;
        private String UPDATE_TIME;
        private int SPEED;
        private String CHECK_NO;
        private int WEIGHT5;
        private int VEHICLE_TOTAL;
        private String CHECK_BY;
        private int WEIGHT4;
        private String DSMC;
        private int WEIGHT6;
        private int WEIGHT1;
        private String SJMC;
        private int WEIGHT3;
        private int WEIGHT2;
        private int VEHICLE_LOAD;
        private int WEIGHT_OTHER;
        private String DATA;
        private int ROW_SEQ_NO;

        public int getLIMIT_TOTAL() {
            return LIMIT_TOTAL;
        }

        public void setLIMIT_TOTAL(int LIMIT_TOTAL) {
            this.LIMIT_TOTAL = LIMIT_TOTAL;
        }

        public String getROAD_CODE() {
            return ROAD_CODE;
        }

        public void setROAD_CODE(String ROAD_CODE) {
            this.ROAD_CODE = ROAD_CODE;
        }

        public String getCREATE_TIME() {
            return CREATE_TIME;
        }

        public void setCREATE_TIME(String CREATE_TIME) {
            this.CREATE_TIME = CREATE_TIME;
        }

        public String getSORTING() {
            return SORTING;
        }

        public void setSORTING(String SORTING) {
            this.SORTING = SORTING;
        }

        public String getOLD_CHECK_NO() {
            return OLD_CHECK_NO;
        }

        public void setOLD_CHECK_NO(String OLD_CHECK_NO) {
            this.OLD_CHECK_NO = OLD_CHECK_NO;
        }

        public String getCREATE_BY() {
            return CREATE_BY;
        }

        public void setCREATE_BY(String CREATE_BY) {
            this.CREATE_BY = CREATE_BY;
        }

        public String getSITE_ID() {
            return SITE_ID;
        }

        public void setSITE_ID(String SITE_ID) {
            this.SITE_ID = SITE_ID;
        }

        public int getTOTAL() {
            return TOTAL;
        }

        public void setTOTAL(int TOTAL) {
            this.TOTAL = TOTAL;
        }

        public String getSHORT_NAME() {
            return SHORT_NAME;
        }

        public void setSHORT_NAME(String SHORT_NAME) {
            this.SHORT_NAME = SHORT_NAME;
        }

        public String getROAD_NAME() {
            return ROAD_NAME;
        }

        public void setROAD_NAME(String ROAD_NAME) {
            this.ROAD_NAME = ROAD_NAME;
        }

        public int getFLOAT_TOTAL() {
            return FLOAT_TOTAL;
        }

        public void setFLOAT_TOTAL(int FLOAT_TOTAL) {
            this.FLOAT_TOTAL = FLOAT_TOTAL;
        }

        public double getCXL() {
            return CXL;
        }

        public void setCXL(double CXL) {
            this.CXL = CXL;
        }

        public int getUNLOAD_WEIGHT() {
            return UNLOAD_WEIGHT;
        }

        public void setUNLOAD_WEIGHT(int UNLOAD_WEIGHT) {
            this.UNLOAD_WEIGHT = UNLOAD_WEIGHT;
        }

        public int getOVER_TOTAL() {
            return OVER_TOTAL;
        }

        public void setOVER_TOTAL(int OVER_TOTAL) {
            this.OVER_TOTAL = OVER_TOTAL;
        }

        public String getCHECK_RESULT() {
            return CHECK_RESULT;
        }

        public void setCHECK_RESULT(String CHECK_RESULT) {
            this.CHECK_RESULT = CHECK_RESULT;
        }

        public String getUPDATE_BY() {
            return UPDATE_BY;
        }

        public void setUPDATE_BY(String UPDATE_BY) {
            this.UPDATE_BY = UPDATE_BY;
        }

        public String getCHECK_TYPE() {
            return CHECK_TYPE;
        }

        public void setCHECK_TYPE(String CHECK_TYPE) {
            this.CHECK_TYPE = CHECK_TYPE;
        }

        public String getWEIGHT() {
            return WEIGHT;
        }

        public void setWEIGHT(String WEIGHT) {
            this.WEIGHT = WEIGHT;
        }

        public int getAXLES() {
            return AXLES;
        }

        public void setAXLES(int AXLES) {
            this.AXLES = AXLES;
        }

        public String getLINE() {
            return LINE;
        }

        public void setLINE(String LINE) {
            this.LINE = LINE;
        }

        public String getSITE_NAME() {
            return SITE_NAME;
        }

        public void setSITE_NAME(String SITE_NAME) {
            this.SITE_NAME = SITE_NAME;
        }

        public int getTYRES() {
            return TYRES;
        }

        public void setTYRES(int TYRES) {
            this.TYRES = TYRES;
        }

        public String getCHECK_TIME() {
            return CHECK_TIME;
        }

        public void setCHECK_TIME(String CHECK_TIME) {
            this.CHECK_TIME = CHECK_TIME;
        }

        public String getVEHICLE_NO() {
            return VEHICLE_NO;
        }

        public void setVEHICLE_NO(String VEHICLE_NO) {
            this.VEHICLE_NO = VEHICLE_NO;
        }

        public String getUPDATE_TIME() {
            return UPDATE_TIME;
        }

        public void setUPDATE_TIME(String UPDATE_TIME) {
            this.UPDATE_TIME = UPDATE_TIME;
        }

        public int getSPEED() {
            return SPEED;
        }

        public void setSPEED(int SPEED) {
            this.SPEED = SPEED;
        }

        public String getCHECK_NO() {
            return CHECK_NO;
        }

        public void setCHECK_NO(String CHECK_NO) {
            this.CHECK_NO = CHECK_NO;
        }

        public int getWEIGHT5() {
            return WEIGHT5;
        }

        public void setWEIGHT5(int WEIGHT5) {
            this.WEIGHT5 = WEIGHT5;
        }

        public int getVEHICLE_TOTAL() {
            return VEHICLE_TOTAL;
        }

        public void setVEHICLE_TOTAL(int VEHICLE_TOTAL) {
            this.VEHICLE_TOTAL = VEHICLE_TOTAL;
        }

        public String getCHECK_BY() {
            return CHECK_BY;
        }

        public void setCHECK_BY(String CHECK_BY) {
            this.CHECK_BY = CHECK_BY;
        }

        public int getWEIGHT4() {
            return WEIGHT4;
        }

        public void setWEIGHT4(int WEIGHT4) {
            this.WEIGHT4 = WEIGHT4;
        }

        public String getDSMC() {
            return DSMC;
        }

        public void setDSMC(String DSMC) {
            this.DSMC = DSMC;
        }

        public int getWEIGHT6() {
            return WEIGHT6;
        }

        public void setWEIGHT6(int WEIGHT6) {
            this.WEIGHT6 = WEIGHT6;
        }

        public int getWEIGHT1() {
            return WEIGHT1;
        }

        public void setWEIGHT1(int WEIGHT1) {
            this.WEIGHT1 = WEIGHT1;
        }

        public String getSJMC() {
            return SJMC;
        }

        public void setSJMC(String SJMC) {
            this.SJMC = SJMC;
        }

        public int getWEIGHT3() {
            return WEIGHT3;
        }

        public void setWEIGHT3(int WEIGHT3) {
            this.WEIGHT3 = WEIGHT3;
        }

        public int getWEIGHT2() {
            return WEIGHT2;
        }

        public void setWEIGHT2(int WEIGHT2) {
            this.WEIGHT2 = WEIGHT2;
        }

        public int getVEHICLE_LOAD() {
            return VEHICLE_LOAD;
        }

        public void setVEHICLE_LOAD(int VEHICLE_LOAD) {
            this.VEHICLE_LOAD = VEHICLE_LOAD;
        }

        public int getWEIGHT_OTHER() {
            return WEIGHT_OTHER;
        }

        public void setWEIGHT_OTHER(int WEIGHT_OTHER) {
            this.WEIGHT_OTHER = WEIGHT_OTHER;
        }

        public String getDATA() {
            return DATA;
        }

        public void setDATA(String DATA) {
            this.DATA = DATA;
        }

        public int getROW_SEQ_NO() {
            return ROW_SEQ_NO;
        }

        public void setROW_SEQ_NO(int ROW_SEQ_NO) {
            this.ROW_SEQ_NO = ROW_SEQ_NO;
        }
    }
    /*
    private int LIMIT_TOTAL;
    private String ROAD_CODE;
    private String CREATE_TIME;
    private String SORTING;
    private String OLD_CHECK_NO;
    private String CREATE_BY;
    private int TOTAL;
    private String SITE_ID;
    private String IMAGES;
    private String ROAD_NAME;
    private int FLOAT_TOTAL;
    private double CXL;
    private int UNLOAD_WEIGHT;
    private int OVER_TOTAL;
    private String CHECK_RESULT;
    private String UPDATE_BY;
    private String WEIGHT;
    private String CHECK_TYPE;
    private int AXLES;
    private String LINE;
    private String SITE_NAME;
    private String CHECK_TIME;
    private String VEHICLE_NO;
    private String UPDATE_TIME;
    private int SPEED;
    private String CHECK_NO;
    private int WEIGHT5;
    private int WEIGHT4;
    private String DSMC;
    private int WEIGHT6;
    private int WEIGHT1;
    private String SJMC;
    private String VIDEOS;
    private int WEIGHT3;
    private int WEIGHT2;
    private int WEIGHT_OTHER;
    private String VEHICLE_TYPE;
    private int ROW_SEQ_NO;
    */


}
