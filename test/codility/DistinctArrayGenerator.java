package codility;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class DistinctArrayGenerator {

    @Test
    public void test01() {

    }

    public int[] solution(int N) {
        // write your code in Java SE 8

        Set<Integer> result = new HashSet<>();
        Integer halfNumber = N / 2;

        for (int idx = 0 ; idx < N ; idx++) {

            if (idx != N -1) {
                if (N % 2 == 0) {
                    result.add(halfNumber);
                } else {
                    result.add(halfNumber * -1);
                }
            } else {
                Integer lastSum = result.stream()
                        .mapToInt(Integer::intValue)
                        .sum();

                Integer magicNumber = 0 - lastSum;

                result.add(magicNumber);
            }

            halfNumber--;
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

}
