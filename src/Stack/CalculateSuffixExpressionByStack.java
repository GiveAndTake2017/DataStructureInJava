package Stack;

import java.util.Scanner;
import java.util.Stack;

import util.CommonUtil;

/**
 * <p>
 * 通过 stack 计算后缀表达式的结果
 * </p>
 * <p>
 * 后缀表达式，指的是不包含括号，运算符放在两个运算对象的后面，所有的计算按运算符出现的顺序，严格从左向右进行
 * </p>
 * 
 * @author Wu, Jiazhuo
 * 
 */
public class CalculateSuffixExpressionByStack {
	private final static char ADD = '+';
	private final static char SUBTRACT = '-';
	private final static char MULTIPLY = '*';
	private final static char DIVIDE = '/';
	private static Stack<Integer> stack;

	private Integer processSuffixExpression(String expression) throws Exception {
		CommonUtil util = new CommonUtil();
		String[] expressionArray;
		Integer result;

		stack = new Stack<>();// 每次计算都是用新的栈
		result = 0;
		expressionArray = expression.split(" ");

		for (String s : expressionArray) {
			if (!isOperator(s)) {
				if (util.isNumeric(s))
					stack.push(Integer.valueOf(s));// 若是合法的非运算符数字，则入栈
				else
					throw new Exception("输入字符串非法，含有无效字符");

			} else {
				if (stack.size() >= 2) {//遇到运算符时，栈内至少有两个数字
					result = processOperator(s.toCharArray()[0]);// 若是运算符，则取出两个栈顶元素，进行运算
					stack.push(result);// 结束后将计算结果入栈
				}else {
					throw new Exception("输入字符串非法，无法正确计算");
				}

			}
		}
		if (stack.size() != 1) {// 整体计算结束后，栈内应该有且只有一个最后压入栈的结果
			throw new Exception("输入字符串非法，无法正确计算");
		}
		return result;
	}

	private boolean isOperator(String operator) {
		return (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"));
	}

	private Integer processOperator(char operator) {
		Integer result = 0;
		int value2 = Integer.valueOf(stack.pop());// 因为后缀表达式严格从左向右执行，而栈结构为LIFO，所以要交换出栈元素顺序
		int value1 = Integer.valueOf(stack.pop());

		switch (operator) {
		case ADD:
			result = value1 + value2;
			break;
		case SUBTRACT:
			result = value1 - value2;
			break;
		case MULTIPLY:
			result = value1 * value2;
			break;
		case DIVIDE:
			result = value1 / value2;
			break;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer result = 0;
		CalculateSuffixExpressionByStack work = new CalculateSuffixExpressionByStack();

		// 7 4 -3 * 1 5 + / * == -14
		// 3 4 * 2 5 + - 4 * 2 / == 10
		while (true) {
			result = 0;
			System.out.println("请输入合法的四则运算后缀表达式  :");
			String expression = scan.nextLine();
			try {
				result = work.processSuffixExpression(expression);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			System.out.println("\n您输入的后缀表达式运算结果为 : " + result + "\n");
		}
	}

}
