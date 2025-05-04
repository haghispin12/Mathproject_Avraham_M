package com.example.mathproject_avraham_m.mathprog;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mathproject_avraham_m.R;

import java.util.ArrayList;

public class ShowfruitsActivity1 extends AppCompatActivity {
private RecyclerView rcShowFruits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.showfruitsactivity);
        initViews();
        start();
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
          //  Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            //return insets;
       // });
    }

    protected void initViews(){
        rcShowFruits = findViewById(R.id.rcShowfruits);
    }
public void start(){
    ArrayList<Fruit>fruits = new ArrayList<>();
    //fruits.add(new Fruit(R.drawable.img_1 , "banana"  ));
    fruits.add(new Fruit(R.drawable.img_2 , "apple"  ));
    fruits.add(new Fruit(R.drawable.img_3 , "grapes"  ));
    fruits.add(new Fruit(R.drawable.img_4 , "lemon"  ));
    fruits.add(new Fruit(R.drawable.img_5 , "orange"  ));
    MyFruitAdapter myFruitAdapter = new MyFruitAdapter(fruits, new MyFruitAdapter.OnItemClickListener1() {
        @Override
        public void OnItemClick(Fruit item) {
            Toast.makeText(ShowfruitsActivity1.this, item.getName(), Toast.LENGTH_SHORT).show();
        }
    });
rcShowFruits.setLayoutManager(new LinearLayoutManager(this));
rcShowFruits.setAdapter(myFruitAdapter);
rcShowFruits.setHasFixedSize(true);

}
}