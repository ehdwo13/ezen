package new02;

import java.io.IOException;
import java.net.URL;

public class Network02 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://n.news.naver.com/mnews/article/001/0014617188?rc=N&ntype=RANKING");
		System.out.println(url.getContent());
		System.out.println(url.getAuthority());
		System.out.println(url.getPort());
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getQuery());
		System.out.println(url.getPath());
	}

}
