package cn.org.tpri.www.overload.bean;

import java.io.Serializable;

/**
 * 作者:丁文 on 2017/1/18.
 * copyright: www.tpri.org.cn
 */

public class MapBean implements Serializable{


    private DataBean data;


    private String code;

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
        private int bytes;
        private String name;
        private String data;
        private String key;

        public int getBytes() {
            return bytes;
        }

        public void setBytes(int bytes) {
            this.bytes = bytes;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
