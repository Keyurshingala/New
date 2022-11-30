package com.example.anew;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.core.content.res.ResourcesCompat;

import com.example.anew.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setToolbar();

//        binding.btnCam.setOnClickListener(v -> {
//            LevelListDrawable background=(LevelListDrawable)binding.btnCam.getBackground();
//            background.setLevel(1);
//         });

        //clickEvents();

        ImageView imageview = (ImageView) findViewById(R.id.image);
        Drawable drawable = imageview.getBackground();
        if (drawable instanceof Drawable) {
            ((ClipDrawable)drawable).setLevel(drawable.getLevel() + 5000);
        }
    }


    /*private void clickEvents() {
        ActivityResultLauncher<Intent> resultLauncherG = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent i = result.getData();
                    if (i != null) {
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), i.getData());
                            binding.iv.setImageBitmap(bitmap);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

        ActivityResultLauncher<Intent> resultLauncherC = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent i = result.getData();
                    if (i != null) {
                        try {
                            Bitmap imageBitmap = null;
                            imageBitmap = (Bitmap) i.getExtras().get("data");
                            ByteArrayOutputStream byteArr = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArr);
                            byte[] BYTE = byteArr.toByteArray();
                            Bitmap bitmap = BitmapFactory.decodeByteArray(BYTE, 0, BYTE.length);
                            binding.iv.setImageBitmap(bitmap);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

        binding.btn.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_PICK);
            i.setType("image/*");
            resultLauncherG.launch(i);
        });

        binding.btnCam.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            resultLauncherC.launch(intent);
        });

        binding.btnContactAc.setOnClickListener(v -> {
            startActivity(new Intent(this,ReadContactActivity.class));
        });
    }*/

    private void setToolbar() {
        setSupportActionBar(binding.tb.tb);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        binding.tb.tb.setNavigationOnClickListener(v -> {
            finish();
//            tosS("Back");
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();

        TextView searchText = (TextView) searchView.findViewById(R.id.search_src_text);
        searchText.setTypeface(ResourcesCompat.getFont(this, R.font.quicksand_regular));
        searchView.setBackgroundResource(R.drawable.bg_search_main);

        searchView.setQueryHint("Type Here");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //on enter click search appears
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                binding.tv.setText(newText);
                return false;
            }
        });

//        return super.onCreateOptionsMenu(menu);
        return true;
    }


}