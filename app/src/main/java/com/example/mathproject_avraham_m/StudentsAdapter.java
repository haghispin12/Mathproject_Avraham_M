package com.example.mathproject_avraham_m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.MyViewHolder> {
    private  ArrayList<Student>students;

    private OnItemClickListener1 listener;
    public interface OnItemClickListener1 {
        void OnItemClick(Student student);
    }

    public StudentsAdapter(ArrayList<Student>students, OnItemClickListener1 listener){
        this.students=students;
        this.listener=listener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.students_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(students.get(position), listener);

    }

    @Override
    public int getItemCount() {
        if(students==null)
return 0;
        return students.size();
    }

    //


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        CheckBox cbisPresent;
        CheckBox cbisLate;
        CheckBox cbisPhone;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            cbisPresent = itemView.findViewById(R.id.cbisPresent);
            cbisLate = itemView.findViewById(R.id.cbisLate);
            cbisPhone = itemView.findViewById(R.id.cbisPhone);
cbisPresent.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        int n=10;
    }
});
        }
        public void bind(final Student student, OnItemClickListener1 listener){
            tvName.setText(student.getName() + "");
            cbisLate.setText(student.isLate() + "");
            cbisPresent.setText(student.isPresent() + "");
            cbisPhone.setText(student.isPhone() +  "");
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnItemClick(student);
                }
            });
        }
    }

}
