package cn.org.tpri.www.overload.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者:丁文 on 2017/3/29.
 * copyright: www.tpri.org.cn
 */

public class NetWorkBean implements Serializable{

    /**
     * message : 处理成功
     * data : [{"SITE_NAME":"海滨高速（南-北）","DIST_NAME":"天津市市辖区滨海新区","RECENTLY_CHECK_TIME":"2017-03-29 09:55:57.0","DSDM":"120116","SHORT_NAME":"海滨（南-北）","ROAD_NAME":"海滨高速","RECENTLY_CONN_TIME":"2017-03-29 09:56:06.112"},{"SITE_NAME":"塘汉快速路（北-南）","DIST_NAME":"天津市市辖区滨海新区","RECENTLY_CHECK_TIME":"2017-03-29 09:56:27.0","DSDM":"120116","SHORT_NAME":"塘汉（北-南）","ROAD_NAME":"塘汉线","RECENTLY_CONN_TIME":"2017-03-29 09:56:06.112"},{"SITE_NAME":"塘汉快速路（南-北）","DIST_NAME":"天津市市辖区滨海新区","RECENTLY_CHECK_TIME":"2017-03-25 02:10:22.0","DSDM":"120116","SHORT_NAME":"塘汉（南-北）","ROAD_NAME":"塘汉线","RECENTLY_CONN_TIME":"2017-03-29 09:56:06.112"},{"SITE_NAME":"港城大道","DIST_NAME":"天津市市辖区滨海新区","RECENTLY_CHECK_TIME":"2017-03-29 09:56:01.0","DSDM":"120116","SHORT_NAME":"港城大道","ROAD_NAME":"港城大道","RECENTLY_CONN_TIME":"2017-03-29 09:56:06.112"},{"SITE_NAME":"京津高速联络线（待建）","DIST_NAME":"天津市市辖区滨海新区","DSDM":"120116","SHORT_NAME":"京津高速联络线","ROAD_NAME":"京津联络线"},{"SITE_NAME":"西中环快速路","DIST_NAME":"天津市市辖区滨海新区","RECENTLY_CHECK_TIME":"2017-03-29 09:56:01.0","DSDM":"120116","SHORT_NAME":"西中环快速路","ROAD_NAME":"西中环快速路","RECENTLY_CONN_TIME":"2017-03-29 09:56:06.112"},{"SITE_NAME":"疏港二线","DIST_NAME":"天津市市辖区滨海新区","DSDM":"120116","SHORT_NAME":"疏港二线","ROAD_NAME":"海滨高速"},{"SITE_NAME":"疏港一线","DIST_NAME":"天津市市辖区滨海新区","RECENTLY_CHECK_TIME":"2017-03-29 09:54:29.845","DSDM":"120116","SHORT_NAME":"疏港一线","ROAD_NAME":"海滨高速","RECENTLY_CONN_TIME":"2017-03-29 09:56:06.112"},{"SITE_NAME":"京门大道","DIST_NAME":"天津市市辖区滨海新区","RECENTLY_CHECK_TIME":"2017-03-29 09:56:14.54","DSDM":"120116","SHORT_NAME":"京门大道","ROAD_NAME":"海滨高速","RECENTLY_CONN_TIME":"2017-03-29 09:56:06.112"},{"SITE_NAME":"新港四号路","DIST_NAME":"天津市市辖区滨海新区","RECENTLY_CHECK_TIME":"2017-03-29 09:56:19.49","DSDM":"120116","SHORT_NAME":"新港四号路","ROAD_NAME":"海滨高速","RECENTLY_CONN_TIME":"2017-03-29 09:56:00.877"},{"SITE_NAME":"海滨高速（北-南）","DIST_NAME":"天津市市辖区滨海新区","RECENTLY_CHECK_TIME":"2017-03-29 09:55:37.0","DSDM":"120116","SHORT_NAME":"海滨（北-南）","ROAD_NAME":"海滨高速","RECENTLY_CONN_TIME":"2017-03-29 09:56:06.112"},{"SITE_NAME":"疏港联络线（待建）","DIST_NAME":"天津市市辖区滨海新区","DSDM":"120116","SHORT_NAME":"疏港联络线","ROAD_NAME":"津沽线"},{"SITE_NAME":"津晋高速延长线","DIST_NAME":"天津市市辖区滨海新区","RECENTLY_CHECK_TIME":"2017-03-29 09:56:01.0","DSDM":"120116","SHORT_NAME":"津晋高速","ROAD_NAME":"津晋高速","RECENTLY_CONN_TIME":"2017-03-29 09:56:06.112"},{"SITE_NAME":"港塘路","DIST_NAME":"天津市市辖区滨海新区","RECENTLY_CHECK_TIME":"2017-03-29 09:56:23.0","DSDM":"120116","SHORT_NAME":"港塘路","ROAD_NAME":"塘港线","RECENTLY_CONN_TIME":"2017-03-29 09:56:06.112"},{"SITE_NAME":"轻纺大道","DIST_NAME":"天津市市辖区滨海新区","RECENTLY_CHECK_TIME":"2017-03-26 18:27:46.0","DSDM":"120116","SHORT_NAME":"轻纺大道","ROAD_NAME":"海滨高速","RECENTLY_CONN_TIME":"2017-03-26 18:28:04.516"},{"SITE_NAME":"津沽一线","DIST_NAME":"天津市市辖区滨海新区","RECENTLY_CHECK_TIME":"2017-03-29 05:49:00.881","DSDM":"120116","SHORT_NAME":"津沽一线","ROAD_NAME":"津沽线","RECENTLY_CONN_TIME":"2017-03-29 05:48:51.577"},{"SITE_NAME":"长江道跨渠桥","DIST_NAME":"天津市市辖区滨海新区","RECENTLY_CHECK_TIME":"2017-03-23 06:59:16.832","DSDM":"120116","SHORT_NAME":"长江道跨渠桥","ROAD_NAME":"海滨高速","RECENTLY_CONN_TIME":"2017-03-23 06:59:43.542"},{"SITE_NAME":"长江道散货物流卡子门","DIST_NAME":"天津市市辖区滨海新区","RECENTLY_CHECK_TIME":"2017-03-29 09:55:17.035","DSDM":"120116","SHORT_NAME":"长江道卡子门","ROAD_NAME":"海滨高速","RECENTLY_CONN_TIME":"2017-03-29 09:55:25.851"},{"SITE_NAME":"津晋高速渤海十路路口西侧","DIST_NAME":"天津市市辖区滨海新区","RECENTLY_CHECK_TIME":"2017-03-29 09:56:00.186","DSDM":"120116","SHORT_NAME":"津晋高速-卡口","ROAD_NAME":"海滨高速","RECENTLY_CONN_TIME":"2017-03-29 09:56:00.877"}]
     * code : 0000
     */

    private String message;
    private String code;
    /**
     * SITE_NAME : 海滨高速（南-北）
     * DIST_NAME : 天津市市辖区滨海新区
     * RECENTLY_CHECK_TIME : 2017-03-29 09:55:57.0
     * DSDM : 120116
     * SHORT_NAME : 海滨（南-北）
     * ROAD_NAME : 海滨高速
     * RECENTLY_CONN_TIME : 2017-03-29 09:56:06.112
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

    public static class DataBean {
        private String SITE_NAME;
        private String XZQH;
        private String DIST_NAME;
        private String CHECK_COUNT;
        private String RECENTLY_CHECK_TIME;
        private String DSDM;
        private String SHORT_NAME;
        private String ROAD_NAME;
        private String RECENTLY_CONN_TIME;
        private String SJMC;

        public String getXZQH() {
            return XZQH;
        }

        public void setXZQH(String XZQH) {
            this.XZQH = XZQH;
        }

        public String getSJMC() {
            return SJMC;
        }

        public void setSJMC(String SJMC) {
            this.SJMC = SJMC;
        }

        public String getCHECK_COUNT() {
            return CHECK_COUNT;
        }

        public void setCHECK_COUNT(String CHECK_COUNT) {
            this.CHECK_COUNT = CHECK_COUNT;
        }

        public String getSITE_NAME() {
            return SITE_NAME;
        }

        public void setSITE_NAME(String SITE_NAME) {
            this.SITE_NAME = SITE_NAME;
        }

        public String getDIST_NAME() {
            return DIST_NAME;
        }

        public void setDIST_NAME(String DIST_NAME) {
            this.DIST_NAME = DIST_NAME;
        }

        public String getRECENTLY_CHECK_TIME() {
            return RECENTLY_CHECK_TIME;
        }

        public void setRECENTLY_CHECK_TIME(String RECENTLY_CHECK_TIME) {
            this.RECENTLY_CHECK_TIME = RECENTLY_CHECK_TIME;
        }

        public String getDSDM() {
            return DSDM;
        }

        public void setDSDM(String DSDM) {
            this.DSDM = DSDM;
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

        public String getRECENTLY_CONN_TIME() {
            return RECENTLY_CONN_TIME;
        }

        public void setRECENTLY_CONN_TIME(String RECENTLY_CONN_TIME) {
            this.RECENTLY_CONN_TIME = RECENTLY_CONN_TIME;
        }
    }
}
