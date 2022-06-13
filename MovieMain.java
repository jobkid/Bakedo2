package project;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class MovieMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
	login();
	}
	
	static void login() throws IOException
	{
		
		System.out.println("접속하셨습니다. 관리자 [1], 이용자 [2], 전체종료 [3]");
		Scanner sc = new Scanner(System.in);
		boolean access=true;
		
		int number=sc.nextInt();
		
		while(access)
		{
			if(number==1)
			{
				Manager admin = new Manager();
				admin.login();
				
			}
			else if(number==2)
			{
				Member member = new Member();
				member.login();
					
			}
			else if(number==3)
			{
				System.out.println("전체 종료합니다.");
				break;
			}
		}
	}

}

class Manager extends AbstractMenu
{
	private String adminid="admin";
	private String password="1234";
	boolean admint = true;
	
	File fileName=new File("src/project/movies.txt");
	File theaterseat=new File("src/project/theaterseat.txt");
	Scanner sc=new Scanner(System.in);
	String dataStr;
	
	Manager(){
		
	}
	
	void managerMenu() throws IOException
	{
		System.out.println("관리자 메뉴입니다. [1]로그인 [2]영화 등록 [3]영화 추가 [4]영화 목록 [5]영화 삭제 [6]전체 삭제 [7] 좌석 설정 [8] 메뉴로 돌아가기 [0] 종료");
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		switch(number)
		{
		case 1: login();
		break;
		
		case 2: getMovie();
		break;
		
		case 3: addMovie();
		break;
		
		case 4: seeList();
		break;
		
		case 5: delMovie();
		break;
		
		case 6: delAll();
		break;
		
		case 7: getSeat();
		break;
		
		case 8: managerMenu();
		break;
		
		case 0:{
			System.out.println("종료합니다.");
			break;	
		}
		
		
		}
		
	}
	
	private void setMovie() throws IOException{
		
		FileWriter movie = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(movie);
		
		int i=5;
		while (i>0){
			System.out.println("영화 제목, 장르, 연령대를 5번 작성해주세요. 현재 "+i+"번 남았습니다. 작성은 '1' 종료는 '0'");
			
			Scanner sc = new Scanner(System.in);
			int tmp=sc.nextInt();
			if(tmp==1)
			{
				Scanner moviesc = new Scanner(System.in);
				
				System.out.print("영화를 등록합니다.");
				String title=moviesc.nextLine();
				
				System.out.print("장르를 입력해주세요.");
				String genre=moviesc.nextLine();
				
				System.out.print("연령대를 입력해주세요.");
				String age=moviesc.nextLine();
			
				System.out.println("========================================");
				
				bw.write(System.currentTimeMillis()+", "+title+", "+genre+", "+age);
				bw.newLine();
			}
			else if(tmp==0)
			{
				System.out.println("영화등록이 취소되었습니다.");
			}
			i--;
		}
		bw.close();
		movie.close();
		
		System.out.println("영화 등록 종료\n==================");
		managerMenu();
		

	}
	
	void getMovie() throws IOException
	{
		setMovie();
	}
	
	void seeList() throws IOException
	{
		try
		{
			FileReader fr=new FileReader(fileName);
			
			int data=0;
			while((data=fr.read())!=-1)
				System.out.print((char)data);
				fr.close();
		}catch(FileNotFoundException e) {e.printStackTrace();}
		
		System.out.println("영화 목록 보기 종료\n============================");
		managerMenu();
	}
	
	void addMovie() throws IOException
	{
		int data=0;
//		movieList();
		File fileName = new File("src/project/movies.txt");
		System.out.println("===================");
		System.out.println("영화를 추가하시겠습니까?");
		
		//String fileName="src/project/movie.txt";
		FileReader fr=new FileReader(fileName);
		BufferedReader br=new BufferedReader(fr);
		
		FileWriter fw=new FileWriter(fileName, true);
		BufferedWriter bw=new BufferedWriter(fw);
		int i=2;
		while(i>0)
		{	
			Scanner sc=new Scanner(System.in);
			
			System.out.print("영화를 등록합니다.");
			String movie=sc.nextLine();
			
			System.out.print("장르를 입력해주세요.");
			String genre=sc.nextLine();
			
			System.out.print("연령대를 입력합니다.");
			String age=sc.nextLine();
			
			bw.write(System.currentTimeMillis()+", "+movie+", "+genre+", "+age);
			bw.newLine();
			//System.out.println();
			
			
			i--;
			
		}
		bw.close();
		fw.close();
		
		System.out.println("영화 추가 종료\n===========================");
		managerMenu();
	}
	
	void delMovie() throws IOException
	{
		System.out.println("삭제할 영화를 선택해주세요.\n================");
		ArrayList<String> movielists=new ArrayList<String>();
		
		FileReader fr=new FileReader(fileName);
		BufferedReader br=new BufferedReader(fr);
		
		int j=0;
		int num=1;
		while((dataStr=br.readLine())!=null)
		{	
			
			movielists.add(dataStr);
			
			System.out.println("["+(num++)+"]"+"번 "+movielists.get(j++));
			
		}
		
		System.out.println("번호를 입력해주세요.\n===========");
	
		Scanner sc=new Scanner(System.in);
		int movenum=sc.nextInt();
		
		
		
		movielists.remove(movenum-1);
		
		FileWriter fw=new FileWriter(fileName);
		BufferedWriter bw=new BufferedWriter(fw);
		
		for(int i=0; i<movielists.size(); i++)
		{
			if(fileName.canWrite())
			{
				bw.write(movielists.get(i));
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		fw.close();
		System.out.println("영화 삭제 종료\n================================");
		managerMenu();
		
	}
	
	void delAll() throws IOException
	{
		fileName.delete();
		managerMenu();
	}
	
	void getSeat()throws IOException
	{
		setSeat();
	}
	
	private void setSeat() throws IOException
	{
		//2자 배열로 극장 좌석을 만든다. 행은 알파멧, 열은 숫자로 만든다.
		System.out.println("좌석의 행과 열을 지정해주세요.");
		char seatrow;
		int sum=1;
		String str=null;
		Scanner sc = new Scanner(System.in);
		
		int row=sc.nextInt();
		int column=sc.nextInt();
		
		int[][] seat=new int[row][column];
		
		FileWriter fw = new FileWriter(theaterseat);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(int i=0; i<seat.length; i++)
		{
			int j;
			for(j=0; j<seat[i].length; j++)
			{
				seat[i][j]=sum+j;
			}
			seatrow=(char)(i+65);
			str=seatrow+Arrays.toString(seat[i]);
			System.out.println(str);
			
			bw.write(seatrow+Arrays.toString(seat[i]));
			bw.newLine();
			
		}
		bw.close();
		fw.close();
		
		managerMenu();
		
	}
	public void login()
	{

			while(admint)
			{
				System.out.println("관리자 로그인 화면입니다.");
				System.out.println("관리자 ID를 입력해주세요 ");
				String inputId=sc.nextLine();
				System.out.println("=======================================");
				System.out.println("관리자 비밀번호를 입력해주세요.");
				String inputPass=sc.nextLine();
				System.out.println("=======================================");
				
				System.out.println("종료를 원하시면 0울 눌러주시고 그대로 진행은 1을 눌러주세요.");
				int ending = sc.nextInt();
				if(inputId.equals(adminid)&&inputPass.equals(password)&&ending==1)
				{
					System.out.println("접속되었습니다.");
					try
					{
						managerMenu();
					} catch (IOException e)
					{
						
						e.printStackTrace();
					}
					
				}
				else if(ending==0)
				{
					admint=false;
				}
				else
				{
					System.out.println("id와 비밀번호를 잘못입력하셨습니다.");
				}
				break;
			}
	}
	
}

class Member extends AbstractMenu
{
	String filename="src/project/reservation.txt";
	String logindata="src/project/logindata.txt";
	String seatfile="src/project/theaterseat.txt";
	
	File filereservation=new File(filename);
	File filelogindata = new File(logindata);
	File fileseat = new File(seatfile);
	
	char movieseat[];
	
	ArrayList<String> reservation = new ArrayList<String>();
	
	String data=null;
	Scanner sc = new Scanner(System.in);
	
	Member()throws IOException
	{
		
	}
	
	void memberMenu() throws IOException
	{
		System.out.println("메뉴를 선택해주세요. [1] 영화예매 [2] 예매 현황 [3] 영화 삭제 [4] 메뉴로 돌아가기 [0] 전체종료");
		int menunumber=sc.nextInt();
		switch(menunumber)
		{
		case 1:
		{
			getReservation();
			break;
		}
		case 2:
		{
			seeReservation();
		}
		case 3:
		{
			delReservation();
		}
		case 4:
		{
			memberMenu();
		}
		case 0:
		{
			break;
		}
		}
	}
	
	private void setReservation() throws IOException
	{
		try {
			File movies = new File("src/project/movies.txt");
			FileReader frmovies = new FileReader(movies);
			BufferedReader brmovies = new BufferedReader(frmovies);
			String str=null;
			ArrayList<String> moviearrays = new ArrayList<String>();
			
			while((data=brmovies.readLine())!=null)
			{
				moviearrays.add(data);
			}
			
			FileWriter fwreserve = new FileWriter(filereservation);
			BufferedWriter bwreserve = new BufferedWriter(fwreserve);
			int i=0;
			int j=0;
			
			do
			{
				System.out.println("영화를 예매하시겠습니까? [1] 예매 [2] 취소");
				System.out.println("===================================");
				
				int selection = sc.nextInt();
				if(selection==1)
				{
					System.out.print("장소를 선택해주세요. 띄어쓰기는 하지 말아주세요.");
					String place=sc.next();
					
					for(i=0; i<moviearrays.size(); i++)
					{
						System.out.println("["+(i+1)+"번]"+moviearrays.get(i));
					}
					int purchase=sc.nextInt();
					String movienum=moviearrays.get(purchase-1);
					System.out.println("["+purchase+"번]"+"영화를 선택했습니다.");
					
					
					FileReader frseats = new FileReader(fileseat);
					BufferedReader brseats = new BufferedReader(frseats);
					ArrayList<String>seatarrays = new ArrayList<String>();
					
					while((data=brseats.readLine())!=null)
					{
						seatarrays.add(data);
						System.out.println(data);
					}
					System.out.println("====================================");
					System.out.print("영화 좌석을 선택해주세요.\n");
					System.out.print("원하는 좌석 행을 선택해주세요. A-Z 순으로 번호를 입력해주세요. ex) A=1, B=2, C=3");
					
					int row=sc.nextInt();
					String row2 = seatarrays.get(row-1);
					
					char alphabet = row2.charAt(0);
					System.out.println(alphabet+"행을 선택하셨습니다.");
					System.out.println("====================================");
					System.out.println("원하시는 열을 선택해주세요.");
					
					int column = sc.nextInt();
					char column2 = row2.charAt(column*3-1);
					
					System.out.println(column2+"열을 선택하셨습니다.");
					String seatnumber=alphabet+"-"+column2;
					
					bwreserve.write(place+", "+System.currentTimeMillis()+", "+movienum+", "+seatnumber);
					bwreserve.newLine();
					System.out.println("영화예매를 종료합니다.");
				}
				else if(selection==2)
				{
					System.out.println("영화예매를 취소했습니다.");
					break;
				}
			}while((j++)<moviearrays.size());
			bwreserve.close();
			fwreserve.close();
			System.out.println("영화 예매를 종료합니다.");
			
		}catch(FileNotFoundException e)
		{
			System.out.println("파일을 찾을 수가 없습니다.");
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("범위를 초과했습니다. 다시 실행해주세요.");
		}
		catch(IOException e)
		{
			
		}
		memberMenu();
		
	}
	void getReservation() throws IOException
	{
		setReservation();
	}
	
	void delReservation() throws IOException
	{
		int i=0;
		System.out.println("취소할 영화를 선택해주세요.\n===================");
	
		FileReader frreserve = new FileReader(filereservation);
		BufferedReader brreserve = new BufferedReader(frreserve);
		try {
			while((data=brreserve.readLine())!=null)
			{
				System.out.println("["+(++i)+"]"+data);
				reservation.add(data);
			}
			
			int delnumber=sc.nextInt();
			reservation.remove(delnumber-1);
			System.out.println("영화를 삭제했습니다.");
			
			FileWriter fwreserve = new FileWriter(filereservation);
			BufferedWriter bwreserve = new BufferedWriter(fwreserve);
			
			while(filereservation.canWrite())
			{
				for(i=0; i<reservation.size(); i++)
				{
					bwreserve.write(reservation.get(i));
					bwreserve.newLine();
				}
				break;
			}
			bwreserve.close();
			fwreserve.close();
			
			System.out.println("삭제 후 새로운 영화 파일 완성");
			memberMenu();
		}catch(FileNotFoundException e)
		{
			System.out.println("예매 파일을 찾을 수가 없습니다.");
		}
		catch(IOException e)
		{
			
		}
	
	}
	
	void seeReservation() throws IOException
	{
		FileReader frreserve = new FileReader(filereservation);
		BufferedReader brreserve = new BufferedReader(frreserve);
		try {
			while((data=brreserve.readLine())!=null){
				System.out.println(data);
			}
			System.out.println("================================");
			memberMenu();
		}catch(IOException e)
		{
			System.out.println("파일을 찾을 수가 없습니다.");
		}
	}
	
	public void login()
	{
		int yn;
		String mname=null;
		String mpass=null;
		boolean tf=true;
		String buf=null;
		String[] member= {};
		try {
			FileWriter fwlogindata = new FileWriter(filelogindata);
			BufferedWriter bwlogindata = new BufferedWriter(fwlogindata);
			
			System.out.println("비회원이면 [1] 회원이면 [2]를 입력해주세요.");
			yn=sc.nextInt();
			
				if(yn==1)
				{
					System.out.println("회원가입을 진행합니다.");
						
					
					System.out.println("회원정보를 입력해주세요.");
					System.out.println("이름을 입력해주세요.");
					mname=sc.next();
							
					System.out.println("비밀번호를 입력해주세요.");
					mpass=sc.next();
							
					String information = mname+", "+mpass+", ";
					bwlogindata.write(information);
					bwlogindata.newLine();
							
					bwlogindata.close();
					fwlogindata.close();
						
				}
				else if(yn==2)
					{
						System.out.println("=====로그인 화면으로 이동합니다.=====");
						FileReader frlogindata = new FileReader(filelogindata);
						BufferedReader brlogindata = new BufferedReader(frlogindata);
						
						while((buf=brlogindata.readLine())!=null)
						{
							member=buf.split(", ");
								
							if(mname.equals(member[0])&&mpass.equals(member[2]))
							{
								System.out.println("\n"+"♥♥♥"+mname+"님 환영홥니다."+"♥♥♥");
								tf=false;
							}
							if(tf!=false)
							{
								System.out.println("회원 정보가 일치하지 않습니다.");
							}
						}
										
					
						
						System.out.println("메뉴로 이동합니다.");
						memberMenu();
					}
							
				else
				{
					System.out.println("정확한 숫자를 입력하세요.");
				}
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	static String register()
	{
		String name;
		String phone;
		String password;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요");
		name = sc.next();
		
		System.out.println("전화번호를 입력하세요(-제외)");
		phone = sc.nextLine();
		
		System.out.println("비밀번호를 입력하세요.(숫자만)");
		password = sc.nextLine();
		
		return name+" "+ " "+phone+" "+"\n";
		
		
	}
	
}

interface Menu{
	public abstract void login();
}

abstract class AbstractMenu implements Menu{
	public abstract void login ();
}
