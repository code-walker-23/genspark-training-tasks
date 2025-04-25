public class DescendingOrder {
    public static void descendingOrder(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        System.out.println(n);
        descendingOrder(n - 1);
    }
}
