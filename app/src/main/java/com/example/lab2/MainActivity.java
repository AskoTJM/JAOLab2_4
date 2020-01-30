package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    ArrayList<String> COUNTRIES = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.addCountry).setOnClickListener(this);
        findViewById(R.id.editCountry).setOnClickListener(this);
        findViewById(R.id.removeCountry).setOnClickListener(this);
        COUNTRIES.add("Angola");
        COUNTRIES.add("Aruba");
        COUNTRIES.add("Australia");

        ListView myListView = (ListView) findViewById(R.id.country_list_view);
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>( this, android.R.layout.simple_expandable_list_item_1, COUNTRIES);
        myListView.setAdapter(aa);


        }
        // Suoraan nyysitty L2DemoNimet esimerkistä.
        // Hakee tekstikohdasta...tekstin ja palauttaa sen String muodossa
        private String getTextFieldText() {
            EditText editor = findViewById(R.id.text_editor);
            String text = editor.getText().toString();
            editor.setText(null);
            return text;
        }
        // Hakee ArrayLististä Maan indeksi numeron
        private int getCountryIndexNumber(String country){
            int indexNumero;
            indexNumero = COUNTRIES.indexOf(country);
            //String vastaus = new String;

            return indexNumero;
        }


        @Override
        public void onClick(View v) {

            String country = getTextFieldText();
            if (country != null && country.length() > 0){
                int indexNumero = getCountryIndexNumber(country);
                if (v.getId() == R.id.addCountry) {
                        // Jos maata ei löytynyt COUNTRIES taulukosta
                        if ( indexNumero == -1)
                        COUNTRIES.add(country);

                } else if (v.getId() == R.id.editCountry) {
                    //Log.d("Lab2", "Pressed Edit");
                    if (indexNumero != -1);

                } else if (v.getId() == R.id.removeCountry) {
                    Log.d("Lab2", "Pressed remove");
                    if(indexNumero != -1)
                    COUNTRIES.remove(indexNumero);
                }
            }
        }
    }

