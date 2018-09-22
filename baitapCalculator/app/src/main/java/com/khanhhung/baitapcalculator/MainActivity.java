package com.khanhhung.baitapcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText vao;
    private TextView ra;

    private Button btnN0;
    private Button btnN1;
    private Button btnN2;
    private Button btnN3;
    private Button btnN4;
    private Button btnN5;
    private Button btnN6;
    private Button btnN7;
    private Button btnN8;
    private Button btnN9;

    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;

    private Button btnCham;
    private Button btnClaer;
    private Button btnClearAll;
    private Button btnBang;

    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickViews();
    }
    public void initWidget(){
        vao = (EditText) findViewById(R.id.vao);
        ra =(TextView) findViewById(R.id.ra);

        btnN0=(Button) findViewById(R.id.btnN0);
        btnN1=(Button) findViewById(R.id.btnN1);
        btnN2=(Button) findViewById(R.id.btnN2);
        btnN3=(Button) findViewById(R.id.btnN3);
        btnN4=(Button) findViewById(R.id.btnN4);
        btnN5=(Button) findViewById(R.id.btnN5);
        btnN6=(Button) findViewById(R.id.btnN6);
        btnN7=(Button) findViewById(R.id.btnN7);
        btnN8=(Button) findViewById(R.id.btnN8);
        btnN9=(Button) findViewById(R.id.btnN9);

        btnCong=(Button) findViewById(R.id.btnCong);
        btnTru=(Button) findViewById(R.id.btnTru);
        btnNhan=(Button) findViewById(R.id.btnNhan);
        btnChia=(Button) findViewById(R.id.btnChia);

        btnCham=(Button) findViewById(R.id.btnCham);
        btnClaer=(Button) findViewById(R.id.btnClear);
        btnClearAll=(Button) findViewById(R.id.btnClearAll);
        btnBang=(Button) findViewById(R.id.btnBang);

    }

    public void setEventClickViews(){
        btnN0.setOnClickListener(this);
        btnN1.setOnClickListener(this);
        btnN2.setOnClickListener(this);
        btnN3.setOnClickListener(this);
        btnN4.setOnClickListener(this);
        btnN5.setOnClickListener(this);
        btnN6.setOnClickListener(this);
        btnN7.setOnClickListener(this);
        btnN8.setOnClickListener(this);
        btnN9.setOnClickListener(this);

        btnCong.setOnClickListener((View.OnClickListener) this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);

        btnCham.setOnClickListener(this);
        btnBang.setOnClickListener(this);
        btnClaer.setOnClickListener(this);
        btnClearAll.setOnClickListener(this);


    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btnN0:
                vao.append("0");
                break;
            case R.id.btnN1:
                vao.append("1");
                break;

            case R.id.btnN2:
                vao.append("2");
                break;
            case R.id.btnN3:
                vao.append("3");
                break;
            case R.id.btnN4:
                vao.append("4");
                break;
            case R.id.btnN5:
                vao.append("5");
                break;
            case R.id.btnN6:
                vao.append("6");
                break;
            case R.id.btnN7:
                vao.append("7");
                break;
            case R.id.btnN8:
                vao.append("8");
                break;
            case R.id.btnN9:
                vao.append("9");
                break;
            case R.id.btnCong:
                vao.append("+");
                break;
            case R.id.btnTru:
                vao.append("-");
                break;
            case R.id.btnNhan:
                vao.append("*");
                break;
            case R.id.btnChia:
                vao.append("/");
                break;
            case R.id.btnCham:
                vao.append(".");
                break;
            case R.id.btnClear:
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(vao, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btnClearAll:
                vao.setText("");
                ra.setText("");
                break;
            case R.id.btnBang:

                DecimalFormat df = new DecimalFormat("###.#######");
                double result = 0;
                addOperation(vao.getText().toString());
                addNumber(vao.getText().toString());

                //tich toan cac bieu thuc

                if (arrOperation.size() >= arrNumber.size() || arrOperation.size() < 1) {

                    ra.setText("Lỗi định dạng");
                } else {
                    for (int i = 0; i < (arrNumber.size() - 1); i++) {
                        switch (arrOperation.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = arrNumber.get(i) + arrNumber.get(i + 1);

                                } else {
                                    result = result + arrNumber.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = arrNumber.get(i) - arrNumber.get(i + 1);

                                } else {
                                    result = result - arrNumber.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    result = arrNumber.get(i) * arrNumber.get(i + 1);

                                } else {
                                    result = result * arrNumber.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    result = arrNumber.get(i) / arrNumber.get(i + 1);

                                } else {
                                    result = result / arrNumber.get(i + 1);
                                }
                                break;
                            default:
                                break;

                        }
                    }
                    ra.setText(df.format(result) + "");

                }
        }




        }

    public ArrayList<String> arrOperation;
    //Mảng chứa các số
    public ArrayList<Double> arrNumber;

    //Lấy tất cả các phép tính lưu vào mảng arrOperation
    public int addOperation(String input) {
        arrOperation = new ArrayList<>();

        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '*':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }
    //Lấy tất cả các số lưu vào mảng arrNumber
    public void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while(matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}





