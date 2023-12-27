package com.example.ecoreciclaproyecto;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class TipsActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        TextView tipsTextView = findViewById(R.id.textViewTips);

        RecyclingManager recyclingManager = new RecyclingManager();

        List<RecyclingRecord> userRecords = recyclingManager.getUserRecords("currentUser");

        double totalPlasticRecycled = recyclingManager.getTotalRecycledAmount(userRecords, "Plastic");
        String tips = generateTips(totalPlasticRecycled);

        tipsTextView.setText(tips);
    }
    private String generateTips(double totalPlasticRecycled) {
        if (totalPlasticRecycled  > 50) {
            return "Great job! you're doing an excellent job recycling plastic. Excelente! hiciste un gran trabajo reciclando plastico.";
        } else {
            return "Consider recycling more plastic to contribute to a greener environment. Considera reciclar mas plastico para contribuir a un medio ambiente mas verde y limpio";
        }
    }
}
