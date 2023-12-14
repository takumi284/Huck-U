package jp.ac.meijou.android.huck_u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import jp.ac.meijou.android.huck_u.databinding.ActivityMapBinding;

public class MapActivity extends AppCompatActivity {

    ActivityMapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageButtonP.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(MapActivity.this, SettingProfActivity.class);
            startActivity(intent);
            finish();
        });

        binding.imageButtonQR.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(MapActivity.this, CameraActivity.class);
            startActivity(intent);
            finish();
        });
    }
}