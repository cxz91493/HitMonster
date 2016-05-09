package com.example.ykk.hitmonster;


import java.util.LinkedList;

/**
 * Created by Ykk on 16/5/8.
 */
public class MonsterThread extends Thread {
    private LinkedList<Monster> monsterList = new LinkedList<>();

    public MonsterThread(LinkedList<Monster> monsterList) {
        this.monsterList = monsterList;
    }

    @Override
    public void run() {
        int monsterCount = 0;
        int speed = 5;
        new DrawThread(monsterList).start();

        while (monsterCount <= 10) {
            if (monsterCount % 5 == 0) {
                speed++;
            }
            float x = (float) (Math.random() * MySurfaceView.screenWidth);
            float y = (float) (Math.random() * MySurfaceView.screenHeight);
            Monster m = new Monster(x, y, speed);
            monsterList.add(m);
            monsterCount++;

            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
