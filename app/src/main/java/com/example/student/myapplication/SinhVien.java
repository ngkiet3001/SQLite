package com.example.student.myapplication;

public class SinhVien {
    private int ID;
    private String Name;

    public SinhVien(int ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
