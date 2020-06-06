package com.enjoy.interntask;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    Daysadapter daysadapter;

    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=view.findViewById(R.id.recyclevw);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //String[] daysofwee={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Monday");
        arrayList.add("Tuesday");
        arrayList.add("Wednesday");
        arrayList.add("Thursday");
        arrayList.add("Friday");
        arrayList.add("Saturday");
        arrayList.add("Sunday");
        daysadapter=new Daysadapter(arrayList);
        recyclerView.setAdapter(daysadapter);
        /*int postobedelete=recyclerView.getChildPosition(view);
        RecyclerView.ViewHolder holder;
        holder.getAdapterPosition();
        String daynametobedelete=arrayList.get(postobedelete);
        int selectedItemId = -1;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(postobedelete).toString().equals(arrayList.get(i).toString())) {
                arrayList.remove(postobedelete);
                daysadapter.notifyItemRemoved(postobedelete);
                break;
            }
        }*/

        return view;




    }

   /* @Override
    public void oncardClick(int pos) {
        //daysadapter.
        Intent intent=new Intent(getActivity(),SecondActivity.class);
        intent.putExtra("Dayname",)
        startActivity(intent);
    }*/
}
