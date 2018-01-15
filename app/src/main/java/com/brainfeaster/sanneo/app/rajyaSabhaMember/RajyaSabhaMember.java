package com.brainfeaster.sanneo.app.rajyaSabhaMember;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.ArrayMap;

import com.brainfeaster.sanneo.simpletools.helper.JSONConvertion;
import com.brainfeaster.sanneo.simpletools.helper.db;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

public class RajyaSabhaMember {

    public int id;
    public String MPCode;
    public String Partyname;
    public String FatherName;
    public String MotherName;
    public String DOB;
    public String PlaceOfBirth;
    public String MaritalStatus;
    public String DateOfMarriage;
    public String SpouseName;
    public String NoOfChildren;
    public String EducatQualification;
    public String Profession;
    public String LocalAddress;
    public String PermanentAddress;
    public String PositionHeld;
    public String SocialActivity;
    public String Books;
    public String FavouritePasstime;
    public String CountryVisite;
    public String EmailID;
    public String Freedom;
    public String stateName;
    public String OtherInfo;
    public String MemberName;

    public RajyaSabhaMember()
    {

    }

    public RajyaSabhaMember(String MPCode,String Partyname,String FatherName,
                           String MotherName,String DOB,String PlaceOfBirth,
                           String MaritalStatus,String DateOfMarriage,String SpouseName,
                           String NoOfChildren,String EducatQualification,
                           String Profession,String LocalAddress,String PermanentAddress,
                           String PositionHeld,String SocialActivity,String Books,
                           String FavouritePasstime,String CountryVisite,String EmailID,
                           String Freedom, String stateName, String OtherInfo, String MemberName)
    {
        this.MPCode = MPCode;this.Partyname = Partyname;this.FatherName =FatherName;
        this.MotherName=MotherName;this.DOB=DOB; this.PlaceOfBirth=PlaceOfBirth;
        this.MaritalStatus=MaritalStatus; this.DateOfMarriage=DateOfMarriage;
        this.SpouseName=SpouseName; this.NoOfChildren=NoOfChildren;
        this.EducatQualification=EducatQualification; this.Profession=Profession;
        this.LocalAddress=LocalAddress; this.PermanentAddress=PermanentAddress;
        this.PositionHeld=PositionHeld; this.SocialActivity=SocialActivity;
        this.Books=Books; this.FavouritePasstime = FavouritePasstime;this.CountryVisite = CountryVisite;
        this.EmailID=EmailID;this.Freedom=Freedom;this.stateName=stateName; this.OtherInfo= OtherInfo;
        this.MemberName = MemberName;
    }

    public void RSMProperty(String key, String value)
    {
        switch (key)
        {
            case "MPCode": this.MPCode = value; break;
            case "Partyname": this.Partyname = value;  break;
            case "FatherName": this.FatherName =value; break;
            case "MotherName": this.MotherName=value; break;
            case "DOB": this.DOB=value; break;
            case "PlaceOfBirth": this.PlaceOfBirth=value; break;
            case "MaritalStatus": this.MaritalStatus=value; break;
            case "DateOfMarriage": this.DateOfMarriage=value; break;
            case "SpouseName": this.SpouseName=value;  break;
            case "NoOfChildren":  this.NoOfChildren=value; break;
            case "EducatQualification": this.EducatQualification=value;  break;
            case "Profession": this.Profession=value; break;
            case "LocalAddress": this.LocalAddress=value;  break;
            case "PermanentAddress": this.PermanentAddress=value; break;
            case "PositionHeld": this.PositionHeld=value; break;
            case "SocialActivity": this.SocialActivity=value; break;
            case "Books": this.Books=value; break;
            case "FavouritePasstime": this.FavouritePasstime=value; break;
            case "CountryVisite":this.CountryVisite=value; break;
            case "EmailID":this.EmailID=value;break;
            case "stateName":this.stateName=value;break;
            case "Freedom":this.Freedom=value;break;
            case "OtherInfo": this.OtherInfo=value;break;
            case "MemberName": this.MemberName=value;break;
        }
    }

    public String toJSON()
    {
        String rtn = "";
        try{
            rtn =  JSONConvertion.toJSON(this);
        }
        catch(Exception ex){
        }
        finally {
            return rtn;
        }
    }

    public ContentValues getValuesToAdd() {
        ContentValues cVal = new ContentValues();
        cVal.put("MPCode",db.sqlEscapeString(this.MPCode));
        cVal.put("Partyname",db.sqlEscapeString(this.Partyname));
        cVal.put("FatherName",db.sqlEscapeString(this.FatherName));
        cVal.put("MotherName",db.sqlEscapeString(this.MotherName));
        cVal.put("DOB",db.sqlEscapeString(this.DOB));
        cVal.put("PlaceOfBirth",db.sqlEscapeString(this.PlaceOfBirth));
        cVal.put("MaritalStatus",db.sqlEscapeString(this.MaritalStatus));
        cVal.put("DateOfMarriage",db.sqlEscapeString(this.DateOfMarriage));
        cVal.put("SpouseName",db.sqlEscapeString(this.SpouseName));
        cVal.put("NoOfChildren",db.sqlEscapeString(this.NoOfChildren));
        cVal.put("EducatQualification",db.sqlEscapeString(this.EducatQualification));
        cVal.put("Profession",db.sqlEscapeString(this.Profession));
        cVal.put("LocalAddress",db.sqlEscapeString(this.LocalAddress));
        cVal.put("PermanentAddress",db.sqlEscapeString(this.PermanentAddress));
        cVal.put("PositionHeld",db.sqlEscapeString(this.PositionHeld));
        cVal.put("SocialActivity",db.sqlEscapeString(this.SocialActivity));
        cVal.put("Books",db.sqlEscapeString(this.Books));
        cVal.put("FavouritePasstime",db.sqlEscapeString(this.FavouritePasstime));
        cVal.put("CountryVisite",db.sqlEscapeString(this.CountryVisite));
        cVal.put("EmailID",db.sqlEscapeString(this.EmailID));
        cVal.put("Freedom",db.sqlEscapeString(this.Freedom));
        cVal.put("stateName",db.sqlEscapeString(this.stateName));
        cVal.put("OtherInfo",db.sqlEscapeString(this.OtherInfo));
        cVal.put("MemberName",db.sqlEscapeString(this.MemberName));

        return cVal;
    }

    public ContentValues getValuesToUpdate() {
        ContentValues cVal = new ContentValues();
        cVal.put("Partyname",db.sqlEscapeString(this.Partyname));
        cVal.put("FatherName",db.sqlEscapeString(this.FatherName));
        cVal.put("MotherName",db.sqlEscapeString(this.MotherName));
        cVal.put("DOB",db.sqlEscapeString(this.DOB));
        cVal.put("PlaceOfBirth",db.sqlEscapeString(this.PlaceOfBirth));
        cVal.put("MaritalStatus",db.sqlEscapeString(this.MaritalStatus));
        cVal.put("DateOfMarriage",db.sqlEscapeString(this.DateOfMarriage));
        cVal.put("SpouseName",db.sqlEscapeString(this.SpouseName));
        cVal.put("NoOfChildren",db.sqlEscapeString(this.NoOfChildren));
        cVal.put("EducatQualification",db.sqlEscapeString(this.EducatQualification));
        cVal.put("Profession",db.sqlEscapeString(this.Profession));
        cVal.put("LocalAddress",db.sqlEscapeString(this.LocalAddress));
        cVal.put("PermanentAddress",db.sqlEscapeString(this.PermanentAddress));
        cVal.put("PositionHeld",db.sqlEscapeString(this.PositionHeld));
        cVal.put("SocialActivity",db.sqlEscapeString(this.SocialActivity));
        cVal.put("Books",db.sqlEscapeString(this.Books));
        cVal.put("FavouritePasstime",db.sqlEscapeString(this.FavouritePasstime));
        cVal.put("CountryVisite",db.sqlEscapeString(this.CountryVisite));
        cVal.put("EmailID",db.sqlEscapeString(this.EmailID));
        cVal.put("Freedom",db.sqlEscapeString(this.Freedom));
        cVal.put("stateName",db.sqlEscapeString(this.stateName));
        cVal.put("OtherInfo",db.sqlEscapeString(this.OtherInfo));
        cVal.put("MemberName",db.sqlEscapeString(this.MemberName));

        return cVal;
    }

    public ContentValues getValuesToUpdateMemberDetails() {
        ContentValues cVal = new ContentValues();
        cVal.put("Partyname",db.sqlEscapeString(this.Partyname));
        cVal.put("FatherName",db.sqlEscapeString(this.FatherName));
        cVal.put("MotherName",db.sqlEscapeString(this.MotherName));
        cVal.put("DOB",db.sqlEscapeString(this.DOB));

        cVal.put("PlaceOfBirth",db.sqlEscapeString(this.PlaceOfBirth));
        cVal.put("MaritalStatus",db.sqlEscapeString(this.MaritalStatus));
        cVal.put("DateOfMarriage",db.sqlEscapeString(this.DateOfMarriage));
        cVal.put("SpouseName",db.sqlEscapeString(this.SpouseName));
        cVal.put("NoOfChildren",db.sqlEscapeString(this.NoOfChildren));

        cVal.put("EducatQualification",db.sqlEscapeString(this.EducatQualification));
        cVal.put("Profession",db.sqlEscapeString(this.Profession));
        cVal.put("LocalAddress",db.sqlEscapeString(this.LocalAddress));
        cVal.put("PermanentAddress",db.sqlEscapeString(this.PermanentAddress));
        cVal.put("PositionHeld",db.sqlEscapeString(this.PositionHeld));

        cVal.put("SocialActivity",db.sqlEscapeString(this.SocialActivity));
        cVal.put("Books",db.sqlEscapeString(this.Books));
        cVal.put("FavouritePasstime",db.sqlEscapeString(this.FavouritePasstime));
        cVal.put("CountryVisite",db.sqlEscapeString(this.CountryVisite));
        cVal.put("EmailID",db.sqlEscapeString(this.EmailID));

        cVal.put("Freedom",db.sqlEscapeString(this.Freedom));
        cVal.put("stateName",db.sqlEscapeString(this.stateName));
        cVal.put("OtherInfo",db.sqlEscapeString(this.OtherInfo));
        return cVal;
    }

    public void fromCursor(Cursor cursor)
    {
        //if (cursor != null) {
          //  cursor.moveToFirst();
            for (int i = 1; i < 25; i++) {
                switch (i) {
                    case 1:
                        this.MPCode = cursor.getString(i);
                        break;
                    case 2:
                        this.Partyname = cursor.getString(i);
                        break;
                    case 3:
                        this.FatherName = cursor.getString(i);
                        break;
                    case 4:
                        this.MotherName = cursor.getString(i);
                        break;
                    case 5:
                        this.DOB = cursor.getString(i);
                        break;
                    case 6:
                        this.PlaceOfBirth = cursor.getString(i);
                        break;
                    case 7:
                        this.MaritalStatus = cursor.getString(i);
                        break;
                    case 8:
                        this.DateOfMarriage = cursor.getString(i);
                        break;
                    case 9:
                        this.SpouseName = cursor.getString(i);
                        break;
                    case 10:
                        this.NoOfChildren = cursor.getString(i);
                        break;
                    case 11:
                        this.EducatQualification = cursor.getString(i);
                        break;
                    case 12:
                        this.Profession = cursor.getString(i);
                        break;
                    case 13:
                        this.LocalAddress = cursor.getString(i);
                        break;
                    case 14:
                        this.PermanentAddress = cursor.getString(i);
                        break;
                    case 15:
                        this.PositionHeld = cursor.getString(i);
                        break;
                    case 16:
                        this.SocialActivity = cursor.getString(i);
                        break;
                    case 17:
                        this.Books = cursor.getString(i);
                        break;
                    case 18:
                        this.FavouritePasstime = cursor.getString(i);
                        break;
                    case 19:
                        this.CountryVisite = cursor.getString(i);
                        break;
                    case 20:
                        this.EmailID = cursor.getString(i);
                        break;
                    case 21:
                        this.stateName = cursor.getString(i);
                        break;
                    case 22:
                        this.Freedom = cursor.getString(i);
                        break;
                    case 23:
                        this.OtherInfo = cursor.getString(i);
                        break;
                    case 24:
                        this.MemberName = cursor.getString(i);
                        break;
                }
           // }
        }
    }

    public void fromList(ArrayMap<String, String> values)
    {
        for (ArrayMap.Entry<String, String> entry : values.entrySet())
        {
            this.RSMProperty(entry.getKey(),entry.getValue());
        }

      /*  if (values != null) {
            for (int i = 1; i < 23; i++) {


                switch (i) {
                    case 1:
                        this.MPCode = values.get(i);
                        break;
                    case 2:
                        this.Partyname = values.get(i);
                        break;
                    case 3:
                        this.FatherName = values.get(i);
                        break;
                    case 4:
                        this.MotherName = values.get(i);
                        break;
                    case 5:
                        this.DOB = values.get(i);
                        break;
                    case 6:
                        this.PlaceOfBirth = values.get(i);
                        break;
                    case 7:
                        this.MaritalStatus = values.get(i);
                        break;
                    case 8:
                        this.DateOfMarriage = values.get(i);
                        break;
                    case 9:
                        this.SpouseName = values.get(i);
                        break;
                    case 10:
                        this.NoOfChildren = values.get(i);
                        break;
                    case 11:
                        this.EducatQualification = values.get(i);
                        break;
                    case 12:
                        this.Profession = values.get(i);
                        break;
                    case 13:
                        this.LocalAddress = values.get(i);
                        break;
                    case 14:
                        this.PermanentAddress = values.get(i);
                        break;
                    case 15:
                        this.PositionHeld = values.get(i);
                        break;
                    case 16:
                        this.SocialActivity = values.get(i);
                        break;
                    case 17:
                        this.Books = values.get(i);
                        break;
                    case 18:
                        this.FavouritePasstime = values.get(i);
                        break;
                    case 19:
                        this.CountryVisite = values.get(i);
                        break;
                    case 20:
                        this.EmailID = values.get(i);
                        break;
                    case 21:
                        this.stateName = values.get(i);
                        break;
                    case 22:
                        this.Freedom = values.get(i);
                        break;
                    case 23:
                        this.OtherInfo = values.get(i);
                        break;
                }

            }
        }*/
    }
}
