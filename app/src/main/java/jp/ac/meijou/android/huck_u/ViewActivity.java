package jp.ac.meijou.android.huck_u;

import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import jp.ac.meijou.android.huck_u.databinding.ActivityViewBinding;

public class ViewActivity extends AppCompatActivity {

    private ActivityViewBinding binding;

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
        for (int i = 0; i < 30; i++) {
            data.add("1限");
        }

        // アダプターをセット
        MyAdapter adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}