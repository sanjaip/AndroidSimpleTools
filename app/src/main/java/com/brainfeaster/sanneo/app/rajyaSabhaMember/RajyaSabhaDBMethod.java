package com.brainfeaster.sanneo.app.rajyaSabhaMember;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.ArrayMap;

import com.brainfeaster.sanneo.simpletools.helper.ISTDataAccess;
import com.brainfeaster.sanneo.simpletools.helper.STDataAccess;
import com.brainfeaster.sanneo.simpletools.helper.db;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import static com.brainfeaster.sanneo.simpletools.helper.JSONConvertion.getFields;

/**
 * Created by sanja on 9/12/2017.
 */

public class RajyaSabhaDBMethod extends STDataAccess {

    public RajyaSabhaDBMethod(db dbInstance)
    {
        super.ST_DATABASE = dbInstance;
        super.ST_TABLE = Config._RSMTable;
    }

    public void addData(ContentValues cVal) {
        super.addData(cVal);
    }

    public int updateDataWithMcode(ContentValues values, String keyFieldsValue ) {
        int rtn = super.updateData( values, "MPCode = ?", new String[] { String.valueOf(keyFieldsValue) });
        return rtn;
    }

    public int updateData(RajyaSabhaMember data) {
        final SQLiteDatabase dbase = ST_DATABASE.open();
        ContentValues values = new ContentValues();
        values.put("MPCode",data.MPCode);
        values.put("Partyname",data.Partyname);
        values.put("FatherName",data.FatherName);
        values.put("MotherName",data.MotherName);
        values.put("DOB",data.DOB);
        values.put("PlaceOfBirth",data.PlaceOfBirth);
        values.put("MaritalStatus",data.MaritalStatus);
        values.put("DateOfMarriage",data.DateOfMarriage);
        values.put("SpouseName",data.SpouseName);
        values.put("NoOfChildren",data.NoOfChildren);
        values.put("EducatQualification",data.EducatQualification);
        values.put("Profession",data.Profession);
        values.put("LocalAddress",data.LocalAddress);
        values.put("PermanentAddress",data.PermanentAddress);
        values.put("PositionHeld",data.PositionHeld);
        values.put("SocialActivity",data.SocialActivity);
        values.put("Books",data.Books);
        values.put("FavouritePasstime",data.FavouritePasstime);
        values.put("CountryVisite",data.CountryVisite);
        values.put("EmailID",data.EmailID);
        values.put("Freedom",data.Freedom);
        values.put("stateName",data.stateName);
        values.put("OtherInfo",data.OtherInfo);
        values.put("MemberName",data.MemberName);
        return dbase.update(Config._RSMTable, values, "MPCode" + " = ?",
                new String[] { String.valueOf(data.MPCode) });
    }

    public RajyaSabhaMember getData(int keyFieldsValue) {
        RajyaSabhaMember rsmData = new RajyaSabhaMember();
        String[] columns = new String[0];
        try {
            columns = getFields(rsmData);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        String WhereClausePattern = "MPCode = ?";
        String[] values = new String[] { String.valueOf(keyFieldsValue) };
        ArrayMap<String, String> arrayMap  = super.getData(columns,WhereClausePattern, values);
        rsmData.fromList(arrayMap);
        return rsmData;
    }

    public List<RajyaSabhaMember> getRajyaSabhaMembers() {
        List<RajyaSabhaMember> RSMList = new ArrayList<RajyaSabhaMember>();
        Cursor cursor = super.getAllData();
        if (cursor.moveToFirst()) {
            do {
                RajyaSabhaMember tmp = new RajyaSabhaMember();
                tmp.fromCursor(cursor);
                RSMList.add(tmp);
            } while (cursor.moveToNext());
        }
        return RSMList;
    }

    public List<Integer> getRajyaSabhaMembersMPcode() {
        List<Integer> RSMMPCodeList = new ArrayList<Integer>();
        Cursor cursor = super.getAllData();
        if (cursor.moveToFirst()) {
            do {
                int currMPCode = 0;
                try {
                    currMPCode = Integer.parseInt(db.sqlEscapeString(cursor.getString(cursor.getColumnIndex("MPCode"))));
                } catch(NumberFormatException nfe) {
                    // Handle parse error.
                }
                if(!RSMMPCodeList.contains(currMPCode)) {
                    RSMMPCodeList.add(currMPCode);
                }
            } while (cursor.moveToNext());
        }
        return RSMMPCodeList;
    }

    public void deleteData(RajyaSabhaMember data) {
        String WhereCaluse = "MPCode = ?";
        String[]  params = new String[] { String.valueOf(data.MPCode) };
        super.deleteData(WhereCaluse, params);
    }

    public void deleteAllData() {
        super.deleteAllData();
    }

    public int getDataCount() {
        final SQLiteDatabase dbase =ST_DATABASE.open();
        String countQuery = "SELECT  * FROM " + Config._RSMTable;
        Cursor cursor = dbase.rawQuery(countQuery, null);
        int rtnVal = cursor.getCount();
        cursor.close();
        return rtnVal;
    }
}
