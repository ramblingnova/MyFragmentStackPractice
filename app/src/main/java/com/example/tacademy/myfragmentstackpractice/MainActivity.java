package com.example.tacademy.myfragmentstackpractice;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Fragment[] list = {StackFragment.newInstance("one"), StackFragment.newInstance("two"), StackFragment.newInstance("three"),  };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, StackFragment.newInstance("base")).commit();
        }

        Button btn = (Button)findViewById(R.id.button_prev);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportFragmentManager().popBackStack();
                }
            }
        });

        btn = (Button)findViewById(R.id.button_post);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = getSupportFragmentManager().getBackStackEntryCount();
                if(count < list.length) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, list[count]).addToBackStack(null).commit();
                } else {
                    getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                }
            }
        });
    }
}
