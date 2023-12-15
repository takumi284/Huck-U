package jp.ac.meijou.android.huck_u;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import jp.ac.meijou.android.huck_u.databinding.ActivityGenerateQrcodeBinding;

public class GenerateQRCodeActivity extends AppCompatActivity {

    ActivityGenerateQrcodeBinding binding;
    private ImageView qrView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGenerateQrcodeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //読み取り
        SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        int confirmed = preferences.getInt("confirmed", 0);
        String name = preferences.getString("userName", "");
        String id = getIntent().getStringExtra("userid");

        generateQRCode("FRI" + id + name);

        binding.backButton.setOnClickListener(view -> {
            Intent intent;
            if (confirmed == 1){
                intent = new Intent(GenerateQRCodeActivity.this, activity_map2r.class);
            } else if (confirmed == 2) {
                intent = new Intent(GenerateQRCodeActivity.this, activity_map2l.class);
            } else{
                intent = new Intent(GenerateQRCodeActivity.this, MapActivity.class);
            }
            startActivity(intent);
            finish();
        });
    }

    private void generateQRCode(String data) {
        QRCodeWriter writer = new QRCodeWriter();
        try {
            // UTF-8 エンコーディングを使用して文字列をバイト配列に変換
            String encodedData = URLEncoder.encode(data, StandardCharsets.UTF_8);
            BitMatrix bitMatrix = writer.encode(encodedData, BarcodeFormat.QR_CODE, 512, 512);

            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bmp.setPixel(x, y, bitMatrix.get(x, y) ? getResources().getColor(R.color.black) : getResources().getColor(R.color.white));
                }
            }

            // 生成したQRコードをImageViewに表示
            binding.qrView.setImageBitmap(bmp);

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
