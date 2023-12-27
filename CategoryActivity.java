package com.example.ecoreciclaproyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private List<RecyclingCategory> categories;
    private ArrayAdapter<RecyclingCategory> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState); {
        Bundle savedInstanceState;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        RecyclingManager recyclingManager = new RecyclingManager();
        categories = recyclingManager.getCategories();

        ListView categoryListview = findViewById(R.id.listViewCategories);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_intem_1, categories);
        categoryListView.setAdapter(adapter);

        categoryListView.setOnItemClick(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RecyclingCategory selectedCategory = categories.get(position);
                Intent intent = new Intent(CategoryActivity.this, RecordActivity.class);
                intent.putExtra("category", selectedCategory);
                startActivity(intent);

            }
        });
    }
}
