package pl.piterowsky.algorithms.kadane;

public class KadaneAlgorithm {

    private KadaneAlgorithm() {
    }

    /**
     * Finds maximum subarray sum using Kadane's algorithm
     *
     * @param arr target array
     * @return biggest subarray sum
     */
    public static int kadane(int[] arr) {
        var bestSum = 0;
        var currentSum = 0;
        for (var x : arr) {
            currentSum = Math.max(0, currentSum + x);
            bestSum = Math.max(bestSum, currentSum);
        }
        return bestSum;
    }

}
