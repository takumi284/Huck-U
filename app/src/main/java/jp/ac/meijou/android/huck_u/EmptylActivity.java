package jp.ac.meijou.android.huck_u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import jp.ac.meijou.android.huck_u.databinding.ActivityEmptylBinding;

public class EmptylActivity extends AppCompatActivity {

    ActivityEmptylBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmptylBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backButton.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(EmptylActivity.this, activity_map2l.class);
            startActivity(intent);
            finish();
        });
    }
}