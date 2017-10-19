package cn.org.tpri.www.overload.bean;

/**
 * 作者:丁文 on 2017/3/27.
 * copyright: www.tpri.org.cn
 */
public class RowTitle {
    private String dateString;
    private String weekString;
    private int availableRoomCount;

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getWeekString() {
        return weekString;
    }

    public void setWeekString(String weekString) {
        this.weekString = weekString;
    }

    public int getAvailableRoomCount() {
        return availableRoomCount;
    }

    public void setAvailableRoomCount(int availableRoomCount) {
        this.availableRoomCount = availableRoomCount;
    }
}
