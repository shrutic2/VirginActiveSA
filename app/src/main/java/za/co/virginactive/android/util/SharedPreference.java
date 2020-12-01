package za.co.virginactive.android.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class SharedPreference {
    final String AppPreferenceName = "vasaDataBase";
    private SharedPreferences sharedPreferences;
    static SharedPreference myAppPreference;

    public static String userToken = "userToken";
    public static String memberId = "memberId";
    public static String loginDetails = "loginDetails";


    public SharedPreference(Context context) {
        if (context != null)
            sharedPreferences = (SharedPreferences) context.getSharedPreferences(AppPreferenceName, Context.MODE_PRIVATE);
    }
    public static SharedPreference getInstance(Context context) {
        if (myAppPreference == null) {
            myAppPreference = new SharedPreference(context);
        }
        return myAppPreference;
    }
    //Save Boolean Data through these method
    public void saveBooleanData(String key, boolean value) {
        android.content.SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
    }
    //Get Boolean Data through these method
    public boolean getBooleanData(String key) {
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(key, false);
        }
        return false;
    }
    //Save String Data through these method
    public void saveData(String key, String value) {
        android.content.SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }
    //Get String Data through these method
    public String getData(String key) {
        if (sharedPreferences != null) {
            return sharedPreferences.getString(key, "");
        }
        return "";
    }
    //Save Integer Data through these method
    public void saveIntValue(String key, int value) {
        android.content.SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putInt(key, value);
        prefsEditor.apply();
    }
    //Get Integer Data through these method
    public int getIntValue(String key) {
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(key, 0);
        }
        return 0;
    }
    //Save object data in shared preference
    public <T> void saveObject(String key, T obj) {
        String data = new Gson().toJson(obj);
        sharedPreferences.edit().putString(key, data).apply();
    }
    //Get object data from shared preference
    public <T> ArrayList<T> getObject(String key) {
        String details = sharedPreferences.getString(key, null);
        Type type = new TypeToken<ArrayList<T>>() {
        }.getType();
        if (details != null) {
            return new Gson().fromJson(details, type);
        }
        return null;
    }
    //To check key is existing or not
    public boolean isKeyAvailable(String key) {
        return sharedPreferences != null && sharedPreferences.contains(key);
    }
    //Clear specific data from SharePreference
    public void clearShareKeyData(String key) {
        if (key != null && isKeyAvailable(key)) {
            sharedPreferences.edit().remove(key).apply();
        }
    }
    //Clear all share preference data
    public void clearAllSharePreferenceData() {
        if (sharedPreferences != null) {
            Map<String, ?> prefs = sharedPreferences.getAll();
            for (Map.Entry<String, ?> prefToReset : prefs.entrySet()) {
                String key = prefToReset.getKey();
                /*if (!key.equals(SharedPreference.userPass))
                    if (!key.equals(SharedPreference.userName))
                        if (!key.equals(SharedPreference.isFirstRun))
                            sharedPreferences.edit().remove(key).apply();*/
            }
        }
    }

}
