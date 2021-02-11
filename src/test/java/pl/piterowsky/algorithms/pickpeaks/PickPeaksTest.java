package pl.piterowsky.algorithms.pickpeaks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PickPeaksTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    void parametrizedTest(int[] array, int[] posS, int[] peaksS) {
        Map<String, List<Integer>> expected = new HashMap<>() {{
            put("pos", Arrays.stream(posS).boxed().collect(Collectors.toList()));
            put("peaks", Arrays.stream(peaksS).boxed().collect(Collectors.toList()));
        }};
        Map<String, List<Integer>> actual = PickPeaks.getPeaks(array);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 6, 4, 1, 2, 3, 2, 1},
                        new int[]{3, 7}, new int[]{6, 3}),
                Arguments.of(new int[]{3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3},
                        new int[]{3, 7}, new int[]{6, 3}),
                Arguments.of(new int[]{3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 2, 2, 1},
                        new int[]{3, 7, 10}, new int[]{6, 3, 2}),
                Arguments.of(new int[]{2, 1, 3, 1, 2, 2, 2, 2, 1}, new int[]{2, 4},
                        new int[]{3, 2}),
                Arguments.of(new int[]{2, 1, 3, 1, 2, 2, 2, 2},
                        new int[]{2}, new int[]{3})
        );
    }

}