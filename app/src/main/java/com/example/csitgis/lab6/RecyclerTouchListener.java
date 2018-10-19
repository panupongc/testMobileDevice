package com.example.csitgis.lab6;

import android.support.annotation.NonNull;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerTouchListener {
    private ClickListtener clicklistener;
    private GestureDetector gestureDetector;

    public interface Clicklistener{
        void onclick(View view, int position);
        void onLongClick(View view, int position)
    }

    public RecyclerTouchListener(Context context,
                                 final Recycler recycleView,
                                 final ClickListener clicklistener) {
        this.clicklistener = clicklistener;
        gestureDetector.SimpleOnGestureListener;
            new GestureDetector.SimpleOnGestureListener(){

                @Override
                public boolean onSingleTapUp(MotionEvent e){
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e){
                    View child = recycleView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clicklistener != null){
                        clicklistener.onLongClick(child, recycleView.getChildAdapterPosition(child));
                    }
                }

                @Override
                public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView,
                                                     @NonNull MotionEvent motionEvent){
                    View child = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());
                    if (child != null && clicklistener != null && gestureDetector.onTouchEvent(motionEvent)){
                        clicklistener.onClick(child, recycleView.getChildAdapterPosition(child));
                    }
                    return false;
                }
            }
    }
}