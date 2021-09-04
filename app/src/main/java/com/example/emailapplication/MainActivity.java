package com.example.emailapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText to, sub, msg;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        to = findViewById(R.id.to);
        sub = findViewById(R.id.sub);
        msg = findViewById(R.id.msg);
        button = findViewById(R.id.btnSend);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }

            private void sendEmail() {
                String TO = to.getText().toString().trim();
                String SUB = sub.getText().toString().trim();
                String MSG = msg.getText().toString().trim();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{TO});
                intent.putExtra(Intent.EXTRA_SUBJECT, SUB);
                intent.putExtra(Intent.EXTRA_TEXT, MSG);
                intent.setType("text/plain");
                try {
                    startActivity(Intent.createChooser(intent, "Choose Mail"));
                } catch (Exception e) {
                    
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}
