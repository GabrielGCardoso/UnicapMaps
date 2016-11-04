package unicap.grafos.unicapmaps.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.model.Coordenadas;

/**
 * Created by cais on 01/11/16.
 */

public class ArestaPathView {

    private Bitmap bitmap;
    private Canvas canvas;
    private Paint pathPaint;
    private PathEffect pathEffect;
    private Paint textPaint;
    private Path path;
    private float escala;

    public ArestaPathView(int width, int height, float escala) {
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        pathPaint = new Paint();
        //textPaint = new Paint();
        path = new Path();
        this.escala = escala;

        setPaint();
    }

    private void setPaint() {
        pathEffect = new CornerPathEffect(10);


        pathPaint.setStrokeWidth(8);
        pathPaint.setStyle(Paint.Style.STROKE);
        pathPaint.setStrokeCap(Paint.Cap.ROUND);
        pathPaint.setAntiAlias(true);
        pathPaint.setStrokeJoin(Paint.Join.ROUND);
        //pathPaint.setPathEffect(pathEffect);
    }

    public void addPath(ArrayList<ArrayList<Coordenadas>> coords, int cor){

        // Line color
        pathPaint.setColor(cor);
        pathPaint.setAlpha(127);

        //pega a primeira coordenada do primeiro array
        float X = coords.get(0).get(0).getX()*escala;
        float Y = coords.get(0).get(0).getY()*escala;

        path.reset();
        path.moveTo(X,Y);

        for(ArrayList<Coordenadas> lista: coords){
            for(Coordenadas ponto: lista){
                path.lineTo(ponto.getX()*escala, ponto.getY()*escala);
            }
        }

        canvas.drawPath(path, pathPaint);
    }

    public void addCircle(int x, int y, int cor){
        // Line color
        pathPaint.setColor(cor);
        int raio = 3;
        canvas.drawCircle(x*escala, y*escala, raio, pathPaint);
    }

    public Bitmap getBitmap(){
        return bitmap;
    }

    public void clear() {
        bitmap.eraseColor(Color.TRANSPARENT);
    }
}
