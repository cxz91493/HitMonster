package com.example.ykk.hitmonster;


import java.util.LinkedList;

/**
 * Created by Ykk on 16/5/8.
 */
public class DrawThread extends Thread {

    private LinkedList<Monster> monsterList;
    private MySurfaceView surfaceView;
    private boolean exitFlag = false;

    public DrawThread(LinkedList<Monster> monsterList, MySurfaceView surfaceView){
        this.monsterList = monsterList;
        this.surfaceView = surfaceView;
    }

    public void interrupt(){
        exitFlag = true;
    }

    @Override
    public void run() {
        while(!exitFlag)
        {
            for(int i=0 ; i < monsterList.size() ; i++){
                Monster monster = monsterList.get(i);
                monster.setNowX();
                monster.setNowY();
            }


            surfaceView.draw(monsterList);

        }

    }
}
