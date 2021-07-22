package com.study.designpattern.builder;
/**
 * 复杂对象分类构建
 *
 * */
public class Main {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .basicBuild("",175,70)
                //.locBuild(100,700)
                .scoreBuild(100)
                .build();
    }
}

class Person{
    String name;
    int height;
    int weight;
    Location location;
    int score;
    public static class PersonBuilder{
        Person person = new Person();
        public PersonBuilder basicBuild(String name,int height,int weight){
            person.name=name;
            person.height=height;
            person.weight=weight;
            return this;
        }

        public PersonBuilder locBuild(int x,int y){
            person.location = new Location(x,y);
            return this;
        }

        public PersonBuilder scoreBuild(int score){
            person.score = score;
            return this;
        }

        Person build(){
            return person;
        }
    }
}

class Location{
    int x;
    int y;

    public Location(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
