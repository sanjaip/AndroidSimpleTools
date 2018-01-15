package com.brainfeaster.sanneo.app.rajyaSabhaMember;

import android.util.Log;

import com.brainfeaster.sanneo.simpletools.helper.JSONConvertion;
import com.brainfeaster.sanneo.simpletools.helper.db;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by sanja on 9/13/2017.
 */

public class RSMBusiness {
    public RSMBusiness() {
    }

    //download the data from service and write to DB
    public void getMembersDataFromService(db dbInstance){
        RajyaSabhaServiceMethod RSSM = new RajyaSabhaServiceMethod(dbInstance);
        RSSM.getFromRajyaSabhaService();
    }

    //clear all from DB
    public void clearAllFromDB(db dbInstance){
        RajyaSabhaDBMethod RSDM = new RajyaSabhaDBMethod(dbInstance);
        RSDM.deleteAllData();
    }

    //get from DB
    public String getDataFromSQL(db dbInstance){
        RajyaSabhaDBMethod RSDM = new RajyaSabhaDBMethod(dbInstance);
        List<RajyaSabhaMember> collRSM = RSDM.getRajyaSabhaMembers();
        String str = "";
        for (RajyaSabhaMember rsm :collRSM) {
            str = str + rsm.toJSON();
        }
        return str;
    }

    //get from DB
    public void getMembersDetailDataFromService(db dbInstance){
        RajyaSabhaDBMethod RSDM = new RajyaSabhaDBMethod(dbInstance);
        RajyaSabhaServiceMethod RSSM = new RajyaSabhaServiceMethod(dbInstance);
        List<Integer> RSMMPCodeList = RSDM.getRajyaSabhaMembersMPcode();
        for (Integer i:RSMMPCodeList ) {
            Log.d("entered for loop "," for " +Integer.toString(i));
            RSSM.getMemberDetailsFromRajyaSabhaService(Integer.toString(i));
        }
    }

    //get from DB
    public String getMemberDetailDataFromService(db dbInstance, String MPCode){
        RajyaSabhaServiceMethod RSSM = new RajyaSabhaServiceMethod(dbInstance);
        RajyaSabhaDBMethod RSDM = new RajyaSabhaDBMethod(dbInstance);
        RajyaSabhaMember RSM = new RajyaSabhaMember();
        RSSM.getMemberDetailsFromRajyaSabhaService(MPCode);
        int myNum = 0;
        try {
            myNum = Integer.parseInt(MPCode);
        } catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }

        RSM = RSDM.getData(myNum);
        Log.d("current details :", RSM.toJSON());
        return RSM.toJSON();
    }

    //get all avialable members from DB
    public String getAllAvailableMPCodeFromSQL(db dbInstance){
        RajyaSabhaDBMethod RSDM = new RajyaSabhaDBMethod(dbInstance);
        List<Integer> RSMMPCodeList = RSDM.getRajyaSabhaMembersMPcode();
        String str= "[";
        int endIndex = 1;
        for (Integer i:RSMMPCodeList ) {
            if (endIndex < RSMMPCodeList.size()) {
                str = str + i.toString() + ",";
                endIndex++;
            }else{
                str = str + i.toString() + "]";
            }
        }
        Log.d("sdafa",str);
        return str;
    }

    //get al from  DB
    public String getAllDataFromSQL(db dbInstance){
        RajyaSabhaDBMethod RSDM = new RajyaSabhaDBMethod(dbInstance);
        List<RajyaSabhaMember> collRSM = RSDM.getRajyaSabhaMembers();
        String str = "";
        for (RajyaSabhaMember rsm :collRSM) {
            str = str + rsm.toJSON();
        }
        return str;
    }

    //get from DB
    public String getOneDataFromSQL(db dbInstance, int index){
        RajyaSabhaDBMethod RSDM = new RajyaSabhaDBMethod(dbInstance);
        return RSDM.getData(index).toJSON();
    }

    //get count of offline data
    public String getRecordCountFromSQL(db dbInstance){
        RajyaSabhaDBMethod RSDM = new RajyaSabhaDBMethod(dbInstance);
        return Integer.toString(RSDM.getDataCount());
    }
}
