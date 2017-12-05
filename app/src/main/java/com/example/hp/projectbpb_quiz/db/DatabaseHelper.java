package com.example.hp.projectbpb_quiz.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hp.projectbpb_quiz.R;

/**
 * Created by HP on 5/12/2560.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "animal.db";
    private static final int DATABASE_VERSION = 8;

    public static final String TABLE_NAME1 = "blood";
    public static final String COL_ID1 = "_id1";
    public static final String COL_NAME1 = "blood";
    public static final String COL_PICTURE1 = "picture1";
    public static final String COL_DEATIL1 = "detail1";


    public static final String TABLE_NAME2 = "zodiac";
    public static final String COL_ID2 = "_id2";
    public static final String COL_NAME2 = "zodiac";
    public static final String COL_PICTURE2= "picture2";
    public static final String COL_DEATIL2 = "detail2";

    public static final String SQL_CREATE_TABLE = "CREATE TABLE "+TABLE_NAME1+"("
            +COL_ID1+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COL_NAME1+" TEXT, "
            +COL_PICTURE1+" TEXT, "
            +COL_DEATIL1+" TEXT"
            +")";
    public static final String SQL_CREATE_TABLE2 = "CREATE TABLE "+TABLE_NAME2+"("
            +COL_ID2+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COL_NAME2+" TEXT, "
            +COL_PICTURE2+" TEXT, "
            +COL_DEATIL2+" TEXT"
            +")";

    private Context mContext;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
        db.execSQL(SQL_CREATE_TABLE2);
        insertInitialData(db);
    }
    private void insertInitialData(SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME1, "A");
        cv.put(COL_PICTURE1, "a.png");
        cv.put(COL_DEATIL1, mContext.getString(R.string.details_a));
        db.insert(TABLE_NAME1,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME1, "B");
        cv.put(COL_PICTURE1, "b.png");
        cv.put(COL_DEATIL1, mContext.getString(R.string.details_b));
        db.insert(TABLE_NAME1,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME1, "O");
        cv.put(COL_PICTURE1, "o.png");
        cv.put(COL_DEATIL1, mContext.getString(R.string.details_o));
        db.insert(TABLE_NAME1,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME1, "AB");
        cv.put(COL_PICTURE1, "ab.png");
        cv.put(COL_DEATIL1, mContext.getString(R.string.details_ab));
        db.insert(TABLE_NAME1,null,cv);

        cv.put(COL_NAME2, "Aries");
        cv.put(COL_PICTURE2, "aries-1.png");
        cv.put(COL_DEATIL2, mContext.getString(R.string.details_aries));
        db.insert(TABLE_NAME2,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME2, "Gemini");
        cv.put(COL_PICTURE2, "gemini.png");
        cv.put(COL_DEATIL2, mContext.getString(R.string.details_gemini));
        db.insert(TABLE_NAME2,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME2, "Cancer");
        cv.put(COL_PICTURE2, "cancer.png");
        cv.put(COL_DEATIL2, mContext.getString(R.string.details_cancer));
        db.insert(TABLE_NAME2,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME2, "Leo");
        cv.put(COL_PICTURE2, "leo.png");
        cv.put(COL_DEATIL2, mContext.getString(R.string.details_leo));
        db.insert(TABLE_NAME2,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME2, "Virgo");
        cv.put(COL_PICTURE2, "virgo.png");
        cv.put(COL_DEATIL2, mContext.getString(R.string.details_virgo));
        db.insert(TABLE_NAME2,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME2, "Libra");
        cv.put(COL_PICTURE2, "libra.png");
        cv.put(COL_DEATIL2, mContext.getString(R.string.details_libra));
        db.insert(TABLE_NAME2,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME2, "Scorpio ");
        cv.put(COL_PICTURE2, "scorpio.png");
        cv.put(COL_DEATIL2, mContext.getString(R.string.details_scorpio));
        db.insert(TABLE_NAME2,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME2, "Sagittarius");
        cv.put(COL_PICTURE2, "sagittarius.png");
        cv.put(COL_DEATIL2, mContext.getString(R.string.details_sagittarius));
        db.insert(TABLE_NAME2,null,cv);
        cv = new ContentValues();

        cv.put(COL_NAME2, "Capricorn");
        cv.put(COL_PICTURE2, "capricorn.png");
        cv.put(COL_DEATIL2, mContext.getString(R.string.details_capricorn));
        db.insert(TABLE_NAME2,null,cv);
        cv = new ContentValues();

        cv.put(COL_NAME2, "Aquarius");
        cv.put(COL_PICTURE2, "aquarius.png");
        cv.put(COL_DEATIL2, mContext.getString(R.string.details_aquarius));
        db.insert(TABLE_NAME2,null,cv);
        cv = new ContentValues();

        cv.put(COL_NAME2, "Pisces");
        cv.put(COL_PICTURE2, "pisces.png");
        cv.put(COL_DEATIL2, mContext.getString(R.string.details_pisces));
        db.insert(TABLE_NAME2,null,cv);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);

        onCreate(db);
    }
}

