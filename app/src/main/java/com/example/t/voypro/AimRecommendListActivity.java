package com.example.t.voypro;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 목표 추천 리스트 액티비티
public class AimRecommendListActivity extends AppCompatActivity {
    ExpandableListView list;
    ExpandableListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aim_recommend_list);
        list = (ExpandableListView) findViewById(R.id.listView_expandable);

        // ExpandableListView - 리스트 생성
        List<Map<String, String>> groupItem = new ArrayList<Map<String, String>>();
        List<List<Map<String, String>>> subItem = new ArrayList<List<Map<String, String>>>();

        // 그룹 1 - 운동
        Map<String, String> groupList1 = new HashMap<String, String>();

        groupList1.put("group", "운동");
        groupItem.add(groupList1);

        // 운동 List
        List<Map<String, String>> List1 = new ArrayList<Map<String, String>>();

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "걷기");
        map.put("2", "달리기");
        map.put("3", "팔굽혀펴기");
        map.put("4", "윗몸일으키기");
        map.put("5", "자전거타기");
        map.put("6", "계단오르기");
        map.put("7", "하늘자전거");
        List1.add(map);
        subItem.add(List1);

        // ExpandableListView - 어뎁터 생성
        adapter = new SimpleExpandableListAdapter(this, groupItem,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{"group"},
                new int[]{android.R.id.text1, android.R.id.text2},

                subItem, android.R.layout.simple_expandable_list_item_2,
                new String[]{"sub"}, new int[]{android.R.id.text1});
        list.setAdapter(adapter);

        // ExpandableListView - 이벤트 처리
        list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                // 선택된 리스트번째의 key값의 정보를 담는 객체

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AimRecommendListActivity.this);
                alertDialogBuilder.setTitle("새로운 목표");
                alertDialogBuilder.setMessage("에 도전하시겠습니까?").setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                Toast.makeText(getBaseContext(), groupPosition + "번째 " + childPosition, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}