package org.example;

public class Utils {
    public static long gcd (long a, long b) {
        //Euclidean_algorithm
        /*if (a == 0)
            return b;
        return gcd(b % a, a);*/
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;

    }
}
