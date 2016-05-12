package com.example.ykk.hitmonster;


import android.graphics.Rect;

/**
 * Created by Ykk on 16/5/9.
 */
public class Monster {

    private int type;
    private float nowX;
    private float nowY;
//    private Rect a;
    //向量，可以通過調節此兩個變數調節移動速度
    private int dx, dy;
    private int HP, speed;

    public Monster(float nowX, float nowY, int speed, int HP) {
        this.nowX = nowX;
        this.nowY = nowY;
        this.HP = HP;
        this.speed = speed;
        dx = speed;
        dy = speed;
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

    public int getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setNowX() {
        if (nowX < 0 || nowX > MySurfaceView.screenWidth - 32) {
            dx = -dx;//random +,-
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