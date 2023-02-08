package edu.ucr.cs.cs167.btran117;

import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class App 
{
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

    static class IsEven implements Function<Integer, Boolean> {
        @Override
        public Boolean apply(Integer x) {
            return x % 2 == 0;
        }
    }

    static class IsDivisibleByThree implements Function<Integer, Boolean> {
        @Override
        public Boolean apply(Integer x) {
            return x % 3 == 0;
        }
    }

    public static void printNumbers(int from, int to, Function<Integer, Boolean> filter) {
        System.out.printf("Printing numbers in the range [%d,%d]\n", from, to);
        for (int i = from; i <= to; i++) {
            if(filter.apply(i)) {
                System.out.printf("%d\n", i);
            }
        }
    }

    public static Function<Integer, Boolean> combineWithAnd(Function<Integer, Boolean> ... filters) {
        return new Function<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer x) {
                for(Function<Integer, Boolean> f : filters) {
                    if(!f.apply(x)) {
                        return false;
                    }
                }
                return true;
            }
        };
    }

    public static Function<Integer, Boolean> combineWithOr(Function<Integer, Boolean> ... filters) {
        return new Function<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer x) {
                for(Function<Integer, Boolean> f : filters) {
                    if(f.apply(x)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    public static void main( String[] args )
    {
        if (args.length < 3) {
            System.out.println("Error: At least three parameters expected, from, to, and base.");
            System.exit(1);
        }
        int beg = Integer.parseInt(args[0]);
        int end = Integer.parseInt(args[1]);

        //int base = Integer.parseInt(args[2]);
        String[] bases;
        boolean v = false;
        if(args[2].contains("v")) {
            bases = args[2].split("v");
            v = true;
        } else {
            bases = args[2].split(",");
        }
        //String[] bases = args[2].split(",");
        Function<Integer, Boolean>[] filters = new Function[bases.length];
        for(int i = 0; i < bases.length; i++) {
            int finalI = i;
            filters[i] = x -> x % Integer.parseInt(bases[finalI]) == 0;
        }
        if(v) {
            printNumbers(beg, end, combineWithOr(filters));
        }
        else {
            printNumbers(beg, end, combineWithAnd(filters));
        }

        //Function<Integer, Boolean> divisibleByBase = x -> x % base == 0;
        //printNumbers(beg, end, divisibleByBase);

//
//        Function<Integer, Boolean> IsDivisibleByFive = new Function<Integer, Boolean>() {
//            @Override
//            public Boolean apply(Integer x) {
//                return x % 5 == 0;
//            }
//        };
//        Function<Integer, Boolean> IsDivisibleByTen = x -> x % 10 == 0;
//
//        if (args[2].equals("2")) {
//            // Using non-static method
//            // printEvenNumbers(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
//
//            // Using static method
//            Function<Integer, Boolean> IsEven = x -> new IsEven().apply(x);
//            printNumbers(beg, end, IsEven);
//        } else if(args[2].equals("3")) {
//            // non-static
//            // printNumbersDivisibleByThree(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
//
//            // static
//            Function<Integer, Boolean> IsDivisibleByThree = x -> new IsDivisibleByThree().apply(x);
//            printNumbers(beg, end, IsDivisibleByThree);
//        } else if(args[2].equals("5")) {
//            printNumbers(beg, end, IsDivisibleByFive);
//        } else if(args[2].equals("10")) {
//            printNumbers(beg, end, IsDivisibleByTen);
//        } else {
//            System.out.printf("Unexpected argument %s", args[2]);
//            System.exit(1);
//        }
    }
}

