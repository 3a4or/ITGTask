package com.example.mohamedashour.itg.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AppUtils {
    public static void initVerticalRV(RecyclerView recyclerView, Context context, int spanCount) {
        recyclerView.setLayoutManager(new GridLayoutManager(context, spanCount, LinearLayoutManager.VERTICAL, false));
        recyclerView.setNestedScrollingEnabled(false);
    }

    public static void initHorizontalRV(RecyclerView recyclerView, Context context, int spanCount) {
        recyclerView.setLayoutManager(new GridLayoutManager(context, spanCount, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setNestedScrollingEnabled(false);
    }

    public static void openFragmentFromActivity(AppCompatActivity from, Fragment to, int layout, String stackName){
        from.getSupportFragmentManager().beginTransaction().replace(layout, to).addToBackStack(stackName).commit();
    }

    public static void openFragmentFromFragment(Fragment from, Fragment to, int layout, String stackName){
        from.getActivity().getSupportFragmentManager().beginTransaction().replace(layout, to).addToBackStack(stackName).commit();
    }

    public static void saveInSharedPreference(Context context, String key, String value) {
        SharedPreferences settings = context.getSharedPreferences(AppTools.SHARED_PREFERENCE_TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getFromSharedPreference(Context context, String key) {
        SharedPreferences settings = context.getSharedPreferences(AppTools.SHARED_PREFERENCE_TAG, Context.MODE_PRIVATE);
        return settings.getString(key, "");
    }
}
