package com.example.mathproject_avraham_m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class GuidersAdapter extends RecyclerView.Adapter<GuidersAdapter.MyViewHolder> {
    private ArrayList<Guide> guiders;

    private OnItemClickListener1 listener;

    public interface OnItemClickListener1 {

    }

    public GuidersAdapter(ArrayList<Guide> guiders, OnItemClickListener1 listener) {
        this.guiders = guiders;
        this.listener = listener;
    }
    @NonNull
    @Override
    public GuidersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guiders_adapter, parent, false);
        return new GuidersAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuidersAdapter.MyViewHolder holder, int position) {
        holder.bind1(guiders.get(position) , listener);

    }

    @Override
    public int getItemCount() {
        if(guiders==null)
            return 0;
        return guiders.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{


        private FirebaseAuth auth;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


        }

        public void bind1(final Guide guider, GuidersAdapter.OnItemClickListener1 listener){
       int i=0;







        }
    }


}