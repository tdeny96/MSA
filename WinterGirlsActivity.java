package e.deny.frontandoverview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WinterGirlsActivity extends AppCompatActivity {
    private Button read;
    private Button fanart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winter_girls);
        read=(Button)findViewById(R.id.ReadButton);
        fanart=(Button)findViewById(R.id.FanArtButton);
        fanart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                GoToFanArt();
            }
        });
        read.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                readBook();
            }
        });
    }
    public void GoToFanArt(){
        // Intent it4=new Intent(OverviewActivity.this, FanArtActivity.class);
        Intent it4=new Intent(WinterGirlsActivity.this, BlankActivity.class);
        startActivity(it4);
    }

    public void readBook(){
         Intent it4=new Intent(WinterGirlsActivity.this, ReadActivity.class);
        //Intent it4=new Intent(WinterGirlsActivity.this, BlankActivity.class);
        startActivity(it4);
    }
}
