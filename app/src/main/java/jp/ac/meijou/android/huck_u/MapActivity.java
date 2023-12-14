package jp.ac.meijou.android.huck_u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import jp.ac.meijou.android.huck_u.databinding.ActivityMapBinding;

public class MapActivity extends AppCompatActivity {

    ActivityMapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //保存
        SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("confirmed", 0);
        editor.apply();

        binding.imageButtonN.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(MapActivity.this, FirebaseActivity.class);
            startActivity(intent);
            finish();
        });

        binding.imageButtonT.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(MapActivity.this, FirebaseActivity.class);
            startActivity(intent);
            finish();
        });


        binding.imageButtonS.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(MapActivity.this, FirebaseActivity.class);
            startActivity(intent);
            finish();
        });

        binding.imageButtonG.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(MapActivity.this, FirebaseActivity.class);
            startActivity(intent);
            finish();
        });

        binding.imageButtonE.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(MapActivity.this, FirebaseActivity.class);
            startActivity(intent);
            finish();
        });

        binding.imageButtonP.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(MapActivity.this, SettingProfActivity.class);
            startActivity(intent);
//            overridePendingTransition(0, 0);
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