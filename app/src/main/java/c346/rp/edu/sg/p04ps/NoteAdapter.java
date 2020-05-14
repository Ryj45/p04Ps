package c346.rp.edu.sg.p04ps;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends ArrayAdapter<Note> {

    private ArrayList<Note> notes;
    private Context context;
    private TextView tvNote;
    private ImageView img1, img2, img3, img4, img5;

    public NoteAdapter(Context context, int resource, ArrayList<Note> objects){
        super(context, resource, objects);
        notes = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        tvNote = (TextView)rowView.findViewById(R.id.tvNote);
        img1 = (ImageView)rowView.findViewById(R.id.img1);
        img2 = (ImageView)rowView.findViewById(R.id.img2);
        img3 = (ImageView)rowView.findViewById(R.id.img3);
        img4 = (ImageView)rowView.findViewById(R.id.img4);
        img5 = (ImageView)rowView.findViewById(R.id.img5);

        Note currentNote = notes.get(position);
        tvNote.setText(currentNote.getNote());
        String stars = currentNote.getStars();
        if (stars.equals("5")) {
            img5.setImageResource(android.R.drawable.btn_star_big_on);
            img4.setImageResource(android.R.drawable.btn_star_big_on);
            img3.setImageResource(android.R.drawable.btn_star_big_on);
            img2.setImageResource(android.R.drawable.btn_star_big_on);
            img1.setImageResource(android.R.drawable.btn_star_big_on);
        }
        else if (stars.equals("4")) {
            img5.setImageResource(android.R.drawable.btn_star_big_off);
            img4.setImageResource(android.R.drawable.btn_star_big_on);
            img3.setImageResource(android.R.drawable.btn_star_big_on);
            img2.setImageResource(android.R.drawable.btn_star_big_on);
            img1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (stars.equals("3")) {
            img5.setImageResource(android.R.drawable.btn_star_big_off);
            img4.setImageResource(android.R.drawable.btn_star_big_off);
            img3.setImageResource(android.R.drawable.btn_star_big_on);
            img2.setImageResource(android.R.drawable.btn_star_big_on);
            img1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (stars.equals("2")) {
            img5.setImageResource(android.R.drawable.btn_star_big_off);
            img4.setImageResource(android.R.drawable.btn_star_big_off);
            img3.setImageResource(android.R.drawable.btn_star_big_off);
            img2.setImageResource(android.R.drawable.btn_star_big_on);
            img1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (stars.equals("1")) {
            img5.setImageResource(android.R.drawable.btn_star_big_off);
            img4.setImageResource(android.R.drawable.btn_star_big_off);
            img3.setImageResource(android.R.drawable.btn_star_big_off);
            img2.setImageResource(android.R.drawable.btn_star_big_off);
            img1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (stars.equals("0")) {
            img5.setImageResource(android.R.drawable.btn_star_big_off);
            img4.setImageResource(android.R.drawable.btn_star_big_off);
            img3.setImageResource(android.R.drawable.btn_star_big_off);
            img2.setImageResource(android.R.drawable.btn_star_big_off);
            img1.setImageResource(android.R.drawable.btn_star_big_off);
        }

        return rowView;
    }

}
