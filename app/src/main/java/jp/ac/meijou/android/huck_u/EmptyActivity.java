package jp.ac.meijou.android.huck_u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import jp.ac.meijou.android.huck_u.databinding.ActivityConfirmBinding;
import jp.ac.meijou.android.huck_u.databinding.ActivityEmptyBinding;

public class EmptyActivity extends AppCompatActivity {
    ActivityEmptyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmptyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backButton.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(EmptyActivity.this, activity_map2r.class);
            startActivity(intent);
            finish();
        });
    }
}