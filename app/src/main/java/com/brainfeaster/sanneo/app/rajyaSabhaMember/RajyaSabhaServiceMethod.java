package com.brainfeaster.sanneo.app.rajyaSabhaMember;

import android.util.Log;
import android.util.Xml;

import com.brainfeaster.sanneo.simpletools.MainActivity;
import com.brainfeaster.sanneo.simpletools.helper.STDataAccess;
import com.brainfeaster.sanneo.simpletools.helper.bfRssReader;
import com.brainfeaster.sanneo.simpletools.helper.db;
import com.brainfeaster.sanneo.simpletools.helper.testDelegate;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RajyaSabhaServiceMethod  extends STDataAccess implements testDelegate {

    private int _processGetAllMembers = 1;
    private int _processGetMembersDetails = 2;
    private String _MPCode = "";

    public RajyaSabhaServiceMethod(db dbInstance) {
        super.ST_DATABASE = dbInstance;
        super.ST_TABLE = Config._RSMTable;
    }

    public void getFromRajyaSabhaService(){
        //Process ID = 1
        bfRssReader task = new bfRssReader(this,(new Config()).getURL(), _processGetAllMembers);
        task.execute();
    }

    public void getMemberDetailsFromRajyaSabhaService(String MPCode){

        InputStream inputStream = null;
        Log.d("entered ","getMemberDetailsFromRajyaSabhaService for " +MPCode);
        _MPCode = MPCode;
        //bfRssReader task = new bfRssReader(this,(new Config()).getMemberURL()+ MPCode, _processGetMembersDetails);
        //task.execute();
        String urlLink = (new Config()).getMemberURL()+ MPCode;
        try {
            if(!urlLink.startsWith("http://") && !urlLink.startsWith("https://"))
                urlLink = "http://" + urlLink;

            URL url = new URL(urlLink);
            inputStream = url.openConnection().getInputStream();
            Log.d("Parsing", urlLink);
            this.parse(inputStream, _processGetMembersDetails);
            inputStream.close();
            // super.addData(item.getValuesToAdd());
        }
        catch (XmlPullParserException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        finally {
            //inputStream.close();
        }
    }


    public void parse(InputStream inputStream, int processId) throws XmlPullParserException, IOException {
        String title = null, link = null, description = null; boolean isItem = false;
        try {
            XmlPullParser xmlPullParser = Xml.newPullParser();
            xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            xmlPullParser.setInput(inputStream, null);
            xmlPullParser.nextTag();
            RajyaSabhaMember item = null;
            String text = "";
            int eventType = xmlPullParser.getEventType();
            try {
               while (eventType != XmlPullParser.END_DOCUMENT) {
                    String tagname = xmlPullParser.getName();
                    String logAddInfo = "";
                    //Put all the tags that needs to be skipped on this space.
                    if (tagname != null) {
                       if (tagname.equalsIgnoreCase("Members") || tagname.equalsIgnoreCase("xmldata")) {
                           logAddInfo = " need to skipping" + tagname;
                           eventType = xmlPullParser.next();
                           continue;
                       }
                    }
                    switch (eventType) {
                       case XmlPullParser.START_TAG:
                           logAddInfo = "Start Tag ";
                           if (tagname.equalsIgnoreCase("Member")) {
                                item = new RajyaSabhaMember();
                           }
                           eventType = xmlPullParser.next();
                           if(eventType == XmlPullParser.TEXT ||eventType == XmlPullParser.CDSECT )
                           {
                               logAddInfo = logAddInfo + "Text Tag : ";
                               text = xmlPullParser.getText();
                           }
                           break;
                       case XmlPullParser.END_TAG:
                           logAddInfo = "End Tag ";
                           item.RSMProperty(tagname, text);
                           if (tagname.equalsIgnoreCase("Member")) {
                               if(processId == _processGetMembersDetails){
                                   //logic for _processGetMembersDetails
                                   if(super.alreadyPresent("MPCode",_MPCode)){
                                       String[] params = new String[]{String.valueOf(_MPCode)};
                                       super.updateData(item.getValuesToUpdateMemberDetails(), "MPCode = ?", params);
                                   }
                               }
                               else{
                                   //logic for _processGetAllMembers
                                   if(super.alreadyPresent("MPCode",item.MPCode)){
                                       String[] params = new String[]{String.valueOf(item.MPCode)};
                                       super.updateData(item.getValuesToUpdate(), "MPCode = ?", params);
                                   }
                                   else {
                                       super.addData(item.getValuesToAdd());
                                   }
                               }
                           }
                           break;
                       default:
                           break;
                    }
                    eventType = xmlPullParser.next();
                }
           }
           catch (Exception ex)
           {
               ex.printStackTrace();
           }

        }
        catch (XmlPullParserException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        finally { inputStream.close(); }
    }

}
