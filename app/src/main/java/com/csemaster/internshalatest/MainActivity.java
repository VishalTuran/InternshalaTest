package com.csemaster.internshalatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.GridLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FruitRecycler fruitRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.fruitRecyclerView);

        ArrayList<String> fruitNames=new ArrayList<String>();

        fruitNames.add("Papaya");
        fruitNames.add("Orange");
        fruitNames.add("Apple");
        fruitNames.add("Mango");

        ArrayList<Integer> fruitImages=new ArrayList<>();

        fruitImages.add(R.drawable.papaya);
        fruitImages.add(R.drawable.fruit);
        fruitImages.add(R.drawable.apple);
        fruitImages.add(R.drawable.mango);

        fruitRecycler=new FruitRecycler(fruitNames,fruitImages);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        fruitRecycler.notifyDataSetChanged();
        recyclerView.setAdapter(fruitRecycler);

    }
}
