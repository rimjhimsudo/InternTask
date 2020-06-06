package com.enjoy.interntask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class SecondActivity extends AppCompatActivity {
    TextView showday;
    FirebaseFirestore firebaseFirestore;
    CollectionReference internround1;
    ImageView imageView ;
    String url;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        showday=findViewById(R.id.showday);
        imageView =findViewById(R.id.imageshow);
        Intent intent=getIntent();
        final String  dayname=intent.getStringExtra("Dayname");
        showday.setText(dayname);
        Toast.makeText(this,"dayname"+dayname,Toast.LENGTH_LONG).show();
        firebaseFirestore = FirebaseFirestore.getInstance();
        DocumentReference docRef = firebaseFirestore.collection("WeeklyPhotos").document("Days");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("TAG", "DocumentSnapshot data: " + document.getData());
                         url=document.getData().get(dayname).toString();
                        Glide
                                .with(SecondActivity.this)
                                .load(url)
                                .into(imageView);

                        Log.d("URL",""+url);
                    } else {
                        Log.d("TAG", "No such document");
                    }
                } else {
                    Log.d("TAG", "get failed with ", task.getException());
                }
            }
        });
        //Glide.with(this).load(url).into(imageView);
      /*  Glide
                .with(this)
                .load(url)
                .centerCrop()
                .into(imageView);*/






    }
}
