package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener{
    private Button Bt_0;
    private Button Bt_1;
    private Button Bt_2;
    private Button Bt_3;
    private Button Bt_4;
    private Button Bt_5;
    private Button Bt_6;
    private Button Bt_7;
    private Button Bt_8;
    private Button Bt_9;
    private Button Bt_mul;
    private Button Bt_divide;
    private Button Bt_plus;
    private Button Bt_minus;
    private Button Bt_cal;
    private Button Bt_dot;
    private Button Bt_clear;
    private Button Bt_back;
    private TextView Answer;
    double f_result=0;       //用来存放最终结果
    double save_number;      //用来存放临时结果
    double s_num1,s_num2,s_num3;       //用来代指计算过程中的第一、二、三个数
    boolean flag=false;         //用来记录是否点击了小数点这个按钮
    boolean flag1=false;        //用来记录是否点击了符号按钮
    int count_dotindex=0;       //用来记录小数点后的位数
    int number_index=0;         //用来记录点击符号的次数
    private String Textstr;         //用来存放从文本框获取的字符串
    int s_prifront=0,s_priback=0;       //用来存放运算式中运算符的优先级，用数字表示

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bt_0 = (Button) findViewById(R.id.button0);
        Bt_1 = (Button) findViewById(R.id.button1);
        Bt_2 = (Button) findViewById(R.id.button2);
        Bt_3 = (Button) findViewById(R.id.button3);
        Bt_4 = (Button) findViewById(R.id.button4);
        Bt_5 = (Button) findViewById(R.id.button5);
        Bt_6 = (Button) findViewById(R.id.button6);
        Bt_7 = (Button) findViewById(R.id.button7);
        Bt_8 = (Button) findViewById(R.id.button8);
        Bt_9 = (Button) findViewById(R.id.button9);
        Bt_cal = (Button) findViewById(R.id.button_cal);
        Bt_divide = (Button) findViewById(R.id.button_divide);
        Bt_clear = (Button) findViewById(R.id.button_clear);
        Bt_dot = (Button) findViewById(R.id.button_dot);
        Bt_mul = (Button) findViewById(R.id.button_mul);
        Bt_plus = (Button) findViewById(R.id.button_plus);
        Bt_minus = (Button) findViewById(R.id.button_minus);
        Bt_back = (Button) findViewById(R.id.button_back);
        Answer = (TextView)findViewById(R.id.answer);

        Bt_0.setOnClickListener(this);
        Bt_1.setOnClickListener(this);
        Bt_2.setOnClickListener(this);
        Bt_3.setOnClickListener(this);
        Bt_4.setOnClickListener(this);
        Bt_5.setOnClickListener(this);
        Bt_6.setOnClickListener(this);
        Bt_7.setOnClickListener(this);
        Bt_8.setOnClickListener(this);
        Bt_9.setOnClickListener(this);
        Bt_cal.setOnClickListener(this);
        Bt_divide.setOnClickListener(this);
        Bt_clear.setOnClickListener(this);
        Bt_dot.setOnClickListener(this);
        Bt_mul.setOnClickListener(this);
        Bt_plus.setOnClickListener(this);
        Bt_minus.setOnClickListener(this);
        Bt_back.setOnClickListener(this);
        Bt_back.setOnLongClickListener(this);
    }

    public void onClick(View v) {
        Textstr = (String) Answer.getText();
        switch (v.getId()) {
            case R.id.button_clear:
                Answer.setText("0");
                f_result = 0;
                save_number = 0;
                flag = false;
                flag1 = false;
                count_dotindex = 0;
                number_index = 0;
                s_prifront = 0;
                s_priback = 0;
                s_num1=0;
                s_num2=0;
                s_num3=0;
                break;
            case R.id.button_dot:
                if(flag1==false) {
                    if (flag == false) {
                        Answer.setText(Textstr + ".");
                        flag = true;
                        count_dotindex = 1;
                    } else {
                    }
                }
                else {
                    count_dotindex = 1;
                    flag1=false;
                }
                break;
            case R.id.button0:
                save_number = getnum(0);
                Textstr = "" + save_number;
                if(flag1==false){
                    if (flag == false) {
                        Answer.setText(Textstr.substring(0, Textstr.length() - 2));
                    }
                    else {
                        BigDecimal d0 = new BigDecimal(save_number);
                        double d00 = d0.setScale(count_dotindex - 1, BigDecimal.ROUND_HALF_UP).doubleValue();
                        Textstr = "" + d00;
                        Answer.setText(Textstr);
                    }
                }
                else{
                    Answer.setText("0");
                    flag1=false;
                }
                break;
            case R.id.button1:
                save_number = getnum(1);
                Textstr = "" + save_number;
                if(flag1==false){
                    if (flag == false) {
                        Answer.setText(Textstr.substring(0, Textstr.length() - 2));
                    }
                    else {
                        BigDecimal d1 = new BigDecimal(save_number);
                        double d11 = d1.setScale(count_dotindex - 1, BigDecimal.ROUND_HALF_UP).doubleValue();
                        Textstr = "" + d11;
                        Answer.setText(Textstr);
                    }
                }
                else{
                    Answer.setText("1");
                    flag1=false;
                }
                break;
            case R.id.button2:
                save_number = getnum(2);
                Textstr = "" + save_number;
                if(flag1==false){
                    if (flag == false) {
                        Answer.setText(Textstr.substring(0, Textstr.length() - 2));
                    }
                    else {
                        BigDecimal d2 = new BigDecimal(save_number);
                        double d22 = d2.setScale(count_dotindex - 1, BigDecimal.ROUND_HALF_UP).doubleValue();
                        Textstr = "" + d22;
                        Answer.setText(Textstr);
                    }
                }
                else{
                    Answer.setText("2");
                    flag1=false;
                }
                break;
            case R.id.button3:
                save_number = getnum(3);
                Textstr = "" + save_number;
                if(flag1==false){
                    if (flag == false) {
                        Answer.setText(Textstr.substring(0, Textstr.length() - 2));
                    }
                    else {
                        BigDecimal d3 = new BigDecimal(save_number);
                        double d33 = d3.setScale(count_dotindex - 1, BigDecimal.ROUND_HALF_UP).doubleValue();
                        Textstr = "" + d33;
                        Answer.setText(Textstr);
                    }
                }
                else{
                    Answer.setText("3");
                    flag1=false;
                }
                break;
            case R.id.button4:
                save_number = getnum(4);
                Textstr = "" + save_number;
                if(flag1==false){
                    if (flag == false) {
                        Answer.setText(Textstr.substring(0, Textstr.length() - 2));
                    }
                    else {
                        BigDecimal d4 = new BigDecimal(save_number);
                        double d44 = d4.setScale(count_dotindex - 1, BigDecimal.ROUND_HALF_UP).doubleValue();
                        Textstr = "" + d44;
                        Answer.setText(Textstr);
                    }
                }
                else{
                    Answer.setText("4");
                    flag1=false;
                }
                break;
            case R.id.button5:
                save_number = getnum(5);
                Textstr = "" + save_number;
                if(flag1==false){
                    if (flag == false) {
                        Answer.setText(Textstr.substring(0, Textstr.length() - 2));
                    }
                    else {
                        BigDecimal d5 = new BigDecimal(save_number);
                        double d55 = d5.setScale(count_dotindex - 1, BigDecimal.ROUND_HALF_UP).doubleValue();
                        Textstr = "" + d55;
                        Answer.setText(Textstr);
                    }
                }
                else{
                    Answer.setText("5");
                    flag1=false;
                }
                break;
            case R.id.button6:
                save_number = getnum(6);
                Textstr = "" + save_number;
                if(flag1==false){
                    if (flag == false) {
                        Answer.setText(Textstr.substring(0, Textstr.length() - 2));
                    }
                    else {
                        BigDecimal d6 = new BigDecimal(save_number);
                        double d66 = d6.setScale(count_dotindex - 1, BigDecimal.ROUND_HALF_UP).doubleValue();
                        Textstr = "" + d66;
                        Answer.setText(Textstr);
                    }
                }
                else{
                    Answer.setText("6");
                    flag1=false;
                }
                break;
            case R.id.button7:
                save_number = getnum(7);
                Textstr = "" + save_number;
                if(flag1==false){
                    if (flag == false) {
                        Answer.setText(Textstr.substring(0, Textstr.length() - 2));
                    }
                    else {
                        BigDecimal d7 = new BigDecimal(save_number);
                        double d77 = d7.setScale(count_dotindex - 1, BigDecimal.ROUND_HALF_UP).doubleValue();
                        Textstr = "" + d77;
                        Answer.setText(Textstr);
                    }
                }
                else{
                    Answer.setText("7");
                    flag1=false;
                }
                break;
            case R.id.button8:
                save_number = getnum(8);
                Textstr = "" + save_number;
                if(flag1==false){
                    if (flag == false) {
                        Answer.setText(Textstr.substring(0, Textstr.length() - 2));
                    }
                    else {
                        BigDecimal d8 = new BigDecimal(save_number);
                        double d88 = d8.setScale(count_dotindex - 1, BigDecimal.ROUND_HALF_UP).doubleValue();
                        Textstr = "" + d88;
                        Answer.setText(Textstr);
                    }
                }
                else{
                    Answer.setText("8");
                    flag1=false;
                }
                break;
            case R.id.button9:
                save_number = getnum(9);
                Textstr = "" + save_number;
                if(flag1==false){
                    if (flag == false) {
                        Answer.setText(Textstr.substring(0, Textstr.length() - 2));
                    }
                    else {
                        BigDecimal d9 = new BigDecimal(save_number);
                        double d99 = d9.setScale(count_dotindex - 1, BigDecimal.ROUND_HALF_UP).doubleValue();
                        Textstr = "" + d99;
                        Answer.setText(Textstr);
                    }
                }
                else{
                    Answer.setText("9");
                    flag1=false;
                }
                break;
            case R.id.button_back:
                if(flag==false){
                    if(Textstr.length()>1) {
                        String a = Textstr.substring(0, Textstr.length() - 1);
                        Answer.setText(a);
                    }
                    else if(Textstr.length()==0||Textstr.length()==1){
                        Answer.setText("0");
                    }
                }
                else{
                    String a=Textstr.substring(0,Textstr.length()-1);
                    Answer.setText(a);
                    count_dotindex--;
                    if(count_dotindex==0){
                        flag=false;
                    }
                }
                break;
            case R.id.button_plus:
                flag1=true;
                number_index++;
                if (number_index == 1) {
                    s_prifront = 1;
                    s_num1 = Double.parseDouble(Textstr);
                    String result0 = "" + s_num1;
                    Answer.setText(result0);
                }
                if (number_index == 2) {
                    s_num2 = Double.parseDouble(Textstr);
                    if(s_prifront==1){
                        s_num1=s_num1+s_num2;
                    }
                    else if(s_prifront==2){
                        s_num1=s_num1-s_num2;
                    }
                    else if(s_prifront==3){
                        s_num1=s_num1*s_num2;
                    }
                    else if(s_prifront==4){
                        s_num1=s_num1/s_num2;
                    }
                    String result0 = "" + s_num1;
                    Answer.setText(result0);
                    number_index--;
                    s_prifront=1;
                }
                if(number_index==3){
                    s_num3 = Double.parseDouble(Textstr);
                    if(s_priback==3){
                        s_num2=s_num2*s_num3;
                    }
                    if(s_priback==4){
                        s_num2=s_num2/s_num3;
                    }
                    if(s_prifront==1){
                        s_num1=s_num1+s_num2;
                    }
                    if(s_prifront==2){
                        s_num1=s_num1-s_num2;
                    }
                    String result0 = "" + s_num1;
                    Answer.setText(result0);
                    s_prifront=1;
                    s_priback=0;
                    number_index=1;
                }
                break;
            case R.id.button_minus:
                flag1=true;
                number_index++;
                if (number_index == 1) {
                    s_prifront = 2;
                    s_num1 = Double.parseDouble(Textstr);
                    String result0 = "" + s_num1;
                    Answer.setText(result0);
                }
                if (number_index == 2) {
                    s_num2 = Double.parseDouble(Textstr);
                    if(s_prifront==1){
                        s_num1=s_num1+s_num2;
                    }
                    else if(s_prifront==2){
                        s_num1=s_num1-s_num2;
                    }
                    else if(s_prifront==3){
                        s_num1=s_num1*s_num2;
                    }
                    else if(s_prifront==4){
                        s_num1=s_num1/s_num2;
                    }
                    String result0 = "" + s_num1;
                    Answer.setText(result0);
                    number_index--;
                    s_prifront=2;
                }
                if(number_index==3){
                    s_num3 = Double.parseDouble(Textstr);
                    if(s_priback==3){
                        s_num2=s_num2*s_num3;
                    }
                    if(s_priback==4){
                        s_num2=s_num2/s_num3;
                    }
                    if(s_prifront==1){
                        s_num1=s_num1+s_num2;
                    }
                    if(s_prifront==2){
                        s_num1=s_num1-s_num2;
                    }
                    String result0 = "" + s_num1;
                    Answer.setText(result0);
                    s_prifront=2;
                    s_priback=0;
                    number_index=1;
                }
                break;
            case R.id.button_mul:
                flag1=true;
                number_index++;
                if (number_index == 1) {
                    s_prifront = 3;
                    s_num1 = Double.parseDouble(Textstr);
                    String result0 = "" + s_num1;
                    Answer.setText(result0);
                }
                if (number_index == 2) {
                    s_priback = 3;
                    s_num2 = Double.parseDouble(Textstr);
                    if (s_prifront >= s_priback) {
                        if (s_prifront == 3) {
                            s_num1 = s_num1 * s_num2;
                        }
                        if (s_prifront == 4) {
                            s_num1 = s_num1 / s_num2;
                        }
                        String result0 = "" + s_num1;
                        Answer.setText(result0);
                        number_index--;
                        s_prifront=3;
                        s_priback=0;
                    }
                    else {

                        String result0 = "" + s_num2;
                        Answer.setText(result0);
                    }
                }
                if (number_index == 3) {
                    s_num3 = Double.parseDouble(Textstr);
                    if(s_priback==3){
                        s_num2=s_num2*s_num3;
                    }
                    else{
                        s_num2=s_num2/s_num3;
                    }
                    String result0 = "" + s_num2;
                    Answer.setText(result0);
                    number_index--;
                    s_priback=3;
                }
                break;
            case R.id.button_divide:
                flag1=true;
                number_index++;
                if (number_index == 1) {
                    s_prifront = 4;
                    s_num1 = Double.parseDouble(Textstr);
                    String result0 = "" + s_num1;
                    Answer.setText(result0);
                }
                if (number_index == 2) {
                    s_num2 = Double.parseDouble(Textstr);
                    s_priback = 4;
                    if (s_prifront==4){
                        s_num1=s_num1/s_num2;
                        String result0 = "" + s_num1;
                        Answer.setText(result0);
                        number_index--;
                        s_priback=0;
                    }
                    else if(s_prifront==3){
                        s_num1=s_num1*s_num2;
                        String result0 = "" + s_num1;
                        Answer.setText(result0);
                        number_index--;
                        s_prifront=4;
                        s_priback=0;
                    }
                    else{
                        s_num2 = Double.parseDouble(Textstr);
                        String result0 = "" + s_num2;
                        Answer.setText(result0);
                    }
                }
                if (number_index==3){
                    s_num3 = Double.parseDouble(Textstr);
                    if(s_priback==3){
                        s_num2=s_num2*s_num3;
                    }
                    else{
                        s_num2=s_num2/s_num3;
                    }
                    String result0 = "" + s_num2;
                    Answer.setText(result0);
                    s_priback=4;
                    number_index--;
                }
                break;
            case R.id.button_cal:
                if (number_index==0){
                    s_num1 = Double.parseDouble(Textstr);
                }
                if (number_index==1){
                    s_num2 = Double.parseDouble(Textstr);
                }
                if (number_index==2){
                    s_num3 = Double.parseDouble(Textstr);
                }
                if (s_prifront==0){

                }
                else if(s_prifront!=0 && s_priback==0){
                    if(s_prifront==1){
                        f_result=s_num1+s_num2;
                    }
                    else if(s_prifront==2){
                        f_result=s_num1-s_num2;
                    }
                    else if(s_prifront==3){
                        f_result=s_num1*s_num2;
                    }
                    else if(s_prifront==4){
                        f_result=s_num1/s_num2;
                    }
                    String re=""+f_result;
                    Answer.setText(re);
                    s_num1=f_result;
                    s_num2=0;
                    s_prifront=0;
                    number_index--;
                }
                else if(s_prifront!=0 && s_priback!=0){
                    switch (s_prifront) {
                        case 1:
                            if (s_priback == 3) {
                                f_result = s_num1 + s_num2 * s_num3;
                            }
                            if (s_priback == 4) {
                                f_result = s_num1 + s_num2 / s_num3;
                            }
                            break;
                        case 2:
                            if (s_priback == 3) {
                                f_result = s_num1 - s_num2 * s_num3;
                            }
                            if (s_priback == 4) {
                                f_result = s_num1 - s_num2 / s_num3;
                            }
                            break;
                    }
                    String re=""+f_result;
                    Answer.setText(re);
                    s_num1=f_result;
                    s_num2=0;
                    s_num3=0;
                    s_prifront=0;
                    s_priback=0;
                    number_index=number_index-2;
                }
        }
    }

    public boolean onLongClick(View v){
        if(v.getId()==R.id.button_back){
            Answer.setText("0");
        }
        return true;
    }

    public double getnum(int a){
        double s = Double.parseDouble(Textstr);
        if (flag==false){
            s=s*10+a;
        }
        else{
            s=s+(a/Math.pow(10,count_dotindex));
            count_dotindex++;
        }
        return s;
    }
}
