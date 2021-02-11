package pl.piterowsky.algorithms.kadane;

import jdk.jfr.Name;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KadaneAlgorithmTest {

    @Test
    @Name("Empty array should have a sum equals 0")
    void testEmptyArray() {
        assertEquals(0, KadaneAlgorithm.kadane(new int[]{}));
    }

    @Test
    @Name("Example array should have a sum of 6 (4 - 1 + 2 + 1)")
    void testExampleArray() {
        assertEquals(6, KadaneAlgorithm.kadane(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}