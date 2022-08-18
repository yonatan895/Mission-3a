package com.example.mission3_a;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;
    public static int sum;
    public static String text;


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
                            sum = num1 + num2;
                            text = String.valueOf(sum);
                            Toast.makeText(getApplicationContext(), "sum: " + sum, Toast.LENGTH_LONG).show();
                            Button b1 = new Button(getApplicationContext());
                            Button b2 = new Button(getApplicationContext());
                            b1.setText("Green Screen");
                            b2.setText("Red Screen");
                            b1.setBackgroundColor(Color.GREEN);
                            b2.setBackgroundColor(Color.RED);
                            layout.addView(b1);
                            layout.addView(b2);
                            b1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent1 = new Intent(getBaseContext(), GreenScreen.class);
                                    intent1.putExtra(Intent.EXTRA_TEXT, text);
                                    startActivity(intent1);
                                }
                            });


                            b2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent2 = new Intent(getBaseContext(), RedScreen.class);
                                    intent2.putExtra(Intent.EXTRA_TEXT, text);
                                    startActivity(intent2);

                                }
                            });

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
