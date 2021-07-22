package com.study.designpattern.prototype.v2;

/**
 * 深拷贝示例
 * */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 =  new Person();
        Person p2 = (Person) p1.clone();
        System.out.println(p1==p2);

        p1.location.street="huizhoudadao";
        System.out.println(p2.location.street);
        System.out.println(p1.location == p2.location);
    }
}

class Person implements Cloneable{
    int age = 19;
    int score = 100;
    Location location = new Location("changjinga",450);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.location = (Location)location.clone();
        return p;
    }
}

class Location implements Cloneable{
    String street;
    int roomNo;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }
}
