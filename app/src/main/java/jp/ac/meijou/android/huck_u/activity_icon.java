package jp.ac.meijou.android.huck_u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_icon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon);

        ImageButton imageButton4 = findViewById(R.id.imageButton4);
        ImageView imageView18 = findViewById(R.id.imageView18);
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageView imageView3 = findViewById(R.id.imageView3);
        TextView textView8 = findViewById(R.id.textView8);
        TextView textView = findViewById(R.id.textView);
        TextView textView3 = findViewById(R.id.textView3);

        imageButton4.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(activity_icon.this, activity_map2r.class);
            startActivity(intent);
            finish();
        });

        //読み取り
        SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        String kosuke = preferences.getString("FRI221205102", "");
        String takumi = preferences.getString("FRI221205139", "");
        String yt = preferences.getString("FRI221205999", "");

        if (kosuke.equals("こうすけ")){
            imageView18.setImageResource(R.drawable.icon_kosuke);
            textView8.setText("こうすけ");
        }
        if (takumi.equals("たくみ")){
            imageView2.setImageResource(R.drawable.icon_man);
            textView.setText("たくみ");
        }
        if (yt.equals("やふ太郎")){
            imageView3.setImageResource(R.drawable.icon_y);
            textView3.setText("やふ太郎");
        }
    }
}