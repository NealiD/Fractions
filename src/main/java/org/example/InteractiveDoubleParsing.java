package org.example;

public class InteractiveDoubleParsing {
    public static void main(String[] args) {
        int opakovac = 1;
        try {
            while(opakovac == 1) {
                try{
                    double number = Double.parseDouble(System.console().readLine("Please, write a number: "));
                    System.out.println("you wrote: " + number);
                } catch (NumberFormatException e) {
                    System.out.println("This is not a number");
                }
                System.out.println("");
                opakovac = Integer.parseInt(System.console().readLine("do you want to continue? [1=yes] [0=no]: "));
            }
        } catch (NumberFormatException e) {
            System.out.println("This was not an option, program is ending");
        }

    }
}
