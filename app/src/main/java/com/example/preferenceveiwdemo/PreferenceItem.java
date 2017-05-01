package com.example.preferenceveiwdemo;

import android.content.Context;
import android.view.View;

/**
 * author: daxiong9527
 * mail : 15570350453@163.com
 */

public abstract class PreferenceItem implements View.OnClickListener {
    int mResId = R.layout.layout_item_setting;

    Context mContext;
    PreferenceClick preferenceClick;
    View mContentView;

    interface PreferenceClick {
        void onPreferenceClick(PreferenceItem preferenceItem);
    }

    public PreferenceItem(Context mContext) {
        this.mContext = mContext;
        setLayoutResId();
    }

    public int getmResId() {
        return mResId;
    }

    public void bindView(View mContentView) {
        this.mContentView = mContentView;
        mContentView.setOnClickListener(this);
        bind(mContentView);
    }

    public void setClickable(boolean enable) {
        mContentView.setClickable(enable);
    }

    public abstract void setLayoutResId();

    public abstract void bind(View mContentView);

    public void setPreferenceClick(PreferenceClick preferenceClick) {
        this.preferenceClick = preferenceClick;
    }

    @Override
    public void onClick(View v) {
        if (null != preferenceClick) {
            preferenceClick.onPreferenceClick(this);
        }
    }
}
