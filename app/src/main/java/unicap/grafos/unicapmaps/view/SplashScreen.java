package unicap.grafos.unicapmaps.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.Toast;

import unicap.grafos.unicapmaps.R;
import unicap.grafos.unicapmaps.dao.GrafoDao;
import unicap.grafos.unicapmaps.model.Grafo;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Grafo grafo = Grafo.getInstance();
        if(grafo.getVertices().size() == 0) {
            GrafoDao dao = new GrafoDao();
            dao.montarGrafo();



            /* New Handler to start the Menu-Activity
             * and close this Splash-Screen after some seconds.*/
            /* Duration of wait */
            int SPLASH_DISPLAY_LENGTH = 1500;
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                    /* Create an Intent that will start the Menu-Activity. */
                    startMain();
                }
            }, SPLASH_DISPLAY_LENGTH);

        } else{
            startMain();
        }
    }
    protected void startMain(){
        Intent mainIntent = new Intent(SplashScreen.this, Main.class);

        startActivity(mainIntent);
        finish();
    }

    class LoadGrafo extends AsyncTask{

        GrafoDao grafoDao = new GrafoDao();

        @Override
        protected Grafo doInBackground(Object[] params) {
            Grafo grafo = (Grafo) params[0];
            if(grafo.getVertices().size() == 0){
                grafoDao.montarGrafo();
            }
            return grafo;
        }

    }
}
