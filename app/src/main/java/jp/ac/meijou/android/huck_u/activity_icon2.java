package jp.ac.meijou.android.huck_u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class activity_icon2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon2);

        ImageButton imageButton2 = findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_icon2.this, activity_map2r.class);
            startActivity(intent);
            finish();
        });
    }
}