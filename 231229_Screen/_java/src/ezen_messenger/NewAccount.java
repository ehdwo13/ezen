package ezen_messenger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NewAccount{

	public void NewMembership(Scanner sc) throws IOException, InterruptedException {
		FileWriter fw = new FileWriter("C:\\Messenger\\memberList.txt", true);
		System.out.println("Id를 생성해주세요>");
		String Id = sc.next();
		if(checkId(Id) == true){
			System.out.println("Password를 생성해주세요>");
			String Password = sc.next();
			fw.write(Id + " " + Password + "\r\n");
			System.out.println("등록되었습니다.");
			String path = "C:\\Messenger\\" + Id;
			File f = new File(path);
			f.mkdir();
			FileWriter fw1 = new FileWriter(path + "\\friendsList.txt");
			FileWriter fw2 = new FileWriter(path + "\\sendMailBox.txt");
			FileWriter fw3 = new FileWriter(path + "\\receivedMailBox.txt");
			Thread.sleep(500);
			System.out.println("폴더 생성 성공");
			fw.close();
			fw1.close();
			fw2.close();
			fw3.close();
		}else{
			NewMembership(sc);
		}
	}
	public Boolean checkId(String tmp) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Messenger\\memberList.txt"));
		while(true){
			String line = br.readLine();
			if(line == null){
				break;
			}
			if(tmp.equals(line.substring(0, line.indexOf(" ")))){
				System.out.println("중복된 아이디입니다. \r\n 다시입력해주세요. ");
				return false;
			}
		}
		br.close();
		return true;
	}
}