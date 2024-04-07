package ezen_messenger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Friends extends Login{
	/*
	 * [친구] 친구 리스트 출력
	 * 
	 * 친구 추가
	 * 
	 * 친구 삭제 닉네임 달기(천천히)
	 */
	public void friendsMain(Scanner sc) throws IOException, InterruptedException {
		System.out.println("친구");
		System.out.println("1.친구 리스트 | 2. 친구 추가 | 3. 친구 삭제 | 4. 돌아 가기 ");
		int menu =sc.nextInt();
		do {
			switch(menu) {
			case 1: friendsList(sc);
					break;
			case 2: friendsAdd(sc);
					break;
			case 3: frienddel(sc);
					break;
			case 4: checkPass(sc);
					break;			
			default : System.out.println("잘못 입력하셨습니다. ");
					break;
			}
		}while(menu!=4);
	}
	public void friendsList(Scanner sc) throws IOException, InterruptedException {
		BufferedReader tmp = new BufferedReader(new FileReader("C:\\Messenger\\tmp.txt"));
		String tp = tmp.readLine();
		BufferedReader fl = new BufferedReader(new FileReader("C:\\Messenger\\"+tp +"\\friendsList.txt"));
		System.out.println("=========친구 리스트=======");
		ArrayList<String> friList = new ArrayList<String>();
		while (true) {
			String fri = fl.readLine();
			if (fri == null) {
				break;
			}
			friList.add(fri);

		}
		for (String f : friList) {
			System.out.println("|" + f);
		}
		fl.close();
		tmp.close();
		friendsMain(sc);
	}
	public void friendsAdd(Scanner sc) throws IOException, InterruptedException {
		BufferedReader tmp = new BufferedReader(new FileReader("C:\\Messenger\\tmp.txt"));
		String tp = tmp.readLine();
		BufferedReader fa = new BufferedReader(new FileReader("C:\\Messenger\\memberList.txt"));
		ArrayList<String> list1 = new ArrayList<String>();

		while (true) {
			String add = fa.readLine();
			if (add == null) {
				break;
			}
			String id = add.substring(0, add.indexOf(" "));
			list1.add(id);
		}
		BufferedReader addfri = new BufferedReader(new FileReader("C:\\Messenger\\"+tp+"\\friendsList.txt"));
		ArrayList<String> list2 = new ArrayList<String>();
		while (true) {
			String addfriends = addfri.readLine();
			if (addfriends == null) {
				break;
			}
			String id = addfriends;
			list2.add(id);
		}
		list1.remove(tp);
		List<String> resultList = list1.stream()
                .filter(old -> list2.stream()
                					.noneMatch(Predicate.isEqual(old)))
                .collect(Collectors.toList());
		System.out.println("=========회원 리스트=======");
		for (String l : resultList) {
			System.out.println("|" + l);
		}
		addfri.close();
		tmp.close();
		fa.close();

		System.out.println("친구추가할 사람을 입력하세요>");
		String a = sc.next();

		boolean isMember = false;
		for (String member : list1) {
			if (member.equals(a)) {
				isMember = true;
				break;
			}
		}
		if (!isMember) {
			System.out.println("회원 목록에 없는 사람입니다.");
			return;
		}
		System.out.println("친구 추가 되었습니다.");
		FileWriter fw = new FileWriter("C:\\Messenger\\"+tp +"\\friendsList.txt", true);
		fw.write(a + "\r\n");
		fw.close();
		friendsMain(sc);
		
	}
	public void frienddel(Scanner sc) throws IOException, InterruptedException {
		BufferedReader tmp = new BufferedReader(new FileReader("C:\\Messenger\\tmp.txt"));
		String tp = tmp.readLine();
		BufferedReader dellist = new BufferedReader(new FileReader("C:\\Messenger\\"+tp+"\\friendsList.txt"));
		ArrayList<String> del = new ArrayList<String>();
		while (true) {
			String add = dellist.readLine();
			if (add == null) {
				break;
			}
			String id = add;
			del.add(id);
		}
		for (String l : del) {
			System.out.println("|" + l);
		}
		dellist.close();
		System.out.println("친구삭제할 이름을 입력하세요>");
		String d = sc.next();
		for (int i = 0; i < del.size(); i++) {
			if (del.get(i).equals(d)) {
				del.remove(i);
				System.out.println("친구 삭제 완료");
			}
		}
		FileWriter newfriendslist = new FileWriter("C:\\Messenger\\"+tp + "\\friendsList.txt");
		for (int i = 0; i < del.size(); i++) {
			String data = del.get(i);
			newfriendslist.write(data + "\r\n");
		}
		tmp.close();
		newfriendslist.close();
		friendsMain(sc);
	}
}