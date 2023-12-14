package jp.ac.meijou.android.huck_u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import jp.ac.meijou.android.huck_u.databinding.ActivityMap2lBinding;

public class activity_map2l extends AppCompatActivity {
    ActivityMap2lBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMap2lBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
            finish();
        });

//        binding.imageButtonN3.setOnClickListener(view -> {
//            Intent intent;
//            intent = new Intent(activity_map2l.this, activity_iconE.class);
//            startActivity(intent);
//            finish();
//        });
//
//        binding.imageButtonT3.setOnClickListener(view -> {
//            Intent intent;
//            intent = new Intent(activity_map2l.this, activity_icon2.class);
//            startActivity(intent);
//            finish();
//        });
//
//        binding.imageButtonE3.setOnClickListener(view -> {
//            Intent intent;
//            intent = new Intent(activity_map2l.this, activity_icon.class);
//            startActivity(intent);
//            finish();
//        });

        binding.imageButtonS3.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2l.this, EmptylActivity.class);
            startActivity(intent);
            finish();
        });

        binding.imageButtonG3.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2l.this, EmptylActivity.class);
            startActivity(intent);
            finish();
        });
    }
}