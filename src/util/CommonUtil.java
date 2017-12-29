package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>提供常用的工具方法</p>
 * @author Wu, Jiazhuo 
 * */
public class CommonUtil {
	
	/**
	 * <p>将输入的 Character 类型转化为 String 类型</p>
	 * @author Wu, Jiazhuo
	 * @param character 需要转换的字符串
	 * @throws Exception 
	 * @exception 传入参数错误
	 * 
	 * */
	public String convertCharToString(Character character) throws Exception {
		if(character instanceof Character)
			return String.valueOf(character.charValue());
		else
			throw new Exception("字符串转换错误，非法传入参数");
	}
	
	
	/**
	 * <p>判断输入的 String 是否是数字</p>
	 * @author Wu, Jiazhuo
	 * @param string 需要判断的字符串
	 * 
	 * */
	public boolean isNumeric(String string){ 
		   Pattern pattern = Pattern.compile("-?[0-9]*"); 
		   Matcher isNumeric = pattern.matcher(string);
		   if( !isNumeric.matches() ){
		       return false; 
		   } 
		   return true; 
		}
	
}
