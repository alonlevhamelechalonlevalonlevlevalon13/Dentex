package com.example.designs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.designs.FireBase.FBAuthHelper;
import com.example.designs.patient.Main_Page;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity implements FBAuthHelper.FBReply {
    private FirebaseAuth mAuth;
    private static final String TAG = "alon";
    private String email = "alonlevalon@gmail.com";
    private String pass = "alon0312";
    private EditText EtE;
    private EditText EtP;
    private Button BtnL;
    private Button BtnS;
    private FBAuthHelper fbAuthHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fbAuthHelper = new FBAuthHelper(this, this);
        if (fbAuthHelper.getCurrentUser() != null)
            startActivity(new Intent(this, Main_Page.class));
        EtE = findViewById(R.id.ETE);
        EtP = findViewById(R.id.ETP);
        BtnS = findViewById(R.id.BtnS);
        BtnL = findViewById(R.id.BtnL);
        BtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = EtE.getText().toString();
                pass = EtP.getText().toString();
                fbAuthHelper.createUser(email, pass);
                startActivity(new Intent(Login.this,Main_Page.class));

            }
        });
        BtnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email =  EtE.getText().toString();
                pass = EtP.getText().toString();
                if (email.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Login.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this,Main_Page.class));
                }
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();

        }

    @Override
    public void createUserSuccess(FirebaseUser user) {

        startActivity(new Intent(this, Main_Page.class));
    }

    @Override
    public void loginSuccess(FirebaseUser user) {
        startActivity(new Intent(this, Main_Page.class));
    }
    public void createUserFail(){
        Toast.makeText(Login.this,"יצירת המשתמש נכשלה", Toast.LENGTH_LONG).show();
    }
}