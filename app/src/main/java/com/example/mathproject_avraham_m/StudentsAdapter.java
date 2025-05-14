package com.example.mathproject_avraham_m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

        }

        public void bind(final Student student, OnItemClickListener1 listener){
            tvName.setText(student.getName() + student.getId());
//            cbisLate.setText(student.isLate() + "");
//            cbisPresent.setText(student.isPresent() + "");
//            cbisPhone.setText(student.isPhone() +  "");

            if (student.isPresent()==true){
                cbisPresent.setChecked(true);
            }
            if (student.isLate()==true){
                cbisLate.setChecked(true);
            }
            if (student.isPhone()==true){
                cbisPhone.setChecked(true);
            }
            cbisPresent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked==true) {
                        student.setPresent(true);
                    }else{
                        student.setPresent(false);
                    }
                    listener.OnItemClick(student);
                }
            });
            cbisPhone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked==true) {
                        student.setPhone(true);
                    } else {
                        student.setPhone(false);
                    }
                    listener.OnItemClick(student);
                }
            });
            cbisLate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked==true) {
                        student.setLate(true);
                    } else {
                        student.setLate(false);
                    }
                    listener.OnItemClick(student);
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnItemClick(student);
                }
            });
        }
    }

}
