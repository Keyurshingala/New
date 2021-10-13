package com.example.anew;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.kaopiz.kprogresshud.KProgressHUD;

public class BaseActivity extends AppCompatActivity {

    public static final String TAG = "TAGZ";
    public KProgressHUD progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        progress = KProgressHUD.create(this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel("Please wait")
                    .setCancellable(true)
                    .setAnimationSpeed(1)
                    .setDimAmount(0.25f);

    }

    public void tosS(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void tosL(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    //Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.myimage, null);
}