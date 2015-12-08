package com.example.t.voypro;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

// 목표 상세리스트 액티비티
public class AimDetailedListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = AimDetailedListActivity.class.getName();

    // 현재 시간
    Calendar calendar = Calendar.getInstance();
    java.util.Date date = calendar.getTime();
    String toDay = (new SimpleDateFormat("yyyy/MM/dd").format(date));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aim_detailed_list);

        // 액션바 - 장착
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

// 리사이클러뷰
        mRecyclerView = (RecyclerView) findViewById(R.id.aim_detailed_list_recycler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AimDetailedListRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
    }

    // 리사이클러뷰
    @Override
    protected void onResume() {
        super.onResume();
        ((AimDetailedListRecyclerViewAdapter) mAdapter).setOnItemClickListener(new AimDetailedListRecyclerViewAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

    // List의 개수 - 태그, 세부내용, 시작날짜
    private ArrayList<AimDetailedListData> getDataSet() {
        ArrayList results = new ArrayList<AimDetailedListData>();
        for (int index = 0; index <=20; index++) {
            AimDetailedListData obj = new AimDetailedListData("D+"+index, "7시에 헬스장 Gogo!!", "달성", toDay.toLowerCase());
            results.add(index, obj);
        }
        return results;
    }


    // 액션바 - 레이아웃
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.aim_detailed_list, menu);
        return true;
    }

    // 액션바 - 이벤트
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.act_end:
                finish();
                break;
            case R.id.act_del:
                finish();
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
