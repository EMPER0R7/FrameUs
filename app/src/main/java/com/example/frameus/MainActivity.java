package com.example.frameus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.frameus.databinding.ActivityMainBinding;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.bottomNavigation.show(1,true);

        binding.bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_dashboard_white_24dp));
        binding.bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.baseline_add_circle_outline_24));
        binding.bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.search));
        binding.bottomNavigation.add(new MeowBottomNavigation.Model(4,R.drawable.profile));
        meonavigation();


        binding.cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent i= new Intent(MainActivity.this,Camera.class);
             startActivity(i);
            }
        });
    }

    private void meonavigation() {
        binding.bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
                        binding.home.setVisibility(View.VISIBLE);
                        binding.post.setVisibility(View.GONE);
                        binding.profile.setVisibility(View.GONE);
                        binding.search.setVisibility(View.GONE);
                        break;
                    case 2:
                        binding.home.setVisibility(View.GONE);
                        binding.post.setVisibility(View.VISIBLE);
                        binding.profile.setVisibility(View.GONE);
                        binding.search.setVisibility(View.GONE);
                        break;
                    case 3:
                        binding.home.setVisibility(View.GONE);
                        binding.post.setVisibility(View.GONE);
                        binding.profile.setVisibility(View.GONE);
                        binding.search.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        binding.home.setVisibility(View.GONE);
                        binding.post.setVisibility(View.GONE);
                        binding.profile.setVisibility(View.VISIBLE);
                        binding.search.setVisibility(View.GONE);
                        break;
                }

                return null;
            }
        });
    }
}