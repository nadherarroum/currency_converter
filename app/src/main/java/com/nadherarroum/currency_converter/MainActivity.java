package com.nadherarroum.currency_converter;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;
    EditText price;
    Button buttonConv;
    int convTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        price = findViewById(R.id.price);
        textView = findViewById(R.id.result);
        buttonConv = findViewById(R.id.ConvBtn);
        radioGroup = findViewById(R.id.radioGRP);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                radioButton = findViewById(i);
                switch (radioButton.getId()){
                    case R.id.radioTUN: {
                        //textView.setText("TND -> EUR");
                        //Log.d("Logid","> You want to convert From TND To EURO !");
                        convTo = 1;
                        break;
                    }
                    case R.id.radioEUR: {
                        //textView.setText("EUR -> TND");
                        //Log.d("Logid","> You want to convert From TND To EURO !");
                        convTo = 2;
                        break;
                    }
                    default:{
                        convTo = 0;
                    }
                }
            }
        });

        buttonConv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertCurrency(view);
            }
        });
    }

    private void convertCurrency(View view) {
        float p = Float.parseFloat(price.getText().toString());

        if (convTo == 1){
            float euro = (float) (p / 3.2);
            textView.setText(String.valueOf(euro));
        }else if(convTo == 2){
            float dinar = (float) (p * 3.2);
            textView.setText(String.valueOf(dinar));
        }else{
            Toast.makeText(this,
                    "Select currency to convert",
                    Toast.LENGTH_SHORT).show();
        }
    }


}