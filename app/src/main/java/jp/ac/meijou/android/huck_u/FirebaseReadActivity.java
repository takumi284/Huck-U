package jp.ac.meijou.android.huck_u;
//ハッシュ値とそのハッシュ値の中に入っている学籍番号と名前が見れる

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.firestore.FirebaseFirestore;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;



public class FirebaseReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_read);
        // Firestore インスタンスを取得
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("student")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("FirestoreReading", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("FirestoreReading", "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}