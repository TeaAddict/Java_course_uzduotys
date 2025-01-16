package utils;

import java.util.ArrayList;
import java.util.List;

public class PrimeGenerator {

    public static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int num = 2; // Start checking for primes from 2

        while (primes.size() < n) {
            if (isPrime(num)) {
                primes.add(num);
            }
            num++;
        }

        return primes;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }

        // Check for divisibility by odd numbers from 3 up to the square root of num
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 10; // Change this value to generate a different number of primes
        List<Integer> primes = generatePrimes(n);

        System.out.println("First " + n + " prime numbers:");
        for (int prime : primes) {
            System.out.print(prime + " ");
        }
    }
}