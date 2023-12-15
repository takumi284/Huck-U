package jp.ac.meijou.android.huck_u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import jp.ac.meijou.android.huck_u.databinding.ActivityMap2lBinding;

public class activity_map2l extends AppCompatActivity {
    ActivityMap2lBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMap2lBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //保存
        SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("confirmed", 2);
        editor.apply();

        binding.imageButtonP3.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2l.this, SettingProfActivity.class);
            startActivity(intent);
            finish();
        });

        binding.imageButtonQR3.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2l.this, CameraActivity.class);
            startActivity(intent);
            finish();
        });

        binding.imageButtonLeft.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2l.this, activity_map2r.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
        });

        binding.imageButtonN3.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2l.this, FirebaseActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
        });

        binding.imageButtonT3.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2l.this, FirebaseActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
        });

        binding.imageButtonE3.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2l.this, FirebaseActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
        });

        binding.imageButtonS3.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2l.this, FirebaseActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
        });

        binding.imageButtonG3.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2l.this, FirebaseActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
        });
    }
}