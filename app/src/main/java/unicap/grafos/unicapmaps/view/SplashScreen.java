package unicap.grafos.unicapmaps.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import unicap.grafos.unicapmaps.R;
import unicap.grafos.unicapmaps.dao.GrafoDao;
import unicap.grafos.unicapmaps.model.Grafo;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Grafo grafo = Grafo.getInstance();
                if (grafo.getVertices().size() == 0) {
                    GrafoDao grafoDao = new GrafoDao();
                    grafoDao.getGrafo();
                }
                startMain();
            }
        }, 300);

    }

    protected void startMain() {
        Intent mainIntent = new Intent(SplashScreen.this, Main.class);
        startActivityForResult(mainIntent, 0);
        finish();
    }

}
