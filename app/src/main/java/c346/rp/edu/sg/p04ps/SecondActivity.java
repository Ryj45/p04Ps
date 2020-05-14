package c346.rp.edu.sg.p04ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lvNote;
    ArrayList<Note> notes;
    ArrayAdapter aaNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent receivedIntent = getIntent();
        DBHelper db = new DBHelper(SecondActivity.this);
        notes = db.getNote();
        db.close();

        lvNote = (ListView)findViewById(R.id.lvNote);
        aaNote = new NoteAdapter(SecondActivity.this, R.layout.row, notes);
        lvNote.setAdapter(aaNote);

    }
}
