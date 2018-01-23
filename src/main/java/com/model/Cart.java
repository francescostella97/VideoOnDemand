package com.model;

import java.util.HashSet;
import java.util.Set;

public class Cart {

    private Set<FilmEntity> items = new HashSet<>();

    public boolean addItem(FilmEntity item){
        boolean result = false;
        if(item != null){
            result = items.add(item);
        }
        return result;
    }

    public boolean removeItem(FilmEntity item){
        boolean result = false;
        if(item != null){
            result = items.remove(item);
        }
        return result;
    }

    public int getItemCount(){
        return items.size();
    }

    public void removeAllItems() {
        if (items != null && items.size() != 0) {
            items.clear();
        }
    }

    public double getItemTotalAmount(){
        double totalAmount = 0;
        if(items != null && items.size() != 0){
            for (FilmEntity item : items ) {
                totalAmount += item.getPrice();
            }
        }
        return totalAmount;
    }
}
