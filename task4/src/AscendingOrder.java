public class AscendingOrder{
    public static void ascendingOrder(int n) {
        if (n == 0) return;
        ascendingOrder(n - 1);
        System.out.println(n);
    }
}
