package com.example.ecoreciclaproyecto;

public class RecyclingRecord {
    private RecyclingCategory category;
    private double amount;
    private double valueEarned;
    private String month;
    public RecyclingRecord (RecyclingCategory category, double amount,
                            double valueEarned, String month) {
        this.category = category;
        this.amount = amount;
        this.valueEarned = valueEarned;
        this.month = month;
    }
    // getter methods
    public RecyclingCategory getCategory () {
        return category;
    }
    public double getAmount() {
        return amount ;
    }
    public double getValueEarned(){
        return valueEarned;
    }
    public String getMonth(){
        return month;
    }

    public Object getUser() {
        return null;
    }
}
