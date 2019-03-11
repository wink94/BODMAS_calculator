package com.sliit.calculator_tbl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;

    private TextView tvOutput;

    private EditText etInput;

    private Button btnCE;
    private Button btnBracket1;
    private Button btnBracket2;
    private Button btnC;
    private Button btnDelete;

    private Button btnAdd;
    private Button btnMinus;
    private Button btnMultiply;
    private Button btnDivision;

    private Button btnDecimal;
    private Button btnResult;

    private double val1=Double.NaN;
    private double val2;
    private String ACTION;

    private BDMAS bdmasSimplify;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * tool bar
        * */

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        //getSupportActionBar().setTitle("CODEFEST - Calculator");
        //getSupportActionBar().setIcon(R.drawable.logo);

        /*
        * retrieve widgets
        * */

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        tvOutput = (TextView) findViewById(R.id.txtResult);

        etInput = (EditText) findViewById(R.id.edtInput);

//        btnCE = (Button) findViewById(R.id.btnCE);
        btnBracket1=(Button) findViewById(R.id.btnBracket1);
        btnBracket2=(Button) findViewById(R.id.btnBracket2);
        btnC = (Button) findViewById(R.id.btnC);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivision = (Button) findViewById(R.id.btnDivision);

        btnDecimal = (Button) findViewById(R.id.btnDecimal);
        btnResult = (Button) findViewById(R.id.btnResult);

        bdmasSimplify=new BDMAS();


        /*
        * functional buttons event handle
        * */

       /* btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.setText(null);
            }
        });*/

        btnBracket1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*val1 = Double.NaN;
                tvOutput.setText(null);
                etInput.setText(null);*/

                String temp=etInput.getText().toString();

                etInput.setText(temp+"( ");


            }
        });

        btnBracket2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*val1 = Double.NaN;
                tvOutput.setText(null);
                etInput.setText(null);*/
                String temp=etInput.getText().toString();

                etInput.setText(temp+") ");
            }

        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.NaN;
                tvOutput.setText(null);
                etInput.setText(null);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = etInput.getText().toString();
                if(number != null && number.length() > 0){
                    number = number.substring(0, number.length() - 1);
                }
                etInput.setText(number);
                etInput.setSelection(etInput.getText().length());
            }
        });


        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               /* if(ACTION != null && ACTION.equals("+")){
                    double result = val1 + Double.parseDouble(etInput.getText().toString());
                    tvOutput.setText(null);
                    etInput.setText(roundOFF(result));
                } else if(ACTION != null && ACTION.equals("-")){
                    double result = val1 - Double.parseDouble(etInput.getText().toString());
                    tvOutput.setText(null);
                    etInput.setText(roundOFF(result));
                } else if(ACTION != null && ACTION.equals("*")){
                    double result = val1 * Double.parseDouble(etInput.getText().toString());
                    tvOutput.setText(null);
                    etInput.setText(roundOFF(result));
                } else if(ACTION != null && ACTION.equals("/")){
                    double result = val1 / Double.parseDouble(etInput.getText().toString());
                    tvOutput.setText(null);
                    etInput.setText(roundOFF(result));
                }
*/


                /*ACTION = null;
                val1 = Double.NaN;
                etInput.setSelection(etInput.getText().length());*/


              double result=BDMAS.evaluate(etInput.getText().toString().trim());
              tvOutput.setText(roundOFF(result));

            }
        });

        /*
        * mathematical operations
        * */
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = "+";

                /*if(!Double.isNaN(val1)){
                    val2 = Double.parseDouble(etInput.getText().toString());
                    val1 = val1 + val2;
                } else {
                    val1 = Double.parseDouble(etInput.getText().toString());
                }

                tvOutput.setText(val1 + " + ");
                etInput.setText(null);*/

                String temp=etInput.getText().toString();

                etInput.setText(temp+"+ ");

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = "-";

                /*if(!Double.isNaN(val1)){
                    val2 = Double.parseDouble(etInput.getText().toString());
                    val1 = val1 - val2;
                } else {
                    val1 = Double.parseDouble(etInput.getText().toString());
                }

                tvOutput.setText(val1 + " - ");
                etInput.setText(null);*/

                String temp=etInput.getText().toString();

                etInput.setText(temp+"- ");

            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = "*";

                /*if(!Double.isNaN(val1)){
                    val2 = Double.parseDouble(etInput.getText().toString());
                    val1 = val1 * val2;
                } else {
                    val1 = Double.parseDouble(etInput.getText().toString());
                }

                tvOutput.setText(val1 + " * ");
                etInput.setText(null);*/

                String temp=etInput.getText().toString();

                etInput.setText(temp+"X ");


            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = "/";

                /*if(!Double.isNaN(val1)){
                    val2 = Double.parseDouble(etInput.getText().toString());
                    val1 = val1/val2;
                } else {
                    val1 = Double.parseDouble(etInput.getText().toString());
                }*/

                /*tvOutput.setText(val1 + " / ");
                etInput.setText(null);*/

                String temp=etInput.getText().toString();

                etInput.setText(temp+"/ ");

            }
        });


        /*
        * number buttons event handle
        * */

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.setText(etInput.getText() + "0 ");
                etInput.setSelection(etInput.getText().length());
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.setText(etInput.getText() + "1 ");
                etInput.setSelection(etInput.getText().length());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.setText(etInput.getText() + "2 ");
                etInput.setSelection(etInput.getText().length());
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.setText(etInput.getText() + "3 ");
                etInput.setSelection(etInput.getText().length());
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.setText(etInput.getText() + "4 ");
                etInput.setSelection(etInput.getText().length());
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.setText(etInput.getText() + "5 ");
                etInput.setSelection(etInput.getText().length());
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.setText(etInput.getText() + "6 ");
                etInput.setSelection(etInput.getText().length());
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.setText(etInput.getText() + "7 ");
                etInput.setSelection(etInput.getText().length());
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.setText(etInput.getText() + "8 ");
                etInput.setSelection(etInput.getText().length());
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.setText(etInput.getText() + "9 ");
                etInput.setSelection(etInput.getText().length());
            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.setText(etInput.getText().toString().trim() + ".");
                etInput.setSelection(etInput.getText().length());
            }
        });

    }


    private String roundOFF(double num){

        DecimalFormat df = new DecimalFormat("#.########");
        df.setRoundingMode(RoundingMode.CEILING);

        if(num%1 == 0){
            return String.valueOf(num);
        }
        else
            return df.format(num);

    }


}
