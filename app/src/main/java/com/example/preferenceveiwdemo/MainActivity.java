package com.example.preferenceveiwdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SettingPreferenceView prefernce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefernce = (SettingPreferenceView) findViewById(R.id.prefernce);
        initSettingView();

    }

    public void initSettingView() {
        PreferenceData[] preferenceDatas = new PreferenceData[]{
                new PreferenceData(R.string.key_setting_divider, DividerPreferenceItem.class, -1,-1, PreferenceData.TYPE_DIVIDER),
                new PreferenceData(R.string.key_bind_phone_num, TextPreferenceItem.class, R.string.str_setting_title_account,
                        R.mipmap.ic_launcher,
                        PreferenceData.TYPE_TEXT),
                new PreferenceData(R.string.key_setting_divider, DividerPreferenceItem.class, -1,-1 ,PreferenceData.TYPE_DIVIDER),
                new PreferenceData(R.string.key_screen_shot_sharing_tips, SwitchPreferenceItem.class,
                        R.string.key_screen_shot_sharing_tips,  R.mipmap.ic_launcher, PreferenceData.TYPE_SWITCH),
                new PreferenceData(R.string.key_setting_divider, DividerPreferenceItem.class, -1,-1, PreferenceData.TYPE_DIVIDER),

        };

        prefernce.setPreferenceItems(preferenceDatas);

        prefernce.findPrefernce(R.string.key_bind_phone_num).setPreferenceClick(PhonepreferenceClick);

        prefernce.findPrefernce(R.string.key_screen_shot_sharing_tips).setPreferenceClick(PushprefernceClick);

    }

    PreferenceItem.PreferenceClick PhonepreferenceClick = new PreferenceItem.PreferenceClick() {
        @Override
        public void onPreferenceClick(PreferenceItem preferenceItem) {
            Log.d("test","aaaaaaaaaaaaa");
            Toast.makeText(MainActivity.this,"phone",Toast.LENGTH_SHORT).show();
        }
    };
    PreferenceItem.PreferenceClick PushprefernceClick = new PreferenceItem.PreferenceClick() {
        @Override
        public void onPreferenceClick(PreferenceItem preferenceItem) {
            Log.d("test","bbbbbbbbbbb");
            Toast.makeText(MainActivity.this,"PushprefernceClick",Toast.LENGTH_SHORT).show();
        }
    };

}
