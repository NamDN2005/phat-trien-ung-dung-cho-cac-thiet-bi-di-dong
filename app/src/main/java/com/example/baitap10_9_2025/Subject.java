package com.example.baitap10_9_2025;

public class Subject {
    private String name;
    private int credit;

    public Subject(String name, int credit) {
        this.name = name;
        this.credit = credit;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCredit() { return credit; }
    public void setCredit(int credit) { this.credit = credit; }
}
