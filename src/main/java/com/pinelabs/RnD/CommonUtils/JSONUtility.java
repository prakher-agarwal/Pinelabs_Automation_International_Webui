package com.pinelabs.RnD.CommonUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class JSONUtility {

    public static String getJsonValue(String jsonReq, String key) {

        JSONObject json = new JSONObject(jsonReq);
        boolean exists = json.has(key);
        Iterator<?> keys;
        String nextKeys;
        String val = "";
        if (!exists) {
            keys = json.keys();
            while (keys.hasNext()) {
                nextKeys = (String) keys.next();
                try {
                    if (json.get(nextKeys) instanceof JSONObject) {
                        return getJsonValue(json.getJSONObject(nextKeys).toString(), key);
                    } else if (json.get(nextKeys) instanceof JSONArray) {
                        JSONArray jsonArray = json.getJSONArray(nextKeys);
                        int i = 0;
                        if (i < jsonArray.length()) do {
                            String jsonArrayString = jsonArray.get(i).toString();
                            JSONObject innerJson = new JSONObject(jsonArrayString);
                            return getJsonValue(innerJson.toString(), key);
                        } while (i < jsonArray.length());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            val = json.get(key).toString();
        }
        return val;
    }
}

