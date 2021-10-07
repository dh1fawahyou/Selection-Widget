package com.example.listviewact;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Nasi Pecel", "Nasi Padang", "Soto", "Pancake", "Nasi Lemak"};
    String mDescription[] = {"Nasi Pecel Description", "Nasi Padang Description", "Soto Description", "Pancake Description", "Nasi Lemak Description"};
    int images[] = {R.drawable.pecel, R.drawable.padang, R.drawable.soto, R.drawable.pancakes, R.drawable.nslemak};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Nasi Pecel Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 1){
                    Toast.makeText(MainActivity.this, "Nasi Padang Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 2){
                    Toast.makeText(MainActivity.this, "Soto Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 3){
                    Toast.makeText(MainActivity.this, "Pancake Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 4){
                    Toast.makeText(MainActivity.this, "Nasi Lemak Description", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]){
            super(c, R.layout.row, R.id.txtTitle, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.txtTitle);
            TextView myDescription = row.findViewById(R.id.txtSubTitle);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }
}