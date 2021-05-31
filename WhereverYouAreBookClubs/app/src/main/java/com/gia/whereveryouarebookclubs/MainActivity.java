package com.gia.whereveryouarebookclubs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button createAccount;
    private Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAccount = findViewById(R.id.createAccount_button);
        signIn = findViewById(R.id.signIn_button);

        setSignIn(signIn);
        setCreateAccount(createAccount);
    }

    public void setSignIn(Button signIn) {
        this.signIn = signIn;

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = new Intent(MainActivity.this, SignIn.class);
                startActivity(signInIntent);
            }
        });
    }

    public void setCreateAccount(Button createAccount) {
        this.createAccount = createAccount;

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newAccountIntent = new Intent(MainActivity.this, CreateAccount.class);
                startActivity(newAccountIntent);
            }
        });
    }
}