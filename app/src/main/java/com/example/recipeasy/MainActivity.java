package com.example.recipeasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;


import java.util.Scanner;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent createOption = new Intent(this, createOptionAct.class);
        final Intent makeItem = new Intent(this, makeItemAct.class);


        Scanner scan = new Scanner(getResources().openRawResource(R.raw.items));
        String num =scan.nextLine();
        int numItems;
        numItems = Integer.parseInt(num);
        final String[] items = new String[numItems];


        int i = 0;
        while(scan.hasNextLine()){
            String line=scan.nextLine();
            items[i]=line;
            i++;
        }
        scan.close();



        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, items);

        ListView list = (ListView) findViewById(R.id.lView);
        list.setAdapter(myadapter);


        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> list, View row, int index, long rowID) {

                        String item = list.getItemAtPosition(index).toString();


                        makeItem.putExtra("item", item);
                        makeItem.putExtra("index", index);
                        startActivity(makeItem);


                    }
                }
        );

        ImageButton b = (ImageButton) findViewById(R.id.addbtn);
        b.setOnClickListener(
                new View.OnClickListener() {
                    @Override public void onClick(View view) {
                        startActivity(createOption);
                    }
                    });
    }

//    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
//        if (requestCode == REQCODE1) {s
////            int point = intent.getIntExtra("point", 0);
//            // might not be usefull i dont need to get anything after making watching the item be made
//
//        }
//        else
//        {
//
//        }
//    }

//    public void addItem(View view) {
//        startActivity(createOption);
//    }
}
