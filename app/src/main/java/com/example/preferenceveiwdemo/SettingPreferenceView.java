package com.example.preferenceveiwdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * author: daxiong9527
 * mail : 15570350453@163.com
 */

public class SettingPreferenceView extends LinearLayout{

    static final String TAG = "SettingPreferenceView" ;
    Context context ;
    PreferenceData[] preferenceItems = new PreferenceData[0] ;
    Map<String,PreferenceItem> mPreferenceManager = new HashMap<>();


    public SettingPreferenceView(Context context) {
        this(context,null);
    }

    public SettingPreferenceView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SettingPreferenceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.context = context ;
        setOrientation(VERTICAL);
    }

    public void setPreferenceItems( PreferenceData[] preferenceItems ) {
        this.preferenceItems = preferenceItems ;
        try {
            initView();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    void initView() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        for(int i = 0 ; i < preferenceItems.length ; i++){
            int type = preferenceItems[i].type ;

            switch (type){
                case PreferenceData.TYPE_TEXT:
                    TextPreferenceItem textPreferenceItem = (TextPreferenceItem) preferenceItems[i].inflaterCla.
                            getConstructor(Context.class)
                            .newInstance(context);
                    View contentView = layoutInflater.inflate(textPreferenceItem.getmResId(),this,false);
                    textPreferenceItem.bindView(contentView);
                    textPreferenceItem.setmTextLeft(preferenceItems[i].nameResId);
                    textPreferenceItem.setmImageLeft(preferenceItems[i].imageLeftResId);
                    mPreferenceManager.put(context.getString(preferenceItems[i].prefkey),textPreferenceItem);
                    addView(contentView);
                    break;
                case PreferenceData.TYPE_SWITCH:
                    SwitchPreferenceItem switchPreferenceItem = (SwitchPreferenceItem) preferenceItems[i].inflaterCla.
                            getConstructor(Context.class)
                            .newInstance(context);
                    View mSwitchView = layoutInflater.inflate(switchPreferenceItem.getmResId(),this,false);
                    switchPreferenceItem.bindView(mSwitchView);
                    switchPreferenceItem.setName(preferenceItems[i].nameResId);
                    switchPreferenceItem.setImageViewleft(preferenceItems[i].imageLeftResId);
                    mPreferenceManager.put(context.getString(preferenceItems[i].prefkey),switchPreferenceItem);
                    addView(mSwitchView);
                    break;
                case PreferenceData.TYPE_DIVIDER:
                    DividerPreferenceItem dividerPreferenceItem = (DividerPreferenceItem) preferenceItems[i].inflaterCla.
                            getConstructor(Context.class).newInstance(context);
                    View mDivider = layoutInflater.inflate(dividerPreferenceItem.getmResId(),this,false);
                    dividerPreferenceItem.bind(mDivider);
                    mPreferenceManager.put(context.getString(preferenceItems[i].prefkey),dividerPreferenceItem);
                    addView(mDivider);
                    break;
            }

            requestLayout();

        }


    }

    public PreferenceItem findPrefernce(int key){
        return mPreferenceManager.get(context.getString(key));
    }
}
