package com.example.t.voypro;

import android.provider.BaseColumns;

public class AimSchema implements BaseColumns {
    public static final String TABLE_NAME     = "voyaim_tbl";
    public static final String TAG_COL        = "tag_col";         // 태그
    public static final String CONTENT_COL    = "content_col";     // 목표 내용
    public static final String AlAM_COL       = "alam_col";        // 알람 시간
    public static final String STARTTIME_COL  = "starttime_col";   // 시작 날짜
    public static final String WEEK_COL       = "week_col";        // 수행 요일
}