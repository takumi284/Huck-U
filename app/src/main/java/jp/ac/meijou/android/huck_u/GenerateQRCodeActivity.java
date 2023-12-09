package jp.ac.meijou.android.huck_u;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import jp.ac.meijou.android.huck_u.databinding.ActivityGenerateQrcodeBinding;

public class GenerateQRCodeActivity extends AppCompatActivity {

    ActivityGenerateQrcodeBinding binding;
    private ImageView qrView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGenerateQrcodeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        generateQRCode("FRIタクミ");
    }

    private void generateQRCode(String data) {
        QRCodeWriter writer = new QRCodeWriter();
        try {
            // UTF-8 エンコーディングを使用して文字列をバイト配列に変換
            String encodedData = URLEncoder.encode(data, "UTF-8");
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

        } catch (WriterException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
