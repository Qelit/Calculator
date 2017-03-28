package qelit.calculator;

import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    // определение переменных
    Button btnC, btnMin, btnPerc, btnDel, btnDiv, btnMul, btnMinus, btnPlus, btnEq, btnDot;
    Button btnZero, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    TextView tv1, tv2;
    double result = 0;
    double prom = 0;
    String top ="";
    String bot ="";
    String crow ="";
    String zod = "";
    int der = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // кнопки и текст
        btnC = (Button) findViewById(R.id.btnC);
        btnMin = (Button) findViewById(R.id.btnMin);
        btnPerc = (Button) findViewById(R.id.btnPerc);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnEq = (Button) findViewById(R.id.btnEq);
        btnZero = (Button) findViewById(R.id.btnZero);
        btnDot = (Button) findViewById(R.id.btnDot);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
    }
        // цифровы кнопки и точка
    public void onClickNumb(View v){
        switch(v.getId()){
            case R.id.btnZero:
                bot = bot + 0;
                tv1.setText(bot);
                crow = crow + 0;
                break;
            case R.id.btn1:
                bot = bot + 1;
                tv1.setText(bot);
                crow = crow + 1;
                break;
            case R.id.btn2:
                bot = bot + 2;
                tv1.setText(bot);
                crow = crow + 2;
                break;
            case R.id.btn3:
                bot = bot + 3;
                tv1.setText(bot);
                crow = crow + 3;
                break;
            case R.id.btn4:
                bot = bot + 4;
                tv1.setText(bot);
                crow = crow + 4;
                break;
            case R.id.btn5:
                bot = bot + 5;
                tv1.setText(bot);
                crow = crow + 5;
                break;
            case R.id.btn6:
                bot = bot + 6;
                tv1.setText(bot);
                crow = crow + 6;
                break;
            case R.id.btn7:
                bot = bot + 7;
                tv1.setText(bot);
                crow = crow + 7;
                break;
            case R.id.btn8:
                bot = bot + 8;
                tv1.setText(bot);
                crow = crow + 8;
                break;
            case R.id.btn9:
                bot = bot + 9;
                tv1.setText(bot);
                crow = crow + 9;
                break;
            case R.id.btnDot:
                bot = bot + ".";
                tv1.setText(bot);
                crow = crow + ".";
                break;
        }
    }
    // кнопки операций
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClickRes(View v){
        switch(v.getId()){
            case R.id.btnC:
                bot = "";
                tv1.setText(bot);
                tv2.setText(bot);
                crow = "";
                result = 0;
                zod ="";
                break;
            case R.id.btnDel:
                char[] m = bot.toCharArray();
                char[] d = crow.toCharArray();
                bot = "";
                crow = "";
                if ((m.length - 1) >= 0) {
                    for (int i = 0; i < m.length - 1; i++) {
                        bot = bot + String.valueOf(m[i]);
                    }
                }
                if ((d.length - 1) >= 0) {
                    for (int i = 0; i < d.length - 1; i++){
                        crow = crow + String.valueOf(d[i]);
                    }
                }
                tv1.setText(bot);
                break;
            case R.id.btnPlus:
                if (crow != "") {
                    bot = bot + "+";
                    tv1.setText(bot);
                    prom = Double.parseDouble(crow);
                    crow = "";
                    if (result != 0) {
                        if (result % 1 == 0 && prom % 1 == 0) {
                            int q = (int) result;
                            int qq = (int) prom;
                            tv2.setText(String.valueOf(q) + "+" + String.valueOf(qq));
                        }
                        else {
                            tv2.setText(String.valueOf(result) + "+" + String.valueOf(prom));
                        }
                        result = result + prom;
                        prom = 0;
                        if (result % 1 == 0) {
                            der = (int) result;
                            tv1.setText(String.valueOf(der));
                            bot = String.valueOf(der + "+");
                        } else {
                            tv1.setText(String.valueOf(result));
                            bot = String.valueOf(result);
                            bot = String.valueOf(result + "+");
                        }
                    } else {
                        result = prom;
                    }
                } else {
                    bot = bot + "+";
                    tv1.setText(bot);
                }
                zod = "+";
                break;
            case R.id.btnMinus:
                if (crow != "") {
                    bot = bot + "-";
                    tv1.setText(bot);
                    prom = Double.parseDouble(crow);
                    crow = "";
                    if (result != 0) {
                        tv2.setText(String.valueOf(result) + "-" + String.valueOf(prom));
                        result = result - prom;
                        prom = 0;
                        tv1.setText(String.valueOf(result));
                        bot = String.valueOf(result + "-");
                    } else {
                        result = prom;
                    }
                } else {
                    bot = bot + "-";
                    tv1.setText(bot);
                }
                zod = "-";
                break;
            case R.id.btnDiv:
                if (crow != "") {
                    bot = bot + "÷";
                    tv1.setText(bot);
                    prom = Double.parseDouble(crow);
                    crow = "";

                    if (prom == 0) {
                        Toast.makeText(this, "Издеваешься?", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if (result != 0) {
                        tv2.setText(String.valueOf(result) + "÷" + String.valueOf(prom));
                        result = result / prom;
                        prom = 0;
                        String formattedDouble = new DecimalFormat("#0.00").format(result);
                        tv1.setText(String.valueOf(formattedDouble));
                        bot = String.valueOf(result + "÷");
                    } else {
                        result = prom;
                    }
                } else {
                    bot = bot + "÷";
                    tv1.setText(bot);

                }
                zod = "÷";
                break;
            case R.id.btnMul:
                if (crow != "") {
                    bot = bot + "x";
                    tv1.setText(bot);
                    prom = Double.parseDouble(crow);
                    crow = "";
                    if (result != 0) {
                        tv2.setText(String.valueOf(result) + "x" + String.valueOf(prom));
                        result = result * prom;
                        prom = 0;
                        tv1.setText(String.valueOf(result));
                        bot = String.valueOf(result + "x");
                    } else {
                        result = prom;
                    }
                } else {
                bot = bot + "x";
                    tv1.setText(bot);
            }
                zod = "x";
                break;
            case R.id.btnPerc:
                bot = bot + "%";
                tv1.setText(bot);
                double p = Double.parseDouble(crow);
                p = (p /100);
                crow = String.valueOf(p);
                break;
            case R.id.btnMin:
                if (crow == ""){
                    bot = "-" + bot;
                    crow = "-";
                } else {
                    double ep = Double.parseDouble(crow) * -1;
                    crow = String.valueOf(ep);
                    if (ep >= 0)
                        bot = "-" + bot;
                    else {
                        bot = bot.substring(1);
                    }
                }
                tv1.setText(bot);
                break;
            case R.id.btnEq:
                if (crow != "") {
                    prom = Double.parseDouble(crow);
                    crow = "";
                }
                switch(zod){
                    case "+" :
                        if (result % 1 == 0 && prom % 1 == 0) {
                            int q = (int) result;
                            int qq = (int) prom;
                            tv2.setText(String.valueOf(q) + "+" + String.valueOf(qq));
                        }
                        else {
                            tv2.setText(String.valueOf(result) + "+" + String.valueOf(prom));
                        }
                        result = result + prom;
                        prom = 0;
                        if (result % 1 == 0) {
                            der = (int) result;
                            tv1.setText(String.valueOf(der));
                            bot = String.valueOf(der);
                        }
                        else {
                            tv1.setText(String.valueOf(result));
                            bot = String.valueOf(result);
                        }
                        zod = "";
                        break;
                    case "-" :
                        if (result % 1 == 0 && prom % 1 == 0) {
                            int q = (int) result;
                            int qq = (int) prom;
                            tv2.setText(String.valueOf(q) + "-" + String.valueOf(qq));
                        } else {
                            tv2.setText(String.valueOf(result) + "-" + String.valueOf(prom));
                        }
                        result = result - prom;
                        prom = 0;
                        if (result % 1 == 0) {
                            der = (int) result;
                            tv1.setText(String.valueOf(der));
                            bot = String.valueOf(der);
                        }
                        else {
                            tv1.setText(String.valueOf(result));
                            bot = String.valueOf(result);
                        }
                        zod = "";
                        break;
                    case "÷" :
                        if (result % 1 == 0 && prom % 1 == 0) {
                            int q = (int) result;
                            int qq = (int) prom;
                            tv2.setText(String.valueOf(q) + "÷" + String.valueOf(qq));
                        } else {
                            tv2.setText(String.valueOf(result) + "÷" + String.valueOf(prom));
                        }
                        result = result / prom;
                        prom = 0;
                        if (result % 1 == 0) {
                            der = (int) result;
                            tv1.setText(String.valueOf(der));
                            bot = String.valueOf(der);
                        }
                        else {
                            String formattedDouble = new DecimalFormat("#0.00").format(result);
                            tv1.setText(String.valueOf(formattedDouble));
                            bot = String.valueOf(result);
                        }
                        zod = "";
                        break;
                    case "x" :
                        if (result % 1 == 0 && prom % 1 == 0) {
                            int q = (int) result;
                            int qq = (int) prom;
                            tv2.setText(String.valueOf(q) + "x" + String.valueOf(qq));
                        } else {
                            tv2.setText(String.valueOf(result) + "x" + String.valueOf(prom));
                        }
                        result = result * prom;
                        prom = 0;
                        if (result % 1 == 0) {
                            der = (int) result;
                            tv1.setText(String.valueOf(der));
                            bot = String.valueOf(der);
                        }
                        else {
                            tv1.setText(String.valueOf(result));
                            bot = String.valueOf(result);
                        }
                        zod = "";
                        break;
                }
                break;
        }

    }
    // создание меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
