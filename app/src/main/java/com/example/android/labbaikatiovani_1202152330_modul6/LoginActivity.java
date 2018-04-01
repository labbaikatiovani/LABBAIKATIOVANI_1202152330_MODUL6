package com.example.android.labbaikatiovani_1202152330_modul6;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "EmaiPassword";
    //deklarasi variable
    Button btn_daftar, btn_masuk;
    EditText emailuser, password;
    String emails, pw;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //binding data yang dibutuhkan
        btn_daftar = findViewById(R.id.daftar);
        btn_masuk = findViewById(R.id.masuk);
        emailuser = findViewById(R.id.email);
        password = findViewById(R.id.password);

        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]

    }

    public void masuk(View view) {

        emails = emailuser.getText().toString();
        pw = password.getText().toString();

        //validasi kosong
        if(emailuser.getText().toString().isEmpty() || pw.isEmpty() ) {
            emailuser.setError("Required");
            password.setError("Required");
            return;
        }

        loginAccount(emails, pw);
        Toast.makeText(LoginActivity.this, emails,
                Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void daftar(View view) {
        emails = emailuser.getText().toString();
        pw = password.getText().toString();

        //validasi kosong
        if(emailuser.getText().toString().isEmpty() || pw.isEmpty() ) {
            emailuser.setError("Required");
            password.setError("Required");
            return;
        }

        createAccount(emails, pw);
        Toast.makeText(LoginActivity.this, emails,
                Toast.LENGTH_SHORT).show();


    }

    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);

        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
        // [END create_user_with_email]
    }

    private void loginAccount(String email, String password) {
        Log.d(TAG, "signInAccount:" + email);

        // [START login_user_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
        // [END login_user_with_email]

    }


}
