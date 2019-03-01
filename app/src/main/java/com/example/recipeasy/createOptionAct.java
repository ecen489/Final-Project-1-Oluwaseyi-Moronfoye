package com.example.recipeasy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class createOptionAct extends AppCompatActivity {

    EditText dName;
    EditText dIngredients;
    EditText dSteps;

    String name;
    String ingredients;
    String steps;

    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putString("name",dName.getText().toString());
        outState.putString("steps",dSteps.getText().toString());
        outState.putString("ingredients",dIngredients.getText().toString());
    }

    public void onRestoreInstanceState(Bundle inState)
    {
        super.onRestoreInstanceState(inState);
        name= inState.getString("name");
        ingredients= inState.getString("ingredients");
        steps= inState.getString("steps");

        dName.setText(name);
        dIngredients.setText(ingredients);
        dSteps.setText(steps);
    }



    private String formatStrings(String list)
    {
        String my_new_str = list.replace(System.getProperty("line.separator"), ";");
        return my_new_str;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_option);


        dName = (EditText) findViewById(R.id.dishName);
        dIngredients = (EditText) findViewById(R.id.dishIngredients);
        dSteps = (EditText) findViewById(R.id.dishSteps);
    }

    public void addToList(View view) {






        name = dName.getText().toString();


        String ing = dIngredients.getText().toString();
        ingredients = formatStrings(ing);


        String st = dSteps.getText().toString();
        steps = formatStrings(st);

        if(name.length() == 0||ingredients.length()==0||steps.length()==0)
        {
            Toast.makeText(createOptionAct.this, "Please enter text in all fields",Toast.LENGTH_SHORT).show();
            finish();
        }

        try {

            Toast.makeText(createOptionAct.this, "Created new recipe!",Toast.LENGTH_SHORT).show();
//            File nameFile = new File("../res/raw/items.txt");
//
//            File ingFile = new File("../res/raw/ingredients.txt");
//
//            File stepsFile = new File("../res/raw/steps.txt");
//
//
//            FileOutputStream fileout=openFileOutput("items.txt", MODE_APPEND| MODE_PRIVATE);
//            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
//            outputWriter.write(name);
//            outputWriter.flush();
//            outputWriter.close();
//
//            FileOutputStream nameFileOutputStream = new FileOutputStream(nameFile,true);
//            FileOutputStream ingFileOutputStream = new FileOutputStream(ingFile,true);
//            FileOutputStream stepsFileOutputStream = new FileOutputStream(stepsFile,true);
//
//
//            nameFileOutputStream.write((name + System.getProperty("line.separator")).getBytes());
//
//            ingFileOutputStream.write((ingredients + System.getProperty("line.separator")).getBytes());
//
//            stepsFileOutputStream.write((steps + System.getProperty("line.separator")).getBytes());

            finish();

        }
        catch(Exception ex) {
            Toast.makeText(createOptionAct.this, "Failed to create entry",Toast.LENGTH_SHORT).show();
            finish();

        }
    }
}
