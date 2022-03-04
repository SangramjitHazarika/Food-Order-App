package com.example.foodorderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "database1.db";
    final static int DBVERSION = 2;

    public DBHelper(Context context) {
        super(context, DBNAME , null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "Create table orders " +
                        "(id integer primary key autoincrement," +
                        "name text," +
                        "phone text," +
                        "price integer," +
                        "image integer," +
                        "quantity integer," +
                        "description text," +
                        "foodName text);"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists orders;");
        onCreate(db);
    }

    public boolean insertOrder(String name, String phone, int price, int image, int quantity, String description, String foodName) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("quantity", quantity);
        values.put("description", description);
        values.put("foodName", foodName);
        long id = database.insert("orders", null, values);
        if(id<0) {
            return false;
        } else {
            return true;
        }
    }
}
