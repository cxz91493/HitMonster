package com.example.ykk.hitmonster;

/**
 * Created by Ykk on 16/5/9.
 */
public class Monster {

    private float nowX;
    private float nowY;

    //向量，可以通過調節此兩個變數調節移動速度
    private int dx, dy;

    public Monster(float nowX, float nowY, int speed) {
        this.nowX = nowX;
        this.nowY = nowY;
        dx = speed;
        dy = speed;

    }

    public float getNowX() {
        return nowX;
    }

    public float getNowY() {
        return nowY;
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
}