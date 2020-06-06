package com.enjoy.interntask;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Daysadapter  extends RecyclerView.Adapter<Daysadapter.Daysadaptervwholder> {
    //public  String[] weedays;
    ArrayList<String> daysofweek=new ArrayList<>();
    public  Daysadapter(ArrayList daysofweek){

        this.daysofweek=daysofweek;
    }
    @NonNull
    @Override
    public Daysadaptervwholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.home_cardvw,parent,false);


        return new Daysadaptervwholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Daysadaptervwholder holder, int position) {
        String day= daysofweek.get(position);
        holder.day.setText(day);

    }

    @Override
    public int getItemCount() {
        return daysofweek.size();
    }

    public  class Daysadaptervwholder extends RecyclerView.ViewHolder{
        ImageView imageVwdelete;
        TextView day;
        public Daysadaptervwholder(final View itemview){
            super(itemview);
            imageVwdelete=itemview.findViewById(R.id.imagevw);
            day=itemview.findViewById(R.id.textvwday);
            imageVwdelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int postobedelete=getAdapterPosition();
                    String daynametobedelete=daysofweek.get(postobedelete);
                    int selectedItemId = -1;
                    for (int i = 0; i < daysofweek.size(); i++) {
                        if (daynametobedelete.equals(daysofweek.get(i).toString())) {
                            daysofweek.remove(postobedelete);
                            notifyItemRemoved(postobedelete);
                            break;
                        }
                    }

                }
            });
            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id=getAdapterPosition();
                    Intent intent=new Intent(itemView.getContext(),SecondActivity.class);
                    intent.putExtra("Dayname",daysofweek.get(id).toString() );
                    Log.d("DAY ",""+daysofweek.get(id));
                    itemview.getContext().startActivity(intent);
                }
            });
        }
    }
    public  interface  oncardviewListener{
        void  oncardClick(int pos);
    }
}
