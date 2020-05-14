package c346.rp.edu.sg.p04ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNote;
    RadioGroup rgStars;
    RadioButton rbSelect;
    Button btnInsert, btnShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnShow = (Button)findViewById(R.id.btnShow);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);

                etNote = (EditText) findViewById(R.id.etNote);
                rgStars = (RadioGroup)findViewById(R.id.rgStars);
                int star = rgStars.getCheckedRadioButtonId();
                rbSelect = (RadioButton)findViewById(star);

                String note = etNote.getText().toString();
                String stars = rbSelect.getText().toString();
                db.insertNote(note, stars);

                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_LONG).show();
                db.close();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
    }
}
