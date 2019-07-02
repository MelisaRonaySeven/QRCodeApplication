package com.artemis.qrcodeapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.BeepManager;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.DefaultDecoderFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class ScanQRActivity extends Activity {

    private static int count = 0;
    ArrayList<String> resultSet = new ArrayList<>();

    private static final String TAG = ScanQRActivity.class.getSimpleName();
    private DecoratedBarcodeView barcodeView;
    private BeepManager beepManager;
    private String lastText;

    private BarcodeCallback callback = new BarcodeCallback() {
        @Override
        public void barcodeResult(BarcodeResult result) {
            if(result.getText() == null || result.getText().equals(lastText)) {
                return;
            }

            lastText = result.getText();
            if(count < 4) {
                resultSet.add(lastText);
                Log.d("result set", "" + resultSet);
                Log.d("count", "" + count);
                Log.d("size11", String.valueOf(resultSet.size()));

                count++;

            } else if(count == 4) {
                Log.d("count111", "" + count);
                resultSet.add(lastText);
                SharedPreferences.Editor editor = getSharedPreferences("sharedPref", MODE_PRIVATE).edit();

                editor.putInt("size", resultSet.size());
                for(int i = 0; i < resultSet.size(); i++) {
                    editor.putString("tv" + i, resultSet.get(i));
                    editor.apply();
                }
                startActivity(new Intent(ScanQRActivity.this, ResultActivity.class));
            }

            barcodeView.setStatusText(result.getText());

            beepManager.playBeepSoundAndVibrate();

            ImageView imageView = findViewById(R.id.barcodePreview);
            imageView.setImageBitmap(result.getBitmapWithResultPoints(Color.YELLOW));
        }

        @Override
        public void possibleResultPoints(List<ResultPoint> resultPoints) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr);

        barcodeView = findViewById(R.id.barcode_scanner);
        Collection<BarcodeFormat> formats = Arrays.asList(BarcodeFormat.QR_CODE, BarcodeFormat.CODE_39);
        barcodeView.getBarcodeView().setDecoderFactory(new DefaultDecoderFactory(formats));
        barcodeView.initializeFromIntent(getIntent());
        barcodeView.decodeContinuous(callback);

        beepManager = new BeepManager(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        barcodeView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        barcodeView.pause();
    }

    public void pause(View view) {
        barcodeView.pause();
        SharedPreferences.Editor editor = getSharedPreferences("sharedPref", MODE_PRIVATE).edit();
        editor.putInt("size", resultSet.size());
        Log.d("size1", String.valueOf(resultSet.size()));
        for(int i = 0; i < resultSet.size(); i++) {
            editor.putString("tv" + i, resultSet.get(i));
            editor.apply();
        }
        startActivity(new Intent(ScanQRActivity.this, ResultActivity.class));
    }

    public void triggerScan(View view) {
        barcodeView.decodeSingle(callback);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return barcodeView.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }
}
