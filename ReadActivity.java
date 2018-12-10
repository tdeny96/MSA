package e.deny.frontandoverview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.barteksc.pdfviewer.PDFView;

public class ReadActivity extends AppCompatActivity {


    public PDFView pdfReader;
    public float zoom=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        pdfReader = findViewById(R.id.pdfReader);
        pdfReader.fromAsset("Speak.pdf").defaultPage(1)
                .spacing(10)
                .load();
    }
}
