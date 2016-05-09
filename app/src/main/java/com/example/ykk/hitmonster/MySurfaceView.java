package com.example.ykk.hitmonster;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.LinkedList;

/**
 * Created by Ykk on 16/5/7.
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private static SurfaceHolder surfaceHolder = null; // 建立SurfaceHolder物件

    //Show the picture
    static Bitmap bitmap;

    static int screenWidth;
    static int screenHeight;

    public MySurfaceView(Context context) {
        super(context);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.star);

        // 取得SurfaceHolder物件並設定Callback
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
    }



    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //程式畫面的大小改變時執行
        // ...初始化資源...

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){
        //程式畫面的Canvas建立時執行
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        //程式畫面的Canvas銷毀時執行
    }

    public static void draw(LinkedList<Monster> monsterList){

        // 取得繪圖用的Canvas物件
        Canvas c = surfaceHolder.lockCanvas();
        try
        {
            // 同一時間必須確保只有一個執行緒存取Canvas
            synchronized(surfaceHolder)
            {

                c.drawColor(Color.BLACK);
                for(Monster monster: monsterList){
                    // Draw by Canvas

                    Log.i("SurfaceView", "draw()");
                    c.drawBitmap(bitmap, monster.getNowX(), monster.getNowY(), null);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // 解除Canvas鎖定
            // 備註: Unlock前確認Canvas是否已經被銷毀
            if(c != null) surfaceHolder.unlockCanvasAndPost(c);
        }

        // ...釋放資源，尤其是Bitmap圖檔...
    }


}
