package com.example.student.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataSql extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String ID = "id";
    private static final String Name = "name";
    public DataSql(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlite =ID  + Name ;
        db.execSQL(sqlite);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "SinhVien");
        onCreate(db);
    }

    //Add
    public void Add(SinhVien sv) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", sv.getID());
        values.put("Name", sv.getName());
        db.insert("SinhVien", null, values);
        db.close();
    }

    //get
    public SinhVien getSinhVien(int studentId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("SinhVien", new String[] { ID, Name }, ID + "=?", new String[] { String.valueOf(ID) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        SinhVien sv = new SinhVien(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
        return sv;
    }

    //List
    public List getAllContacts() {

        List contactList = new ArrayList();
        String selectQuery = "SELECT  * FROM " + "SinhVien";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {

            do {
                SinhVien contact = new SinhVien(1,"Kiet");
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contactList.add(contact);
            } while (cursor.moveToNext());

        }

        return contactList;

    }

    //Updating
    public int Update(SinhVien sv) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Name, sv.getName());
        return db.update("SinhVien", values, ID + " = ?", new String[] { String.valueOf(sv.getID()) });
    }

    //Detele
    public void Detele(SinhVien sv) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("SinhVien", ID + " = ?", new String[] { String.valueOf(sv.getID()) });
        db.close();
    }
}
