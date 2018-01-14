package com.example.admin.quadraticcalculator;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mBtnResult;
    EditText txta, txtb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnResult = (findViewById(R.id.btn_result));
        txta = (EditText) findViewById(R.id.input_a);
        txtb = (EditText) findViewById(R.id.input_b);

        if(this.getIntent().getExtras() != null){
            Toast.makeText(this,this.getIntent().getExtras().getString("value"),Toast.LENGTH_LONG).show();
        }

        mBtnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txta.getText().toString().trim().equals("") && !txtb.getText().toString().trim().equals("")) {
                    Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                    int a=Integer.parseInt(txta.getText().toString());
                    int b=Integer.parseInt(txtb.getText().toString());
                    Bundle bundle = new Bundle();
                    bundle.putInt("soA",a);
                    bundle.putInt("soB",b);

                    myIntent.putExtra("MyPackage", bundle);
                    startActivity(myIntent);
                }else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số vào!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
            txta = (EditText) findViewById(R.id.input_a);
            txtb = (EditText) findViewById(R.id.input_b);
            txta.setText("");
            txtb.setText("");
        }
    }
}
