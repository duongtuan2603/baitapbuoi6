package com.example.baitapbuoi6;

public class Folder {
    int folder_id;
    String folder_name;
    String folder_description;

    public Folder(int folder_id, String folder_name, String folder_description) {
        this.folder_id = folder_id;
        this.folder_name = folder_name;
        this.folder_description = folder_description;
    }

    public int getFolder_id() {
        return folder_id;
    }

    public void setFolder_id(int folder_id) {
        this.folder_id = folder_id;
    }

    public String getFolder_name() {
        return folder_name;
    }

    public void setFolder_name(String folder_name) {
        this.folder_name = folder_name;
    }

    public String getFolder_description() {
        return folder_description;
    }

    public void setFolder_description(String folder_description) {
        this.folder_description = folder_description;
    }
}
