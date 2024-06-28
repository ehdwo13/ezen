package ezen_messenger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Login{

	public boolean checkLogin(Scanner sc) throws IOException, InterruptedException{
		System.out.println("아이디를 입력해주세요. ");
		String id = sc.next();
		if(checkId(id)==true){
			System.out.println("비밀번호를 입력해주세요. ");
			String PassWord = sc.next();
			while(!checkPassWord(PassWord)){
				System.out.println("비밀번호 에러");
				System.out.println("다시 입력해주세요. ");
				PassWord = sc.next();
			}
			System.out.println("로그인에 성공하였습니다.");
			tmpPath(id);
			return true;
		}else{
			System.out.println("없는 아이디 입니다. ");
			checkLogin(sc);
		}
		return false;
	}
	public void checkPass(Scanner sc) throws IOException, InterruptedException {
		LoginManager lm = new LoginManager();
		System.out.println("1. 친구 | 2. 쪽지함 | 3. 로그아웃");
		int menu = sc.nextInt();
		File f1= new File("C:\\Messenger\\tmp.txt");
		do{
			switch(menu){
			case 1: System.out.println("                         ####                              ###                        \r\n"
					+ "                    ##############                    #############                   \r\n"
					+ "                 ######        ######              ######       ######                \r\n"
					+ "               ####               ####           ####               ####              \r\n"
					+ "              ###                   ##         ####                   ###             \r\n"
					+ "             ###                              ###                      ###            \r\n"
					+ "            ###                        ###    ##                        ###           \r\n"
					+ "           ###                         ###   ###                         ###          \r\n"
					+ "           ###      ###        ###      ###  ##       ##         ##       ##          \r\n"
					+ "           ##      ####       ####      ### ###      ####       ####      ##          \r\n"
					+ "           ##       ##         ##       ### ###       ##         ##       ##          \r\n"
					+ "           ###         ###  ##          ###  ##          ##   ##          ##          \r\n"
					+ "            ##         #######         ###   ###         #######         ###          \r\n"
					+ "            ###                        ##     ###                       ###           \r\n"
					+ "        ########                      #####   ####                     ###            \r\n"
					+ "      ####    ####                  ###############                   ###             \r\n"
					+ "      ##     ####                   #####       ###                   #####           \r\n"
					+ "      ###  ####                        ####                             ###           \r\n"
					+ "       ######                            ####                                ##       \r\n"
					+ "       ####                                ####                              ###      \r\n"
					+ "     ####                                    ###                              ####    \r\n"
					+ "    ####                                      ###                               ###   \r\n"
					+ "    ##                                         ###                               ###  \r\n"
					+ "                                                ###                               ### \r\n"
					+ "  ##       ###                          ###      ###                      ##       ## \r\n"
					+ " ###      ###                            ##       ##                      ###      ###\r\n"
					+ " ##       ##                             ###      ###                      ##       ##\r\n"
					+ " ###     ###     #                       ####     ###          #   #       ###      ##\r\n"
					+ " #####################################################################################");
					lm.f.friendsMain(sc);
					break;
			case 2: System.out.println(""
					+ "   ###############################################                                   \r\n"
					+ "   ####                                    ###  ##                                   \r\n"
					+ "   ## ###                                   ### ##                                    \r\n"
					+ "   ##   ###                               ###   ##                                    \r\n"
					+ "   ##     ###                           ###     ##                                   \r\n"
					+ "   ##       ###                       ####      ##                                    \r\n"
					+ "   ##        ####                   ####        ##                                    \r\n"
					+ "   ##          ###                 ###          ##      #############                  \r\n"
					+ "   ##            ###             ###            ##      ####      ####                \r\n"
					+ "   ##            #####         #####            ##         ##        ###              \r\n"
					+ "   ##          ###   ###     ###   ###          ##          ###        ##             \r\n"
					+ "   ##        ####      #######      ####        ##            ##        ##            \r\n"
					+ "   ##      ####          ###          ####      ##            ##         #            \r\n"
					+ "   ##    ####                           ####    ##             ##        ##           \r\n"
					+ "   ##   ###                               ###   ##         ######        ######       \r\n"
					+ "   ## ###                                   ### ##        ##                 ###      \r\n"
					+ "   ###   #################################  #####         ##                ##       \r\n"
					+ "   ##############################################           ###            ###        \r\n"
					+ "                                                              ##          ##          \r\n"
					+ "                                                               ##        ##           \r\n"
					+ "                                                                ###    ###            \r\n"
					+ "                                                                  ##  ##              \r\n"
					+ "                                                                   ####               \r\n"
					+ "                 #                                                                    \r\n"
					+ "               #####                                                                  \r\n"
					+ "              ##   ##                                                                 \r\n"
					+ "             ##     ###                                                               \r\n"
					+ "           ###        ##                                                              \r\n"
					+ "          ##           ##                                                             \r\n"
					+ "         ##             ###          ##############################################    \r\n"
					+ "        ##                ##         ####                                      ####   \r\n"
					+ "       ##                 ##         #  ###                                  ###  #   \r\n"
					+ "        #####         #####          ##   ###                               ##    #   \r\n"
					+ "            ##        ##             ##     ###                           ##      #   \r\n"
					+ "            ##         #             ##       ##                        ###       #   \r\n"
					+ "             ##        ##            ##        ###                    ###         #   \r\n"
					+ "              ##        ##           ##          ###                ###           #   \r\n"
					+ "               ###        ##         ##            ###            ###             #   \r\n"
					+ "                 ####      ####      ##            #####        #####             #   \r\n"
					+ "                    ###########      ##          ###   ###    ###    ###          #   \r\n"
					+ "                                     ##        ###       ######        ##         #   \r\n"
					+ "                                     ##      ###                        ###       #   \r\n"
					+ "                                     ##    ###                            ###     #   \r\n"
					+ "                                     ##  ###                                ###   #   \r\n"
					+ "                                     ## ##                                    ##  #   \r\n"
					+ "                                     ####                                      ####   \r\n"
					+ "                                     ##############################################   ");
					lm.m.mailMain(sc);
					break;		
			case 3: System.out.println("   ########################                     \r\n"
							+ "   ############################                   \r\n"
							+ "  ##############################                  \r\n"
							+ " #####                      #####                 \r\n"
							+ " #####                      #####                 \r\n"
							+ " #####                      #####                 \r\n"
							+ " #####                      #####                 \r\n"
							+ " #####                      #####     ####        \r\n"
							+ " #####                                ######      \r\n"
							+ " #####                                #######     \r\n"
							+ " #####                                   ######   \r\n"
							+ " #####      ##################################### \r\n"
							+ " #####     #######################################\r\n"
							+ " #####     ###################################### \r\n"
							+ " #####                                   #######  \r\n"
							+ " #####                                 #######    \r\n"
							+ " #####                                ######      \r\n"
							+ " #####                      ####      #####       \r\n"
							+ " #####                      #####                 \r\n"
							+ " #####                      #####                 \r\n"
							+ " #####                      #####                 \r\n"
							+ " #####                      #####                 \r\n"
							+ "  ######                  ######                  \r\n"
							+ "  #############################                   \r\n"
							+ "     ########################    ");
					System.out.println("메인화면으로 돌아갑니다. ");
					if(f1.exists()) {
						f1.delete();						
					}
					MessengerMain.main(null);
			default : System.out.println("잘못 입력하셨습니다. "); break;
			}
		}while(menu != 3);
	}
	public boolean checkId(String a) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("C:\\Messenger\\memberList.txt"));
		while(true){
			String line = br.readLine();
			if(line == null)
				break;
			String Id = line.substring(0, line.indexOf(" "));
			if(Id.equals(a)){
				return true;
			}
		}
		br.close();
		return false;
	}
	public boolean checkPassWord(String a) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("C:\\Messenger\\memberList.txt"));
		while(true){
			String line = br.readLine();
			if(line == null)
				break;
			String PassWord = line.substring(line.indexOf(" ") + 1);
			if(PassWord.equals(a)) {
				return true;
			}
		}
		br.close();
		return false;
	}
	public void tmpPath(String a) throws IOException{
		FileWriter fw = new FileWriter("C:\\Messenger\\tmp.txt");
		fw.write(a);
		fw.close();
	}
}