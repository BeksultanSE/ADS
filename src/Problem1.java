public class Problem1 {
    public static int Min(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            min = Integer.min(min, j);
        }
        return min;
    }
}
