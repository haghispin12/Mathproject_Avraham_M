package com.example.mathproject_avraham_m;

import static android.app.Activity.RESULT_OK;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.provider.MediaStore;
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
    private Button bback;
    private TextView trating;
    private TextView tscore;
    private Uri uri;
    private ActivityResultLauncher<Intent> startCamera = registerForActivityResult
            (new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK)
                    {
                        iimageview.setImageURI(uri);
                    }
                }
            });
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
        bback = view.findViewById(R.id.bback);
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
bback.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        getActivity().onBackPressed();
    }
});
baddpicture.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ContentValues values =new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From Camera");
          uri = requireContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startCamera.launch(cameraIntent);
    }
});


        trating.setText(viewModelMain.getrate() + "");
        etuser.setText(viewModelMain.getUser() + "");
        tscore.setText(viewModelMain.getscore()+"");
        return view;
    }

}