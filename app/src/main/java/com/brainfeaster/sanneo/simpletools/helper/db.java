//http://androidexample.com/SQLite_Database_Manipulation_Class_-_Android_Example/index.php?view=article_discription&aid=51

package com.brainfeaster.sanneo.simpletools.helper;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class db extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ST_DBase.db";
    public static final int DATABASE_VERSION = 1;
    public List<String> CREATE_SQL;

    public db(Context context,List<String> createSql) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        CREATE_SQL = createSql;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //if (DEBUG) Log.i(LOG_TAG, "new create");
        try {
            for (String table : CREATE_SQL) {
                db.execSQL(table);
            }
            // if (DEBUG) Log.i(LOG_TAG, "Exception onCreate() exception");
        } catch (Exception exception) {

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // if (DEBUG) Log.w(LOG_TAG, "Upgrading database from version" + oldVersion + "to" + newVersion + "...");
        for (String table : CREATE_SQL) {
            db.execSQL("DROP TABLE IF EXISTS " + table);
        }
        onCreate(db);
    }

    public static String sqlEscapeString(String aString) {
        String aReturn = "";

        if (null != aString) {
            //aReturn = aString.replace(", );
            aReturn = DatabaseUtils.sqlEscapeString(aString);
            // Remove the enclosing single quotes ...
            aReturn = aReturn.substring(1, aReturn.length() - 1);
        }

        return aReturn;
    }

    public synchronized SQLiteDatabase open() throws SQLException {
        return this.getWritableDatabase();
    }

    public static String sqlUnEscapeString(String aString) {
        String aReturn ="";
        if (null != aString) {
            aReturn = aString.replace( "", "");
        }
        return aReturn;
    }
}
