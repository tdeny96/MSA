package msa.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SongListenerActivity extends AppCompatActivity implements View.OnClickListener {
    Button play,pause,stop,next;
    MediaPlayer mp;
    int pauseCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_library);

        play = (Button)findViewById(R.id.PlayButton);
        pause = (Button)findViewById(R.id.PauseButton);
        stop = (Button)findViewById(R.id.StopButton);
        next = (Button)findViewById(R.id.NextButton);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    public void onClick(View view){
        switch(view.getId()){

            case R.id.PlayButton:
                if(mp==null) {
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.song);
                    mp.start();
                }
                else if (!mp.isPlaying())
                    mp.seekTo(pauseCurrentPosition);
                mp.start();
                break;
            case  R.id.PauseButton:
                if(mp==null) {
                    mp.pause();
                    pauseCurrentPosition = mp.getCurrentPosition();
                }
                break;
            case R.id.StopButton:
                if(mp!=null) {
                    mp.stop();
                    mp=null;
                }
                break;

        }
    }

    public void GoToSongs(){
        Intent intent1 = new Intent(SongListenerActivity.this,MusicLibraryActivity.class);
        startActivity(intent1);
    }
}
