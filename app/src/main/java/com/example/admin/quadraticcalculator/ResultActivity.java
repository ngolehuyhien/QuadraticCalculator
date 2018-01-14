package com.example.admin.quadraticcalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private Button mBtnBack;
    TextView txtKetQua, txtPhuongTrinh;
    public static final String EXTRA_DATA = "EXTRA_DATA";
    int a, b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtKetQua = (TextView)findViewById(R.id.result);
        txtPhuongTrinh = (TextView)findViewById(R.id.equation);
        mBtnBack = (findViewById(R.id.btn_back));

        Intent callerIntent = getIntent();

        Bundle packBundle = callerIntent.getBundleExtra("MyPackage");

        a = packBundle.getInt("soA");
        b = packBundle.getInt("soB");

        if (b>=0)
            txtPhuongTrinh.setText(a + " x + " +b +" = 0");
        else
            txtPhuongTrinh.setText(a + " x - " +(-b) +" = 0");

        giaiPTBN(a,b);

        mBtnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String toast = "Welcome back to MainActivity! Your last edit text : a = "+ a + ", b = " + b;
                Bundle bundle = new Bundle();
                bundle.putString("value", toast);
                startActivityForResult(new Intent(ResultActivity.this, MainActivity.class).putExtras(bundle),1);
            }
        });

    }

    public void giaiPTBN(int a, int b){
        if (a==0){
            if (b==0){
                txtKetQua.setText("Phương trình vô số nghiệm");
                return;
            }else {
                txtKetQua.setText("Phương trình vô nghiệm");
            }
        }else
            txtKetQua.setText(String.valueOf((float)-b/a));
    }
}
