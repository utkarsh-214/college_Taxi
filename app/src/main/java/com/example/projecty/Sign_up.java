package com.example.projecty;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Sign_up extends AppCompatActivity {

TextView login;
EditText email;
EditText password;
EditText username;
Button signup;
ImageView google;
ImageView facebook;
FirebaseAuth mAuth;
GoogleSignInClient gsc;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        login = findViewById(R.id.login);

        email = findViewById(R.id.email);
        username = findViewById(R.id.editText);
        password = findViewById(R.id.Password);

        signup = findViewById(R.id.appCompatButton);
        google = findViewById(R.id.google);
        facebook = findViewById(R.id.facebook);

        mAuth = FirebaseAuth.getInstance();

    }

}
