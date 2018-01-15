package com.brainfeaster.sanneo.simpletools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.brainfeaster.sanneo.simpletools.helper.IConfig;
import com.brainfeaster.sanneo.simpletools.helper.db;

import java.util.ArrayList;
import java.util.List;

public class InitModules implements IConfig  {
    public Context _con;
    public SQLiteDatabase _STdb;
    public  db _db;
    public InitModules(Context con) {
        _con = con;
        db dtb = new db(con, getCreateTablesSQL());
        //trigger the create queries.
        _STdb = dtb.getWritableDatabase();
        _db = dtb;
    }

    public List<String> getCreateTablesSQL()
    {
        List<String> createSQLS = new ArrayList<String>();
        //ModuleInit
        com.brainfeaster.sanneo.app.rajyaSabhaMember.Config rajyasabhaConfig = new com.brainfeaster.sanneo.app.rajyaSabhaMember.Config();
        createSQLS.addAll(rajyasabhaConfig.getCreateTablesSQL());

        return createSQLS;
    }
    public void downloadfromService(){}
}
