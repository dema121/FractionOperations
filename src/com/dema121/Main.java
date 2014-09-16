package com.dema121;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        writeHeader();
        boolean exit = false;
        while (!exit) {
            System.out.print("\nOperation to do: ");
            char choose = scanIn.nextLine().charAt(0);

            switch (choose) {
                case 'a':
                    System.out.println("Insert a list of fractions to sum");
                    System.out.println("Syntax is: numerator/denominator");
                    System.out.println("When you've inserted all type c");
                    boolean finished = false;
                    ArrayList<Fraction> fractionList = new ArrayList<Fraction>();
                    do {
                        String line = scanIn.nextLine();
                        if (line.equals("c"))
                            finished = true;
                        else {
                            Fraction fraction = new Fraction(Integer.valueOf(line.split("/")[0]), Integer.valueOf(line.split("/")[1]));
                            fractionList.add(fraction);
                        }
                    } while (!finished);
                    if (fractionList.isEmpty()) {
                        System.out.println("You've not entered anything");
                    } else {
                        Fraction resultFraction = Fraction.sumFractions(fractionList);
                        System.out.println("The sum value is: " + resultFraction);
                    }
                    break;
                case 's':
                    System.out.println("Insert a fractions to simplify");
                    System.out.println("Syntax is: numerator/denominator");
                    String line = scanIn.nextLine();
                    Fraction fraction = new Fraction(Integer.valueOf(line.split("/")[0]), Integer.valueOf(line.split("/")[1]));
                    fraction.simplify();
                    System.out.println("The simplified fraction is: " + fraction.toString());
                    break;
                case 'e':
                    exit = true;
                    break;
            }
        }
        scanIn.close();
    }

    private static void writeHeader() {
        System.out.println(" Fraction operations - by dema121 ");
        System.out.println("---------------------------------");
        System.out.println(" Type:");
        System.out.println("   a to sum fractions");
        System.out.println("   s to simplify a fraction");
        System.out.println("   e to exit");
        System.out.println("_________________________________\n");
    }
}
