import MatrixGauss.MatrixGauss;
import Seidel.Seidel;
import Sweep.Sweep;

import java.util.Scanner;

public class Main {
    private static final String METHOD_CHOICE = """
            Which method would you like to test?
            1. Gauss method with matrices
            2. Sweep method
            3. Seidel method
                        
            The chosen method is: """;
    public static void main(String[] args) {
        System.out.print(METHOD_CHOICE);
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        System.out.println("");
        switch (choice) {
            case (1) -> MatrixGauss.runMethod();
            case (2) -> Sweep.runMethod();
            case (3) -> Seidel.runMethod();
        }
    }
}
