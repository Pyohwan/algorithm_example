package algorithm.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindMissingNumberTests {

    @Test
    public void fineMissingNumbers() {
        Assert.assertEquals(Arrays.asList(5,7,8,9), this.getMissingNumbers(Arrays.asList(1,10,2,3,6,4)));
        Assert.assertEquals(Arrays.asList(11,12,13,15,17,18,20), this.getMissingNumbers(Arrays.asList(10,19,21,16,14,10)));

    }

    private List<Integer> getMissingNumbers(List<Integer> numbers) {

        // sort and distinct
        List<Integer> cleanedNumbers = numbers.stream().sorted().distinct().collect(Collectors.toList());

        Integer firstNumber = cleanedNumbers.get(0);
        Integer lastNumber = cleanedNumbers.get(cleanedNumbers.size() -1);

        // verify numbers are between 0 ~ 100.
        if (firstNumber < 0 || lastNumber > 100) {
            throw new IllegalArgumentException("Number must be be between 0 and 100.");
        }

        List<Integer> missingNumbers = new ArrayList<>();
        Integer cleanedNumbersIdx = 0;

        for (Integer fullCount = firstNumber ; fullCount <= lastNumber ; fullCount++) {
            Integer getCleanedNumber = cleanedNumbers.get(cleanedNumbersIdx);

            if (getCleanedNumber.equals(fullCount)) {
                cleanedNumbersIdx++;
            } else if (! getCleanedNumber.equals(fullCount)) {
                missingNumbers.add(fullCount);
            }
        }

        // something is wrong.
        if (cleanedNumbersIdx < cleanedNumbers.size() -1) {
            throw new RuntimeException("Could not do foreach cycle.");
        }

        return missingNumbers;
    }
}
