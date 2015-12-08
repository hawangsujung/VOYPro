package com.example.t.voypro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class BadgeListActivity extends AppCompatActivity {

   static ImageView badge1, badge2, badge3, badge4, badge5, badge6, badge7, badge8, badge9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badge_list);

        badge1 = (ImageView) findViewById(R.id.badge_1_clover);
        badge2 = (ImageView) findViewById(R.id.badge_2_fanclub);
        badge3 = (ImageView) findViewById(R.id.badge_3);
        badge4 = (ImageView) findViewById(R.id.badge_4);
        badge5 = (ImageView) findViewById(R.id.badge_5);
        badge6 = (ImageView) findViewById(R.id.badge_6);
        badge7 = (ImageView) findViewById(R.id.badge_7);
        badge8 = (ImageView) findViewById(R.id.badge_8);
        badge9 = (ImageView) findViewById(R.id.badge_9);
    }

    public static void badgeGetCheck(int badgeNumber) {
        switch (badgeNumber) {
            case 1:
                badge1.setVisibility(View.VISIBLE);
                break;
            case 2:
                break;
            case BadgeData.BADGE_3:
                break;
            case BadgeData.BADGE_4:
                break;
            case BadgeData.BADGE_5:
                break;
            case BadgeData.BADGE_6:
                break;
            case BadgeData.BADGE_7:
                break;
            case BadgeData.BADGE_8:
                break;
            case BadgeData.BADGE_9:
                break;
        }
    }
}