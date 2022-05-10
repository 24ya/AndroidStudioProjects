package com.example.sharedexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.SharedPreferencesCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save;
    String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText) findViewById(R.id.et_save);

        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        String value = sharedPreferences.getString("사야","");
        et_save.setText(value);

    }


    @Override
    protected void onDestroy() { //액티비티(앱 종료 후) 호출
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = et_save.getText().toString();
        editor.putString("사야",value);
        editor.commit();
    }
}