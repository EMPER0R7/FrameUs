package com.example.frameus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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




    }

    private void meonavigation() {
        binding.bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                FragmentTransaction transition= getSupportFragmentManager().beginTransaction();
                switch (model.getId()){
                    case 1:
                        transition.replace(R.id.container, new HomeFragment());


                        break;
                    case 2:
                        transition.replace(R.id.container, new PostFragment());

                        break;
                    case 3:
                        transition.replace(R.id.container, new SearchFragment());

                        break;
                    case 4:
                        transition.replace(R.id.container, new ProfileFragment());

                        break;
                }
                transition.commit();
                return null;
            }
        });
    }
}