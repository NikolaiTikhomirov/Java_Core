/**
Написать метод, возвращающий количество чётных элементов массива. countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
Написать метод, возвращающий разницу между самым большим и самым маленьким элементами переданного не пустого массива.
Написать метод, возвращающий истину, если в переданном массиве есть два соседних элемента, с нулевым значением.

ЛИБО задания по игре Крестики-нолики

Оптимизировать проверку победы, используя циклы 2*. Добавить логику ходов для компьютера - либо выбирать наиболее успешный ход, либо "перебивать" соперника, либо и то и другое 3**. Реализовать проверку победы для квадратного поля произвольного размера.
Любые улучшения на Ваш вкус
*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int [] array = {1, -45, 0, 0, 4, 9, 7, 2, 47};
        int [] nullArr = {};

        System.out.println(countEvens(array));
        System.out.println(findMaxArrayElement(array));
        System.out.println(findMinArrayElement(array));
        System.out.println(diffBetweenMinAndMaxArrayElements(array));
        System.out.println(diffBetweenMinAndMaxArrayElements(nullArr));
        System.out.println(isTwoZeroElementsNearbyEachOver(array));
    }

    /**метод, возвращающий количество чётных элементов массива*/
    static int countEvens (int [] arr) {
        int res = 0;
        for (int element : arr) {
            if (element % 2 == 0) {
                res++;
            }
        }
        return res;
    }
    
    /**метод поиска минимального элемента в массиве*/
    static int findMinArrayElement (int [] arr){
        int min = arr [0];
        for (int i : arr) {
            if(i < min){
                min = i;
            }
        }
        return min;
    }

    /**метод поиска максимального элемента в массиве*/
    static int findMaxArrayElement (int [] arr){
        int max = arr [0];
        for (int i : arr) {
            if(i > max){
                max = i;
            }
        }
        return max;
    }
    
    /**метод, возвращающий разницу между самым большим и самым маленьким элементами переданного не пустого массива*/
    static int diffBetweenMinAndMaxArrayElements (int [] arr){
        int res = -1;
        if (arr.length != 0){
            res = findMaxArrayElement(arr) - findMinArrayElement(arr);
        }
        return res;
    }

    /**метод, возвращающий истину, если в переданном массиве есть два соседних элемента, с нулевым значением*/
    static boolean isTwoZeroElementsNearbyEachOver (int [] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0 && arr[i + 1] == 0){
                return true;
            }
        }
        return false;
    }
}