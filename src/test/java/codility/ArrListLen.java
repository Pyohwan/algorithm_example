package codility;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ArrListLen {

    @Test
    public void test1() {
        int[] a = {1,4,-1,3,2};
        System.out.println(this.solution(a));
    }

    private int solution(int[] A) {
        // write your code in Java SE 8

        Map<Integer, Integer> resultMap = new HashMap<>();

        Integer value = A[0];

        resultMap.put(0, value);

        do {
            Integer index = value;
            value = A[value];

            resultMap.put(index, value);
        } while (value != -1);

        return resultMap.size();
    }
}
