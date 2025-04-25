public class StarPrinterAscending {
    public static void printStarsAscending(int j) {
        if (j <= 0) return;
        System.out.print("*");
        printStarsAscending(j - 1);
    }

    public static void printPatternAscending(int i) {
        if (i <= 0) return;
        printPatternAscending(i - 1);
        printStarsAscending(i);
        System.out.println();
    }
}
