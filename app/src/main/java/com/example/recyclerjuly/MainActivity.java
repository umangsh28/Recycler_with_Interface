package com.example.recyclerjuly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements itemClickListener{

    private final ArrayList<Employee>employeeList=new ArrayList<>();
    private RecyclerView recyclerView;
    private CardView mEditcardView;
    private EditText mEtName;
    private EditText mEtAge;
    private EditText mEtAddress;
    private Button mBtnDone;
    private cAdopter employeeAdopter;
    private LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildEmployeeList();
        setRecyclerView();
    }

    private void setRecyclerView() {
        employeeAdopter=new cAdopter(employeeList,this );
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager((this));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(employeeAdopter);
    }

    private void buildEmployeeList() {
        for(int i=0;i<50;i++){
            Employee employee=new Employee("umang",i+1,"lalbangla"+i,false);
            employeeList.add(employee);

        }
    }

    private void initViews() {
        recyclerView=findViewById(R.id.recyclerView);
        mEditcardView =findViewById(R.id.editCardView);
        mEtName=findViewById(R.id.etName);
        mEtAge=findViewById(R.id.etAge);
        mEtAddress=findViewById(R.id.etAddress);
        mBtnDone=findViewById(R.id.btnDone);
        linearLayout=findViewById(R.id.Linear);

    }




    @Override
    public void onitemClicked(int position, Employee employee) {
        Employee updatem;
        if(employee.isok()){
            updatem=new Employee(employee.getname(),employee.getAge(),employee.getAddress(),false);
        }else{
            updatem=new Employee(employee.getname(),employee.getAge(),employee.getAddress(),true);
        }
        employeeList.set(position,updatem);
        employeeAdopter.notifyDataSetChanged();

    }
}