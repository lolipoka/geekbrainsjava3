package ru.geekbrains.java3.lesson1;

import java.util.ArrayList;

public class FruitsDemo {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        for (int i = 0; i < 6; i++) {
            appleBox.add(new Apple());
        }
        System.out.printf("The weight of the box of apples is %.1f\n", appleBox.getWeight());

        Box<Orange> orangeBox = new Box<>();
        for (int i = 0; i < 4; i++) {
            orangeBox.add(new Orange());
        }
        System.out.printf("The weight of the box of oranges is %.1f\n", appleBox.getWeight());

        System.out.printf("The box of apples has the same weight as the box of oranges: %b\n\n", appleBox.compare(orangeBox));

        Box<Apple> otherAppleBox = new Box<>();
        System.out.printf("Weight of empty new box of apples: %.1f\n", otherAppleBox.getWeight());
        System.out.printf("Weight of old box of apples before moving: %.1f\n\n", appleBox.getWeight());
        appleBox.move(otherAppleBox);
        System.out.printf("Weight of filled new box of apples: %.1f\n", otherAppleBox.getWeight());
        System.out.printf("Weight of old box of apples after moving: %.1f\n", appleBox.getWeight());

//        Box<Orange> otherOrangeBox = new Box<>();
//        appleBox.move(otherOrangeBox); // won't compile
    }
}

abstract class Fruit {
    public abstract float getWeight();
}

class Apple extends Fruit {
    @Override
    public float getWeight() {
        return 1.0f;
    }
}

class Orange extends Fruit {
    @Override
    public float getWeight() {
        return 1.5f;
    }
}

class Box<T extends Fruit> {
    private final ArrayList<T> box = new ArrayList<>();

    public void add(T fruit) {
        box.add(fruit);
    }

    public float getWeight() {
        float weight = 0;
        for (T fruit : box) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> otherBox) {
        return getWeight() == otherBox.getWeight();
    }

    public void move(Box<T> otherBox) {
        /* Т.к. элементы ArrayList смещаются при удалении, то при использовании цикла foreach возникает исключение,
        *  а при использовании прямого порядка итерации в цикле for половина содержимого не будет перемещена.
        *  Можно было бы использовать box.forEach(otherBox::add) и box.clear(), но это не соответствует
        *  реальному перемещению фруктов из одной коробки в другую. */
        for (int i = box.size() - 1; i >= 0; i--) {
            T t = box.get(i);
            otherBox.add(t);
            box.remove(t);
        }
    }
}