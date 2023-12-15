package jp.ac.meijou.android.huck_u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import jp.ac.meijou.android.huck_u.databinding.ActivityMap2rBinding;

public class activity_map2r extends AppCompatActivity {

    ActivityMap2rBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMap2rBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //保存
        SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("confirmed", 1);
        editor.apply();

        //読み取り
        String kosuke = preferences.getString("FRI221205102", "");
        String takumi = preferences.getString("FRI221205139", "");
        String yt = preferences.getString("FRI221205999", "");

        if (kosuke.equals("こうすけ")){
            binding.imageViewNuclear.setImageResource(R.drawable.icon_kosuke);
        }
        if (takumi.equals("たくみ")){
            binding.imageViewSky.setImageResource(R.drawable.icon_man);
        }
        if (yt.equals("やふ太郎")){
            binding.imageViewGear.setImageResource(R.drawable.icon_y);
        }

        binding.imageButtonP2.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2r.this, SettingProfActivity.class);
            startActivity(intent);
            finish();
        });

        binding.imageButtonQR2.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2r.this, CameraActivity.class);
            startActivity(intent);
            finish();
        });

        binding.imageButtonRight.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2r.this, activity_map2l.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
        });

        binding.imageButtonN2.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2r.this, activity_iconE.class);
            startActivity(intent);
            finish();
        });

        binding.imageButtonT2.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2r.this, activity_icon2.class);
            startActivity(intent);
            finish();
        });

        binding.imageButtonE2.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2r.this, activity_icon.class);
            startActivity(intent);
            finish();
        });

        binding.imageButtonS2.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2r.this, EmptyActivity.class);
            startActivity(intent);
            finish();
        });

        binding.imageButtonG2.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_map2r.this, EmptyActivity.class);
            startActivity(intent);
            finish();
        });

        binding.resetButton.setOnClickListener(view -> {
            //reset
            editor.putString("FRI221205102", "");
            editor.putString("FRI221205139", "");
            editor.putString("FRI221205999", "");

            editor.apply();

            Intent intent;
            intent = new Intent(activity_map2r.this, activity_map2r.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
        });
    }
}