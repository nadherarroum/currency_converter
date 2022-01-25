package com.nadherarroum.currency_converter;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.result);

        radioGroup = findViewById(R.id.radioGRP);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                radioButton = findViewById(i);
                switch (radioButton.getId()){
                    case R.id.radioTUN: {
                        textView.setText("TND -> EUR");
                        Log.d("Logid","> You want to convert From TND To EURO !");
                        break;
                    }
                    case R.id.radioEUR: {
                        textView.setText("EUR -> TND");
                        Log.d("Logid","> You want to convert From TND To EURO !");
                        break;
                    }
                }
            }
        });
    }
}