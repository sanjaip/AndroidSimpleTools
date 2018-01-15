package com.brainfeaster.sanneo.app.lokSabhaMember;

import com.brainfeaster.sanneo.simpletools.helper.IConfig;

import java.util.ArrayList;
import java.util.List;


public class Config implements IConfig {

    public final static String _RSMTable = "tbl_LokSabhaMember";
    public final static String _DbInstance = "";

    public List<String> getCreateTablesSQL() {
        List<String> sqlColl = new ArrayList<String>();
        sqlColl.add( "create table " + _RSMTable +
                " ( _id integer primary key autoincrement," +
                " MPCode text,"+
                " Partyname text,"+
                " FatherName text,"+
                " MotherName text,"+
                " DOB text,"+
                " PlaceOfBirth text,"+
                " MaritalStatus text,"+
                " DateOfMarriage text,"+
                " SpouseName text,"+
                " NoOfChildren text,"+
                " EducatQualification text,"+
                " Profession text,"+
                " LocalAddress text,"+
                " PermanentAddress text,"+
                " PositionHeld text,"+
                " SocialActivity text,"+
                " Books text,"+
                " FavouritePasstime text,"+
                " CountryVisite text,"+
                " EmailID text,"+
                " Freedom text,"+
                " stateName text,"+
                " OtherInfo text," +
                " MemberName text ); ");
        return sqlColl;
    }

    public String getURL() {
        return "http://164.100.47.193/android_rssfeed_ls/all_members.aspx";
    }

    public String getMemberURL(){
        return "http://164.100.47.5/AndroidFeeds/member_biography.aspx?member_id=";
    }



    public void downloadfromService(){}



    public final static String _SampleResponse = "" +
            "<Member>\n" +
            "    <Sno>1</Sno>\n" +
            "    <memberId>\n" +
            "        <![CDATA[2654]]>\n" +
            "    </memberId>\n" +
            "    <Name>\n" +
            "        <![CDATA[Abdullah, Dr. Farooq]]>\n" +
            "    </Name>\n" +
            "    <Party>\n" +
            "        <![CDATA[J&KNC]]>\n" +
            "    </Party>\n" +
            "    <Constituencies>\n" +
            "        <![CDATA[Srinagar]]>\n" +
            "    </Constituencies>\n" +
            "    <State>\n" +
            "        <![CDATA[Jammu and Kashmir]]>\n" +
            "    </State>\n" +
            "    <Paddress>\n" +
            "        <![CDATA[40, Gupkar Road,  Srinagar,  Jammu &amp; Kashmir]]>\n" +
            "    </Paddress>\n" +
            "    <Permanentphone>\n" +
            "        <![CDATA[Tel : (0194) 2452540, 09018210000 (M), Fax. (0194) 2452120]]>\n" +
            "    </Permanentphone>\n" +
            "    <Localaddress>\n" +
            "        <![CDATA[Upper Ground Floor, Flat - D, , Sagar Apartment, 6, Tilak Marg,  New Delhi-110001]]>\n" +
            "    </Localaddress>\n" +
            "    <Localphone>\n" +
            "        <![CDATA[09018210000, 09868181158 (M), Fax : (0194) 2452120]]>\n" +
            "    </Localphone>\n" +
            "    <EmailID>\n" +
            "        <![CDATA[iamfarooq70@hotmail.com]]>\n" +
            "    </EmailID>\n" +
            "</Member>";
}
