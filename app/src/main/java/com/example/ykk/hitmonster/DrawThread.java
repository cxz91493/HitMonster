package com.example.ykk.hitmonster;


import java.util.LinkedList;

/**
 * Created by Ykk on 16/5/8.
 */
public class DrawThread extends Thread {

    private LinkedList<Monster> monsterList;
    private MySurfaceView surfaceView;
    private boolean exitFlag = false;

    public DrawThread(LinkedList<Monster> monsterList, MySurfaceView surfaceView) {
        this.monsterList = monsterList;
        this.surfaceView = surfaceView;
    }

    public void interrupt() {
        exitFlag = true;
    }

    @Override
    public void run() {
        while (!exitFlag) {
            for (int i = 0; i < monsterList.size(); i++) {
                Monster monster = monsterList.get(i);
                monster.setNowX();
                monster.setNowY();
            }


            /***** merge monster *****/
            boolean mergeflag = false;
            for (int i = 0; !mergeflag && i < monsterList.size(); i++) {
                for (int j = i + 1; j < monsterList.size(); j++) {
                    Monster m1 = monsterList.get(i);
                    Monster m2 = monsterList.get(j);
                    if (distance(m1, m2) < 60 * Math.sqrt(2)) {
                        if (m1.getType() == m2.getType()) {
                            if (m1.getHP()!=5 && m1.getHP() == m2.getHP()) {
                                float x1 = m1.getNowX();
                                float y1 = m1.getNowY();
                                float x2 = m2.getNowX();
                                float y2 = m2.getNowY();
                                int speed = m1.getSpeed();
                                if(m2.getSpeed()>speed){
                                    speed = m2.getSpeed();
                                }
                                Monster mergeMonster = new Monster((x1 + x2) / 2, (y1 + y2) / 2, speed, 5);
                                monsterList.remove(m1);
                                monsterList.remove(m2);
                                monsterList.add(mergeMonster);
                                mergeflag = true;
                                break;
                            }
                        }
                    }
                }
            }

            surfaceView.draw(monsterList);

        }

    }

    public float distance(Monster m1, Monster m2) {
        float x1 = m1.getNowX();
        float y1 = m1.getNowY();
        float x2 = m2.getNowX();
        float y2 = m2.getNowY();
        float dist = (float) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return dist;
    }
}
