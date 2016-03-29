package com.example.mael.androidproject2.liste.BaseDonne;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mael on 18/03/2016.
 */
public class AddBase {
    private SQLiteDatabase db;
    private ContentValues contentValues;
    static public AddBase instance=null;
    static public AddBase getInstance(Context context){
        if(instance == null){
            instance = new AddBase(context);
        }
        return instance;
    }
    private AddBase(Context context){
        db = BaseDonne.getBaseDonne(context).getWritableDatabase();
        contentValues = new ContentValues();
    }
    public void addJson(JSONArray js) throws JSONException {
        for(int i = 0; i<js.length(); ++i){
            JSONObject jo =js.getJSONObject(i);
            contentValues.put(BaseDonne.COLUMN_ID, jo.getJSONObject("id").getInt("-val"));
            contentValues.put(BaseDonne.COLUMN_NAME, jo.getJSONObject("nom").getString("-val"));
            contentValues.put(BaseDonne.COLUMN_PLAY, jo.getJSONObject("mp3-192").getString("-val"));
            long id =db.insert(BaseDonne.DATABASE_TABLE,null, contentValues);
            Log.d("BaseAdd", jo.getString("nom"));
        }

    }
}
