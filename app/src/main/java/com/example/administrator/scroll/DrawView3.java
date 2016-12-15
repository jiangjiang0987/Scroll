package com.example.administrator.scroll;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Scroller;

/**
 * Created by Administrator on 2016/12/15.
 */
public class DrawView3 extends View {
    private int lastX;
    private int lastY;
    private Scroller mScroller;
    public DrawView3(Context context){
        super(context);
        initView(context);
    }



    public DrawView3(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public DrawView3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);

    }
    private void initView(Context context){
        setBackgroundColor(Color.BLUE);
        mScroller = new Scroller(context);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(mScroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = (int)event.getX();
                lastY = (int)event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                ((View)getParent()).scrollBy(-offsetX,-offsetY);
               ;

                break;
            case MotionEvent.ACTION_UP:
                View viewGroup = ((View)getParent());
//                mScroller.startScroll(viewGroup.getScrollX(),viewGroup.getScrollY(),-viewGroup.getScrollX(),-viewGroup.getScrollY());
                mScroller.startScroll(viewGroup.getScrollX(),viewGroup.getScrollY(),0,0);
                invalidate();
                break;
        }
        return  true;
    }
}

