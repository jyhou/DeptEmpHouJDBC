package com.johnny.deptemp.utility;

import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;

public class UserUtility {

	public static void main(String[] args) {
		
		System.out.println(userPwdTable);

	}
	
	private static ConcurrentHashMap<String, String> userPwdTable = new ConcurrentHashMap<String, String>();
	
	public static boolean setNewUser(String newUserName, String pwd){
		userPwdTable.put("Johnny", "123");
		if (userPwdTable.contains(newUserName)){
			return false;// username alread exists, return false to notify the invoker
		}else{
			userPwdTable.put(newUserName, pwd);
			return true;// new username and pwd are set, return true to notify the invoker
		}
	}
	
	public static boolean validateUser(String userName, String pwd, HttpServletRequest request){
		userPwdTable.put("Johnny", "123");
		if (userPwdTable.containsKey(userName) && userPwdTable.get(userName).equals(pwd)){
			return true;
		}else{
			return false;
		}
	}

}
