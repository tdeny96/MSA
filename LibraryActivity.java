package e.deny.frontandoverview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LibraryActivity extends AppCompatActivity {

    private ImageButton btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        btn1 = (ImageButton) findViewById(R.id.WintergirlsButton);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                GoToWinterGirls();
            }
        });
    }

    private void GoToWinterGirls(){
        Intent i1 = new Intent(LibraryActivity.this,WinterGirlsActivity.class);
        startActivity(i1);
    }
}
