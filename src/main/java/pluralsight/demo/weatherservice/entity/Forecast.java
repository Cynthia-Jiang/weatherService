package pluralsight.demo.weatherservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Forecast implements Serializable {
    private static final long serialVersionUID = 1L;
    //日期
    private String date;
    //最高温度
    private String high;
    //风力
    @JsonProperty("fengli")
    private String fengli;
    //最低温度
    private String low;
    //风向
    @JsonProperty("fengxiang")
    private String fengxiang;
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
        return fengxiang;
    }

    public void setFx(String fx) {
        this.fengxiang = fx;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFl() {
        return fengli;
    }

    public void setFl(String fl) {
        this.fengli = fl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Forecast [date=" + date + ", high=" + high + ", fx=" + fengxiang + ", low=" + low + ", fl=" + fengli + ", type="
                + type + "]";
    }
}
