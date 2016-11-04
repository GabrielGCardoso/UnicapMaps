package unicap.grafos.unicapmaps.util;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by uira on 01/11/16.
 */

public class MapaZoom extends RelativeLayout {

    private String TAG = "MapaZoom";

    public MapaZoom(Context context) {
        super(context);
    }

    public MapaZoom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MapaZoom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_DOWN:
                        Log.i(TAG, "ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.i(TAG, "ACTION_MOVE");
                        break;
                }
                return true;
            }
        });

    }
}
