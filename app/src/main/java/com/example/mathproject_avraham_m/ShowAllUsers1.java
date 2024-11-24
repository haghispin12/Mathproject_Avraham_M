package com.example.mathproject_avraham_m;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class ShowAllUsers1 extends Fragment {
private EditText etuser;

    private Button baddpicture;
    private ImageView iimageview;
    private Button badduser;
    private TextView trating;
    private TextView tscore;
    MainViewModel viewModelMain;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //if (getArguments() != null) {
             viewModelMain =new ViewModelProvider(requireActivity()).get(MainViewModel.class);

    }

    protected void initViews(View view) {
        tscore = view.findViewById(R.id.tscore);

        trating=view.findViewById(R.id.trating);
        badduser=view.findViewById(R.id.badduser);
        iimageview =view.findViewById(R.id.iimageview);
        baddpicture=view.findViewById(R.id.baddpicture);
        etuser=view.findViewById(R.id.etuser);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_showusers, container, false);

        initViews(view);

        trating.setText(viewModelMain.getrate() + "");
        etuser.setText(viewModelMain.getUser() + "");
        tscore.setText(viewModelMain.getscore()+"");
        return view;
    }

}