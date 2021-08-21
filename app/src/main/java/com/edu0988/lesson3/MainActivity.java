package com.edu0988.lesson3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    UserAdapter userAdapter;
    ArrayList<String> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 100; i++) {
            userList.add("Пользователь " + i);
        }

        recyclerView = findViewById(R.id.recyclerView);
        // Установка менеджера компоновки для RecycleView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Создание адаптера и инициализация его списком значений
        userAdapter = new UserAdapter(userList);
        // Подключение адаптера к View
        recyclerView.setAdapter(userAdapter);

    }
}


