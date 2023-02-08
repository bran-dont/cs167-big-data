package org.example;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Error: At least three parameters expected, from, to, and base.");
            System.exit(1);
        }

        if (args[2].equals("2")) {
            printEvenNumbers(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        } else if(args[2].equals("3")) {
            printNumbersDivisibleByThree(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        } else {
            System.out.printf("Unexpected argument %s", args[2]);
            System.exit(1);
        }
    }

    public static void printEvenNumbers(int from, int to) {
        System.out.printf("Printing numbers in the range [%d,%d]\n", from, to);

        for (int i = from; i <= to; i++) {
            if (i % 2 == 0) System.out.printf("%d\n", i);
        }
    }

    public static void printNumbersDivisibleByThree (int from, int to) {
        System.out.printf("Printing numbers in the range [%d,%d]\n", from, to);

        for (int i = from; i <= to; i++) {
            if (i % 3 == 0) System.out.printf("%d\n", i);
        }
    }
}

static class IsEven implements Function<Integer, Boolean> {
    @Override
    public Boolean apply(Integer x) {
        return x % 2 == 0;
    }
}