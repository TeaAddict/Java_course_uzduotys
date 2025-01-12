package lt.techin.praktinis;

import java.util.ArrayList;

public class ArraysTask {


    public static void main(String[] args) {
        // Įgyvendikite visus metodus (turi pažaliuoti unit testai)
        // Pateiktas masyvas ir pavyzdys programos patikrinimui. Masyvo elementų reikšmes galite keisti.

        int[] arr = {3, 2, 1, 4, 6, 5};

        int minMark = getMin(arr);
        System.out.printf("Min mark: %d\n", minMark);

    }

    //Metodas turi grąžinti pirmą masyvo elementą
    public static int getFirstElement(int[] arr) {
        //TODO
        return arr[0];
    }

    //Metodas turi grąžinti paskutinį masyvo elementą
    public static int getLastElement(int[] arr) {
        //TODO
        return arr[arr.length - 1];
    }

    //Raskite mažiausią masyvo elementą
    public static int getMin(int[] arr) {
        //TODO
        int smallestEl = arr[0];

        for (int el : arr) {
            if (el > smallestEl) smallestEl = el;
        }
        return smallestEl;
    }

    //Raskite didžiausią masyvo elementą
    public static int getMax(int[] arr) {
        //TODO
        int largestInt = arr[0];

        for (int el : arr) {
            if (el < largestInt) largestInt = el;
        }
        return largestInt;
    }

    //Suskaičiuokite masyvo elementų sumą
    public static int getSum(int[] arr) {
        //TODO
        int sum = 0;

        for (int el : arr) {
            sum += el;
        }
        return sum;
    }

    //Raskite masyvo elementų vidurkį
    public static int getAverage(int[] arr) {
        //TODO
        int avg = 0;

        for (int el : arr) {
            avg += el;
        }
        return avg / arr.length;
    }


    //Suskaičiuokite kiek masyve yra skaičių, didesnių nei duotas skaičius n
    public static int countElements(int[] arr, int n) {
        //TODO
        int count = 0;

        for (int el : arr) {
            if (el > n)
                count += 1;
        }
        return count;
    }

    //Metodas turi grąžinti true, jei masyve yra elementas kurio reikšmė lygi n
    public static boolean contains(int[] arr, int n) {
        //TODO
        int count = 0;

        for (int el : arr) {
            if (el == n)
                return true;
        }
        return false;
    }


    //Raskite elemento kurio reikšmė lygi n paskutinį indeksą
    public static int lastIndexOf(int[] arr, int n) {
        //TODO
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) list.add(i);
        }


        return 0;
    }


}
