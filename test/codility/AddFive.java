package codility;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class AddFive {

    @Test
    public void test01() {
        this.solution(268);
        this.solution(-123);
    }

    public int solution(int N) {
        // write your code in Java SE 8

        String stringNumber = String.valueOf(N);
        Set<Integer> candidateResult = new HashSet<>();

        Boolean negativeNumber = stringNumber.startsWith("-");

        for (Integer idx = 0 ; idx <= stringNumber.length() ; idx++) {

            if (negativeNumber && idx == 0) {
                continue;
            }

            String insertNumber = new StringBuilder(stringNumber).insert(idx, "5").toString();

            candidateResult.add(Integer.valueOf(insertNumber));
        }

        return candidateResult.stream().max(Comparator.comparing(Integer::valueOf)).orElse(0);
    }

}
