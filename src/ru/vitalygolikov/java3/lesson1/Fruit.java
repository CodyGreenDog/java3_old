package ru.vitalygolikov.java3.lesson1;

/*
 * a. Есть классы Fruit -> Apple, Orange;
 */
public class Fruit {
    private final float WEIGHT;

    public Fruit(float weight)
    {
        WEIGHT = weight;
    }

    public float getWeight() {
        return WEIGHT;
    }
}

class Apple extends Fruit {
    public static final float WEIGHT = 1.f;

    Apple(){
        super(WEIGHT);
    }
}

class Orange extends Fruit {
    private static final float WEIGHT = 1.5f;

    Orange(){
        super(WEIGHT);
    }

}