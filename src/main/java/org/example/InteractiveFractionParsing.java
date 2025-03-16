package org.example;
import java.util.Scanner;

public class InteractiveFractionParsing {
    public static Scanner Input = new Scanner(System.in);
    public static void main(String[] args) {
        int opakovac = 1;
        try{
            while(opakovac == 1) {
                try{
                    System.out.println("write fractions to add together: ");
                    String fraction = Input.next();
                    Fraction output = Fraction.parse(fraction);
                    System.out.println(output);
                } catch (NumberFormatException e) {
                    System.out.println("This is not a number");
                }
                System.out.println("");
                opakovac = Integer.parseInt(System.console().readLine("do you want to continue? [1=yes, 0=no]: "));
                if ((opakovac != 0) && (opakovac != 1)) {
                    System.out.println("This was not an option, program is ending");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("This was not an option, program is ending");
        }
    }
}
