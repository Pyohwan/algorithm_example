package algorithm.example;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

/**
* @author <a href="mailto:phjang1983@daum.net">Jang,Pyohwan</a>
* @company  : http://jakduk.com
* @date     : 2015. 10. 17.
* @desc     :
*/
public class spearheadTest {
	
	public int eakorea01(int[] A) {				
		Arrays.sort(A);
		
		int cnt = 0;
		int dupCnt = 0;
		int dupSum = 0;
		int dupVal = A[0];
		
		for (int i = 1 ; i < A.length ; i++) {
			
			if (dupVal == A[i]) {
				dupCnt++;
				dupSum += dupCnt;
			} else {
				dupVal = A[i];
				if (dupCnt != 0) {
					cnt += dupSum;
				}
				
				dupSum = 0;
				dupCnt = 0;
			}
		}
		return cnt;
		
	}
	
	@Test
	public void eakorea02() {
		int test[] = {3,5,6,3,3,5};
		System.out.println(eakorea01(test));
	}
	
	public int eakorea03(String S) {				
		
		int cnt = 0;
		int decimal = Integer.parseInt(S, 2);
		
		while(decimal > 0) {
			
			if (decimal % 2 == 0) {
				decimal = decimal / 2;
			} else {
				decimal--;
			}
			
			cnt++;
		}

		return cnt;
	}

	@Test
	public void eakorea04() {
		String test = "011100";
		System.out.println(eakorea03(test));
	}
	
	public boolean eakorea05(int[] A) {				
		
		int[] clone = A.clone();
		Arrays.sort(clone);
		String expect = Arrays.toString(clone);

		boolean result = false;
		int swapIdx = -1;
		int swapValue = -1;
		
		for (int i = 0 ; i < A.length ; i++) {

			int pre = A[i];
			int next = -1;
			
			if (i+1 < A.length) {
				next = A[i+1];	
			}

			if (swapValue < A[i] && swapValue > 0) {
				A[swapIdx] = A[i-1];
				A[i-1] = swapValue;
				break;
			}

			if (pre > next && next > 0) {
				swapIdx = i;
				swapValue = A[i];
			}
		}

		
		if (expect.equals(Arrays.toString(A))) {
			result = true;
		}

		return result;
	}
	
	@Test
	public void eakorea06() {
		//int test[] = {1,5,3,3,7};
		int test[] = {1,3,5,3,4};
		System.out.println(eakorea05(test));
	}
	
	public int eakorea07(String S) {				
		Stack<Integer> myStack = new Stack<>();
		
		for (int i = 0 ; i < S.length() ; i++) {
			
			if (S.charAt(i) >= '0' && S.charAt(i) <= '9') {
				myStack.push((int) (S.charAt(i) - '0'));
				continue;
			}
			
			if (S.charAt(i) == '+' || S.charAt(i) == '*') {
				
				int pop1, pop2;
				
				if (!myStack.isEmpty()) {
					pop1 = myStack.pop();
				} else {
					return -1;
				}
				
				if (!myStack.isEmpty()) {
					pop2 = myStack.pop();
				} else {
					return -1;
				}

				if (S.charAt(i) == '+') {
					myStack.push(pop1 + pop2);					
				} else if (S.charAt(i) == '*') {
					myStack.push(pop1 * pop2);
				}
				
				continue;
			}
		}

		if (!myStack.isEmpty()) {
			return myStack.pop();
		} else {
			return -1;
		}
	}
	
	@Test
	public void eakorea08() {
		String test = "13+62*7+*";
		//String test = "11++";
		System.out.println("result=" + eakorea07(test));
	}

}
