package com.example.baitapbuoi6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.ViewHolder> {
    List<Folder> mFolder;
    MainActivity context;

    public FolderAdapter(List<Folder> mFolder, MainActivity context) {
        this.mFolder = mFolder;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View folderview = inflater.inflate(R.layout.layout_eachrow,parent,false);
        return new ViewHolder(folderview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Folder folder = mFolder.get(position);
        holder.eachfoldername.setText(folder.getFolder_name());
        holder.eachfolderdescription.setText(folder.getFolder_description());
        holder.position = position;
        holder.folder = folder;
    }

    @Override
    public int getItemCount() {
        return mFolder.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView eachfoldername;
        TextView eachfolderdescription;
        Folder folder;
        int position;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eachfoldername = (TextView) itemView.findViewById(R.id.txteachfoldername);
            eachfolderdescription = (TextView) itemView.findViewById(R.id.txteachfolderdescription);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.navigate(position,folder.getFolder_name(),folder.getFolder_description());
                }
            });

        }
    }
}
