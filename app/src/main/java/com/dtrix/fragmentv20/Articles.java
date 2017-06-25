package com.dtrix.fragmentv20;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Soumya on 17-06-2017.
 */

public class Articles extends Fragment {

    public static String ARG_POS = "Position";
    public  int currentposition =-1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(savedInstanceState!=null){
            currentposition=savedInstanceState.getInt(ARG_POS);
        }
        return  inflater.inflate(R.layout.articles,container,false);
    }

    public void updateArticle(int position){
        View v = getView();
        TextView textView =(TextView) v.findViewById(R.id.art);
        String[] str = Data.arr2;
        textView.setText(str[position]);
        currentposition = position;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if(args != null){
            updateArticle(args.getInt(ARG_POS));
        }else if(currentposition !=-1){
            updateArticle(currentposition);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POS,currentposition);

    }
}
