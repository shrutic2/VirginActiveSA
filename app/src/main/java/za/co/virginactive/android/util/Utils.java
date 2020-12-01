package za.co.virginactive.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import za.co.virginactive.android.R;

public class Utils {

    //Checks network connection
    public static boolean isNetworkAvailable(Context context) {
        Log.d("Inside NetworkUtil", "isNetworkAvailable ");
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return (cm.getActiveNetworkInfo() != null
                && cm.getActiveNetworkInfo().isAvailable() && cm
                .getActiveNetworkInfo().isConnected());
    }

    public static void showToast(Context context, String message){
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.custom_toast,null);
        TextView tvMessage = layout.findViewById(R.id.tvMessage);
        tvMessage.setText(message);
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
//        toast.setText(message);
        toast.setView(layout);
        toast.show();
    }

}
