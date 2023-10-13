package com.example.lab2;
    import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

    import androidx.appcompat.app.AppCompatActivity;

    import com.google.gson.Gson;

public class SecondActivity extends AppCompatActivity {
    private TextView dataTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scond_activity);

        dataTextView = findViewById(R.id.dataTextView);
        backButton = findViewById(R.id.backButton);

        // Получение JSON-строки из Intent
        Intent intent = getIntent();
        String userJson = intent.getStringExtra("userJson");

        // Используем библиотеку Gson для десериализации JSON-строки в объект User
        Gson gson = new Gson();
        User user = gson.fromJson(userJson, User.class);

        // Отображение информации о пользователе
        String userData = "Имя: " + user.firstName + "\n" +
                "Фамилия: " + user.lastName + "\n" +
                "Возраст: " + user.age + "\n" +
                "Зарплата: " + user.salary;

        dataTextView.setText(userData);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Закрыть вторую активность и вернуться к первой
            }
        });
    }
}
