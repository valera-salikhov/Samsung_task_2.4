package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener  {
    TextView text;
    Button solve;
    EditText ed1, ed2, ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        solve = findViewById(R.id.solve);
        text = findViewById(R.id.text);
        ed1 = findViewById(R.id.num1);
        ed2 = findViewById(R.id.num2);
        ed3 = findViewById(R.id.num3);
        solve.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String t1 = ed1.getText().toString();
        String t2 = ed2.getText().toString();
        String t3 = ed3.getText().toString();
        double a = Double.parseDouble(t1);
        double b = Double.parseDouble(t2);
        double c = Double.parseDouble(t3);
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    text.setText("бесконечное количество решений");
                    return;
                } else {
                    text.setText("нет решений");
                    return;
                }
            } else {
                text.setText(" x = " + String.valueOf(String.format(Locale.US, "%.2f", -c/b)));
            }
        } else {
            if (b == 0) {
                if (c == 0) {
                    text.setText("x = 0");
                    return;
                } else {
                    if ((-c/a) < 0) {
                        text.setText("бесконечное количество решений");
                        return;
                    } else {
                        double x = Math.sqrt(-c/a);
                        text.setText("x1 = " + String.valueOf(String.format(Locale.US, "%.2f", x)) + '\n' + "x2 = " + String.valueOf(String.format(Locale.US, "%.2f", -x)));
                        return;
                    }
                }
            } else {
                double D = b * b - 4 * a * c;
                if (D < 0) {
                    text.setText("нет решений");
                    return;
                }
                if (D == 0) {
                    text.setText("x = " + String.valueOf(String.format(Locale.US, "%.2f", -b/(2  * a))));
                    return;
                }
                if (D > 0) {
                    double x1 = (-b + Math.sqrt(D)) / (2 * a);
                    double x2 = (-b - Math.sqrt(D)) / (2 * a);
                    text.setText("x1 = " + String.valueOf(String.format(Locale.US, "%.2f", x1)) + '\n' + "x2 = " + String.valueOf(String.format(Locale.US, "%.2f", x2)));
                    return;
                }
            }
        }
    }
}