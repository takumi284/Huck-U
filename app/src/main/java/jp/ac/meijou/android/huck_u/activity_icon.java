package jp.ac.meijou.android.huck_u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class activity_icon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon);

        ImageButton imageButton4 = findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_icon.this, activity_map2r.class);
            startActivity(intent);
            finish();
        });
    }
}