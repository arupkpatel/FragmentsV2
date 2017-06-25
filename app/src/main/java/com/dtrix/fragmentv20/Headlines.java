package com.dtrix.fragmentv20;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Soumya on 17-06-2017.
 */

public class Headlines extends ListFragment {

    public interface headlineselectedListner{
        void OnArticleSelectd(int position);
    }
    headlineselectedListner callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            callback=(headlineselectedListner)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must be Implemented with headselectedlinelistener");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Fragment f =getFragmentManager().findFragmentById(R.id.articles);
        ListView v = getListView();
        if(f!=null && v!=null)
            v.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        int layout= android.R.layout.simple_list_item_1;
        String[] data =Data.arr1;

        setListAdapter(new ArrayAdapter<String>(getActivity(),layout,data));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        callback.OnArticleSelectd(position);
        l.setItemChecked(position,true);
        //highlights selected item
    }
}
