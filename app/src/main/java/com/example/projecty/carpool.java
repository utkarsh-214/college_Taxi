package com.example.projecty;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.google.firebase.auth.FirebaseAuth;


public class carpool extends AppCompatActivity {
    ImageView home, message, person, setting;
    RecyclerView recyclerView;
    FirebaseAuth mAuth;
    ProgressBar hint;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpool);
        home = findViewById(R.id.home);
        message = findViewById(R.id.message);
        person = findViewById(R.id.person);
        setting = findViewById(R.id.setting);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Dashboard.class));
                finish();
            }
        });
    }

}
