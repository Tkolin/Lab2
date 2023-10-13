package com.example.lab2;

import com.google.gson.Gson;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, ageEditText, salaryEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Получение данных с формы
        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        salaryEditText = findViewById(R.id.salaryEditText);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                int age = Integer.parseInt(ageEditText.getText().toString());
                float salary = Float.parseFloat(salaryEditText.getText().toString());
                // Создание объекта User
                User user = new User(firstName, lastName, age, salary);

                // Используем библиотеку Gson для сериализации в JSON-строку
                Gson gson = new Gson();
                String userJson = gson.toJson(user);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("userJson", userJson);
                startActivity(intent);
            }
        });
    }
}
