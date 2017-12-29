package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>�ṩ���õĹ��߷���</p>
 * @author Wu, Jiazhuo 
 * */
public class CommonUtil {
	
	/**
	 * <p>������� Character ����ת��Ϊ String ����</p>
	 * @author Wu, Jiazhuo
	 * @param character ��Ҫת�����ַ���
	 * @throws Exception 
	 * @exception �����������
	 * 
	 * */
	public String convertCharToString(Character character) throws Exception {
		if(character instanceof Character)
			return String.valueOf(character.charValue());
		else
			throw new Exception("�ַ���ת�����󣬷Ƿ��������");
	}
	
	
	/**
	 * <p>�ж������ String �Ƿ�������</p>
	 * @author Wu, Jiazhuo
	 * @param string ��Ҫ�жϵ��ַ���
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
