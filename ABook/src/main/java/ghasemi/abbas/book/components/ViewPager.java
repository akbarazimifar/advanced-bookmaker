/*
 * Copyright (C) 2019  All rights reserved for FaraSource (ABBAS GHASEMI)
 *
 * All rights This application For FaraSource Reserved.
 * using the license of this source is permitted only for customers.
 * customers are not permitted to share,sell and exchange this source.
 *
 * This source is sold only at the following site:
 *
 * https://farasource.com
 *
 * Copyright ABBAS GHASEMI, 2019. Developer => ABBAS GHASEMI
 * Reference = http://stackoverflow.com/
 */
package ghasemi.abbas.book.components;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class ViewPager extends androidx.viewpager.widget.ViewPager {

    public ViewPager(@NonNull Context context) {
        super(context);
    }

    public ViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        if (mode == MeasureSpec.UNSPECIFIED || mode == MeasureSpec.AT_MOST) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            int height = 0;
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                int h = child.getMeasuredHeight();
                if (h > height) height = h;
            }
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}