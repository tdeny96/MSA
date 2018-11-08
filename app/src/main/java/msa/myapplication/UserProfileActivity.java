package msa.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserProfileActivity extends AppCompatActivity {
    private Button MusicButton;
    private Button LibraryButton;
    private TextView username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        MusicButton = (Button)findViewById(R.id.MusicLibraryButton);
        LibraryButton = (Button)findViewById(R.id.BookLibraryButton);
        username = (TextView)findViewById(R.id.userName);
        MusicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotonext();
            }
        });
        LibraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToBooks();
            }
        });
    }

    private void gotonext(){
        Intent intent2 = new Intent(UserProfileActivity.this,MusicLibraryActivity.class);
        startActivity(intent2);
    }

    private void GoToBooks(){
        Intent intent3 = new Intent(UserProfileActivity.this,BookLibraryActivity.class);
        startActivity(intent3);
    }
}
