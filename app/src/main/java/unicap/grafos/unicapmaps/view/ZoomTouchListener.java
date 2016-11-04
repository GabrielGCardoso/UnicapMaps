package unicap.grafos.unicapmaps.view;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import unicap.grafos.unicapmaps.util.LayoutWrapContentUpdater;

/**
 * Created by uira on 01/11/16.
 */

public class ZoomTouchListener extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, GestureDetector.OnDoubleTapListener {
    private String TAG = "MOTION EVENT";
    private RelativeLayout view;
    private GestureDetector gestureDetector;
    int wOriginal;
    int hOriginal;
    int minScale = 1;
    int maxScale = 2;

    public ZoomTouchListener(RelativeLayout view, Context context) {
        this.view = view;
        gestureDetector = new GestureDetector(context, this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        gestureDetector.onTouchEvent(event);

        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.i(TAG, "onSingleTapConfirmed");

        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.i(TAG, "onDoubleTap");

        wOriginal = view.getWidth();
        hOriginal = view.getHeight();

        view.setScaleX(2);
        view.setScaleY(2);
        ViewGroup.LayoutParams params;

        LayoutWrapContentUpdater.wrapContentAgain((ViewGroup) view.getParent());
        //params = ((View) view.getParent()).getLayoutParams();
        //((View) view.getParent()).setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        //((View) view.getParent().getParent()).setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.i(TAG, "onDoubleTapEvent");
        return false;
    }
}
