package jp.ac.meijou.android.huck_u;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import jp.ac.meijou.android.huck_u.databinding.ActivityConfirmBinding;
import jp.ac.meijou.android.huck_u.databinding.ActivityViewBinding;

public class ConfirmActivity extends AppCompatActivity {

    private ActivityConfirmBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfirmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // IntentからQRコードの情報を取得
        String qrCodeValue = getIntent().getStringExtra("QRCodeValue");

        // qrCodeValue を使用して必要な処理を行う
        if (qrCodeValue != null) {
            // qrCodeValue を使用して何か処理を行う
            binding.editSchoolNumber.setText(qrCodeValue);
        } else {
            Log.e("AnotherActivity", "QR Code Value is null");
        }
    }
}