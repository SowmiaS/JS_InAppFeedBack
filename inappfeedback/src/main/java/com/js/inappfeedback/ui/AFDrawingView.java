package com.js.inappfeedback.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by sowmi on 12/04/16.
 */
public class AFDrawingView extends ImageView{

    private Path drawingPath = new Path();
    private Paint paint = new Paint(Paint.DITHER_FLAG);
    private Canvas drawCanvas;
    private Bitmap canvasBitmap;
    private float strokeWidth = 3f;
    private boolean mEnableDrawing = true;
    private boolean isBitmapInitialised = false;

    public AFDrawingView(Context context) {
        super(context);
        init();
    }

    public AFDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AFDrawingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setScreenshotImg(Bitmap bitmap){
        canvasBitmap = bitmap;
        invalidate();
    }

    private void init() {
        paint.setStrokeWidth(strokeWidth);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mEnableDrawing) {
            Log.d("DrawingView", "canvasBitmap:" + canvasBitmap);
            Log.d("DrawingView", "drawingPath:" + drawingPath);
            Log.d("DrawingPath", "paint:" + paint);
            Log.d("DrawingPath", "canvas :" + canvas);
            canvas.drawBitmap(canvasBitmap, 0, 0, paint);
            canvas.drawPath(drawingPath, paint);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if(!isBitmapInitialised) {
            Log.d("DrawingView", "onSizeChanged");
            canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            drawCanvas = new Canvas(canvasBitmap);
            Log.d("DrawingView", "onSizeChanged Done assigning value");
            paint.setColor(Color.RED);
            isBitmapInitialised = true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(mEnableDrawing) {
            Log.d("DrawingView", "onTouchEvent");
            Log.d("DrawingView", "X" + event.getX());
            Log.d("DrawingView", "Y" + event.getY());
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Log.d("DrawingView", "Action Down");
                    drawingPath.moveTo(event.getX(), event.getY());
                    break;
                case MotionEvent.ACTION_UP:
                    Log.d("DrawingView", "Action Up");
                    Log.d("DrawingView", "Action Up DrawCanvas:" + drawCanvas);
                    break;
                case MotionEvent.ACTION_MOVE:
                    Log.d("DrawingView", "Action Move");
                    drawingPath.lineTo(event.getX(), event.getY());
                    break;
                default:
                    return false;
            }
            invalidate();
            return  true;
        }
        return  false;
    }

    public void setmEnableDrawing(boolean mEnableDrawing) {
        this.mEnableDrawing = mEnableDrawing;
    }

    public void clearDrawing() {
        mEnableDrawing = true;
        drawingPath.rewind();
        invalidate();
        mEnableDrawing = false;
    }

    public Bitmap getBitmap(){
        return canvasBitmap;
    }
}
