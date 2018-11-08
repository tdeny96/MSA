package msa.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.core.Context;

import java.util.ArrayList;

public class MusicLibraryActivity extends AppCompatActivity {


    private static final int MY_PERMISSION_REQUEST = 1;
    ArrayList<String> ar;
    ListView sv;
    ArrayAdapter<String> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_library);
        if(ContextCompat.checkSelfPermission(MusicLibraryActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MusicLibraryActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)){
                ActivityCompat.requestPermissions(MusicLibraryActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST);
            } else {
                ActivityCompat.requestPermissions(MusicLibraryActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST);
            }
        } else doStuff();
    }

    public void doStuff(){
        sv = (ListView) findViewById(R.id.list);
        ar = new ArrayList<>();
        getMusic();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ar);
        sv.setAdapter(adapter);
        sv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playSongs();
                    }
                });
    }

    public void getMusic(){
        ContentResolver contentResolver = getContentResolver();
        Uri songUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor songCursor = contentResolver.query(songUri,null,null,null,null);
        if (songCursor !=null && songCursor.moveToFirst()){
            int songTitle = songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int songArtist = songCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);

            do {
                String currentTitle = songCursor.getString(songTitle);
                String currentArtist = songCursor.getString(songArtist);
                ar.add(currentTitle+"\n"+currentArtist);
            } while (songCursor.moveToNext());
        }
    }

    public void OnRequestPermissionResult(int requestCode, String[] permissions[],int [] grantResults){
        switch(requestCode){
            case MY_PERMISSION_REQUEST: {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(MusicLibraryActivity.this,
                            Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
                        Toast.makeText(this,"Permission Granted.",Toast.LENGTH_SHORT).show();
                    doStuff();
                }
                else {
                    Toast.makeText(this,"Permission Denied.",Toast.LENGTH_SHORT).show();
                    finish();
                }
                return;
            }
        }
    }

    public void playSongs(){
        Intent i1= new Intent(MusicLibraryActivity.this, SongListenerActivity.class);
        startActivity(i1);
    }
}
