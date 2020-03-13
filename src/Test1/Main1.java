package Test1;

import java.util.Scanner;

public class Main1 {

    private static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        int size =10;
        int[] array = initArray(size);
        sotrArry(array);
        printArray(array);

    }



    public static int[] initArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i <array.length ; i++) {
            array[i] = (int)(Math.random()*100);
            System.out.print(array[i]+" ");
        }
        return array;
    }

    public static void sotrArry(int[] array) {
        for (int i = 0; i <array.length ; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    private static void printArray(int[] array) {
        System.out.println();
        for (int o:array
        ) {
            System.out.print(o+" ");
        }
    }

}
