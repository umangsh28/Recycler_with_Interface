package com.example.recyclerjuly;

public class Employee {

    private String name;
    private int age;
    private String address;
    private boolean okay;

    public Employee(String name,int age,String address,boolean okay){
        this.name=name;
        this.age=age;
        this.address=address;
        this.okay=okay;
    }

    public String  getname(){
        return  name;
    }
    public int getAge(){
        return age;
    }
    public String getAddress(){
        return address;
    }
    public Boolean isok(){
        return okay;
    }

}
