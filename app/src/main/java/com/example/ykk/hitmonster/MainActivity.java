package com.example.ykk.hitmonster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private LinkedList<Monster> monsterList = new LinkedList<>();

    float x, y;
    MySurfaceView surfaceView;
    MonsterThread monsterThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DisplayMetrics monitorSize = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(monitorSize);

        MySurfaceView.screenWidth = monitorSize.widthPixels - 32;
        MySurfaceView.screenHeight = monitorSize.heightPixels - 82;
        surfaceView = new MySurfaceView(this);
        setContentView(surfaceView);

        monsterThread  = new MonsterThread(monsterList, surfaceView);
        monsterThread.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.action_settings:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY() - 60;//誤差
//                for(Monster monster: monsterList){
//                    Log.e("Monster X ", monster.getNowX()+"");
//                    Log.e("Monster Y", monster.getNowY() +"");
////                }
//                Log.e("onTouch X", x +"");
//                Log.e("onTouch Y",  y+"");
                for(Monster monster: monsterList){
                    if(x >= monster.getNowX() && x <= monster.getNowX()+100 && y >= monster.getNowY() && y <= monster.getNowY()+100){
                        //Log.e("hitMonster ", monster.getHP() - 1 + "");
                        if(monster.getHP()!=0) {
                            monster.setHP(monster.getHP() - 1);
                            if(monster.getHP()==0){
                                monsterList.remove(monster);
                                    break;
                            }
                        }
                    }
                }
                break;
        }
        return true;
    }

    public void onDestroy(){
        super.onDestroy();
        monsterThread.interrupt();

    }
}
