package com.example.baitapbuoi6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;
    RecyclerView recyclerView;
    ArrayList<Folder> folders = new ArrayList<Folder>();
    FolderAdapter adapter;
    int editposition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new Database(this,"foldermanager.sqlite",null,1);
        database.QueryData("CREATE TABLE IF NOT EXISTS Folder(ID_Folder INTEGER PRIMARY KEY AUTOINCREMENT, Folder_Name VARCHAR(200), Folder_Description VARCHAR(500))");
        database.QueryData("INSERT INTO Folder VALUES(null,'Tổng hợp tin tức thời sự','Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo hiện nay')");
        database.QueryData("INSERT INTO Folder VALUES(null,'Do it yourself','Sơn tùng MTP quá đẹp trai hát hay')");
        database.QueryData("INSERT INTO Folder VALUES(null,'Cảm hứng sáng tạo','Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo hiện nay')");
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new FolderAdapter(folders,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        getdata();



    }
    private void getdata(){
        Cursor cursor = database.GetData("SELECT * FROM Folder");
        folders.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String foldername = cursor.getString(1);
            String folderdescription = cursor.getString(2);
            folders.add(new Folder(id,foldername,folderdescription));
        }
        adapter.notifyDataSetChanged();
    }
    public void navigate(int position,String foldername,String folderdescription){
        editposition = position;
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        Bundle bundle = new Bundle();
        bundle.putString("folder name",foldername);
        bundle.putString("folder description",folderdescription);
        intent.putExtras(bundle);
        startActivityForResult(intent,10,bundle);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==10&&resultCode==RESULT_OK){
                String editedfoldername = data.getExtras().getString("Edited Folder Name");
                String editedfolderdescription = data.getExtras().getString("Edited Folder Description");
                database.QueryData("UPDATE Folder SET Folder_Name = '"+editedfoldername+"' WHERE ID_Folder = '"+(editposition+1)+"'");
                database.QueryData("UPDATE Folder SET Folder_Description = '"+editedfolderdescription+"' WHERE ID_Folder = '"+(editposition+1)+"'");
                getdata();


        }
    }
}