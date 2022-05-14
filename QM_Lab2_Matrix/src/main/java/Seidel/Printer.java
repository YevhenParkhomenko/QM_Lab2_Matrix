package Seidel;

class Printer {
    public static void printColumn (double [] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.printf("x%d: %6.3f\n",i, x[i]);
        }
    }
}
