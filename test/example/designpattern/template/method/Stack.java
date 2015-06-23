package example.designpattern.template.method;

import java.util.LinkedList;

public class Stack {
	
	private final LinkedList<Integer> stack;
	
	public Stack() {
		stack = new LinkedList<Integer>();
	}
	
	public Stack(final LinkedList<Integer> initalState) {
		this.stack = initalState;
	}
	
	public void push(final int number) {
		stack.add(0, number);
	}
	
	public Integer pop() {
		return stack.remove(0);
	}
	
	public Stack filter(final StackPredicate filter) {
		final LinkedList<Integer> initalState = new LinkedList<Integer>();
		
		for (Integer integer : stack) {
			if (filter.isValid(integer)) {
				initalState.add(integer);
			}
		}
		return new Stack(initalState);
	}
	
	public interface StackPredicate {
		boolean isValid(int i);
	}
}
