package jp.ac.meijou.android.huck_u;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;

import java.util.Map;

public class OperateFirebase extends AppCompatActivity {

    //引数：なし（本来は教室と椅子）　戻り値：bool
    public static Boolean value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Firebaseデータベースの参照を取得
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("E/101/A/1");
        // データベースからデータを取得
        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    // データの取得に成功
                    DataSnapshot dataSnapshot = task.getResult();
                    if (dataSnapshot.exists()) {
                        // データが存在する場合
                        // データを取得して処理する
                        value = (Boolean) dataSnapshot.getValue();
                        Log.d("FirebaseData", "Data: " + value);
                    } else {
                        // データが存在しない場合
                        Log.d("FirebaseData", "Data does not exist");
                    }
                } else {
                    // データの取得に失敗
                    Exception exception = task.getException();
                    Log.e("FirebaseData", "Error getting data", exception);
                }
            }
        });
    }

    //引数：入力された学籍番号と名前/メソッドの定義
    protected void onCreateMember(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Firestore インスタンスを取得
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // データを格納する Map を作成
        Map<String, Object> data = new HashMap<>();
        data.put("name", "John Doe");
        data.put("id", 30);

        // Firestoreにデータを書き込む
        db.collection("users")
                .add(data)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            Log.d("Firestoretest", "DocumentSnapshot added with ID: " + task.getResult().getId());
                        } else {
                            Log.e("Firestoretestno", "Error adding document", task.getException());
                        }
                    }
                });
    }
}
