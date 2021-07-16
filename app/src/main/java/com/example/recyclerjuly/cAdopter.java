package com.example.recyclerjuly;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class cAdopter extends RecyclerView.Adapter<cViewHolder> {

    private final ArrayList<Employee> employeeList;
    private final itemClickListener itemClickListener;

    public cAdopter(ArrayList<Employee>employeeList, itemClickListener itemClickListener){
        this.employeeList=employeeList;
        this.itemClickListener=itemClickListener;
    }

    @NonNull
    @Override
    public cViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new cViewHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull cViewHolder holder, int position) {
        Employee employee=employeeList.get(position);
        holder.setData(employee,position);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }


}


