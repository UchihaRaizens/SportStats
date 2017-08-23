package com.example.lukasresutik.sportstats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lukasresutik.sportstats.activities.SportActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etUsername;
    private EditText etPassword;
    private Button bLogin;
    private TextView registerLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        etUsername = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.btLogin);
        registerLink = (TextView) findViewById(R.id.tvRegisterHere);

        etUsername.setOnClickListener(this);
        etPassword.setOnClickListener(this);
        bLogin.setOnClickListener(this);
        registerLink.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Log.d("Registracia", "stlacenie registraci");
        switch(v.getId()) {
            case R.id.tvRegisterHere:
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
                break;
            case R.id.btLogin:
                Intent loginIntent = new Intent(LoginActivity.this,SportActivity.class);
                LoginActivity.this.startActivity(loginIntent);
                break;
            default:
                break;
        }
    }
}
