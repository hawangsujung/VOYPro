package com.example.t.voypro;

// 목표 데이터
public class AimData {
    public long _id;          // 아이디
    public String tag;         // 태그 (운동, 저금, 공부, 자기계발, 기타)
    public String content;    // 목표 세부내용
    public String period;     // 기간
    public String alarm_time; // 알람 설정
    public String week;        // 목표 시작 날짜
    public String start_day;  // 목표 시작날짜
    public String complete;   // 목표 완료 여부

    @Override
    public String toString() {
        return "AimData{" +
                "_id=" + _id +
                ", tag='" + tag + '\'' +
                ", content='" + content + '\'' +
                ", period='" + period + '\'' +
                ", alarm_time='" + alarm_time + '\'' +
                ", week='" + week + '\'' +
                ", start_day='" + start_day + '\'' +
                ", complete='" + complete + '\'' +
                '}';
    }
}