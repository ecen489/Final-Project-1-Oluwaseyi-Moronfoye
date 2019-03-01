package com.example.recipeasy;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;


/**
 * A simple {@link Fragment} subclass.
 */
public class textFragment extends Fragment {



    View myView;
    TextView ingView;
    TextView stepsView;
    TextView nameView;




    private String getFormartedString(String list)
    {
        String my_new_str = list.replace(";", System.getProperty("line.separator")+System.getProperty("line.separator"));
        return my_new_str;
    }


    public textFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.fragment_text, container, false);
        ingView = (TextView) myView.findViewById(R.id.ing);
        stepsView = (TextView) myView.findViewById(R.id.steps);
        nameView = (TextView) myView.findViewById(R.id.name);


        // Inflate the layout for this fragment
        return myView;
    }

    public void onActivityCreated(Bundle savedState)
    {
        super.onActivityCreated(savedState);

        int index, numItems;
        String name;



        Scanner scan = new Scanner(getResources().openRawResource(R.raw.items));
        String num =scan.nextLine();

        numItems = Integer.parseInt(num);

        final String[] ingredients = new String[numItems];
        final String[] steps = new String[numItems];



        scan = new Scanner(getResources().openRawResource(R.raw.ingredients));

        int i = 0;
        while(scan.hasNextLine()){
            String line=scan.nextLine();
            ingredients[i]=getFormartedString(line);
            Log.d("ingitems",ingredients[i]);
            i++;
        }

        /////////////////////////////////////////////
        scan = new Scanner(getResources().openRawResource(R.raw.steps));

        i = 0;
        while(scan.hasNextLine()){
            String line=scan.nextLine();
            steps[i]=getFormartedString(line);
            i++;
        }
        scan.close();

        Intent intent = getActivity().getIntent();
        index = intent.getIntExtra("index", 0);
        name = intent.getStringExtra("item");






        nameView.setText(name);
        ingView.setText(ingredients[index]);
        stepsView.setText(steps[index]);

        // }
    }

}
