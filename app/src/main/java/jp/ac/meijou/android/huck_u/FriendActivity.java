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

//        String qrCodeValue = getIntent().getStringExtra("QRCodeValue");
//
//        binding.nameView.setText(qrCodeValue.substring(3));

        binding.nameView.setText("たくみ");
        binding.friendImageView.setImageResource(R.drawable.icon_sky);

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
    }
}