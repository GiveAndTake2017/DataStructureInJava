package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 提供常用的工具方法
 * </p>
 * 
 * @author Wu, Jiazhuo
 */
public class CommonUtil {

	/**
	 * <p>
	 * 将输入的 Character[] 类型转化为 String 类型
	 * </p>
	 * 
	 * @author Wu, Jiazhuo
	 * @param character
	 *            需要转换的 Character 数组
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
	 * 判断输入的 String 是否是数字
	 * </p>
	 * 
	 * @author Wu, Jiazhuo
	 * @param string
	 *            需要判断的字符串
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
