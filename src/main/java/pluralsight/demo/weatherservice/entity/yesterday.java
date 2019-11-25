package pluralsight.demo.weatherservice.entity;

import java.io.Serializable;

public class yesterday implements Serializable {
    private static final long serialVersionUID = 1L;
    //日期
    private String date;
    //最高温度
    private String high;
    //风向
    private String fx;
    //最低温度
    private String low;
    //风力
    private String fl;
    //天气情况
    private String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Yesterday [date=" + date + ", high=" + high + ", fx=" + fx + ", low=" + low + ", fl=" + fl + ", type="
                + type + "]";
    }

}
