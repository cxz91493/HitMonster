package com.example.ykk.hitmonster;


import java.util.LinkedList;

/**
 * Created by Ykk on 16/5/8.
 */
public class DrawThread extends Thread {

    private LinkedList<Monster> monsterList = new LinkedList<>();

    public DrawThread(LinkedList<Monster> monsterList){
        this.monsterList = monsterList;
    }

    @Override
    public void run() {
        while(true)
        {
            for(int i=0 ; i < monsterList.size() ; i++){
                Monster monster = monsterList.get(i);
                monster.setNowX();
                monster.setNowY();
            }
            MySurfaceView.draw(monsterList);

        }

    }
}
