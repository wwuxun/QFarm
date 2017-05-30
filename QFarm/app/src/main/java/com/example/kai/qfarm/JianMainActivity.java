package com.example.kai.qfarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JianMainActivity extends AppCompatActivity implements View.OnClickListener{
    private  Button Button;
    private  Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jian_main);
        Button = (Button)findViewById(R.id.Button);
        Button.setOnClickListener(this);
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(JianMainActivity.this,ShujuMainActivity.class);
        startActiviy(intent);
    }

    public void onClick(View V) {
        Intent intent = new Intent(JianMainActivity.this,KongMainActivity.class);
        startActiviy(intent);
    }

}
