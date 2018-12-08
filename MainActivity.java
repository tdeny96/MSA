package e.deny.frontandoverview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button explore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        explore=(Button)findViewById(R.id.ExploreButton);
        explore.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                overview();
            }
        });
    }

    private void overview(){
        Intent it = new Intent(MainActivity.this,OverviewActivity.class);
        startActivity(it);
    }
}
