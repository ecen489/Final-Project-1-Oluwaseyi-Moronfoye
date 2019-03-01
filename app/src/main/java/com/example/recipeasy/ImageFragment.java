package com.example.recipeasy;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Scanner;


/*
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ImageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ImageFragment extends Fragment {



    View myView;
    ImageView imv;

    String item;

    public ImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Scanner scan = new Scanner(getResources().openRawResource(R.raw.items));
        String num =scan.nextLine();
        int index, numItems;
//    private OnFragmentInteractionListener mListener;

        numItems = Integer.parseInt(num);
        final String[] items = new String[numItems];


        int i = 0;
        while(scan.hasNextLine()){
            String line=scan.nextLine();
            items[i]=line;
            i++;
        }
        scan.close();

        myView = inflater.inflate(R.layout.fragment_image, container, false);
        Intent intent = getActivity().getIntent();
        index = intent.getIntExtra("index", 0);
        item = intent.getStringExtra("item");
        imv= (ImageView) myView.findViewById(R.id.foodImg);


//        for(int j = 0; j< items.length; j++)
//        {
//
//            if (item.equals(items[i])) {
                String newItem = item.replace(" ", "").toLowerCase();
                String uri = "@drawable/"+ newItem;
                int imageResource = getResources().getIdentifier(uri, null, this.getActivity().getPackageName());// might need to put "this" some were
                Drawable res = getResources().getDrawable(imageResource);
                imv.setImageDrawable(res);
//            }
//        }

        return myView;
    }
//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
