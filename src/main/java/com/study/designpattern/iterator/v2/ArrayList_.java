package com.study.designpattern.iterator.v2;

public class ArrayList_ implements Collection_ {

    public static void main(String[] args) {
        ArrayList_ arrayList_=new ArrayList_();
        for (int i = 0; i < 15; i++) {
            arrayList_.add("$"+i);
        }
        System.out.println("size:"+arrayList_.size());
    }

    Object[] object;
    int size=0;

    public ArrayList_() {
        object = new Object[10];
    }

    public void add(Object o){
        if (size<object.length){
            object[size]=o;
        }else{
            Object[] newObject = new Object[object.length+2];
            System.arraycopy(object,0,newObject,0,object.length);
            object = newObject;
            object[size]=o;
        }
        size++;
    }

    public int size(){
        return size;
    }

    public Iterator_ iterator(){
        return new ArrayListIterator();
    }

    class ArrayListIterator implements Iterator_{
        private int offset = 0;
        @Override
        public boolean hasNext() {
            if(offset<size)
                return true;
            return false;
        }

        @Override
        public Object next() {
            Object o = object[offset];
            offset ++;
            return o;
        }
    }
}
