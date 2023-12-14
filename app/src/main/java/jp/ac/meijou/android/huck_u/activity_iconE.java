package jp.ac.meijou.android.huck_u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class activity_iconE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_e);

        ImageButton imageButton3 = findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_iconE.this, activity_map2r.class);
            startActivity(intent);
            finish();
        });
    }
}