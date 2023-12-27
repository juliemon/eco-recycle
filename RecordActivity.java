package com.example.ecoreciclaproyecto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RecordActivity extends AppCompatActivity {
    
    private RecyclingCategory selectedCategory;
    
    private EditText amountEditText;
    private EditText valueEarnedEditText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        
        selectedCategory = (RecyclingCategory)  getIntent().getSerializableExtra("category");
        
        amountEditText = findViewById(R.id.editTextAmount);
        valueEarnedEditText = findViewById(R.id.editTextValueEarned);

        Button saveButton = findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveRecord();
            }
        });
    }
    private void saveRecord () {
        try {
            double amount = Double.parseDouble(amountEditText.getText().toString());
            double valueEarned = Double.parseDouble(valueEarnedEditText.getText().toString());
            RecyclingRecord record = new RecyclingRecord(selectedCategory, amount, valueEarned, "January");
            RecyclingManager recyclingManager= new RecyclingManager();
            recyclingManager.addRecord(record);

            Toast.makeText(this, "Record saved successfully", Toast.LENGTH_SHORT).show();
             finish();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "please enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }
}
