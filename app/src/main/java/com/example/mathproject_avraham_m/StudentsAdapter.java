package com.example.mathproject_avraham_m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.MyViewHolder> {
    private  ArrayList<Student>students;

    private OnItemClickListener1 listener;
    public interface OnItemClickListener1 {
        void OnItemClick(Student student,int n  , Long count);
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

        CheckBox cbisHome;
        CheckBox cbisPresent;
        CheckBox cbisLate;
        CheckBox cbisPhone;
        TextView tvCount;

        private FirebaseAuth auth;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            cbisPresent = itemView.findViewById(R.id.cbisPresent);
            cbisLate = itemView.findViewById(R.id.cbisLate);
            cbisPhone = itemView.findViewById(R.id.cbisPhone);
            cbisHome = itemView.findViewById(R.id.cbhome);
            tvCount = itemView.findViewById(R.id.tvCount);

        }

        public void bind(final Student student, OnItemClickListener1 listener){
            tvName.setText(student.getName());
            tvCount.setText(student.getCount() + "");
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
//            if (student.gethome()==0L){
//                cbisHome.setChecked(true);
//            }
            if (student.getViewType()==true){
                cbisHome.setEnabled(true);
                cbisPresent.setEnabled(false);
                cbisPhone.setEnabled(true);
                cbisLate.setEnabled(false);

            }

            else{
                cbisHome.setEnabled(false);
            }
            if (student.gethome()==0L) {
            cbisLate.setEnabled(false);
            cbisPhone.setEnabled(false);
            cbisPresent.setEnabled(false);
            }


            cbisPresent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked==true) {
                        student.setPresent(true);
                    }else{
                        student.setPresent(false);
                    }
                    listener.OnItemClick(student ,1 , student.getCount());
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
                    listener.OnItemClick(student , 3 , student.getCount());
                }
            });
            cbisHome.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    if (isChecked==true){
//                        student.sethome(0L);
//                    } else{
//                        student.sethome(1L);
//                    }
                    listener.OnItemClick(student , 4 , student.getCount());
                }
            });
            cbisLate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked==true) {
                        student.setLate(true);
                        student.incNum();

                    } else {
                        student.setLate(false);
                    }
                    listener.OnItemClick(student , 2 , student.getCount());

                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    listener.OnItemClick(student);
                }
            });
        }
    }

}
