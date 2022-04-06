package com.seng405.localdata_sp_db.DB;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.seng405.localdata_sp_db.Entity.Person;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

public class DB extends SQLiteOpenHelper {

    private static DB dbInstance = null;
    private final static String databaseName = "rollCallDB";
    private final static int databaseVersion = 1;
    private String PERSON_TABLE = "Persons";


    public synchronized static DB getInstance(Context context)
    {
        if(dbInstance == null)
        {
            dbInstance = new DB(context.getApplicationContext());
        }
        return dbInstance;
    }

    public DB(Context context)
    {
        super(context,databaseName,null,databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createQuery = "CREATE TABLE " + PERSON_TABLE + " ("
                + " userID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " name TEXT,"
                + " surname TEXT,"
                + " phoneNumber TEXT,"
                + " company TEXT,"
                + " email TEXT"
                + " )";

        sqLiteDatabase.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    @SuppressLint("Range")
    public Person getPerson(int Id)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(
                PERSON_TABLE,
                null,
                "userID= ? " ,
                new String[]{ String.valueOf(Id) },
                null,
                null,
                null
        );

        Person person;

        //Person(String name, String surname, int userId, String phoneNumber, String company, String email) {
        if(cursor.moveToFirst())
        {
            new Person(
                    cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getString(cursor.getColumnIndex("surname")),
                    cursor.getInt(cursor.getColumnIndex("userID")),
                    cursor.getString(cursor.getColumnIndex("phoneNumber")),
                    cursor.getString(cursor.getColumnIndex("company")),
                    cursor.getString(cursor.getColumnIndex("email"))
            );
        }

        return null;


    }

    @SuppressLint("Range")
    public ArrayList<Person> getPersonList()
    {
        ArrayList<Person> personArrayList = new ArrayList<Person>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(
                PERSON_TABLE,
                null,
                null,
                null,
                null,
                null,
                null
        );

        Person person;

        if(cursor.moveToFirst())
        {
            do {
                personArrayList.add(
                        new Person(
                                cursor.getString(cursor.getColumnIndex("name")),
                                cursor.getString(cursor.getColumnIndex("surname")),
                                cursor.getInt(cursor.getColumnIndex("userID")),
                                cursor.getString(cursor.getColumnIndex("phoneNumber")),
                                cursor.getString(cursor.getColumnIndex("company")),
                                cursor.getString(cursor.getColumnIndex("email"))
                        )
                );

            }
            while(cursor.moveToNext());
        }

        sqLiteDatabase.close();

        return personArrayList;
    }

    public void updatePerson(String name, String surname, int userId, String phoneNumber, String company, String email)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("name",name);
        contentValues.put("surname",surname);
        contentValues.put("phoneNumber",phoneNumber);
        contentValues.put("company",company);
        contentValues.put("email",email);

        sqLiteDatabase.update(
                PERSON_TABLE,
                contentValues,
                "userID= ? ",
                new String[]{
                        String.valueOf(userId)
                }
        );



        sqLiteDatabase.close();
    }

    public void deletePerson(int Id)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.delete(
                PERSON_TABLE,
                "userID= ? ",
                new String[]{
                        String.valueOf(Id)
                }
        );

        sqLiteDatabase.close();

    }

    public void addNewPerson(String name, String surname, String phoneNumber, String company, String email)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("name",name);
        contentValues.put("surname",surname);
        contentValues.put("phoneNumber",phoneNumber);
        contentValues.put("company",company);
        contentValues.put("email",email);

        sqLiteDatabase.insert(PERSON_TABLE,null,contentValues);
        sqLiteDatabase.close();




    }

}
