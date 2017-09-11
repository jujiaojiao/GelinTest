package com.example.administrator.gelintest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = ((TextView) findViewById(R.id.tv));
        tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ApkUtils.openGreenCategory(this,"2");
    }
}
