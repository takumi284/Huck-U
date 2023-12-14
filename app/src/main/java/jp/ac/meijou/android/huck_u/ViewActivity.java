package jp.ac.meijou.android.huck_u;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;

import jp.ac.meijou.android.huck_u.databinding.ActivityViewBinding;

public class ViewActivity extends AppCompatActivity {

    private ActivityViewBinding binding;
    long seed = 123; // 任意のシード値を指定
    Random random = new Random(seed);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 区切り線を追加
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        // ダミーデータを生成
        List<String> data = new ArrayList<>();
        String value = getIntent().getStringExtra("Value");
        if (value.equals("true")){
            data.add("55");
        }
        else {
            data.add("0");
        }
        for (int i = 0; i < 28; i++) {
//            String randomString = Integer.toString(random.nextInt(60));
            data.add("0");
        }

        // アダプターをセット
        MyAdapter adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);

        binding.roadButton.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(ViewActivity.this, FirebaseActivity.class);
            startActivity(intent);
            finish();
        });

        //読み取り
        SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        int confirmed = preferences.getInt("confirmed", 0);

        binding.backButton.setOnClickListener(view -> {
            Intent intent;
            if (confirmed == 1){
                intent = new Intent(ViewActivity.this, activity_map2r.class);
            } else if (confirmed == 2) {
                intent = new Intent(ViewActivity.this, activity_map2l.class);
            } else{
                intent = new Intent(ViewActivity.this, MapActivity.class);
            }
            startActivity(intent);
            finish();
        });
    }
}