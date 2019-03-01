package com.example.recipeasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class makeItemAct extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_item);


    }


    public void exit(View view) {
        finish();
    }

//    public void likebtn(View view) {
//        ImageButton btn = (ImageButton)findViewById(R.id.fav);
//        btn.setImageResource(R.drawable.clickedstar);
//    }
}
