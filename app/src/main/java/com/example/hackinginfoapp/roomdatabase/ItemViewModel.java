package com.example.hackinginfoapp.roomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {
    private ItemRepository repository;

    private LiveData<List<Item>> allItems;
    private LiveData<List<Item>> cyberVulItems;
    private LiveData<List<Item>> famousHackersItems;
    private LiveData<List<Item>> famousHacksItems;
    private LiveData<List<Item>> howToProtectItems;

    public ItemViewModel(@NonNull Application application) {
        super(application);
        repository = new ItemRepository(application);
        allItems = repository.getAllItems();
        cyberVulItems = repository.getCyberVulItems();
        famousHackersItems = repository.getFamousHackersItems();
        famousHacksItems = repository.getFamousHacksItems();
        howToProtectItems = repository.getHowToProtectItems();
    }

    public void insert(Item item) {
        repository.insert(item);
    }

    public void update (Item item) {
        repository.update(item);
    }

    public void delete (Item item) {
        repository.delete(item);
    }

    public void deleteAllItems (Item item) {
        repository.deleteAllItems();
    }

    public LiveData<List<Item>> getAllItems() {
        return allItems;
    }

    public LiveData<List<Item>> getCyberVulItems() {
        return cyberVulItems;
    }

    public LiveData<List<Item>> getFamousHackersItems() {
        return famousHackersItems;
    }

    public LiveData<List<Item>> getFamousHacksItems() {
        return famousHacksItems;
    }

    public LiveData<List<Item>> getHowToProtectItems() {
        return howToProtectItems;
    }
}
