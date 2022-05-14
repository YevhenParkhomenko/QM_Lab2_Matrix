package Sweep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Sweep.Printer.printLemmaCheck;
import static Sweep.Printer.printResult;
import static java.lang.Math.abs;

public class Sweep {
    private final static int[][] arr = {{2, 4, 0},
                                        {4, 1, 5},
                                        {0, 5, 2}};
    private static final List<Integer> a = new ArrayList<>();
    private static final List<Integer> c = new ArrayList<>();
    private static final List<Integer> b = new ArrayList<>();
    private static final List<Integer> f = new ArrayList<>(Arrays.asList(18, 33, 30));
    private static final List<Double> alpha = new ArrayList<>();
    private static final List<Double> beta = new ArrayList<>();
    private static final double[] x = new double[3];

    public static void runMethod() {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) a.add(arr[i][i - 1]);
            c.add(-arr[i][i]);
            if (i != arr.length - 1) b.add(arr[i][i + 1]);
        }
        findSweepCoefs();
        findResults();
        printResult(x);
        printLemmaCheck();
    }

    static boolean lemmaCheck(){
        for (int i = 0; i < arr.length - 1; i++) {
            if (a.get(i) == 0 || b.get(i) == 0)
                return false;
        }
        if (c.get(arr.length - 1) == 0 || c.get(0) == 0)
            return false;
        a.add(0,0);
        b.add(arr.length - 1, 0);

        for (int i = 0; i < arr.length; i++) {
            if (abs(c.get(i)) < abs(a.get(i)) + abs(b.get(i)))
                return false;
        }

        a.remove(0);
        b.remove(arr.length - 1);
        return true;
    }

    private static void findSweepCoefs(){
        alpha.add((double) b.get(0) / c.get(0));
        beta.add((double) f.get(0) / c.get(0));

        for (int i = 1; i < arr.length - 1; i++) {
            double z = c.get(i) - alpha.get(i - 1) * a.get(i - 1);
            alpha.add(b.get(i) / z);
            beta.add((f.get(i) + a.get(i - 1) * beta.get(i - 1)) / z);
        }
    }

    private static void findResults(){
        x[2] = (f.get(2) + a.get(1)*beta.get(1))/
                (c.get(2) - alpha.get(1)*a.get(1));
        for (int i = arr.length-2; i > -1; i--) {
            x[i] = alpha.get(i) * x[i+1] + beta.get(i);
        }
    }
}