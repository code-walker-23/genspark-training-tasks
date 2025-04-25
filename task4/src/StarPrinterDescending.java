public class StarPrinterDescending {
    public static void printStarsDescending(int j) {
        if (j <= 0) return;
        System.out.print("*");
        printStarsDescending(j - 1);
    }

    public static void printPatternDescending(int i) {
        if (i <= 0) return;
        printStarsDescending(i);
        System.out.println();
        printPatternDescending(i - 1);
    }
}
