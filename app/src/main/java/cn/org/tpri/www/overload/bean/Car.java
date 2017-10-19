package cn.org.tpri.www.overload.bean;

import java.io.Serializable;

/**
 * 作者:丁文 on 2017/2/9.
 * copyright: www.tpri.org.cn
 */
public class Car implements Serializable{
    String img_id;
    String car_license;
    String check_address;
    String check_time;
    int check_weight;
    String day_data;
    String overload_rate;
    int index;
    String video;

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    byte[] car_map;

    public byte[] getCar_map() {
        return car_map;
    }

    public void setCar_map(byte[] car_map) {
        this.car_map = car_map;
    }

    public int getLimittotal() {
        return limittotal;
    }

    public void setLimittotal(int limittotal) {
        this.limittotal = limittotal;
    }

    int limittotal;

    public int getOvertotal() {
        return overtotal;
    }

    public void setOvertotal(int overtotal) {
        this.overtotal = overtotal;
    }

    int overtotal;

    public String  getImg_id() {
        return img_id;
    }

    public void setImg_id(String img_id) {
        this.img_id = img_id;
    }

    public String getCar_license() {
        return car_license;
    }

    public void setCar_license(String car_license) {
        this.car_license = car_license;
    }

    public String getCheck_address() {
        return check_address;
    }

    public void setCheck_address(String check_address) {
        this.check_address = check_address;
    }

    public String getCheck_time() {
        return check_time;
    }

    public void setCheck_time(String check_time) {
        this.check_time = check_time;
    }

    public int getCheck_weight() {
        return check_weight;
    }

    public void setCheck_weight(int check_weight) {
        this.check_weight = check_weight;
    }

    public String getDay_data() {
        return day_data;
    }

    public void setDay_data(String day_data) {
        this.day_data = day_data;
    }

    public String getOverload_rate() {
        return overload_rate;
    }

    public void setOverload_rate(String overload_rate) {
        this.overload_rate = overload_rate;
    }
}
