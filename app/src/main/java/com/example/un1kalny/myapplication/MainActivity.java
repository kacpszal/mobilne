package com.example.un1kalny.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView titleTextView;
    EditText editText;
    ToggleButton toggleButton;
    Spinner spinner;
    TextView activateTextView;
    ImageView imageView;
    Button addButton;

    private static final List<String> SPINNER_MENU = new ArrayList<>();
    private static final Map<String, Integer> letterToImageMap;
    static
    {
        letterToImageMap = new HashMap<>();
        letterToImageMap.put("A", R.drawable.letter_a);
        letterToImageMap.put("B", R.drawable.letter_b);
        letterToImageMap.put("C", R.drawable.letter_c);
        letterToImageMap.put("D", R.drawable.letter_d);
        letterToImageMap.put("E", R.drawable.letter_e);
        letterToImageMap.put("F", R.drawable.letter_f);
        letterToImageMap.put("G", R.drawable.letter_g);
        letterToImageMap.put("H", R.drawable.letter_h);
        letterToImageMap.put("I", R.drawable.letter_i);
        letterToImageMap.put("J", R.drawable.letter_j);
        letterToImageMap.put("K", R.drawable.letter_k);
        letterToImageMap.put("L", R.drawable.letter_l);
        letterToImageMap.put("M", R.drawable.letter_m);
        letterToImageMap.put("N", R.drawable.letter_n);
        letterToImageMap.put("O", R.drawable.letter_o);
        letterToImageMap.put("P", R.drawable.letter_p);
        letterToImageMap.put("Q", R.drawable.letter_q);
        letterToImageMap.put("R", R.drawable.letter_r);
        letterToImageMap.put("S", R.drawable.letter_s);
        letterToImageMap.put("T", R.drawable.letter_t);
        letterToImageMap.put("U", R.drawable.letter_u);
        letterToImageMap.put("V", R.drawable.letter_v);
        letterToImageMap.put("W", R.drawable.letter_w);
        letterToImageMap.put("X", R.drawable.letter_x);
        letterToImageMap.put("Y", R.drawable.letter_y);
        letterToImageMap.put("Z", R.drawable.letter_z);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SPINNER_MENU.addAll(Arrays.asList("Ewa", "Kacper", "Michał"));

        findControls();

        editText.setHint("Type here");

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_dropdown_item_1line, SPINNER_MENU);

        spinner.setAdapter(adapter);
        activateTextView.setText(R.string.inactive);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editText.setText("");
                if(isChecked) {
                    editText.setFocusable(false);
                    titleTextView.setVisibility(View.INVISIBLE);
                    activateTextView.setText(R.string.active);
                    editText.setHint("Edit mode off");
                    addButton.setVisibility(View.INVISIBLE);
                } else {
                    editText.setFocusableInTouchMode(true);
                    titleTextView.setVisibility(View.VISIBLE);
                    activateTextView.setText(R.string.inactive);
                    editText.setHint("Type here");
                    addButton.setVisibility(View.VISIBLE);
                }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SPINNER_MENU.add(editText.getText().toString());
                editText.setText("");
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                try {
                    imageView.setImageResource(letterToImageMap.get(spinner.getSelectedItem().toString().substring(0, 1).toUpperCase()));
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // do nothing
            }
        });
    }

    private void findControls() {
        titleTextView = findViewById(R.id.titleTextView);
        editText = findViewById(R.id.editText);
        toggleButton = findViewById(R.id.toggleButton);
        spinner = findViewById(R.id.spinner);
        activateTextView = findViewById(R.id.activateTextView);
        imageView = findViewById(R.id.imageView);
        addButton = findViewById(R.id.addButton);
    }
}
