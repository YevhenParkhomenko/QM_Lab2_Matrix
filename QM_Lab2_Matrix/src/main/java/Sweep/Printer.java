package Sweep;

class Printer {

    static void printLemmaCheck() {
        if (Sweep.lemmaCheck()){
            System.out.println("Fortunately, the lemma holds true.");
        } else {
            System.out.println("Unfortunately, the lemma doesn't hold true.");
        }
    }

    static void printResult(double[] x){
        for (int i = 0; i < x.length; i++) {
            System.out.printf("x%d: %.1f%n", i, x[i]);
        }
    }
}
