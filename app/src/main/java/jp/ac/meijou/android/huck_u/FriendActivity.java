package jp.ac.meijou.android.huck_u;

import androidx.appcompat.app.AppCompatActivity;

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
    }
}