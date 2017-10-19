package cn.org.tpri.www.overload.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者:丁文 on 2017/4/1.
 * copyright: www.tpri.org.cn
 */

public class City_CountyBean implements Serializable{

    /**
     * message : 处理成功
     * xzqh_lev : 2
     * data : [{"DIST_NAME":"天津市市辖区和平区","DIST_CODE":"120101","TYPE_":"1","DIST_SHORT_NAME":"和平区","ORG_ID":"1200201511193272F50CAE2642A78D09"},{"DIST_NAME":"天津市市辖区河东区","DIST_CODE":"120102","TYPE_":"1","DIST_SHORT_NAME":"河东区","ORG_ID":"1200201511195BA700F2D99F4EDBB4C0"},{"DIST_NAME":"天津市市辖区河西区","DIST_CODE":"120103","TYPE_":"1","DIST_SHORT_NAME":"河西区","ORG_ID":"12002015111972F7A1E8A561466D8711"},{"DIST_NAME":"天津市市辖区南开区","DIST_CODE":"120104","TYPE_":"1","DIST_SHORT_NAME":"南开区","ORG_ID":"1200201511190CD69D31E0F34D169C55"},{"DIST_NAME":"天津市市辖区河北区","DIST_CODE":"120105","TYPE_":"1","DIST_SHORT_NAME":"河北区","ORG_ID":"12002015111968A8E24512C345C4B0E5"},{"DIST_NAME":"天津市市辖区红桥区","DIST_CODE":"120106","TYPE_":"1","DIST_SHORT_NAME":"红桥区","ORG_ID":"120020151119AB00D6910CB04204A886"},{"DIST_NAME":"天津市市辖区东丽区","DIST_CODE":"120110","TYPE_":"1","DIST_SHORT_NAME":"东丽区","ORG_ID":"12002015111961FB9D6496D4452B8B40"},{"DIST_NAME":"天津市市辖区西青区","DIST_CODE":"120111","TYPE_":"1","DIST_SHORT_NAME":"西青区","ORG_ID":"120020151119A2AD5CA422044E7D943F"},{"DIST_NAME":"天津市市辖区津南区","DIST_CODE":"120112","TYPE_":"1","DIST_SHORT_NAME":"津南区","ORG_ID":"1200201511192FC77263397342558566"},{"DIST_NAME":"天津市市辖区北辰区","DIST_CODE":"120113","TYPE_":"1","DIST_SHORT_NAME":"北辰区","ORG_ID":"120020151119DD19B43076744B72B633"},{"DIST_NAME":"天津市市辖区武清区","DIST_CODE":"120114","TYPE_":"1","DIST_SHORT_NAME":"武清区","ORG_ID":"120020151119A5A1ABAE52F340C1B05B"},{"DIST_NAME":"天津市市辖区宝坻区","DIST_CODE":"120115","TYPE_":"1","DIST_SHORT_NAME":"宝坻区","ORG_ID":"120020151119825B39E2EBE64AFF89F3"},{"DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","TYPE_":"1","DIST_SHORT_NAME":"滨海新区","ORG_ID":"120020151119CE37FB2772BA4349AF92"},{"DIST_NAME":"天津市县宁河县","DIST_CODE":"120221","TYPE_":"1","DIST_SHORT_NAME":"宁河县","ORG_ID":"120020151119C71E262D728A47879FEB"},{"DIST_NAME":"天津市县静海县","DIST_CODE":"120223","TYPE_":"1","DIST_SHORT_NAME":"静海县","ORG_ID":"120020151119ABE0DB4569C84BA28F32"},{"DIST_NAME":"天津市县蓟县","DIST_CODE":"120225","TYPE_":"1","DIST_SHORT_NAME":"蓟县","ORG_ID":"120020151119291C3F1FF0EB4707BE14"}]
     * code : 0000
     */

    private String message;
    private String xzqh_lev;
    private String code;
    /**
     * DIST_NAME : 天津市市辖区和平区
     * DIST_CODE : 120101
     * TYPE_ : 1
     * DIST_SHORT_NAME : 和平区
     * ORG_ID : 1200201511193272F50CAE2642A78D09
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
        private String DIST_NAME;
        private String DIST_CODE;
        private String TYPE_;
        private String DIST_SHORT_NAME;
        private String ORG_ID;

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
