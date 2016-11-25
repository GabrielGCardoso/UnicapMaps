package unicap.grafos.unicapmaps.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.model.Coordenadas;

/**
 * Created by Cais Automação on 08/10/2016. project UnicapMaps
 */

public class ArestaView extends View{

    Paint paint = new Paint();
    Path path = new Path();
    int density = 0;

    public ArestaView(Context context){
        super(context);
    }
    public ArestaView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ArestaView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setOriginByView(View view){
        this.setPivotX(view.getX());
        this.setPivotY(view.getPivotY());
    }

    private void setPaint() {
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAlpha(127);
        paint.setAntiAlias(true);
    }

    public void setDensity(int d){
        density = d;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(density != 0) canvas.setDensity(density);
        canvas.drawPath(path, paint);
    }

    public void show(ArrayList<ArrayList<Coordenadas>> coords, float escala) {
        setPaint();
        path.reset();
        path.moveTo(coords.get(0).get(0).getX(), coords.get(0).get(0).getY()); //pega a primeira coordenada do primeiro array

        for(ArrayList<Coordenadas> lista: coords){
            for(Coordenadas ponto: lista){
                path.lineTo(ponto.getX()*escala, ponto.getY()*escala);
            }
        }
    }
}
