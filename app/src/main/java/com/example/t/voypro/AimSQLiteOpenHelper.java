package com.example.t.voypro;

import android.content.ContentValues;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by T on 2015-12-03.
 */
public class AimSQLiteOpenHelper extends SQLiteOpenHelper {
    private static String DB_NAME = "voySchema.db";
    private static int DB_VERSION = 1;
    private static AimSQLiteOpenHelper openHelper;

    private AimSQLiteOpenHelper() {
        super(VOYApplication.getContext(), DB_NAME, null, DB_VERSION);
    }

    // 생성자 - 현재 객체 생성
    public static AimSQLiteOpenHelper openAimSQLiteDatabase() {
        if (openHelper == null) {
            openHelper = new AimSQLiteOpenHelper();
        }
        return openHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder buf = new StringBuilder();
        buf.append(" CREATE TABLE ")
                .append(AimSchema.TABLE_NAME)
                .append(" ( ")
                .append(AimSchema._ID)
                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(AimSchema.TAG_COL)
                .append(" TEXT, ")
                .append(AimSchema.CONTENT_COL)
                .append(" TEXT, ")
                .append(AimSchema.AlAM_COL)
                .append(" TEXT, ")
                .append(AimSchema.STARTTIME_COL)
                .append(" TEXT, ")
                .append(AimSchema.WEEK_COL)
                .append(" TEXT ); ");
        db.execSQL(buf.toString());
    }

    public long insertVOY(AimListData aimListData) {
        SQLiteDatabase db = AimSQLiteOpenHelper.openAimSQLiteDatabase().getWritableDatabase();
        long resultID = -1;

        try {
            Log.e("들어옴", ">>>>>>>>11");
            ContentValues values = new ContentValues();
            values.put(AimSchema.TAG_COL,       aimListData.tag);
            values.put(AimSchema.CONTENT_COL,   aimListData.content);
            values.put(AimSchema.AlAM_COL,      aimListData.alam);
            values.put(AimSchema.STARTTIME_COL, aimListData.startTime);
            values.put(AimSchema.WEEK_COL, aimListData.week);

            db.beginTransaction();
            resultID = db.insert(AimSchema.TABLE_NAME, null, values);
            db.setTransactionSuccessful();

            Log.e("", " 주제:" + aimListData.content.toString());
            Log.e("들어옴", ">>>>>>>>22");
            Log.e("id 값 증가 >>>>>>", resultID + "");
        } catch (SQLiteAbortException sql) {
            Log.e("SQL에러 insertVOY >>>>> ", sql.toString());
        } catch (Exception e) {
            Log.e("에러 insertVOY >>>>> ", e.toString());
        } finally {
            if (db != null) {
                db.endTransaction();
                db.close();
            }
        }
        return resultID;
    }

    public void deleteVOY(AimListData aimListData) {
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = AimSchema._ID + " =? ";
        String[] whereArgs = new String[]{"" + aimListData._id};

        try {
            db.beginTransaction();
            db.delete(AimSchema.TABLE_NAME, whereClause, whereArgs);
            db.setTransactionSuccessful();
        } catch (SQLiteException sqe) {
            Log.e("SQL에러 deleteVOY >>>>> ", sqe.toString());
        } catch (Exception e) {
            Log.e("에러 deleteVOY >>>>> ", e.getMessage());
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    // 필요없음
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
