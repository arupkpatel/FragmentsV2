package com.dtrix.fragmentv20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Headlines.headlineselectedListner{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.container)!= null){
            if(savedInstanceState!=null)
                //if system is restored than no need
                return;

            Headlines headlines =new Headlines();
            headlines.setArguments(getIntent().getExtras());

            getFragmentManager().beginTransaction().add(R.id.container,headlines).commit();
        }

    }

    @Override
    public void OnArticleSelectd(int position) {
        //2 pane checking
        Articles articles = (Articles)getFragmentManager().findFragmentById(R.id.articles);

        if(articles != null){
            articles.updateArticle(position);
        }else{
            //fragment swaping
            Articles swap = new Articles();
            Bundle args = new Bundle();
            args.putInt(Articles.ARG_POS,position);
            swap.setArguments(args);
            getFragmentManager().beginTransaction().replace(R.id.container,swap).addToBackStack(null).commit();
        }
    }
}
