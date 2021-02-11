package pl.piterowsky.algorithms.pickpeaks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class PickPeaks {

    private PickPeaks() {
    }

    /**
     * Finds all local maxima (peaks) in numeric array
     *
     * @param arr numeric array
     * @return {@link Map} of two 'pos' and 'peaks' {@link List}
     */
    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        var pos = new ArrayList<Integer>();
        var peaks = new ArrayList<Integer>();
        IntStream.range(0, arr.length).forEach((int index) -> {
            if (index == 0 || index == arr.length - 1 || arr[index - 1] >= arr[index] || arr[index] < arr[index + 1]) {
                return;
            }
            if (arr[index] == arr[index + 1]) {
                var isPeak = false;
                for (var i = index; i < arr.length - 1; i++) {
                    if (arr[i + 1] != arr[i]) {
                        isPeak = arr[i + 1] < arr[i];
                        break;
                    }
                }
                if (!isPeak) return;
            }
            pos.add(index);
            peaks.add(arr[index]);
        });
        return Map.of("pos", pos, "peaks", peaks);
    }

}
