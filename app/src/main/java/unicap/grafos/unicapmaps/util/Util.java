package unicap.grafos.unicapmaps.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by cais on 21/11/16.
 */

public class Util {
    public static void esconderTeclado(Context context, View view){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static int calculaDistancia(int x1, int y1, int x2, int y2) {
        return (int) (Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) * 0.328f);
    }
}
