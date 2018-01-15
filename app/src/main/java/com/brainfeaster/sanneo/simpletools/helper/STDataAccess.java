package com.brainfeaster.sanneo.simpletools.helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.ArrayMap;

import com.brainfeaster.sanneo.app.rajyaSabhaMember.Config;
import com.brainfeaster.sanneo.app.rajyaSabhaMember.RajyaSabhaMember;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanja on 9/12/2017.
 */

public abstract class STDataAccess implements ISTDataAccess {
    public db ST_DATABASE;
    public String ST_TABLE = "";

    public STDataAccess(){ }

    public STDataAccess(db dbInstance) { ST_DATABASE = dbInstance; }

    public void checkAndAddData(ContentValues cVal,String dbfield, String fieldValue ) {
        SQLiteDatabase dbase = ST_DATABASE.open();
        //insert only if it is not already there :)
        if(!alreadyPresent(dbfield,fieldValue)){
            dbase.insert(ST_TABLE, null, cVal);
        }
        dbase.close();
    }

    public void addData(ContentValues cVal) {
        SQLiteDatabase dbase = ST_DATABASE.open();
        dbase.insert(ST_TABLE, null, cVal);
        dbase.close();
    }

    protected boolean alreadyPresent(String dbfield, String fieldValue){
        boolean rtnAlreadyPresent = true;
        SQLiteDatabase sqldb = ST_DATABASE.open();
        String Query = "Select * from " + ST_TABLE + " where " + dbfield + " = " + fieldValue;
        Cursor cursor = sqldb.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            rtnAlreadyPresent = false;
        }
        cursor.close();
        return rtnAlreadyPresent;
    }

    public int updateData(ContentValues values, String WhereClause, String[] params ) {
        SQLiteDatabase dbase = ST_DATABASE.open();
        int rtn = dbase.update(ST_TABLE, values, WhereClause, params);
        dbase.close();
        return  rtn;
    }

    public  ArrayMap<String, String> getData(String[] columns, String WhereClause, String[] params ) {
        SQLiteDatabase dbase = ST_DATABASE.open();
        int columnCount = columns.length;
        Cursor cursor = dbase.query(ST_TABLE, columns, WhereClause, params, null, null, null, null);
        ArrayMap<String, String> arrayMap = new ArrayMap<String, String>(columnCount);
        if (cursor.moveToFirst()) {
            for (int k = 0; k < columnCount; k++) {
                arrayMap.put(columns[k],db.sqlEscapeString(cursor.getString(cursor.getColumnIndex(columns[k]))));
            }
        }
        return arrayMap;
    }

    public Cursor getAllData() {
        String selectQuery = "SELECT  * FROM "+ST_TABLE;
        SQLiteDatabase dbase = this.ST_DATABASE.open();
        Cursor cursor = dbase.rawQuery ( selectQuery, null );
        return cursor;
    }

    public void deleteData(String WhereClause, String[] params) {
        final SQLiteDatabase dbase = ST_DATABASE.open();
        dbase.delete(ST_TABLE,WhereClause,params);
        dbase.close();
    }

    public void deleteAllData() {
        final SQLiteDatabase dbase = ST_DATABASE.open();
        dbase.execSQL("delete from "+ ST_TABLE);
        dbase.close();
    }

    public int getDataCount() {
        final SQLiteDatabase dbase =ST_DATABASE.open();
        String countQuery = "SELECT  * FROM " + ST_TABLE;
        Cursor cursor = dbase.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    public void parseFeed(InputStream inputStream) throws XmlPullParserException, IOException
    {

    }
}
