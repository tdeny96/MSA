package msa.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class BookLibraryActivity extends AppCompatActivity {
    SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_library);

    }

    public void seeBook(){
        Intent i1 = new Intent(BookLibraryActivity.this, AboutBookActivity.class);
        startActivity(i1);
    }
}
