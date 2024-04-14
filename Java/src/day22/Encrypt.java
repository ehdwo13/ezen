package day22;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;


public class Encrypt {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Encrypt en = new Encrypt();
		
		String pwd = sc.next();
		System.out.println("ps : "+pwd);
		
		String salt = en.getSalt();
		System.out.println("salt : "+salt);
		
		String res = en.getEncrypt(pwd,salt);
		System.out.println(res);
		sc.close();
	}

	public String getSalt() {
		SecureRandom r = new SecureRandom();
		byte [] salt = new byte[20];
		r.nextBytes(salt);
		
		StringBuffer sb = new StringBuffer();
		for(byte b : salt) {
			sb.append(String.format("%02x", b));
		};
		return sb.toString();
	}
	
	public String getEncrypt(String pwd,String salt) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			System.out.println("pwd + salt 적용 전 : "+pwd+salt);
			md.update((pwd+salt).getBytes());
			byte[] pwdsalt = md.digest();
			
			StringBuffer sb = new StringBuffer();
			for(byte b : pwdsalt) {
				sb.append(String.format("%02x", b));
			}
			result = sb.toString();
			System.out.println("pwd + salt 적용 후 : "+ result);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
}