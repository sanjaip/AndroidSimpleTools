package com.brainfeaster.sanneo.simpletools.helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanja on 9/10/2017.
 */

public class JSONConvertion {

    public static String toJSON(Object object) throws JSONException, IllegalAccessException {
        String str = "";
        Class c = object.getClass();
        JSONObject jsonObject = new JSONObject();
        for (Field field : c.getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            String value = String.valueOf(field.get(object));
            jsonObject.put(name, value);
        }
        return jsonObject.toString();
    }

    public static String[] getFields(Object object) throws  IllegalAccessException {
        List<String> str = new ArrayList<String>();
        Class c = object.getClass();
        JSONObject jsonObject = new JSONObject();
        for (Field field : c.getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            if(name != "id" &&  name != "$change" && name != "serialVersionUID")
            {
                str.add(name);
            }
        }
        String[] collArr = new String[str.size()];
        collArr = str.toArray(collArr);
        return collArr;
    }


    public static String toJSON(List list ) throws JSONException, IllegalAccessException {
        JSONArray jsonArray = new JSONArray();
        for (Object i : list) {
            String jstr = toJSON(i);
            JSONObject jsonObject = new JSONObject(jstr);
            jsonArray.put(jsonArray);
        }
        return jsonArray.toString();
    }
}
