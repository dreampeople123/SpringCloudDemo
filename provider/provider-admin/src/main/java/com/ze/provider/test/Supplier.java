package com.ze.provider.test;

/**
 * @Date 2019/11/28 13:50
 * @Author GaoZien
 * @Desc TODO
 */
@FunctionalInterface
public interface Supplier<T> {
    T get();
}

class Car {
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create (final Supplier<Car> supplier){
        return supplier.get();
    }

    public static void collide(final Car car){
        System.out.println("collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair(){
        System.out.println("Repaired " + this.toString());
    }
}

