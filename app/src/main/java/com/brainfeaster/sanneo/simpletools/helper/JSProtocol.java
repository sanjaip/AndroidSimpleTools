package com.brainfeaster.sanneo.simpletools.helper;
//http://tutorials.jenkov.com/android/android-web-apps-using-android-webview.html#prefetching-known-web-resources
//https://kylewbanks.com/blog/HTML5-Database-In-Android
import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanja on 9/11/2017.
 */

public class JSProtocol {

    private Context _con = null;
    public JSProtocol(Context con) {
        _con = con;
    }

    public  String test(String str) {
        File tempFile;
        File cDir = _con.getCacheDir();
        String path =cDir.getPath() + "/" + "STresponse.json";
        tempFile = new File(path) ;

        FileWriter writer=null;
        try {
            writer = new FileWriter(tempFile);
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
       /* String strLine="";
        StringBuilder text = new StringBuilder();
        try {
            FileReader fReader = new FileReader(tempFile);
            BufferedReader bReader = new BufferedReader(fReader);

            while( (strLine=bReader.readLine()) != null  ){
                text.append(strLine+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }*/
    }

    public static List<String> doRespond(String response)
    {
        List<String> strColl = new ArrayList<String>();
        if(response.length() > 1000)
        {
            int charRemaining = response.length() ;
            int i = charRemaining/1000;
            int endIndex = 1000;
            int charConsumed = 0;
            for(int j=0;j<=i;j++) {
                if(charRemaining > 999) {
                    strColl.add(response.substring(charConsumed , charConsumed + 999));
                    charConsumed = charConsumed + response.substring(charConsumed , charConsumed + 999).length();
                }
                else{
                    strColl.add(response.substring(charConsumed , response.length()));
                    charConsumed = charConsumed + response.substring(charConsumed , response.length()).length();
                }
                charRemaining = response.length() - charConsumed;
            }
        }
        else
        {
            strColl.add(response.substring(1,response.length()));
        }
        return strColl;
    }
}
