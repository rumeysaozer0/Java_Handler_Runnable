package com.rumeysaozer.javahandlerrunnable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.rumeysaozer.javahandlerrunnable.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    int number ;
    Runnable runnable;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        number = 0;
        binding.start.setOnClickListener(v->{
            handler = new Handler();
            runnable = new Runnable() {
                @Override
                public void run() {
                    binding.textView.setText("Time : "+number);
                    number++;
                    binding.textView.setText("Time : "+number);
                    handler.postDelayed(runnable,1000);
                }
            };
            handler.post(runnable);
            binding.start.setEnabled(false);


        });
        binding.stop.setOnClickListener(v->{
            binding.start.setEnabled(true);
            handler.removeCallbacks(runnable);
            number = 0;
            binding.textView.setText("Time : "+number);
        });
    }
}