package jp.ac.meijou.android.huck_u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;

public class SettingProfActivity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_prof);

        ImageButton selectImageButton = findViewById(R.id.selectImageButton);
        ImageView selectedImageView = findViewById(R.id.selectedImageView);
        selectedImageView.setImageResource(R.drawable.icon_sample);
        ImageButton backButton = findViewById(R.id.backButton);
        EditText editTextText = findViewById(R.id.editTextText);

        selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });

        //読み取り
        SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        int confirmed = preferences.getInt("confirmed", 0);
        String name = preferences.getString("userName", "");

        backButton.setOnClickListener(view -> {
            Intent intent;
            if (confirmed == 1){
                intent = new Intent(SettingProfActivity.this, activity_map2r.class);
            } else if (confirmed == 2) {
                intent = new Intent(SettingProfActivity.this, activity_map2l.class);
            } else{
                intent = new Intent(SettingProfActivity.this, MapActivity.class);
            }
            startActivity(intent);
            finish();
        });

        editTextText.setText(name);
    }
    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            try {
                ImageView selectedImageView = findViewById(R.id.selectedImageView);
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                selectedImageView.setImageBitmap(bitmap);
                // 選択された画像に対する追加の処理をここに追加
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}