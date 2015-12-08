package com.example.t.voypro;


public class AimListData {
    public long _id;
    public String tag;         // 태그
    public String content;     // 내용
    public String alam;        // 알람시간
    public String period;      // 기간
    public String week;        // 수행 요일
    public String startTime;   // 시작날짜


    @Override
    public String toString() {
        return "AimListData{" +
                "_id=" + _id +
                ", tag='" + tag + '\'' +
                ", content='" + content + '\'' +
                ", alam='" + alam + '\'' +
                ", period='" + period + '\'' +
                ", week='" + week + '\'' +
                ", startTime='" + startTime + '\'' +
                '}';
    }
}