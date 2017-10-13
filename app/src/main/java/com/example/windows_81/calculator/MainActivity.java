package com.example.windows_81.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mainTextView;
    private Button btn_7,btn_8,btn_9,btn_4,btn_5,btn_6,btn_1,btn_2,btn_3,btn_0,btnDot;
    private Button btnSum,btnSub,btnMul,btnDiv;
    private Button btnPersent,btnEqual;
    private Button btnClear,btnUndo;
    private Button btnRightP,btnLeftP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
        this.addListeners();
        this.editControls();
    }

    private void init(){
        mainTextView = (TextView) findViewById(R.id.editTexExpression);

        btn_7 = (Button) findViewById(R.id.button7);
        btn_8 = (Button) findViewById(R.id.button8);
        btn_9 = (Button) findViewById(R.id.button9);
        btn_4 = (Button) findViewById(R.id.button4);
        btn_5 = (Button) findViewById(R.id.button5);
        btn_6 = (Button) findViewById(R.id.button6);
        btn_1 = (Button) findViewById(R.id.button1);
        btn_2 = (Button) findViewById(R.id.button2);
        btn_3 = (Button) findViewById(R.id.button3);
        btn_0 = (Button) findViewById(R.id.button0);
        btnDot = (Button) findViewById(R.id.buttonDot);

        btnSum = (Button) findViewById(R.id.buttonSum);
        btnSub = (Button) findViewById(R.id.buttonSub);
        btnMul = (Button) findViewById(R.id.buttonMul);
        btnDiv = (Button) findViewById(R.id.buttonDiv);

        btnPersent = (Button) findViewById(R.id.buttonPercent);
        btnEqual = (Button) findViewById(R.id.buttonEqual);

        btnClear = (Button) findViewById(R.id.buttonClear);
        btnUndo = (Button) findViewById(R.id.buttonClearOne);

        btnRightP = (Button) findViewById(R.id.buttonRightP);
        btnLeftP = (Button) findViewById(R.id.buttonLeftP);


    }

    private void addListeners(){
        //button 7
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.append("7");

            }
        });

        //button 8
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.append("8");

            }
        });

        //button 9
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.append("9");

            }
        });

        //button 4
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.append("4");

            }
        });

        //button 5
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.append("5");

            }
        });

        //button 6
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.append("6");

            }
        });

        //button 1
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.append("1");

            }
        });

        //button 2
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.append("2");

            }
        });

        //button 3
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.append("3");

            }
        });

        //button 0
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.append("0");

            }
        });

        //button dot
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.append(".");

            }
        });

        //button sum
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.append("+");

            }
        });

        //button sub
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.append("-");

            }
        });

        //button mul
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.append("*");

            }
        });

        //button div
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.append("/");

            }
        });

        //button clear
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.setText("");

            }
        });

        //button left p
        btnLeftP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.append("(");

            }
        });

        //button right p
        btnRightP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.append(")");

            }
        });

        //button percent
        btnPersent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String result = Calculator.calculateExpression(mainTextView.getText().toString());
                    double finalResult = Double.parseDouble(result) / 100;
                    mainTextView.setText(String.valueOf(finalResult));
                }catch(Exception ex){
                    mainTextView.setText("");
                }

            }
        });

        //button undo
        btnUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence str = mainTextView.getText();
                if(str.length() > 0){
                    str =  str.subSequence(0,str.length()-1);
                    mainTextView.setText(str);
                }

            }
        });

        //button equal
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    mainTextView.setText(Calculator.calculateExpression(mainTextView.getText().toString()));
                }catch (Exception ex){
                   // Toast.makeText(getApplicationContext(),"Invalid Expression",Toast.LENGTH_LONG);
                    mainTextView.setText("Invalid Expression");
                }

            }
        });
    }

    private void editControls(){
        mainTextView.setText("");
        mainTextView.setKeyListener(null);
    }
}
