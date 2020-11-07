package ru.vitalygolikov.java3.lesson1;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class HomeworkApp {

    private static final int FRUIT_VAL = 10;

    public static void main(String[] args)
    {
        Integer[] arr = {2, 4, 6, 12, 5, 7, 42, 8, 10, 18, 200, 35};
        System.out.println("Исходный массив");
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i].intValue() + " ");
        }
        System.out.println();

        ArrayUtills<Integer> arrayUtills = new ArrayUtills<>();

        //Задание 1. Метод, который меняет два элемента массива местами
        /*-------------------------------------------------------------*/
        int idx1 = 4;
        int idx2 = 7;

        System.out.println("1. Метод, который меняет местами два элемента массива");
        System.out.println("Первоначально:\nИндексы idx1 = " + idx1 + ", idx2 = " + idx2);
        System.out.println("Соответствующие значения arr[" + idx1 + "] = " + arr[idx1] +
                ", arr[" + idx2 + "] = " + arr[idx2] + "\n");


        int status = arrayUtills.swapElements( arr, 4, 7);
        if(status == ArrayUtills.SUCCESS)
        {
            //print results
            System.out.println("В результате работы метода swapElements:");
            System.out.println("Соответствующие значения arr[" + idx1 + "] = " + arr[idx1] +
                    ", arr[" + idx2 + "] = " + arr[idx2] + "\n\nИтоговый массив:");
            for(int i = 0; i < arr.length; i++)
            {
                System.out.print(arr[i].intValue() + " ");
            }
            System.out.println("\n");
        }
        /*-------------------------------------------------------------*/


        //Задание 2. Приведение массива к ArrayList
        /*--------------------------------------------------------------*/
        ArrayList<Integer> arrayList = arrayUtills.arrayToArrayList(arr);
        System.out.println("2. Содержимое arrayList\n" + arrayList.toString());
        /*--------------------------------------------------------------*/


        /*
         * 3. Большая задача с фруктами и коробками
         */
        /*-----------------------------------------------------------------*/
        System.out.println("\nЗадание 3");
        Apple[] apples = new Apple[FRUIT_VAL];
        Orange[] oranges = new Orange[FRUIT_VAL];

        initFruitArrays(apples, oranges);

        Box<Apple> appleBox = new Box<>(apples);
        Box<Orange> orangeBox = new Box<>(oranges);

        System.out.println("Количество фруктов в каждом ящике " + FRUIT_VAL );
        System.out.println("Вес ящика с яблоками = " + appleBox.getWeight());
        System.out.println("Вес ящика с апельсинами = " + orangeBox.getWeight());

        Box<Apple> newAppleBox = new Box<>(apples);

        System.out.println("Сравнение двух ящиков с яблоками. Результат: " + appleBox.compare(newAppleBox));

        Box<Orange> newOrangeBox = new Box<>();

        orangeBox.pourOut( newOrangeBox );

        System.out.println("Пересыпали из orangeBox в newOrangeBox; результат:\norangeBox = " + orangeBox.getWeight()
         + ", newOrangeBox = " + newOrangeBox.getWeight());

        /*----------------------------------------------------------------*/
    }

    private static void initFruitArrays(Apple[] apples, Orange[] oranges)
    {
        for(int i = 0; i < FRUIT_VAL; i++ )
        {
            apples[i] = new Apple();
            oranges[i] = new Orange();
        }
    }

}


class ArrayUtills<T>
{
    public static final int SUCCESS = 0;
    public static final int ERROR_OUT_OF_BOUNDS = 1;
    /*
     * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
     */

    public int swapElements(T[] arr, int idx1, int idx2)
    {
        if( idx1 == idx2 ) {return SUCCESS;}

        if(idx1 < 0 || idx1 >= arr.length ||
               idx2 < 0 || idx2 >= arr.length )
        {
            System.out.println("Error: index is out of bounds");
            return ERROR_OUT_OF_BOUNDS;
        }

        T tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;

        return SUCCESS;
    }


    /*
     * 2. Написать метод, который преобразует массив в ArrayList;
     */
    public ArrayList<T> arrayToArrayList(T[] arr)
    {
        return new ArrayList<T>( Arrays.asList(arr) );
    }


}


