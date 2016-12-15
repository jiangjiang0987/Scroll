package com.example.administrator.scroll;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2016/12/15.
 */
public class DragView extends View {
    private int lastX;
    private int lastY;

    public DragView(Context context) {
        super(context);
        initView();
    }

    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();

    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();

    }
    private void initView(){
        setBackgroundColor(Color.BLUE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX = (int)(event.getRawX());
        int rawY = (int)(event.getRawY());
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = rawX;
                lastY = rawY;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = rawX - lastX;
                int offsetY = rawY - lastY;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.rightMargin = getRight() + offsetY;
                setLayoutParams(layoutParams);
                lastX = rawX;
                lastY = rawY;
                break;
        }
        return  true;
    }
}
