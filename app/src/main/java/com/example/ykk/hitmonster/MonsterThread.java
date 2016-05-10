package com.example.ykk.hitmonster;


import java.util.LinkedList;

/**
 * Created by Ykk on 16/5/8.
 */
public class MonsterThread extends Thread {
    private LinkedList<Monster> monsterList;
    MySurfaceView surfaceView;

    public MonsterThread(LinkedList<Monster> monsterList,MySurfaceView surfaceView) {
        this.monsterList = monsterList;
        this.surfaceView = surfaceView;
    }

    @Override
    public void run() {
        int monsterCount = 0;
        int speed = 3;
        int time = 3000;
        new DrawThread(monsterList,surfaceView).start();

        while (monsterCount <= 10) {
            if (monsterCount % 5 == 0) {//Add speed
                speed++;
                time = (time == 1000 ) ? 1000 : time-500;

            }
            float x = (float) (Math.random() * MySurfaceView.screenWidth);
            float y = (float) (Math.random() * MySurfaceView.screenHeight);
            Monster m = new Monster(x, y, speed, 5);
            monsterList.add(m);
            monsterCount++;

            try {
                this.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
