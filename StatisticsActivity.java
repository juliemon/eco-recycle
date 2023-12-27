package com.example.ecoreciclaproyecto;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class StatisticsActivity extends AppCompatActivity {

    private RecyclingCategory selectedCategory;

    private TextView averageTextView;
    private TextView maxTextView;
    private TextView minTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState);

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        selectedCategory = (RecyclingCategory) getIntent().getSerializableExtra("category");

        averageTextView = findViewById(R.id.textViewAverage);
        maxTextView = findViewById(R.id.textViewMax);
        minTextView = findViewById(R.id.textViewMin);

        calculateStatistics();

    }

    private void calculateStatistics() {
        RecyclingManager recyclingManager = new RecyclingManager();
        List<RecyclingRecord> records = recyclingManager.getRecordsByCategory(selectedCategory);

        double totalAmount = 0.0;
        double maxAmount = Double.MIN_VALUE;
        double minAmount = Double.MAX_VALUE;

        for (RecyclingRecord record : records) {
            totalAmount += record.getAmount();
            maxAmount = Math.max(maxAmount, record.getAmount());
            minAmount = Math.min(minAmount, record.getAmount());
        }

        double averageAmount = totalAmount / records.size();

        averageTextView.setText("Average: " + averageAmount);
        maxTextView.setText("Max: " + maxAmount);
        minTextView.setText("Min: " + minAmount);
    }
}