package com.example.anew.btnWithVibration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

import com.example.anew.BaseActivity;
import com.example.anew.R;
import com.example.anew.databinding.ActivityBtnBinding;

public class BtnActivity extends BaseActivity {

    ActivityBtnBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBtnBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibe.vibrate(1);
            }
        });
     }
}