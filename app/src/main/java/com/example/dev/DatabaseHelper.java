package com.example.dev;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MenuDB";
    private static final int DATABASE_VERSION = 2;


    public static final String TABLE_MENU = "menu_items";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_DESCRIPTION = "description";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MENU_TABLE = "CREATE TABLE " + TABLE_MENU + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_CATEGORY + " TEXT, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_PRICE + " REAL, "
                + COLUMN_IMAGE + " INTEGER, "
                + COLUMN_DESCRIPTION + " TEXT)";
        db.execSQL(CREATE_MENU_TABLE);


        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {

        addMenuItem(db, "Sıcak İçecekler", "Çay", 15.0, R.drawable.cay);
        addMenuItem(db, "Sıcak İçecekler", "Kahve", 30.0, R.drawable.kahve);
        addMenuItem(db, "Sıcak İçecekler", "Sahlep", 35.0, R.drawable.salep);
        addMenuItem(db, "Sıcak İçecekler", "Sıcak Çikolata", 40.0, R.drawable.sicakcikolata);


        addMenuItem(db, "Soğuk İçecekler", "Kola", 25.0, R.drawable.cola);
        addMenuItem(db, "Soğuk İçecekler", "Ayran", 15.0, R.drawable.ayran);
        addMenuItem(db, "Soğuk İçecekler", "Limonata", 30.0, R.drawable.limonata);
        addMenuItem(db, "Soğuk İçecekler", "Ice Tea", 25.0, R.drawable.icetea);


        addMenuItem(db, "Tatlılar", "Baklava", 75.0, R.drawable.baklava);
        addMenuItem(db, "Tatlılar", "Künefe", 85.0, R.drawable.kunefe);
        addMenuItem(db, "Tatlılar", "Sütlaç", 45.0, R.drawable.sutlac);
        addMenuItem(db, "Tatlılar", "Kazandibi", 50.0, R.drawable.kazandibi);


        addMenuItem(db, "Yemekler", "Kebap", 150.0, R.drawable.kebap);
        addMenuItem(db, "Yemekler", "Pide", 90.0, R.drawable.pide);
        addMenuItem(db, "Yemekler", "Lahmacun", 50.0, R.drawable.lahmacun);
        addMenuItem(db, "Yemekler", "İskender", 140.0, R.drawable.iskender);
    }

    private void addMenuItem(SQLiteDatabase db, String category, String name, double price, int imageResource) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_CATEGORY, category);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_PRICE, price);
        values.put(COLUMN_IMAGE, imageResource);
        db.insert(TABLE_MENU, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU);
        onCreate(db);
    }


    public Cursor getMenuItemsByCategory(String category) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_MENU,
                new String[]{COLUMN_ID, COLUMN_NAME, COLUMN_PRICE, COLUMN_IMAGE},
                COLUMN_CATEGORY + "=?",
                new String[]{category},
                null, null, null);
    }
} 