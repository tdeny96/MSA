package e.deny.frontandoverview;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OverviewActivity extends AppCompatActivity  {

    private Button library;
    private Button signIn;
    private Button fanArt;
    private Button logIn;
    private Button upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        library = (Button)findViewById(R.id.GoToLibrary);
        signIn = (Button)findViewById(R.id.SignInButton);
        fanArt = (Button)findViewById(R.id.FanArtButton);
        logIn = (Button)findViewById(R.id.LoginButton);
        upload = (Button)findViewById(R.id.UploadButton);
        upload.setEnabled(false);
        library.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                GoToLibrary();
            }
        });
        signIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SignIn();
            }
        });
        logIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LogIn();
            }
        });
        fanArt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                GoToFanArt();
            }
        });
    }

    public void GoToLibrary(){
        //Intent it1=new Intent(OverviewActivity.this, LibraryActivity.class);
        Intent it1=new Intent(OverviewActivity.this, BlankActivity.class);
        startActivity(it1);
    }

    public void SignIn(){
       // Intent it2 =new Intent(OverviewActivity.this, SignInActivity.class);
        Intent it2=new Intent(OverviewActivity.this, BlankActivity.class);
        startActivity(it2);
    }

    public void LogIn(){
        //Intent it3=new Intent(OverviewActivity.this, LogInActivity.class);
        Intent it3=new Intent(OverviewActivity.this, BlankActivity.class);
        startActivity(it3);
    }

    public void GoToFanArt(){
       // Intent it4=new Intent(OverviewActivity.this, FanArtActivity.class);
        Intent it4=new Intent(OverviewActivity.this, BlankActivity.class);
        startActivity(it4);
    }
}
