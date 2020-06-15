package com.example.hackinginfoapp.roomdatabase;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "item_table")
public class Item {

    @PrimaryKey (autoGenerate = true)
    private int id;

    private String title;

    private String text;

    private String picturename;

    private String fragtype;

    //constructor
    public Item(String title, String text, String picturename, String fragtype) {
        this.title = title;
        this.text = text;
        this.picturename = picturename;
        this.fragtype = fragtype;
    }

    //setter for Database to generate the id
    public void setId(int id) {
        this.id = id;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getPicturename() {
        return picturename;
    }

    public String getFragtype() {
        return fragtype;
    }
}
