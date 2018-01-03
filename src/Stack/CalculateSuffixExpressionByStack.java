package Stack;

import java.util.Scanner;
import java.util.Stack;

import util.CommonUtil;

/**
 * <p>
 * ͨ�� stack �����׺���ʽ�Ľ��
 * </p>
 * <p>
 * ��׺���ʽ��ָ���ǲ��������ţ���������������������ĺ��棬���еļ��㰴��������ֵ�˳���ϸ�������ҽ���
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

		stack = new Stack<>();// ÿ�μ��㶼�����µ�ջ
		result = 0;
		expressionArray = expression.split(" ");

		for (String s : expressionArray) {
			if (!isOperator(s)) {
				if (util.isNumeric(s))
					stack.push(Integer.valueOf(s));// ���ǺϷ��ķ���������֣�����ջ
				else
					throw new Exception("�����ַ����Ƿ���������Ч�ַ�");

			} else {
				if (stack.size() >= 2) {//���������ʱ��ջ����������������
					result = processOperator(s.toCharArray()[0]);// �������������ȡ������ջ��Ԫ�أ���������
					stack.push(result);// �����󽫼�������ջ
				}else {
					throw new Exception("�����ַ����Ƿ����޷���ȷ����");
				}

			}
		}
		if (stack.size() != 1) {// ������������ջ��Ӧ������ֻ��һ�����ѹ��ջ�Ľ��
			throw new Exception("�����ַ����Ƿ����޷���ȷ����");
		}
		return result;
	}

	private boolean isOperator(String operator) {
		return (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"));
	}

	private Integer processOperator(char operator) {
		Integer result = 0;
		int value2 = Integer.valueOf(stack.pop());// ��Ϊ��׺���ʽ�ϸ��������ִ�У���ջ�ṹΪLIFO������Ҫ������ջԪ��˳��
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
			System.out.println("������Ϸ������������׺���ʽ  :");
			String expression = scan.nextLine();
			try {
				result = work.processSuffixExpression(expression);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			System.out.println("\n������ĺ�׺���ʽ������Ϊ : " + result + "\n");
		}
	}

}
