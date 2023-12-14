//trueとfalseを見るためのクラス
package jp.ac.meijou.android.huck_u;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import android.util.Log;
import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import jp.ac.meijou.android.huck_u.databinding.ActivityViewBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.app.Application;
import com.google.firebase.FirebaseApp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class FirebaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        // FirebaseAppを初期化する
        if (FirebaseApp.getApps(this).isEmpty()) {
            FirebaseApp.initializeApp(this);
        }


        //test
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
                        String value = dataSnapshot.getValue().toString();
                        Intent intent;
                        intent = new Intent(FirebaseActivity.this, ViewActivity.class);
                        intent.putExtra("Value", value);
                        startActivity(intent);
                        finish();

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
}