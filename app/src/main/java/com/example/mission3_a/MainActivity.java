package com.example.mission3_a;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.main);
        Button button = findViewById(R.id.bt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    EditText n1 = new EditText(getApplicationContext());
                    EditText n2 = new EditText(getApplicationContext());
                    Button b = new Button(getApplicationContext());
                    n1.setId(Integer.parseInt("1"));
                    n2.setId(Integer.parseInt("2"));
                    b.setText("Submit");
                    n1.setInputType(InputType.TYPE_CLASS_NUMBER);
                    n2.setInputType(InputType.TYPE_CLASS_NUMBER);
                    layout.addView(n1);
                    layout.addView(n2);
                    layout.addView(b);

                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int num1 = Integer.valueOf(String.valueOf(n1.getText()));
                            int num2 = Integer.valueOf(String.valueOf(n2.getText()));
                            int sum = num1 + num2;
                            Toast.makeText(getApplicationContext(), "sum: " + sum, Toast.LENGTH_LONG).show();
                        }


                    })
                    ;
                } catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Nan", Toast.LENGTH_LONG).show();

                }






            }


        });
        return;

        }
}
