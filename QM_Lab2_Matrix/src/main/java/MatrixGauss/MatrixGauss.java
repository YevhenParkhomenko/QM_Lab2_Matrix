package MatrixGauss;

import java.util.*;

import static MatrixGauss.MPOperations.*;
import static MatrixGauss.Multiplication.multiply;

public class MatrixGauss {
    static final double[][] E = {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
    };
    static double[][] mtr = {
            {5, 2, 1, 0},
            {1, 3, 2, 8},
            {4, -6, 1, 0},
            {5, 0, 3, 2}
    };

    static final int LENGTH = mtr.length;
    private static double[] b = {15, 58, -10 ,27};
    private static double det;
    private static double[][] InvMtr;
    private static double[] x = new double[LENGTH];

    private static double[][] Ei = E;
    private static int prmtCount = 0;
    private static final double[] leadElem = new double[LENGTH];

    static double[][] M;
    static double[][] P;
    static final List<double[][]> MList = new ArrayList<>();
    static final List<double[][]> PList = new ArrayList<>();

    public static void runMethod() {
        for (int i = 0; i < LENGTH; i++) {
            clearMP();
            int ind = findLeadElem(i);

            if (ind != i) {
                calcP(i, ind);
                prmtCount++;
            }
            calcM(i);

            addMPToList();
            calcNewMtr();
            calcNewB();
        }
        calcX();
        calcDet();
        calcInvMtr();
        Printer.showResult(x, det, InvMtr);
    }

    private static void calcX() {
    x = backStroke(mtr, b);
    }

    private static void calcDet() {
        det = Math.pow(-1, prmtCount);
        for (double v : leadElem) {
            det *= v;
        }
    }

    private static void calcInvMtr() {
        for (int i = 0; i < PList.size(); i++) {
            Ei = multiply(PList.get(i), Ei);
            Ei = multiply(MList.get(i), Ei);
        }

        InvMtr = new double[LENGTH][LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            double[] b1 = new double[LENGTH];
            for (int j = 0; j < LENGTH; j++) {
                b1[j] = Ei[j][i];
            }
            b1 = backStroke(mtr, b1);
            for (int j = 0; j < LENGTH; j++) {
                InvMtr[j][i] = b1[j];
            }
        }
    }

    private static void calcNewMtr() {
        mtr = multiply(P, mtr);
        mtr = multiply(M, mtr);
    }

    private static void calcNewB() {
        b = multiply(P, b);
        b = multiply(M, b);
    }

    private static int findLeadElem(int i) {
        int ind = i;
        double max = mtr[i][i];
        for (int j = i; j < LENGTH; j++) {
            if (max < mtr[j][i]) {
                max = mtr[j][i];
                ind = j;
            }
        }
        leadElem[i] = max;
        return ind;
    }

        private static double[] backStroke(double[][] m, double[] b1) {
        double[] res = new double[b1.length];
        for (int i = m.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < m.length; j++) {
                b1[i] = b1[i] - m[i][j] * res[j];
            }
            res[i] = b1[i];
        }
        return res;
    }
}