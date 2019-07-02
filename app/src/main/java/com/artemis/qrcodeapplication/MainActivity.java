package com.artemis.qrcodeapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.Manifest.permission.CAMERA;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int REQUEST_CAMERA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button qrScanButton = findViewById(R.id.qrScanButton);
        Button qrGenerateButton = findViewById(R.id.qrGenerateButton);

        qrScanButton.setOnClickListener(this);
        qrGenerateButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.qrScanButton:
                if(checkPermission()){
                    startActivity(new Intent(MainActivity.this, ScanQRActivity.class));
                } else {
                    requestPermission();
                }
                break;
            case R.id.qrGenerateButton:
                startActivity(new Intent(MainActivity.this, GenerateQRActivity.class));
                break;
        }
    }

    private boolean checkPermission()
    {
        return (ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA) == PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermission()
    {
        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, REQUEST_CAMERA);
    }
}
