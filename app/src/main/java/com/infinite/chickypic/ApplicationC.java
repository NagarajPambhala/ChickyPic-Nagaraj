package com.infinite.chickypic;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

/**
 * ujwalv on 28-05-2017.
 */

public class ApplicationC extends Application {

    private static ApplicationC applicationC;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static ApplicationC getApplicationC(){
        if(applicationC==null){
            applicationC = new ApplicationC();
        }
        return applicationC;
    }


    public Typeface getFbPractica_Bold(Context context){
        return Typeface.createFromAsset(context.getAssets(),  "fonts/fbpractica_bold.otf");
    }

    public Typeface getFbPractica_Regular(Context context){
        return Typeface.createFromAsset(context.getAssets(),  "fonts/fbpractica_regular.otf");
    }
    public Typeface getFbPractica_Light(Context context){
        return Typeface.createFromAsset(context.getAssets(),  "fonts/fbpractica_light.otf");
    }
}
