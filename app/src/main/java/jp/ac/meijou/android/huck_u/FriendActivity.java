package jp.ac.meijou.android.huck_u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import jp.ac.meijou.android.huck_u.databinding.ActivityFriendBinding;

public class FriendActivity extends AppCompatActivity {

    ActivityFriendBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFriendBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String qrCodeValue = getIntent().getStringExtra("QRCodeValue");
        String id = qrCodeValue.substring(3, 12);
        String name = qrCodeValue.substring(12);

        binding.nameView.setText(name);

        if (id.equals("221205102")){
            binding.friendImageView.setImageResource(R.drawable.icon_kosuke);
        } else if (id.equals("221205139")) {
            binding.friendImageView.setImageResource(R.drawable.icon_man);
        } else if (id.equals("221205999")) {
            binding.friendImageView.setImageResource(R.drawable.icon_y);
        }
        else{
            binding.nameView.setText("");
            binding.friendImageView.setImageResource(R.drawable.icon_sample2);
        }

        //読み取り
        SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        int confirmed = preferences.getInt("confirmed", 0);

        binding.backButton.setOnClickListener(view -> {
            Intent intent;
            if (confirmed == 1){
                intent = new Intent(FriendActivity.this, activity_map2r.class);
            } else if (confirmed == 2) {
                intent = new Intent(FriendActivity.this, activity_map2l.class);
            } else{
                intent = new Intent(FriendActivity.this, MapActivity.class);
            }
            startActivity(intent);
            finish();
        });

        binding.imageButton.setOnClickListener(view -> {
            //保存
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("FRI" + id, name);
            editor.apply();

            Intent intent;
            if (confirmed == 1){
                intent = new Intent(FriendActivity.this, activity_map2r.class);
            } else if (confirmed == 2) {
                intent = new Intent(FriendActivity.this, activity_map2l.class);
            } else{
                intent = new Intent(FriendActivity.this, MapActivity.class);
            }
            startActivity(intent);
            finish();
        });
    }
}