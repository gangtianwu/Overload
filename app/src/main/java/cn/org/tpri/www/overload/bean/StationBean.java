package cn.org.tpri.www.overload.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者:丁文 on 2017/3/23.
 * copyright: www.tpri.org.cn
 */

public class StationBean implements Serializable{

    /**
     * message : 处理成功
     * xzqh_lev : 3
     * data : [{"SITE_NAME":"津晋高速渤海十路路口西侧","SITE_CODE":"1201160208","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"00002016102242A682C7BF2A4E7CD1CF","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"马棚口治超检测站","SITE_CODE":"1201160001","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"120020151119087BAE12634145A398AB","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"长江道跨渠桥","SITE_CODE":"1201160206","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"000020161022411EBD3EC4DD1BBC56BD","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"津沽一线","SITE_CODE":"1201160205","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"0000201610224A2DAE23224116EDD139","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"轻纺大道","SITE_CODE":"1201160110","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"00002016102241698AE0E65E6E2CD2B0","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"港塘路","SITE_CODE":"1201160109","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"0000201610224C06963486F3CF2E0307","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"津晋高速延长线","SITE_CODE":"1201160108","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"00002016102246AEAB8DAB1F246F664C","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"疏港联络线（待建）","SITE_CODE":"1201160107","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"0000201610224EE8977CF50F1A9F3EAF","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"海滨高速（北-南）","SITE_CODE":"1201160106","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"0000201610224018B3E4499D46CC808D","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"新港四号路","SITE_CODE":"1201160204","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"0000201610224EC0A3DAC665B7A1D68C","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"京门大道","SITE_CODE":"1201160203","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"00002016102242D0B4E3D4B53836807E","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"疏港一线","SITE_CODE":"1201160202","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"0000201610224783AA939E5005388C96","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"疏港二线","SITE_CODE":"1201160201","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"0000201610224468B4C72230378F1B0C","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"西中环快速路","SITE_CODE":"1201160105","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"0000201610224AA0873133936CCB4829","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"京津高速联络线（待建）","SITE_CODE":"1201160104","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"0000201610224001833DE0B52BC09DC0","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"港城大道","SITE_CODE":"1201160103","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"000020161022438F88EE1995ABB0C8AA","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"塘汉快速路（南-北）","SITE_CODE":"1201160102","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"0000201610224EAEB5F1F79F01C68EAD","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"塘汉快速路（北-南）","SITE_CODE":"1201160113","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"0000201610224EAEB5F1F79F01C68123","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"海滨高速（南-北）","SITE_CODE":"1201160112","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"12002016122846C19819CB00AE27DAAB","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"高庄治超检查站","SITE_CODE":"1201160002","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"12002015111937A1653D44B84B8B88F7","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"SITE_NAME":"长江道散货物流卡子门","SITE_CODE":"1201160207","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"00002016102249C695B771B64DC5343C","TYPE_":"2","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"}]
     * code : 0000
     */

    private String message;
    private String xzqh_lev;
    private String code;
    /**
     * SITE_NAME : 津晋高速渤海十路路口西侧
     * SITE_CODE : 1201160208
     * DIST_NAME : 天津市市辖区滨海新区
     * DIST_CODE : 120116
     * SITE_ID : 00002016102242A682C7BF2A4E7CD1CF
     * TYPE_ : 2
     * DIST_SHORT_NAME : 滨海新区
     * ORG_ID : 120020151119CE37FB2772BA4349AF92
     */

    private List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getXzqh_lev() {
        return xzqh_lev;
    }

    public void setXzqh_lev(String xzqh_lev) {
        this.xzqh_lev = xzqh_lev;
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
        private String SITE_CODE;
        private String DIST_NAME;
        private String DIST_CODE;
        private String SITE_ID;
        private String TYPE_;
        private String DIST_SHORT_NAME;
        private String ORG_ID;

        public String getSITE_NAME() {
            return SITE_NAME;
        }

        public void setSITE_NAME(String SITE_NAME) {
            this.SITE_NAME = SITE_NAME;
        }

        public String getSITE_CODE() {
            return SITE_CODE;
        }

        public void setSITE_CODE(String SITE_CODE) {
            this.SITE_CODE = SITE_CODE;
        }

        public String getDIST_NAME() {
            return DIST_NAME;
        }

        public void setDIST_NAME(String DIST_NAME) {
            this.DIST_NAME = DIST_NAME;
        }

        public String getDIST_CODE() {
            return DIST_CODE;
        }

        public void setDIST_CODE(String DIST_CODE) {
            this.DIST_CODE = DIST_CODE;
        }

        public String getSITE_ID() {
            return SITE_ID;
        }

        public void setSITE_ID(String SITE_ID) {
            this.SITE_ID = SITE_ID;
        }

        public String getTYPE_() {
            return TYPE_;
        }

        public void setTYPE_(String TYPE_) {
            this.TYPE_ = TYPE_;
        }

        public String getDIST_SHORT_NAME() {
            return DIST_SHORT_NAME;
        }

        public void setDIST_SHORT_NAME(String DIST_SHORT_NAME) {
            this.DIST_SHORT_NAME = DIST_SHORT_NAME;
        }

        public String getORG_ID() {
            return ORG_ID;
        }

        public void setORG_ID(String ORG_ID) {
            this.ORG_ID = ORG_ID;
        }
    }
}
