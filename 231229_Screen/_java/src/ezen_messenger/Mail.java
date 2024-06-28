package ezen_messenger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Mail extends Login{
	
	public void mailMain(Scanner sc) throws IOException, InterruptedException {
		System.out.println("쪽지함");
		System.out.println("1.쪽지 쓰기 | 2. 쪽지 보기 | 3. 쪽지 삭제 | 4. 쪽지 답장 | 5. 돌아 가기 ");
		
		int menu = sc.nextInt();
		do {
			switch (menu) {
			case 1:
				writeMail(sc);
				break;
			case 2:
				printMail(sc);
				break;
			case 3:
				deleteMail(sc);
				break;
			case 4:
				replyMail(sc);
				break;
			case 5:checkPass(sc);
				break;
			default:
				System.out.println("잘못 누르셨습니다. ");
				break;
			}
		} while (menu != 5);
	}
	public void writeMail(Scanner sc) throws IOException, InterruptedException {
		BufferedReader br1 = new BufferedReader(new FileReader("C:\\Messenger\\tmp.txt"));
		String tmp1 = br1.readLine();
		BufferedReader br = new BufferedReader(new FileReader("C:\\Messenger\\"+tmp1+"\\friendsList.txt"));
		ArrayList <String> friendsList = new ArrayList<>();
		while (true) {
			String tmp = br.readLine();
			if (tmp == null) {
				break;
			}
			String id = tmp;
			friendsList.add(id);
		}
		if(friendsList.size()==0) {
			System.out.println("친구가 없습니다. ");
			printMail(sc);
		}else{
			System.out.println("쪽지를 보낼 친구이름을 입력하세요. ");
			System.out.println("---친구 리스트---");
			for(String print : friendsList) {
				System.out.println(print);
			}
			String search = sc.next();
			boolean check = false;
			for(String checkFriends : friendsList) {
				if(checkFriends.equals(search)) {
					check = true;
					break;
				}else {
					System.out.println("없는 친구입니다. ");
					writeMail(sc);
				}
			}
			if(check==true) {
				FileWriter fw = new FileWriter("C:\\Messenger\\"+tmp1+"\\sendMailBox.txt", true); // 내발신메일함
				FileWriter fw1 = new FileWriter("C:\\Messenger\\" + search + "\\receivedMailBox.txt", true); // 상대수신메일함
				System.out.println("쪽지 내용을 입력해주세요. ");
				sc.nextLine();
				String text = sc.nextLine();
				fw.write(search + "님에게 보낸 쪽지 : " + text);
				fw.write("\r\n");
				fw1.write(tmp1 + "님에게 받은 쪽지 : " + text);
				fw1.write("\r\n");
				fw.close();
				fw1.close();
				System.out.println("쪽지 전송 완료. ");
				mailMain(sc);
				}
		}
		br1.close();
		br.close();
	}
	public void printMail(Scanner sc) throws IOException, InterruptedException {
		BufferedReader br1 = new BufferedReader(new FileReader("C:\\Messenger\\tmp.txt"));
		ArrayList<String> tmp = new ArrayList<String>();
		String tmp1 = br1.readLine();
		System.out.println("1. 발신쪽지함 | 2. 수신쪽지함 | 3. 돌아가기");
		br1.close();
		int menu = sc.nextInt();
		do {
			switch(menu) {
			case 1 : 
				BufferedReader br = new BufferedReader(new FileReader("C:\\Messenger\\"+tmp1+"\\sendMailBox.txt"));
				while(true) {
					String line = br.readLine();
					if(line==null) {
						break;
					}
					String print = line;
					tmp.add(print);
				}
				if(tmp.size()==0) {
					System.out.println("발신쪽지함이 비었습니다. ");
					return;
				}else {
					for(String printAll : tmp) {
						System.out.println(printAll);
					}
				}
				br.close();
				mailMain(sc);
			case 2 : 
				BufferedReader br2 = new BufferedReader(new FileReader("C:\\Messenger\\"+tmp1 + "\\receivedMailBox.txt"));
				while(true) {
					String line = br2.readLine();
					if(line==null) {
						break;
					}
					String print = line;
					tmp.add(print);
				}
				if(tmp.size()==0) {
					System.out.println("수신쪽지함이 비었습니다. ");
					return;
				}else {
					for(String printAll : tmp) {
						System.out.println(printAll);
					}
				}
				br2.close();
				mailMain(sc);
			case 3 : mailMain(sc);
					 break;
			default : System.out.println("잘못누르셨습니다. ");
			}
		}while(menu!=3);
	}
	public void deleteMail(Scanner sc) throws IOException, InterruptedException {
		BufferedReader br1 = new BufferedReader(new FileReader("C:\\Messenger\\tmp.txt"));
		String tmp1 = br1.readLine();
		System.out.println("1.발신메일함 | 2. 수신메일함");
		int menu = sc.nextInt();
		int count = 1;
		if (menu == 1) {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Messenger\\"+tmp1 + "\\sendMailBox.txt"));
			ArrayList<String> mail = new ArrayList<>();
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				String tmp = line;
				mail.add(tmp);
			}
			if(mail.size()==0) {
				System.out.println("발신쪽지함이 비었습니다. ");
				deleteMail(sc);
			}else {
				System.out.println("지울 쪽지 번호를 입력해주세요. ");
				for (int i = 0; i < mail.size(); i++) {
					System.out.println(count + "번 쪽지" + mail.get(i));
					count++;
				}
				int del = sc.nextInt() - 1;
				System.out.println("삭제 완료. ");
				mail.remove(del);
				FileWriter fw = new FileWriter("C:\\Messenger\\"+tmp1 + "\\sendMailBox.txt");
				for (int i = 0; i < mail.size(); i++) {
					fw.write(mail.get(i) + "\r\n");
				}
				fw.close();
			}
			br.close();
			mailMain(sc);
		} else if (menu == 2) {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Messenger\\"+tmp1 + "\\receivedMailBox.txt"));
			ArrayList<String> mail = new ArrayList<>();
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				String tmp = line;
				mail.add(tmp);
			}
			if(mail.size()==0) {
				System.out.println("발신쪽지함이 비었습니다. ");
				deleteMail(sc);
			}
			System.out.println("지울 쪽지 번호를 입력해주세요. ");
			for (int i = 0; i < mail.size(); i++) {
				System.out.println(count + " " + mail.get(i));
				count++;
			}
			int del = sc.nextInt() - 1;
			mail.remove(del);
			FileWriter fw = new FileWriter("C:\\Messenger\\"+tmp1 + "\\receivedMailBox.txt");
			for (int i = 0; i < mail.size(); i++) {
				fw.write(mail.get(i));
			}
			br.close();
			fw.close();
			mailMain(sc);
		}
		br1.close();
	}

	public void replyMail(Scanner sc) throws IOException, InterruptedException {
		BufferedReader br1 = new BufferedReader(new FileReader("C:\\Messenger\\tmp.txt"));
		String tmp1 = br1.readLine();
		BufferedReader br = new BufferedReader(new FileReader("C:\\Messenger\\"+tmp1+"\\receivedMailBox.txt"));
		ArrayList<String> mail = new ArrayList<>();
		int count = 1;
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			String tmp = line;
			mail.add(tmp);
		}
		if(mail.size()==0) {
			System.out.println("수신쪽지함이 비었습니다. ");
			mailMain(sc);
		}else {
			System.out.println("답장할 쪽지 번호를 입력해주세요. ");
			for (int i=0; i <mail.size(); i++) {
				System.out.println(count + " " + mail.get(i));
				count++;
			}
			int pick = sc.nextInt()-1;
			String name = mail.get(pick).substring(0, mail.get(pick).indexOf("님"));
			FileWriter fw = new FileWriter("C:\\Messenger\\"+tmp1 + "\\sendMailBox.txt", true); // 내발신메일함
			FileWriter fw1 = new FileWriter("C:\\Messenger\\" + name + "\\receivedMailBox.txt", true); // 상대수신메일함
			System.out.println("쪽지 내용을 입력해주세요. ");
			sc.nextLine();
			String text = sc.nextLine();
			text.replace(" ", "_");
			fw.write(name + "님에게 보낸 쪽지 : " + text);
			fw.write("\r\n");
			fw1.write(tmp1 + "님에게 받은 쪽지 : " + text);
			fw1.write("\r\n");
			fw.close();
			fw1.close();
			System.out.println("쪽지 전송 완료. ");
			br.close();
			br1.close();
			mailMain(sc);
		}
	}
}