package com.example.unitConvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView inpView;
    private TextView resView;
    private TextView resValue;
    private EditText inpValue;
    private Button convert;
    private Button swap;
    private TextView heading;

    public void calculate(){
        String s = inpValue.getText().toString();
        int inp = Integer.parseInt(s);

        if(heading.getText().toString().equals("Convert Kg to Pounds")) {
            double res = 2.205 * inp;
            resValue.setText("" + res);
        }else {
            double res=inp/2.205;
            resValue.setText("" + res);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inpView =findViewById(R.id.textView);
        resView =findViewById(R.id.textView2);
        resValue=findViewById(R.id.textView4);
        inpValue=findViewById(R.id.editTextNumber);
        convert=findViewById(R.id.button);
        swap=findViewById(R.id.button2);
        heading=findViewById(R.id.textView3);
        inpValue.setText("1");

        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp= resView.getText().toString();
                resView.setText(inpView.getText().toString());
                inpView.setText(temp);
                inpValue.setText("1");
                resValue.setText("");
                if(heading.getText().toString().equals("Convert Kg to Pounds"))
                    heading.setText("Convert Pounds to Kg");
                else
                    heading.setText("Convert Kg to Pounds");
            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                Toast.makeText(MainActivity.this, "Calculating the values...", Toast.LENGTH_SHORT).show();
            }
        });

    }
}