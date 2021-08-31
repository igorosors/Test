package com.company;
import java.util.*;

public class Main {
    static int count = 20;
    private static ArrayList<Double> fill(int k) {
        ArrayList<Double> arrList = new ArrayList<Double>();
        for (int i = 0; i < k; i++)
            arrList.add((double) Math.round(Math.random() * 100) / 100);
        return arrList;
    }

    private static ArrayList<ArrayList<Double>> createAndSort(int n) {
        ArrayList<ArrayList<Double>> arrList = new ArrayList<ArrayList<Double>>();
        LinkedHashSet<Integer> masSize = new LinkedHashSet<Integer>();
        while (masSize.size() < n)
            masSize.add((int) (Math.random() * count + 1));
        Iterator<Integer> it = masSize.iterator();
        int i = 0;
        while (it.hasNext()) {
            int k = it.next();
            arrList.add(fill(k));
            if (i % 2 == 0)
                Collections.sort(arrList.get(i));
            else
                Collections.sort(arrList.get(i), Collections.reverseOrder());
            i++;
        }
        return arrList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.println("Enter a number of arrays");
            while (!sc.hasNextInt()) {
                System.out.println("Input error, try again");
                sc.next();
            }
            if ((n = sc.nextInt()) < 1) {
                System.out.println("The number of an arrays must be greater then zero");
            }
            else
            if (n > count) {
                System.out.println("The number of arrays cannot be greater than max number of array elements (" + count + ")");
            }
            else {
                ArrayList<ArrayList<Double>> arrList = createAndSort(n);
                for (ArrayList<Double> arr : arrList)
                    System.out.println(arr);
            }
        }
        while ((n < 1) || (n > count));
    }
}
