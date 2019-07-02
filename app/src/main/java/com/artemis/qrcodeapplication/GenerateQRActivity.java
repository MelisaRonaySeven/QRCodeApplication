package com.artemis.qrcodeapplication;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GenerateQRActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr);

        ImageView qrImage = findViewById(R.id.generated_qrView);
        Bitmap bitmap;

        BarcodeEncoder barcodeEncoder;

        try {
            barcodeEncoder = new BarcodeEncoder();
            bitmap = barcodeEncoder.encodeBitmap("melisa", BarcodeFormat.QR_CODE, 300, 300);
            bitmap = Bitmap.createBitmap(bitmap, 25, 25, 250, 250);
            qrImage.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
