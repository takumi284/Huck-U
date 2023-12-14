package jp.ac.meijou.android.huck_u;
//
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class FirebaseWriteActivity extends AppCompatActivity {

    String schoolId = getIntent().getStringExtra("schoolid");
    String username = getIntent().getStringExtra("name");

    //ハッシュ値Myidユニークな値
    public String Myid;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        //test
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_write);

        // Firestore インスタンスを取得
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // データを格納する Map を作成
        Map<String, Object> data = new HashMap<>();


        data.put("name", username);
        data.put("schoolid", schoolId);

        // Firestoreにデータを書き込む
        db.collection("student")
                .add(data)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            Myid = task.getResult().getId();
                            Log.d("Firestore", "DocumentSnapshot added with ID: " + Myid);
                        } else {
                            Log.e("Firestore", "Error adding document", task.getException());
                        }
                    }
                });
        //testend


//        super.onCreate(savedInstanceState);
//        binding = ActivityViewBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
    }

}
//ireru-end