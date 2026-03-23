package com.springtest.userapi;

import jakarta.persistence.*;
@Entity
@Table(name = "users")

public class User  {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int age;

    public User() { }

    public User(Integer id, String name, int age){
        this.setId(id);
        this.setName(name);
        this.setAge(age);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        if (id != null && id < 0){
            throw new IllegalArgumentException("ID deve ser maior que zero");
        }
        this.id = id;
    }

    public User(String name, int age){
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if (age < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa.");
        }
        this.age = age;
    }
 }
