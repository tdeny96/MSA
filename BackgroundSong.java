package e.deny.frontandoverview;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class BackgroundSong extends Service {
    MediaPlayer mp;
    String tag = "start";
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
    public void onCreate()
    {
        mp = MediaPlayer.create(this, R.raw.dream);
        mp.setLooping(false);
    }
    public void onDestroy()
    {
        mp.stop();
    }
    public void onStart(Intent intent,int startid){

        Log.d(tag,"On start");
        mp.start();
    }
}

