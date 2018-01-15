package com.brainfeaster.sanneo.app.rajyaSabhaMember;

import com.brainfeaster.sanneo.simpletools.helper.IConfig;

import java.util.ArrayList;
import java.util.List;


public class Config implements IConfig {

    public final static String _RSMTable = "tbl_RajyaSabhaMember";
    public final static String _DbInstance = "";

    public List<String> getCreateTablesSQL() {
        List<String> sqlColl = new ArrayList<String>();
        sqlColl.add( "create table tbl_RajyaSabhaMember " +
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
        return "http://164.100.47.5/AndroidFeeds/MemberRss.aspx";
    }

    public String getMemberURL(){
        return "http://164.100.47.5/AndroidFeeds/member_biography.aspx?member_id=";
    }



    public void downloadfromService(){}

    public final static String _SampleResponse = "<Member>\n" +
            "    <Sno>1</Sno>\n" +
            "    <MPCode>\n" +
            "        <![CDATA[1929]]>\n" +
            "    </MPCode>\n" +
            "    <MemberName>\n" +
            "        <![CDATA[Abdul Wahab,Shri]]>\n" +
            "    </MemberName>\n" +
            "    <Gender>\n" +
            "        <![CDATA[Male]]>\n" +
            "    </Gender>\n" +
            "    <Party>\n" +
            "        <![CDATA[IUML]]>\n" +
            "    </Party>\n" +
            "    <Partyname>\n" +
            "        <![CDATA[Indian Union Muslim League]]>\n" +
            "    </Partyname>\n" +
            "    <State>\n" +
            "        <![CDATA[KR]]>\n" +
            "    </State>\n" +
            "    <stateName>\n" +
            "        <![CDATA[Kerala]]>\n" +
            "    </stateName>\n" +
            "    <PermanentAddress>\n" +
            "        <![CDATA[Peevees Mirage, Nilambur P.O., Malappuram District, Kerala. 679329]]>\n" +
            "    </PermanentAddress>\n" +
            "    <Permanentphone>\n" +
            "        <![CDATA[04931-220542, fax:04931-221988 M:09847020911]]>\n" +
            "    </Permanentphone>\n" +
            "    <LocalAddress>\n" +
            "        <![CDATA[402- SWAJAS Deluxe, Dr. B.D. Marg, New Delhi 110001]]>\n" +
            "    </LocalAddress>\n" +
            "    <Localphone>\n" +
            "        <![CDATA[23319163, 21430553, Mobile 9013181677, 9868181280]]>\n" +
            "    </Localphone>\n" +
            "    <EmailID>\n" +
            "        <![CDATA[wahab.pv@sansad.nic.in]]>\n" +
            "    </EmailID>\n" +
            "</Member>";
}
