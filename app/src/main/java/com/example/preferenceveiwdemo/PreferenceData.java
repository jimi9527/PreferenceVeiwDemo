package com.example.preferenceveiwdemo;

/**
 * author: daxiong9527
 * mail : 15570350453@163.com
 */

public class PreferenceData {

    final static int TYPE_DIVIDER = 0;
    final static int TYPE_TEXT = 1;
    final static int TYPE_SWITCH = 2;

    int prefkey;
    Class<? extends PreferenceItem> inflaterCla;
    int nameResId;
    int summaryResId;
    int type;
    int imageLeftResId;


    public PreferenceData(int prefkey, Class<? extends PreferenceItem> inflaterCla, int nameResId,
                          int imageLeftResId, int type) {
        this(prefkey, inflaterCla, nameResId, -1, imageLeftResId, type);
    }

    public PreferenceData(int prefkey, Class<? extends PreferenceItem> inflaterCla, int nameResId,
                          int summaryResId, int imageLeftResId, int type) {
        this.prefkey = prefkey;
        this.inflaterCla = inflaterCla;
        this.nameResId = nameResId;
        this.summaryResId = summaryResId;
        this.imageLeftResId = imageLeftResId;
        this.type = type;
    }
}
