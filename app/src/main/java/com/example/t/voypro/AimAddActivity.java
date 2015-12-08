package com.example.t.voypro;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AimAddActivity extends AppCompatActivity {
    TextView tagIcon;
    TextView contentEdit, alamSelect, periodSelect, weekSelect;
    TextView startTime;
    ImageView backgImage;

    // 현재 시간
    Calendar calendar = Calendar.getInstance();
    java.util.Date date = calendar.getTime();
    String toDay = (new SimpleDateFormat("yyyy/MM/dd").format(date));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aim_add);

        // 액션바
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        tagIcon      = (TextView)  findViewById(R.id.tagIcon);
        contentEdit  = (TextView)  findViewById(R.id.content);
        alamSelect   = (TextView)  findViewById(R.id.alamSelect);
        periodSelect = (TextView)  findViewById(R.id.periodSelect);
        weekSelect   = (TextView)  findViewById(R.id.weekSelect);
        startTime    = (TextView)  findViewById(R.id.startTime);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.aim_add, menu);
        return true;
    }

    // 액션바
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // 확인 버튼
            case R.id.act_add:
                if (!contentEdit.getText().toString().trim().equals("")) {
                    AimListData aimListData = new AimListData();

                    // 사용자가 입력한 데이터 받아냄
                    aimListData.tag       = tagIcon.getText().toString();
                    aimListData.content   = contentEdit.getText().toString();
                    aimListData.alam      = alamSelect.getText().toString();
                    aimListData.period    = periodSelect.getText().toString();
                    aimListData.week      = weekSelect.getText().toString();
                    aimListData.startTime = toDay.toLowerCase();

                    // DB - INSERT
                    AimSQLiteOpenHelper.openAimSQLiteDatabase().insertVOY(aimListData);

                    // EditText 비우기
                    tagIcon.setText("");

                    // 인텐트 종료
                    finish();
                }
                break;
            // back key
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
