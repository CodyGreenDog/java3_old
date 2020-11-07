package ru.vitalygolikov.java3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
 *    поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 */
public class Box<T extends Fruit> {

    /*
     * c. Для хранения фруктов внутри коробки можете использовать ArrayList;
     */
    private ArrayList<T> fruits = new ArrayList<>();

    public Box(){ }

    public Box(T[] fruits)
    {
        add(fruits);
    }

    public Box(ArrayList<T> fruits)
    {
        add(fruits);
    }

    /*
     * d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного
     *    фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
     */
    public float getWeight()
    {
        float weight = 0.f;

        for(T fruit : fruits)
        {
            weight += fruit.getWeight();
        }

        return weight;
    }

    /*
     * e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
     *    которую подадут в compare в качестве параметра, true - если их веса равны, false в противном
     *    случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
     */
    public boolean compare(Box<T> box)
    {
        return this.getWeight() == box.getWeight();
    }


    /*
     * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую
     *    коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
     *    соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты,
     *    которые были в этой коробке;
     */
    public void pourOut(Box<T> box)
    {
        box.add( fruits );
        fruits.clear();
    }

    /*
     * g. Не забываем про метод добавления фрукта в коробку.
     */
    public void add(T fruit)
    {
        fruits.add(fruit);
    }

    public void add(ArrayList<T> fruits)
    {
        this.fruits.addAll(fruits);
    }

    public void add(T[] fruits)
    {
        this.fruits.addAll(Arrays.asList(fruits) );
    }
}
