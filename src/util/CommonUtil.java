package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * �ṩ���õĹ��߷���
 * </p>
 * 
 * @author Wu, Jiazhuo
 */
public class CommonUtil {

	/**
	 * <p>
	 * ������� Character[] ����ת��Ϊ String ����
	 * </p>
	 * 
	 * @author Wu, Jiazhuo
	 * @param character
	 *            ��Ҫת���� Character ����
	 * 
	 */
	public String convertCharacterToString(Character[] character) {
		char[] tempArray = new char[character.length];
		for (int i = 0; i < character.length; i++) {
			tempArray[i] = character[i];
		}
		return new String(tempArray);
	}

	/**
	 * <p>
	 * �ж������ String �Ƿ�������
	 * </p>
	 * 
	 * @author Wu, Jiazhuo
	 * @param string
	 *            ��Ҫ�жϵ��ַ���
	 * 
	 */
	public boolean isNumeric(String string) {
		Pattern pattern = Pattern.compile("-?[0-9]*");
		Matcher isNumeric = pattern.matcher(string);
		if (!isNumeric.matches()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Character[] testArray = { 'a', 'b', 'c' };
		CommonUtil common = new CommonUtil();
		String result = common.convertCharacterToString(testArray);
		System.out.println(result);
	}

}
