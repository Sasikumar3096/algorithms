import java.util.*;
public class InfixToPostfix {
	public static int  prec(char ch) {
		switch(ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
	return -1;
	}
	public static void main(String[] args) {
		char exp[]= "A+(B*C-(D/E-F)*G)*H".toCharArray();
		String result="";
		Stack<Character> stack = new Stack<Character>(); 
		int k=0;
		for(int i=0;i<exp.length;i++)
		{
			if(Character.isLetter(exp[i])) {
				result+= exp[i];
			}
			else
				if(exp[i]=='(') {
					stack.push(exp[i]);
				}
				else
					if(exp[i]==')')
					{
						while(!stack.isEmpty() && stack.peek()!='('){
							result += stack.pop();
						}
						if(!stack.isEmpty())
							stack.pop();
						
					}
					else {
						while(!stack.isEmpty() && prec(exp[i])<=prec(stack.peek()))
								result += stack.pop();
						stack.push(exp[i]);
					}
		}
		while(!stack.isEmpty()) {
			result += stack.pop();
		}
		
		System.out.println(result);
	}

}
