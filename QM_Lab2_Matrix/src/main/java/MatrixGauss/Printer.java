package MatrixGauss;

import java.util.List;

import static MatrixGauss.MatrixGauss.mtr;

class Printer {

    public static final void printMatrix(double[][] m) {
        for (double[] doubles : m) {
            for (double aDouble : doubles) {
                System.out.printf("%8.3f", aDouble);
            }
            System.out.println();
        }
    }

    public static final void printColumn(double[] m) {
        for (double v : m) {
            System.out.printf("%8.3f", v);
            System.out.println();
        }
    }

    static final void printList(List<double[][]> list){
        for (double[][] doubles : list) {
            printMatrix(doubles);
        }
    }


    public static void showResult(double[] x, double det, double[][] invMtr) {
        System.out.println("Matrix:");
        printMatrix(mtr);
        System.out.println("");

        System.out.printf("Determinant: %.1f\n",det);
        System.out.println("");

        for (int i = 0; i < x.length; i++) {
            System.out.printf("x%d: %6.3f\n",i, x[i]);
        }
        System.out.println("");

        System.out.println("Inverse of the matrix:");
        printMatrix(invMtr);
    }
}