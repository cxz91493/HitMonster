package com.example.ykk.hitmonster;


import android.graphics.Rect;
import android.util.Log;

import java.util.Random;

/**
 * Created by Ykk on 16/5/9.
 */
public class Monster {

    private float nowX;
    private float nowY;

    //向量，可以通過調節此兩個變數調節移動速度
    private int dx, dy;
    double r = Math.random() * (Math.PI * 2);

    private int HP;

    public Monster(float nowX, float nowY, int speed, int HP) {
        this.nowX = nowX;
        this.nowY = nowY;
        this.HP = HP;
        dx = (int)(speed * Math.cos(r));
        dy = (int)(speed * Math.sin(r));

    }

    public float getNowX() {
        return nowX;
    }

    public float getNowY() {
        return nowY;
    }

    public int getHP(){
        return HP;
    }
    public void setNowX() {
        if (nowX < 0 || nowX > MySurfaceView.screenWidth - 32) {
            dx = -dx;
        }
        nowX = nowX + dx;
    }

    public void setNowY() {
        if (nowY < 0 || nowY > MySurfaceView.screenHeight - 32) {
            dy = -dy;
        }
        nowY = nowY + dy;
    }

    public void setHP(int nowHP){
        HP = nowHP;
    }
}