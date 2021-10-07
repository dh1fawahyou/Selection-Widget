package com.example.spinneract;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String[] PORSI = new String[]{
            "Kecil", "Biasa", "Jumbo", "Super Jumbo"
    };

    TextView textView;
    Spinner spinner;
    String [] makanan = {"Nasi Pecel", "Nasi Padang", "Soto", "Pancake", "Nasi Lemak"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtView);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, makanan);

        spinner.setAdapter(adapterSpinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                switch (i){
                    case 0:
                        textView.setText("Nasi Pecel");
                        break;
                    case 1:
                        textView.setText("Nasi Padang");
                        break;
                    case 2:
                        textView.setText("Soto");
                        break;
                    case 3:
                        textView.setText("Pancake");
                        break;
                    case 4:
                        textView.setText("Nasi Lemak");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        AutoCompleteTextView editText = findViewById(R.id.auto);
        ArrayAdapter<String> adapterAuto = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, PORSI);
        editText.setAdapter(adapterAuto);
    }
}