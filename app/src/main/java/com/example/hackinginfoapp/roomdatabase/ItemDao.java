package com.example.hackinginfoapp.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
//Data Access Object interface to handle SQLite operations on DB
@Dao
public interface ItemDao {
    @Insert
    void insert (Item item);

    @Update
    void update (Item item);

    @Delete
    void delete (Item item);

    @Query("DELETE FROM item_table")
    void deleteAllItems();

    @Query("SELECT * FROM item_table")
    LiveData<List<Item>> getAllItems();

    @Query("SELECT * FROM item_table WHERE fragtype IS  'cybervuls' ")
    LiveData<List<Item>> getCyberVulItems();

    @Query("SELECT * FROM item_table WHERE fragtype LIKE  'famoushackers' ")
    LiveData<List<Item>> getFamousHackersItems();

    @Query("SELECT * FROM item_table WHERE fragtype IS  'famoushacks' ")
    LiveData<List<Item>> getFamousHacksItems();

    @Query("SELECT * FROM item_table WHERE fragtype IS  'howtoprotect' ")
    LiveData<List<Item>> getHowToProtectItems();
}
