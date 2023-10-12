package com.example.frameus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.frameus.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent i= new Intent(MainActivity.this,Camera.class);
             startActivity(i);
            }
        });
    }
}