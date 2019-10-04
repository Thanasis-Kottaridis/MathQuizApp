package mymusicplayer.kottarido.unipi.com.mathquizapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ShearedPreferencesHealper {

    //preference file
    public static final String PREF_FILE = "shared preferences";
    //user profile key
    public static final String TEST_HISTORY_KEY = "test history";

    //tin kanw static gia na mporw na tin kalesw xoris antikimeno
    //etsi oste na apofigo to instantiate tou helper kathe fora pou thelw na kanw read i write
    static void saveMyTest(Context context, List<Test> myTests){
        //apothikevei tin lista me ta tests sta sheared Preferences
        SharedPreferences preferences = context.getSharedPreferences(PREF_FILE,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(myTests);
        editor.putString(TEST_HISTORY_KEY,json);
        editor.commit();
    }

    static List<Test> loadMyTests(Context context){
        //fortonei to pref file
        SharedPreferences preferences = context.getSharedPreferences(PREF_FILE,Context.MODE_PRIVATE);
        //ftisxnei ena neo gson obj
        Gson gson = new Gson();
        //diavazei tin sting timi pou einai apotikeumenei sto pref file
        String json = preferences.getString(TEST_HISTORY_KEY,null);
        //dilwnw ton tipo pou tha ginei metatropei to string pou diavasa
        Type type = new TypeToken<ArrayList<Test>>(){}.getType();
        //ftiaxnw to gason metatrepontas to string sto type pou orisa
        return gson.fromJson(json,type);
    }

}
