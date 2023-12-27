package com.example.ecoreciclaproyecto;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Map;
    import java.util.HashMap;

public class RecyclingManager {
    private List<User> users;
    private List<RecyclingCategory> categories;
    private List<RecyclingRecord> records;

    public RecyclingManager() {
        users = new ArrayList<>();
        categories = new ArrayList<>();
        records = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addCategory(RecyclingCategory category) {
        categories.add(category);
    }

    public void addRecord(RecyclingRecord record) {
        records.add(record);
    }
    public List<RecyclingRecord> getRecordsByCategory(RecyclingCategory category) {
        List<RecyclingRecord> categoryRecords = new ArrayList<>();
        for (RecyclingRecord record : records) {
            if (record.getCategory().equals(category)) {
                categoryRecords.add(record);
            }
        }
        return categoryRecords;
    }
    public List<RecyclingRecord> getUserRecords(String username) {
        List<RecyclingRecord> userRecords = new ArrayList<>();
        for (RecyclingRecord record : records){
            if (record.getUser(). equals(username)){
                userRecords.add(record);
            }
        }
        return userRecords;
    }
    public double getTotalRecycledAmount(List<RecyclingRecord> records, String categoryName) {
        double totalAmount = 0.0;
        for (RecyclingRecord record : records) {
            if (record.getCategory().getName().equals(categoryName)) {
                totalAmount += record.getAmount();
            }
        }
        return totalAmount;
    }
}
