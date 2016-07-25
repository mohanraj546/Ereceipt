package com.eReceipt.app.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;



public class CustomTextView extends TextView {

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        AppCustomFontLoader.loadFont(this, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        AppCustomFontLoader.loadFont(this, attrs);
    }
}
