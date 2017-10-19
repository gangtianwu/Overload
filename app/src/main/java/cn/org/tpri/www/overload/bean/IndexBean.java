package cn.org.tpri.www.overload.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者:丁文 on 2017/3/28.
 * copyright: www.tpri.org.cn
 */

public class IndexBean implements Serializable{

    /**
     * message : 处理成功
     * data : [{"SITE_NAME":"海滨高速（南-北）","BIG_OVER_COUNT":106,"OVER_COUNT":2388,"UNLOAD_COUNT":0,"DIST_NAME":"天津市市辖区滨海新区","CHECK_COUNT":12888,"UNLOAD_TOTAL":0,"SITE_ID":"12002016122846C19819CB00AE27DAAB","CXL55YX":12184,"CXL55YS":704,"ZS_6":4934,"CXL":0.19,"ZS_6YS":0,"ZS_2":4462,"ZS_3":1223,"ZS_4":1615,"ZS_5":654,"DIST_CODE":"120116","CX100_":224},{"SITE_NAME":"京津高速联络线（待建）","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"0000201610224001833DE0B52BC09DC0"},{"SITE_NAME":"长江道跨渠桥","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"000020161022411EBD3EC4DD1BBC56BD"},{"SITE_NAME":"轻纺大道","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"00002016102241698AE0E65E6E2CD2B0"},{"SITE_NAME":"津晋高速渤海十路路口西侧","BIG_OVER_COUNT":0,"OVER_COUNT":0,"UNLOAD_COUNT":0,"DIST_NAME":"天津市市辖区滨海新区","CHECK_COUNT":1154,"UNLOAD_TOTAL":0,"SITE_ID":"00002016102242A682C7BF2A4E7CD1CF","CXL55YX":1154,"CXL55YS":0,"ZS_6":0,"CXL":0,"ZS_6YS":0,"ZS_2":0,"ZS_3":0,"ZS_4":0,"ZS_5":0,"DIST_CODE":"120116","CX100_":0},{"SITE_NAME":"京门大道","BIG_OVER_COUNT":0,"OVER_COUNT":0,"UNLOAD_COUNT":0,"DIST_NAME":"天津市市辖区滨海新区","CHECK_COUNT":18073,"UNLOAD_TOTAL":0,"SITE_ID":"00002016102242D0B4E3D4B53836807E","CXL55YX":18073,"CXL55YS":0,"ZS_6":0,"CXL":0,"ZS_6YS":0,"ZS_2":0,"ZS_3":0,"ZS_4":0,"ZS_5":0,"DIST_CODE":"120116","CX100_":0},{"SITE_NAME":"港城大道","BIG_OVER_COUNT":51,"OVER_COUNT":1597,"UNLOAD_COUNT":0,"DIST_NAME":"天津市市辖区滨海新区","CHECK_COUNT":14282,"UNLOAD_TOTAL":0,"SITE_ID":"000020161022438F88EE1995ABB0C8AA","CXL55YX":13625,"CXL55YS":657,"ZS_6":2168,"CXL":0.11,"ZS_6YS":0,"ZS_2":8023,"ZS_3":622,"ZS_4":2107,"ZS_5":1362,"DIST_CODE":"120116","CX100_":169},{"SITE_NAME":"疏港二线","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"0000201610224468B4C72230378F1B0C"},{"SITE_NAME":"津晋高速延长线","BIG_OVER_COUNT":0,"OVER_COUNT":1501,"UNLOAD_COUNT":0,"DIST_NAME":"天津市市辖区滨海新区","CHECK_COUNT":8469,"UNLOAD_TOTAL":0,"SITE_ID":"00002016102246AEAB8DAB1F246F664C","CXL55YX":8120,"CXL55YS":349,"ZS_6":3795,"CXL":0.18,"ZS_6YS":0,"ZS_2":3296,"ZS_3":615,"ZS_4":509,"ZS_5":254,"DIST_CODE":"120116","CX100_":1},{"SITE_NAME":"疏港一线","BIG_OVER_COUNT":0,"OVER_COUNT":0,"UNLOAD_COUNT":0,"DIST_NAME":"天津市市辖区滨海新区","CHECK_COUNT":16938,"UNLOAD_TOTAL":0,"SITE_ID":"0000201610224783AA939E5005388C96","CXL55YX":16938,"CXL55YS":0,"ZS_6":0,"CXL":0,"ZS_6YS":0,"ZS_2":0,"ZS_3":0,"ZS_4":0,"ZS_5":0,"DIST_CODE":"120116","CX100_":0},{"SITE_NAME":"长江道散货物流卡子门","BIG_OVER_COUNT":0,"OVER_COUNT":0,"UNLOAD_COUNT":0,"DIST_NAME":"天津市市辖区滨海新区","CHECK_COUNT":740,"UNLOAD_TOTAL":0,"SITE_ID":"00002016102249C695B771B64DC5343C","CXL55YX":740,"CXL55YS":0,"ZS_6":0,"CXL":0,"ZS_6YS":0,"ZS_2":0,"ZS_3":0,"ZS_4":0,"ZS_5":0,"DIST_CODE":"120116","CX100_":0},{"SITE_NAME":"津沽一线","BIG_OVER_COUNT":0,"OVER_COUNT":0,"UNLOAD_COUNT":0,"DIST_NAME":"天津市市辖区滨海新区","CHECK_COUNT":2718,"UNLOAD_TOTAL":0,"SITE_ID":"0000201610224A2DAE23224116EDD139","CXL55YX":2718,"CXL55YS":0,"ZS_6":0,"CXL":0,"ZS_6YS":0,"ZS_2":0,"ZS_3":0,"ZS_4":0,"ZS_5":0,"DIST_CODE":"120116","CX100_":0},{"SITE_NAME":"西中环快速路","BIG_OVER_COUNT":7,"OVER_COUNT":960,"UNLOAD_COUNT":0,"DIST_NAME":"天津市市辖区滨海新区","CHECK_COUNT":13711,"UNLOAD_TOTAL":0,"SITE_ID":"0000201610224AA0873133936CCB4829","CXL55YX":13416,"CXL55YS":295,"ZS_6":975,"CXL":0.07,"ZS_6YS":0,"ZS_2":10018,"ZS_3":313,"ZS_4":1710,"ZS_5":695,"DIST_CODE":"120116","CX100_":48},{"SITE_NAME":"港塘路","BIG_OVER_COUNT":124,"OVER_COUNT":1158,"UNLOAD_COUNT":0,"DIST_NAME":"天津市市辖区滨海新区","CHECK_COUNT":8231,"UNLOAD_TOTAL":0,"SITE_ID":"0000201610224C06963486F3CF2E0307","CXL55YX":7675,"CXL55YS":556,"ZS_6":1834,"CXL":0.14,"ZS_6YS":0,"ZS_2":4756,"ZS_3":129,"ZS_4":801,"ZS_5":711,"DIST_CODE":"120116","CX100_":166},{"SITE_NAME":"塘汉快速路（北-南）","BIG_OVER_COUNT":52,"OVER_COUNT":694,"UNLOAD_COUNT":0,"DIST_NAME":"天津市市辖区滨海新区","CHECK_COUNT":5388,"UNLOAD_TOTAL":0,"SITE_ID":"0000201610224EAEB5F1F79F01C68123","CXL55YX":4869,"CXL55YS":519,"ZS_6":924,"CXL":0.13,"ZS_6YS":0,"ZS_2":3426,"ZS_3":154,"ZS_4":648,"ZS_5":236,"DIST_CODE":"120116","CX100_":161},{"SITE_NAME":"塘汉快速路（南-北）","BIG_OVER_COUNT":5,"OVER_COUNT":323,"UNLOAD_COUNT":0,"DIST_NAME":"天津市市辖区滨海新区","CHECK_COUNT":3457,"UNLOAD_TOTAL":0,"SITE_ID":"0000201610224EAEB5F1F79F01C68EAD","CXL55YX":3366,"CXL55YS":91,"ZS_6":666,"CXL":0.09,"ZS_6YS":0,"ZS_2":2149,"ZS_3":118,"ZS_4":358,"ZS_5":166,"DIST_CODE":"120116","CX100_":16},{"SITE_NAME":"新港四号路","BIG_OVER_COUNT":0,"OVER_COUNT":0,"UNLOAD_COUNT":0,"DIST_NAME":"天津市市辖区滨海新区","CHECK_COUNT":10507,"UNLOAD_TOTAL":0,"SITE_ID":"0000201610224EC0A3DAC665B7A1D68C","CXL55YX":10507,"CXL55YS":0,"ZS_6":0,"CXL":0,"ZS_6YS":0,"ZS_2":0,"ZS_3":0,"ZS_4":0,"ZS_5":0,"DIST_CODE":"120116","CX100_":0},{"SITE_NAME":"疏港联络线（待建）","DIST_NAME":"天津市市辖区滨海新区","DIST_CODE":"120116","SITE_ID":"0000201610224EE8977CF50F1A9F3EAF"},{"SITE_NAME":"海滨高速（北-南）","BIG_OVER_COUNT":23,"OVER_COUNT":4113,"UNLOAD_COUNT":0,"DIST_NAME":"天津市市辖区滨海新区","CHECK_COUNT":29239,"UNLOAD_TOTAL":0,"SITE_ID":"0000201610224018B3E4499D46CC808D","CXL55YX":28165,"CXL55YS":1074,"ZS_6":9842,"CXL":0.14,"ZS_6YS":0,"ZS_2":14809,"ZS_3":770,"ZS_4":2535,"ZS_5":1283,"DIST_CODE":"120116","CX100_":93}]
     * code : 0000
     */

    private String message;
    private String code;
    /**
     * SITE_NAME : 海滨高速（南-北）
     * BIG_OVER_COUNT : 106
     * OVER_COUNT : 2388
     * UNLOAD_COUNT : 0
     * DIST_NAME : 天津市市辖区滨海新区
     * CHECK_COUNT : 12888
     * UNLOAD_TOTAL : 0
     * SITE_ID : 12002016122846C19819CB00AE27DAAB
     * CXL55YX : 12184
     * CXL55YS : 704
     * ZS_6 : 4934
     * CXL : 0.19
     * ZS_6YS : 0
     * ZS_2 : 4462
     * ZS_3 : 1223
     * ZS_4 : 1615
     * ZS_5 : 654
     * DIST_CODE : 120116
     * CX100_ : 224
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
        private String BIG_OVER_COUNT;
        private String OVER_COUNT;
        private String UNLOAD_COUNT;
        private String DIST_NAME;
        private String CHECK_COUNT;
        private String UNLOAD_TOTAL;
        private String SITE_ID;
        private String CXL55YX;
        private String CXL55YS;
        private String ZS_6;
        private String CXL;
        private String ZS_6YS;
        private String ZS_2;
        private String ZS_3;
        private String ZS_4;
        private String ZS_5;
        private String DIST_CODE;
        private String CX100_;
        private String SJMC;
        private String XZQH;

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

        public String getSITE_NAME() {
            return SITE_NAME;
        }

        public void setSITE_NAME(String SITE_NAME) {
            this.SITE_NAME = SITE_NAME;
        }

        public String getBIG_OVER_COUNT() {
            return BIG_OVER_COUNT;
        }

        public void setBIG_OVER_COUNT(String BIG_OVER_COUNT) {
            this.BIG_OVER_COUNT = BIG_OVER_COUNT;
        }

        public String getOVER_COUNT() {
            return OVER_COUNT;
        }

        public void setOVER_COUNT(String OVER_COUNT) {
            this.OVER_COUNT = OVER_COUNT;
        }

        public String getUNLOAD_COUNT() {
            return UNLOAD_COUNT;
        }

        public void setUNLOAD_COUNT(String UNLOAD_COUNT) {
            this.UNLOAD_COUNT = UNLOAD_COUNT;
        }

        public String getDIST_NAME() {
            return DIST_NAME;
        }

        public void setDIST_NAME(String DIST_NAME) {
            this.DIST_NAME = DIST_NAME;
        }

        public String getCHECK_COUNT() {
            return CHECK_COUNT;
        }

        public void setCHECK_COUNT(String CHECK_COUNT) {
            this.CHECK_COUNT = CHECK_COUNT;
        }

        public String getUNLOAD_TOTAL() {
            return UNLOAD_TOTAL;
        }

        public void setUNLOAD_TOTAL(String UNLOAD_TOTAL) {
            this.UNLOAD_TOTAL = UNLOAD_TOTAL;
        }

        public String getSITE_ID() {
            return SITE_ID;
        }

        public void setSITE_ID(String SITE_ID) {
            this.SITE_ID = SITE_ID;
        }

        public String getCXL55YX() {
            return CXL55YX;
        }

        public void setCXL55YX(String CXL55YX) {
            this.CXL55YX = CXL55YX;
        }

        public String getCXL55YS() {
            return CXL55YS;
        }

        public void setCXL55YS(String CXL55YS) {
            this.CXL55YS = CXL55YS;
        }

        public String getZS_6() {
            return ZS_6;
        }

        public void setZS_6(String ZS_6) {
            this.ZS_6 = ZS_6;
        }

        public String getCXL() {
            return CXL;
        }

        public void setCXL(String CXL) {
            this.CXL = CXL;
        }

        public String getZS_6YS() {
            return ZS_6YS;
        }

        public void setZS_6YS(String ZS_6YS) {
            this.ZS_6YS = ZS_6YS;
        }

        public String getZS_2() {
            return ZS_2;
        }

        public void setZS_2(String ZS_2) {
            this.ZS_2 = ZS_2;
        }

        public String getZS_3() {
            return ZS_3;
        }

        public void setZS_3(String ZS_3) {
            this.ZS_3 = ZS_3;
        }

        public String getZS_4() {
            return ZS_4;
        }

        public void setZS_4(String ZS_4) {
            this.ZS_4 = ZS_4;
        }

        public String getZS_5() {
            return ZS_5;
        }

        public void setZS_5(String ZS_5) {
            this.ZS_5 = ZS_5;
        }

        public String getDIST_CODE() {
            return DIST_CODE;
        }

        public void setDIST_CODE(String DIST_CODE) {
            this.DIST_CODE = DIST_CODE;
        }

        public String getCX100_() {
            return CX100_;
        }

        public void setCX100_(String CX100_) {
            this.CX100_ = CX100_;
        }
    }
}
