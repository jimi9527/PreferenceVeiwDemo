package com.example.preferenceveiwdemo;

import android.content.Context;
import android.view.View;

/**
 * author: daxiong9527
 * mail : 15570350453@163.com
 */

public class DividerPreferenceItem extends PreferenceItem {

    public DividerPreferenceItem(Context mContext) {
        super(mContext);
    }

    @Override
    public void setLayoutResId() {
        mResId = R.layout.layout_title_preference_item ;
    }

    @Override
    public void bind(View mContentView) {

    }
}
