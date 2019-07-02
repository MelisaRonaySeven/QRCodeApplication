package com.artemis.qrcodeapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        TextView tv3 = findViewById(R.id.tv3);
        TextView tv4 = findViewById(R.id.tv4);
        TextView tv5 = findViewById(R.id.tv5);

        EditText et1 = findViewById(R.id.et1);
        EditText et2 = findViewById(R.id.et2);
        EditText et3 = findViewById(R.id.et3);
        EditText et4 = findViewById(R.id.et4);
        EditText et5 = findViewById(R.id.et5);

        tv1.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        tv3.setVisibility(View.INVISIBLE);
        tv4.setVisibility(View.INVISIBLE);
        tv5.setVisibility(View.INVISIBLE);

        et1.setVisibility(View.INVISIBLE);
        et2.setVisibility(View.INVISIBLE);
        et3.setVisibility(View.INVISIBLE);
        et4.setVisibility(View.INVISIBLE);
        et5.setVisibility(View.INVISIBLE);

        SharedPreferences mPref = this.getSharedPreferences("sharedPref", MODE_PRIVATE);

        int size = mPref.getInt("size", 10);

        Log.d("size", String.valueOf(size));

        switch (size) {
            case 0:
                Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                tv1.setVisibility(View.VISIBLE);
                et1.setVisibility(View.VISIBLE);

                tv1.setText(mPref.getString("tv0", null));
                break;
            case 2:
                tv1.setVisibility(View.VISIBLE);
                et1.setVisibility(View.VISIBLE);

                tv2.setVisibility(View.VISIBLE);
                et2.setVisibility(View.VISIBLE);

                tv1.setText(mPref.getString("tv0", null));
                tv2.setText(mPref.getString("tv1", null));

                break;
            case 3:
                tv1.setVisibility(View.VISIBLE);
                et1.setVisibility(View.VISIBLE);

                tv2.setVisibility(View.VISIBLE);
                et2.setVisibility(View.VISIBLE);

                tv3.setVisibility(View.VISIBLE);
                et3.setVisibility(View.VISIBLE);

                tv1.setText(mPref.getString("tv0", null));
                tv2.setText(mPref.getString("tv1", null));
                tv3.setText(mPref.getString("tv2", null));

                break;
            case 4:
                tv1.setVisibility(View.VISIBLE);
                et1.setVisibility(View.VISIBLE);

                tv2.setVisibility(View.VISIBLE);
                et2.setVisibility(View.VISIBLE);

                tv3.setVisibility(View.VISIBLE);
                et3.setVisibility(View.VISIBLE);

                tv4.setVisibility(View.VISIBLE);
                et4.setVisibility(View.VISIBLE);

                tv1.setText(mPref.getString("tv0", null));
                tv2.setText(mPref.getString("tv1", null));
                tv3.setText(mPref.getString("tv2", null));
                tv4.setText(mPref.getString("tv3", null));

                break;
            case 5:
                tv1.setVisibility(View.VISIBLE);
                et1.setVisibility(View.VISIBLE);

                tv2.setVisibility(View.VISIBLE);
                et2.setVisibility(View.VISIBLE);

                tv3.setVisibility(View.VISIBLE);
                et3.setVisibility(View.VISIBLE);

                tv4.setVisibility(View.VISIBLE);
                et4.setVisibility(View.VISIBLE);

                tv5.setVisibility(View.VISIBLE);
                et5.setVisibility(View.VISIBLE);

                tv1.setText(mPref.getString("tv0", null));
                tv2.setText(mPref.getString("tv1", null));
                tv3.setText(mPref.getString("tv2", null));
                tv4.setText(mPref.getString("tv3", null));
                tv5.setText(mPref.getString("tv4", null));

                Toast.makeText(this, "Already scanned 5 QR Code", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
