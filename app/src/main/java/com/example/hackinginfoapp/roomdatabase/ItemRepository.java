package com.example.hackinginfoapp.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ItemRepository {
    private ItemDao itemDao;

    //lists to store items for different fragments
    private LiveData<List<Item>> allItems;
    private LiveData<List<Item>> cyberVulItems;
    private LiveData<List<Item>> famousHackersItems;
    private LiveData<List<Item>> famousHacksItems;
    private LiveData<List<Item>> howToProtectItems;

    public ItemRepository(Application application) {
        ItemDatabase database = ItemDatabase.getInstance(application);
        itemDao = database.itemDao();

        allItems = itemDao.getAllItems();
        cyberVulItems = itemDao.getCyberVulItems();
        famousHackersItems = itemDao.getFamousHackersItems();
        famousHacksItems = itemDao.getFamousHacksItems();
        howToProtectItems = itemDao.getHowToProtectItems();

    }

    public void insert(Item item) {
        new InsertItemAsyncTask(itemDao).execute(item);
    }

    public void update (Item item) {
        new UpdateItemAsyncTask(itemDao).execute(item);
    }

    public void delete (Item item) {
        new DeleteItemAsyncTask(itemDao).execute(item);
    }

    public void deleteAllItems () {
        new DeleteAllItemsAsyncTask(itemDao).execute();
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

    //
    private static class InsertItemAsyncTask extends AsyncTask<Item, Void, Void> {
        private ItemDao itemDao;
        private InsertItemAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(Item... items) {
            itemDao.insert(items[0]);
            return null;
        }
    }

    private static class UpdateItemAsyncTask extends AsyncTask<Item, Void, Void> {
        private ItemDao itemDao;
        private UpdateItemAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(Item... items) {
            itemDao.update(items[0]);
            return null;
        }
    }

    private static class DeleteItemAsyncTask extends AsyncTask<Item, Void, Void> {
        private ItemDao itemDao;
        private DeleteItemAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(Item... items) {
            itemDao.delete(items[0]);
            return null;
        }
    }

    private static class DeleteAllItemsAsyncTask extends AsyncTask<Void, Void, Void> {
        private ItemDao itemDao;
        private DeleteAllItemsAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            itemDao.deleteAllItems();
            return null;
        }
    }
}
