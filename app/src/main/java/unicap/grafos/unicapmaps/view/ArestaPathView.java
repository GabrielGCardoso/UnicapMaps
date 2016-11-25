package unicap.grafos.unicapmaps.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;

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
    private int strokeWidth;

    public ArestaPathView(int width, int height, float escala, int strokeWidth) {
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        pathPaint = new Paint();
        this.strokeWidth = strokeWidth;

        //bitmap.setDensity(bitmap.getDensity());
        //textPaint = new Paint();
        path = new Path();
        this.escala = escala;

        setPaint(1);
    }

    private void setPaint(int style) {

        if(style == 1) {
            pathPaint.setStyle(Paint.Style.STROKE);
            pathPaint.setStrokeWidth(strokeWidth);
            pathPaint.setStrokeCap(Paint.Cap.ROUND);
            pathPaint.setStrokeJoin(Paint.Join.ROUND);
        } else{
            pathPaint.setStyle(Paint.Style.FILL);
        }
        pathPaint.setAntiAlias(true);
    }

    public void addPath(ArrayList<ArrayList<Coordenadas>> coords, int cor){

        // Line color
        pathPaint.setColor(cor);
        pathPaint.setAlpha(150);

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

    public void addCircle(int x, int y, int cor, int raio){
        // Line color
        setPaint(0);
        pathPaint.setColor(cor);
        canvas.drawCircle(x*escala, y*escala, raio, pathPaint);
    }

    public Bitmap getBitmap(){
        return bitmap;
    }

    public void clear() {
        bitmap.eraseColor(Color.TRANSPARENT);
    }
}
