public class NumberPyramid {
    public static void printCounting(int j) {
        if (j <= 0) return;
        printCounting(j - 1);
        System.out.print(j + " ");
    }

    public static void printPatternNumberPyramid(int i) {
        if (i <= 0) return;
        printPatternNumberPyramid(i - 1);
        printCounting(i);
        System.out.println();
    }
}
