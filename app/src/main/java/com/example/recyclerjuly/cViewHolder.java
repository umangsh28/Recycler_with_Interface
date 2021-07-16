package com.example.recyclerjuly;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class cViewHolder extends RecyclerView.ViewHolder {
    private TextView mtvName;
    private TextView mtvage;
    private ImageView mtvEdit;
    private TextView mtvaddress;
    itemClickListener itemClickListener;
    private LinearLayout linearLayout;

    public cViewHolder(@NonNull  View itemView, itemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initData(itemView);
    }

    private void initData(View itemView) {
        mtvName=itemView.findViewById(R.id.tvName);
        mtvage=itemView.findViewById(R.id.tvAge);
        mtvEdit=itemView.findViewById(R.id.ivEdit);
        mtvaddress=itemView.findViewById(R.id.tvAddress);
        linearLayout=itemView.findViewById(R.id.linear1);
    }

    public void setData(Employee employee,int po){
        mtvName.setText(employee.getname());
        mtvage.setText(employee.getAge() +" ");
        mtvaddress.setText(employee.getAddress()  );



        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(employee.isok()){
                    linearLayout.setBackgroundColor(ContextCompat.getColor(linearLayout.getContext(),R.color.purple_200));
                }else{
                    linearLayout.setBackgroundColor(ContextCompat.getColor(linearLayout.getContext(),R.color.black));
                }
                itemClickListener.onitemClicked(getAdapterPosition(),employee);
            }
        });
    }


}

