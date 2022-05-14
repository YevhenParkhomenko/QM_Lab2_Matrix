package Seidel;



public class Seidel {
    private static double[][] matrix = {
            {6, 0, 2, 3},
            {0, 4, 2, 1},
            {2, 2, 5, 0},
            {1, 1, 0, 3}
    };

    private static double[] result = {24, 18, 21, 15};
    private static double[] x0 = {0, 0, 0, 0};
    private static double[] x1 = {0, 0, 0, 0};
    private static final double e = 0.001;

    public static void runMethod() {
        while (true) {
            for (int i = 0; i < x1.length; i++) {
                double sum = result[i];
                for (int j = 0; j < x1.length; j++) {
                    if(j!=i){
                        sum -= matrix[i][j]*x1[j];
                    }
                }
                x1[i] = 1.0 / matrix[i][i] * sum;
            }
            if ((Math.abs(x1[0] - x0[0]) < e)
                    && (Math.abs(x1[1] - x0[1]) < e)
                    && (Math.abs(x1[2] - x0[2]) < e)
                    && (Math.abs(x1[3] - x0[3]) < e)) {
                break;
            }
            for (int i = 0; i < x0.length; i++) {
                x0[i] = x1[i];
            }
        }
        Printer.printColumn(x1);
    }
}