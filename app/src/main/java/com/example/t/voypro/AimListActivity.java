package com.example.t.voypro;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class AimListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    // 리사이클
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 리사이클
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AimListRecyclerAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        // 이벤트 작동이 안됨.....;;;
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                Intent intentCall = new Intent(AimListActivity.this, AimAddActivity.class);
                startActivity(intentCall);
            }

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });


        // 목표 추가버튼
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AimListActivity.this, AimAddActivity.class);
                startActivity(intent);
                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                */
            }
        });

        // 네비게이션
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    // ★★★★ 여기가 MainActivity 카드에 뿌려질 내용
    private ArrayList<AimListData> getDataSet() {
        AimListData aimAdata = new AimListData();
        aimAdata.tag = "tag";
        aimAdata.content = "7시 발닦고 잠들기";
        aimAdata.startTime = "startDate";
        aimAdata.alam = "alam";
        aimAdata.week = "week";
        ArrayList<AimListData> results = new ArrayList<AimListData>();
        results.add(aimAdata);
        return results;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    // 네비게이션 메뉴
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_aim) {

        } else if (id == R.id.nav_facebook) {
            Intent intent = new Intent(AimListActivity.this, AimDetailedListActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_aimrecommend) { // 목표 추천
            Intent intent = new Intent(AimListActivity.this, AimRecommendListActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_badge) { // 뱃지 리스트
            Intent intent = new Intent(AimListActivity.this, BadgeListActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_graph) {
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}