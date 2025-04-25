public class CombinedOrder {
    public static void combineOrder(int n) {
        if (n == 0) return;
        System.out.println(n);
        combineOrder(n - 1);
        System.out.println(n);
    }
}
