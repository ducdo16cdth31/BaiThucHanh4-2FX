package sample;

public class TimeModel {
    private String second;
    private String minute;
    private String hour;

    public TimeModel() {
    }

    public TimeModel(String second, String minute, String hour) {
        this.second = second;
        this.minute = minute;
        this.hour = hour;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
