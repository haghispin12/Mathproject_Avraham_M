package com.example.mathproject_avraham_m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyUsersAdapter extends RecyclerView.Adapter<MyUsersAdapter.MyViewHolder> {
    private ArrayList<User>users;
    private OnItemClickListener1 listener;
    public interface OnItemClickListener1 {
        void OnItemClick(User user);
    }

    public MyUsersAdapter(ArrayList<User>users, OnItemClickListener1 listener){
        this.users=users;
        this.listener=listener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(users.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    //


    public static class MyViewHolder extends RecyclerView.ViewHolder{
       TextView tvScoreuser;
        TextView tvUsername;
        ImageView ivUserimg;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvScoreuser = itemView.findViewById(R.id.tvScoreuser);
            ivUserimg = itemView.findViewById(R.id.ivUserimg);

        }
        public void bind(final User user, OnItemClickListener1 listener){
            tvScoreuser.setText(user.getscore() + "");
            tvUsername.setText(user.getUsername());
            ivUserimg.setImageBitmap(user.getBitmap());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnItemClick(user);
                }
            });
        }
    }
}
