package com.aes.encrypter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.scottyab.aescrypt.AESCrypt;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText et_key, et_value, message;
    AppCompatButton encrypt, decrypt, developer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_key = findViewById(R.id.et_text_key);
        et_value = findViewById(R.id.et_value);
        message = findViewById(R.id.message);
        encrypt = findViewById(R.id.encrypt);
        decrypt = findViewById(R.id.decrypt);
        developer = findViewById(R.id.developer);

        encrypt.setOnClickListener(v -> {
            try {
                String encrpyted = AESCrypt.encrypt(Objects.requireNonNull(et_key.getText()).toString(), Objects.requireNonNull(et_value.getText()).toString());
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("label", encrpyted);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(MainActivity.this, "Your Encrypted Message is Copied to clipboard", Toast.LENGTH_LONG).show();
                et_key.setText("");
                et_value.setText("");
                message.setText(String.format("%s", encrpyted));
            } catch (Exception e) {
                et_key.setText("");
                et_value.setText("");
                Toast.makeText(MainActivity.this, "" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        decrypt.setOnClickListener(v -> {
            try {
                String encrpyted = AESCrypt.decrypt(Objects.requireNonNull(et_key.getText()).toString(), Objects.requireNonNull(et_value.getText()).toString());
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("label", encrpyted);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(MainActivity.this, "Your Decrypted Message is Copied to clipboard", Toast.LENGTH_LONG).show();
                et_key.setText("");
                et_value.setText("");
                message.setText(String.format("%s", encrpyted));
            } catch (Exception e) {
                et_key.setText("");
                et_value.setText("");
                Toast.makeText(MainActivity.this, "" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        developer.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DeveloperActivity.class);
            startActivity(intent);
        });
    }
}