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
    private EditText EtP2;
    private Button BtnL;
    private Button BtnS;
    private FBAuthHelper fbAuthHelper;///

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fbAuthHelper = new FBAuthHelper(this, this);
        if (fbAuthHelper.isLoggedIn()){
            startActivity(new Intent(this, Main_Page.class));
        }
        EtE = findViewById(R.id.ETE);
        EtP = findViewById(R.id.ETP);
        EtP2 = findViewById(R.id.ETP2);
        BtnS = findViewById(R.id.BtnS);
        BtnL = findViewById(R.id.BtnL);
        BtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( checkEmailValidity(EtE.getText().toString()) &&
                        checkPasswordValidity(EtP.getText().toString(), EtP2.getText().toString())){
                         email = EtE.getText().toString();
                         pass = EtP.getText().toString();
                         fbAuthHelper.createUser(email, pass);
                }
            }
        });
        BtnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkEmailValidity(EtE.getText().toString()) &&
                        checkPasswordValidity(EtP.getText().toString() , EtP.getText().toString())) {

                    fbAuthHelper.login(
                            EtE.getText().toString(),
                            EtP.getText().toString());
                }
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();

        }
private boolean checkPasswordValidity(String password, String confirm) {
    if (password.length() >= 6 && password.equals(confirm)) {
        // Password is valid
        return true;
    } else {
        // Password is invalid, show an error message
        EtP.setError("Password must be 6 characters or longer");
        return false;
    }
}
    private boolean checkEmailValidity(String email) {
        if (EtE != null && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            // Email is valid
            return true;
        } else {
            // Email is invalid, show an error message
            EtE.setError("Invalid email address");
            return false;
        }
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