package new02;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Network01 {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress ip = null;
		ip = InetAddress.getByName("www.naver.com");
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getHostName());
		System.out.println(ip.toString());
	}

}
