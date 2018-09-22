package com.khanhhung.baitapevent1;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtA,txtB;
    private TextView txtKQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();

    }
    private void addEvent(){

    }
    private void addControls(){
        txtA= findViewById(R.id.txtA);
        txtB= findViewById(R.id.txtB);
        txtKQ= findViewById(R.id.txtKQ);
    }
    public void Tong(View view){
        int a = Integer.parseInt(txtA.getText().toString()); //doi kieu tu string sang int
        int b= Integer.parseInt(txtB.getText().toString()); //doi kieu tu string sang int

        int c=a+b;


        txtKQ.setText(a + "+" + b + "=" + c); //ep kieu tu int sang string

        txtA.getText().clear(); //xoa so A
        txtB.getText().clear(); // xoa so B
        txtA.requestFocus(); //focus vao o A

    }
}
