package com.study.designpattern.memento;

import java.io.*;

/**
 * 备忘录模式；记录状态，用于回滚
 * */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        GameRole gameRole = new GameRole(3,"雷神","锤子",0);
        Memeto memeto = new Memeto();
        System.out.println("初始化："+gameRole.toString());
        gameRole.setLevle(60);
        gameRole.setName("温火雷神");
        gameRole.setWeapon("火箭");
        gameRole.setKillNum(200);
        gameRole.setMemeto(memeto);
        System.out.println("中间状态："+gameRole.toString());
        gameRole.setLevle(89);
        gameRole.setName("暴怒雷神");
        gameRole.setWeapon("原子弹");
        gameRole.setKillNum(18956);
        System.out.println("终极状态："+gameRole.toString());
        gameRole = (GameRole) memeto.load();
        System.out.println("返回上个状态："+gameRole.toString());
    }
}

class GameRole implements Serializable {
    int levle;
    String name;
    String weapon;
    int killNum;

    @Override
    public String toString() {
        return levle+";"+name+";"+weapon+";"+killNum+";";
    }

    GameRole(int levle, String name, String weapon, int killNum) {
        this.levle = levle;
        this.name = name;
        this.weapon = weapon;
        this.killNum = killNum;
    }

    public int getLevle() {
        return levle;
    }

    public void setLevle(int levle) {
        this.levle = levle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getKillNum() {
        return killNum;
    }

    public void setKillNum(int killNum) {
        this.killNum = killNum;
    }

    void setMemeto(Memeto memeto) throws IOException {
        memeto.save(this);
    }

    GameRole getMemeto(Memeto memeto) throws IOException, ClassNotFoundException {
        return (GameRole)memeto.load();
    }
}

class Memeto{
    /**将对象写入文件*/
    public void save(Object object) throws IOException {
        File file = new File("C:\\Users\\Lenovo\\Desktop\\gameRole.data");
        ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(file));
        //可以同时写入同个对象
        outStream.writeObject(object);
    }

    public Object load() throws IOException, ClassNotFoundException {
        File file = new File("C:\\Users\\Lenovo\\Desktop\\gameRole.data");
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        //可以同时读出同个对象，读出来的顺序与写入的顺序一致
        return inputStream.readObject();
    }
}
