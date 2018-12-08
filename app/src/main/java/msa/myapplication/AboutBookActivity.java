package msa.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutBookActivity extends AppCompatActivity {
    Button read, seeLib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_book);
        read = (Button) findViewById(R.id.ReadButton);
        seeLib = (Button) findViewById(R.id.SongLibraryButton);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goRead();
            }
        });
        seeLib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeSongs();
            }
        });
    }

    public void goRead(){
        Intent int1 = new Intent(AboutBookActivity.this, ReaderActivity.class);
        startActivity(int1);
    }

    public void seeSongs(){
        Intent int1 = new Intent(AboutBookActivity.this, ReaderActivity.class);
        startActivity(int1);
    }


}
