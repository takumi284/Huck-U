package jp.ac.meijou.android.huck_u;

//遷移元の学籍番号useridを受け取り，
//その学籍番号と一致する名前がデーベース上に存在しなかったらname = notfound
//一致するなら名前が格納される

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.firebase.firestore.FirebaseFirestore;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;
import android.content.Intent;

public class FirebaseReadActivity extends AppCompatActivity {
    String userinfo;
    //遷移元から読み込んだ学籍番号
    //String AcquireId = "221205102";

    public String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_read);

        //遷移元の学籍番号（ラベル名：userid）
        String AcquireId = getIntent().getStringExtra("userid");
        // Firestore インスタンスを取得
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("student")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                userinfo = document.getData().toString();
                                // 余分な `}` を取り除く
                                userinfo = userinfo.replace("}", "");
                                // 正規表現パターン
                                Pattern pattern = Pattern.compile("(name|schoolid)=([^,]+)");

                                // マッチャーを作成し、パターンと入力文字列を関連付ける
                                Matcher matcher = pattern.matcher(userinfo);

                                // マッチが見つかればそれをMapに格納
                                Map<String, String> values = new HashMap<>();
                                while (matcher.find()) {
                                    values.put(matcher.group(1), matcher.group(2));
                                }

                                // 変数に格納
                                name = values.get("name");
                                String schoolId = values.get("schoolid");

                                // マッチが一致し，見つかればその値を取得
                                if(schoolId.equals(AcquireId)){
                                    Log.d("firestore",name);
                                    //保存
                                    SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = preferences.edit();
                                    editor.putString("userName", name);
                                    editor.putString("userId", schoolId);
                                    editor.apply();

                                    //移動
                                    Intent intent;
                                    intent = new Intent(FirebaseReadActivity.this,activity_map2r.class);
                                    startActivity(intent);
                                    finish();
                                    break;
                                } else{
                                    name = "notfound";
                                }
                            }
                            //読み取り
                            SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
                            String id = preferences.getString("userId", "miss");
                            if (!id.equals(AcquireId)){
                                //移動
                                Intent intent;
                                intent = new Intent(FirebaseReadActivity.this,ConfirmActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        } else {
                            Log.w("FirestoreReading", "Error getting documents.", task.getException());
                        }
                    }
                });

//        Intent intent;
//        intent = new Intent(FirebaseReadActivity.this, ConfirmActivity.class);
//        startActivity(intent);
//        finish();
    }
}