package com.cs_360.project_two;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    // creating a constant variables for our database.
    private static final String DB_NAME = "inventorydb";
    private static final int DB_VERSION = 2;
    private static final String USERS_TABLE_NAME = "users";
    private static final String PRODUCTS_TABLE_NAME = "products";


    private static final String ID_COL = "id";


    private static final String USERNAME_COL = "username";

    // below variable id for our course duration column.
    private static final String PASSWORD_COL = "password";


    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create SQLite query and set column names along with their data types.
        String query = "CREATE TABLE " + USERS_TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USERNAME_COL + " TEXT,"
                + PASSWORD_COL + " TEXT)";

        // execute above sql query
        db.execSQL(query);
    }

    // Add new user to database
    public Boolean addUserToDatabase(String username, String password) {

        // Call writable method for database
        SQLiteDatabase db = this.getWritableDatabase();

        // Create variable for content values.
        ContentValues values = new ContentValues();

        // Pass all values along with key, value pair.
        values.put(USERNAME_COL, username);
        values.put(PASSWORD_COL, password);

        // Pass content values to table.
        long result = db.insert(USERS_TABLE_NAME, null, values);

        // Close database when done
        db.close();

        return result == -1;
    }

    public Boolean checkUsername(String username) {
        // Call writable method for database
        SQLiteDatabase db = this.getWritableDatabase();
        // Fetch username from database
        Cursor cursor = db.query(USERS_TABLE_NAME, new String[]{username}, "username=?", new String[]{username}, null, null, null);
        cursor.close();
        // return true if a user is found
        return cursor.getCount() > 0;
    }

    public Boolean checkUsernameAndPassword(String username, String password) {
        // Call writable method for database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + USERS_TABLE_NAME +
                " WHERE " + USERNAME_COL + " = " + username + " AND " + PASSWORD_COL + " = " + password,
                new String[]{username, password});
        cursor.close();
        return cursor.getCount() > 0;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE_NAME);
        onCreate(db);
    }
}