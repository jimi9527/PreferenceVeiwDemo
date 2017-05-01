package com.example.preferenceveiwdemo;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

/**
 * author: daxiong9527
 * mail : 15570350453@163.com
 */

public class SwitchPreferenceItem extends PreferenceItem {

    Switch mSwitch ;
    TextView mTextView;
    ImageView imageViewleft ;

    SwitchClick mSwitchClick;

    public interface SwitchClick{
        void onSwitchClick();
    }

    public void setmSwitchClick( SwitchClick mSwitchClick){
        this.mSwitchClick = mSwitchClick ;
    }

    public SwitchPreferenceItem(Context mContext) {
        super(mContext);
    }

    @Override
    public void setLayoutResId() {
        mResId = R.layout.layout_switch_prefernce_item ;
    }

    @Override
    public void bind(View mContentView) {

        mSwitch = (Switch) mContentView.findViewById(R.id.item_switch);
        mTextView = (TextView) mContentView.findViewById(R.id.item_switch_text);
        imageViewleft = (ImageView) mContentView.findViewById(R.id.item_left_image);

        mSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwitch.setChecked(!mSwitch.isSelected());
                if(mSwitchClick != null){
                    mSwitchClick.onSwitchClick();
                }
            }
        });
    }

    public void setName (int resId){
        mTextView.setText(mContext.getString(resId));
    }
    public void setSelected(boolean selected){
        mSwitch.setSelected(selected);
    }
    public void setImageViewleft(int imageResld){
        imageViewleft.setImageResource(imageResld);
    }
}
