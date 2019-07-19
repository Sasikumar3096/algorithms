import java.util.*;

public class PostfixToInfix {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		//A+(B*C-(D/E-F)*G)*H
		char exp[] = "ABC*DE/F-G*-H*+".toCharArray();
		for(int i =0; i<exp.length;i++) {
			if(Character.isLetter(exp[i])) {
				stack.push(String.valueOf(exp[i]));
			}
			else {
				String t2 = stack.pop();
				String t1 = stack.pop();
				stack.push("(" + t1 + String.valueOf(exp[i]) + t2 +")" );
			}
		}
		System.out.println(stack.pop());
	}
}
