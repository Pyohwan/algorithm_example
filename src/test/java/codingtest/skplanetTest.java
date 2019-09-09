package codingtest;

import org.junit.Test;

/**
* @author <a href="mailto:phjang1983@daum.net">Jang,Pyohwan</a>
* @company  : http://jakduk.com
* @date     : 2015. 10. 17.
* @desc     :
*/
public class skplanetTest {
    public int solution(int[] S) {
        int max_sum = 0;
        int current_sum = 0;
        boolean positive = false;
        int n = S.length;
        for (int i = 0; i < n; ++i) {
            int item = S[i];
            if (item < 0) {
                  if (item < 0 && current_sum < 0) {
                      max_sum = current_sum;
                      current_sum = 0;
                  }
            } else {
                  positive = true;
                  current_sum += item;
            }
        }
        if (current_sum > max_sum) {
            max_sum = current_sum;
        }
        if (positive) {
            return max_sum;
        }
        return -1;
      }
    
	@Test
	public void skTest01() {
		int[] arr = {1,2,-3,4,5,-6};
		int result = solution(arr);
		
		System.out.println(result);
	}
}
