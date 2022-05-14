package MatrixGauss;

import java.util.Arrays;

import static MatrixGauss.MatrixGauss.*;

class MPOperations {
    static void addMPToList() {
        MList.add(M);
        PList.add(P);
    }

    static void clearMP() {
        M = Arrays.stream(E).map(double[]::clone).toArray(double[][]::new);
        P = Arrays.stream(E).map(double[]::clone).toArray(double[][]::new);
    }

    static void calcM(int i) {
        M[i][i] = 1 / mtr[i][i];
        double[] column = new double[LENGTH];
        for (int j = i; j < LENGTH; j++) {
            column[j] = mtr[j][i];
        }

        for (int u = i + 1; u < M.length; u++) {
            M[u][i] = -column[u] / column[i];
        }
    }

    static void calcP(int i, int ind) {
        double[] tmp = P[ind];
        P[ind] = P[i];
        P[i] = tmp;
    }
}
