package cn.org.tpri.www.overload.bean;

import java.io.Serializable;

/**
 * 作者:丁文 on 2017/3/17.
 * copyright: www.tpri.org.cn
 */
public class LoginBean implements Serializable {


    private DataBean data;
    /**
     * data : {"org_id":["11000000000000000000000000000000","11000000000000000000000000000000"],"org_name":"北京市交通委","user_name":"北京市","sex":"","disable_flag":"0","token":"0D03FD208A264E89B8C3A365C0A2F8DF","privs":"AbcaD","tel":"","dist_code":"110000","dist_short_name":"北京市","org_code":"10011000000","user_id":"beijing","dist_name":"北京市"}
     * code : 0000
     */

    private String code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class DataBean {
        private String org_name;
        private String user_name;
        private String sex;
        private String disable_flag;
        private String token;
        private String privs;
        private String tel;
        private String dist_code;
        private String dist_short_name;
        private String org_code;
        private String user_id;
        private String dist_name;
        private String org_id;
        private  String role_code;

        public String getRole_code() {
            return role_code;
        }

        public void setRole_code(String role_code) {
            this.role_code = role_code;
        }

        public String getOrg_name() {
            return org_name;
        }

        public void setOrg_name(String org_name) {
            this.org_name = org_name;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getDisable_flag() {
            return disable_flag;
        }

        public void setDisable_flag(String disable_flag) {
            this.disable_flag = disable_flag;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getPrivs() {
            return privs;
        }

        public void setPrivs(String privs) {
            this.privs = privs;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getDist_code() {
            return dist_code;
        }

        public void setDist_code(String dist_code) {
            this.dist_code = dist_code;
        }

        public String getDist_short_name() {
            return dist_short_name;
        }

        public void setDist_short_name(String dist_short_name) {
            this.dist_short_name = dist_short_name;
        }

        public String getOrg_code() {
            return org_code;
        }

        public void setOrg_code(String org_code) {
            this.org_code = org_code;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getDist_name() {
            return dist_name;
        }

        public void setDist_name(String dist_name) {
            this.dist_name = dist_name;
        }

        public String getOrg_id() {
            return org_id;
        }

        public void setOrg_id(String org_id) {
            this.org_id = org_id;
        }
    }
}
