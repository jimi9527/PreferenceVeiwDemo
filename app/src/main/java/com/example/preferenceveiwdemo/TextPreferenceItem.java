package com.example.preferenceveiwdemo;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * author: daxiong9527
 * mail : 15570350453@163.com
 */

public class TextPreferenceItem  extends PreferenceItem{
    ImageView mImageLeft,mImageNext ;
    TextView mTextLeft ;

    public TextPreferenceItem(Context mContext) {
        super(mContext);
    }

    @Override
    public void setLayoutResId() {
        mResId = R.layout.layout_text_preference_item ;
    }

    @Override
    public void bind(View mContentView) {
        mImageLeft = (ImageView) mContentView.findViewById(R.id.item_left_image);
        mTextLeft = (TextView) mContentView.findViewById(R.id.item_left_text);
        mImageNext = (ImageView) mContentView.findViewById(R.id.item_next_image);
    }

    public void setmTextLeft(int nameResId){
        if( -1 != nameResId){
            mTextLeft.setText(mContext.getString(nameResId));
        }

    }
    public void setmImageLeft(int imageRseld){
        if( -1 != imageRseld){
            mImageLeft.setImageResource(imageRseld);
        }
    }
}
