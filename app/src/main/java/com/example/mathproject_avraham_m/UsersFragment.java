package com.example.mathproject_avraham_m;

import static android.app.Activity.RESULT_OK;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class UsersFragment extends Fragment implements MenuProvider {
private EditText etuser;


    private Button baddpicture;
    private ImageView iimageview;
    private Button badduser;
    private Button bback;
    private TextView trating;
    private TextView tscore;
    private RecyclerView rcShowUsers;
    private User currentUser;
    private Uri uri;
    private ActivityResultLauncher<Intent> startCamera = registerForActivityResult
            (new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK)
                    {
                        iimageview.setImageURI(uri);
                        viewModelMain.user.setUri(uri);
                    }
                }
            });
    MainViewModel viewModelMain;
    private MenuItem itemDelete;
    private MenuItem itemEdit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //if (getArguments() != null) {
             viewModelMain =new ViewModelProvider(requireActivity()).get(MainViewModel.class);

    }

    protected void initViews(View view) {
        tscore = view.findViewById(R.id.tscore);
rcShowUsers = view.findViewById(R.id.rcShowUsers);
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
        viewModelMain.u1.observe(getActivity(), new Observer<ArrayList<User>>() {
            @Override
            public void onChanged(ArrayList<User> users) {
                if (users.size()>0){
MyUsersAdapter myUsersAdapter = new MyUsersAdapter(users, new MyUsersAdapter.OnItemClickListener1() {
    @Override
    public void OnItemClick(User user) {
itemDelete.setVisible(true);
    itemEdit.setVisible(true);
         currentUser = user;
        tscore.setText(currentUser.getscore() + "");
trating.setText(currentUser.getRate() + "");
etuser.setText(currentUser.getUsername());
iimageview.setImageBitmap(currentUser.getBitmap());
    }
});

                    rcShowUsers.setLayoutManager(new LinearLayoutManager(requireContext()));
                    rcShowUsers.setAdapter(myUsersAdapter);
                    rcShowUsers.setHasFixedSize(true);

                }



            }
        });
        viewModelMain.getArray(getActivity());
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
badduser.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        long g = viewModelMain.dbAddUser(getActivity());
        viewModelMain.getArray(getActivity());
        Toast.makeText(getActivity() , g + "" , Toast.LENGTH_LONG).show();
    }
});

        trating.setText(viewModelMain.getrate() + "");
        etuser.setText(viewModelMain.getUser() + "");
        tscore.setText(viewModelMain.getscore()+"");
        requireActivity().addMenuProvider(this);

        return view;

    }

    @Override
    public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
menuInflater.inflate(R.menu.menu , menu);
itemDelete = menu.findItem(R.id.action_delete);
itemDelete.setVisible(false);
itemEdit = menu.findItem(R.id.action_edit);
itemEdit.setVisible(false);
super.onCreateOptionsMenu(menu , menuInflater);
    }

    @Override
    public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
        int id =menuItem.getItemId();
        switch (id){
            case R.id.action_delete:
openDialog();
return true;
            case R.id. action_edit:
                viewModelMain.getUpdate(getActivity(), currentUser);
currentUser.setUsername(etuser.getText().toString());
            return true;
        }
        return false;
    }

public void openDialog(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Delete");
        alertDialog.setMessage("Do you want to delete?");
        alertDialog.setIcon(R.drawable.ic_launcher_background);
        alertDialog.setCancelable(true);
alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
viewModelMain.getDelete(getActivity() , currentUser);

dialogInterface.dismiss();
    }
});
alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
dialogInterface.dismiss();
    }
});
alertDialog.show();

}

}