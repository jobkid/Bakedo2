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
		
		Manager admin = new Manager();
		//admin.managerMenu();
		admin.managerMenu();
	}

}

class Manager extends AbstractMenu{
	
	File movies=new File("src/project/movies.txt");
	File theaterseat=new File("src/project/theaterseats");
	String dataStr;
	Manager(){
		
	}
	void managerMenu() throws IOException
	{
		System.out.println("관리자 메뉴입니다. [1] 영화 등록 [2] 영화 추가 [3] 영화 목록 [4] 영화 삭제 [5] 전체 삭제 [6] 좌석 설정 [7] 메뉴로 돌아가기 [0] 전체종료");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		
		switch(num)
		{
		case 1: getMovie();
		break;
		
		case 2: addMovie();
		break;
		
		case 3: seeList();
		break;
		
		case 4: delMovie();
		break;
		
		case 5: delAll();
		break;
		
		case 6: getSeat();
		
		case 7:managerMenu();
		break;
		
		case 0:
		break;
		}
		
	}
	
	void setMovie() throws IOException{
		
		FileWriter fwMovie = new FileWriter(movies);
		BufferedWriter bwMovie = new BufferedWriter(fwMovie);
		
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
				
				
				bwMovie.write(System.currentTimeMillis()+", "+title+", "+genre+", "+age);
				bwMovie.newLine();
			}
			else if(tmp==0)
			{
				System.out.println("영화등록이 취소되었습니다.");
			}
			i--;
		}
		bwMovie.close();
		fwMovie.close();
		
		System.out.println("영화 등록 종료");
		managerMenu();
		System.out.println("==========================================================");
	}
	
	void getMovie() throws IOException
	{
		setMovie();
	}
	
	void seeList() throws IOException
	{
		try
		{
			FileReader fr=new FileReader(movies);
			
			int data=0;
			while((data=fr.read())!=-1)
			{
				System.out.print((char)data);
			}
			fr.close();
		}catch(FileNotFoundException e) {e.printStackTrace();}
		
		System.out.println("==========================================================");
		managerMenu();
	}
	
	void addMovie() throws IOException
	{
		int data=0;
//		movieList();
		System.out.println("===================");
		System.out.println("영화를 추가하시겠습니까?");
		
		FileReader frMovie=new FileReader(movies);
		BufferedReader brMovie=new BufferedReader(frMovie);
		
		FileWriter fwMovie=new FileWriter(movies, true);
		BufferedWriter bwMovie=new BufferedWriter(fwMovie);
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
			
			bwMovie.write(System.currentTimeMillis()+", "+movie+", "+genre+", "+age);
			bwMovie.newLine();
			//System.out.println();
			
			
			i--;
			
		}
		bwMovie.close();
		fwMovie.close();
		System.out.println("영화를 추가했습니다.");
		managerMenu();
		System.out.println("==========================================================");
	}
	
	void delMovie() throws IOException
	{
		System.out.println("삭제할 영화를 선택해주세요.\n===================");
		
		ArrayList<String> movielists=new ArrayList<String>();
		FileReader frMovie = new FileReader(movies);
		BufferedReader brMovie = new BufferedReader(frMovie);
		
		int index=0;
		int num=1;
		
		while((dataStr=brMovie.readLine())!=null)
		{
			movielists.add(dataStr);
			System.out.println("["+(num++)+"]번 "+movielists.get(index++));
		}
		
		System.out.println(movielists.size());
		
		System.out.println("번호를 입력해주세요.\n==================");
		
		Scanner sc=new Scanner(System.in);
		int movnum=sc.nextInt();
		
		movielists.remove(movnum-1);
		
		FileWriter fwMovie = new FileWriter(movies);
		BufferedWriter bwMovie = new BufferedWriter(fwMovie);
		
		for(int i=0; i<movielists.size(); i++)
		{
			if(movies.canWrite())
			{
				bwMovie.write(movielists.get(i));
				bwMovie.newLine();
			}
		}
		bwMovie.flush();
		bwMovie.close();
		fwMovie.close();
		System.out.println("영화 삭제 종료\n===================================");
		managerMenu();
	}
	
	void delAll() throws IOException
	{	
		//this.movies=movies;
		movies.delete();
		System.out.println("=====================");
		managerMenu();
	}
	
	void getSeat() throws IOException
	{
		setSeat();
	}
	
	private void setSeat() throws IOException
	{	//2차 배열로 극장 좌석을 만든다. 행은 알파벳 열은 숫자로 만든다.
		System.out.println("좌석의 행과 열을 지정해주세요.");

		char seatrow=' ';
		int sum=1;
		Scanner sc=new Scanner(System.in);
		
		int row=sc.nextInt();
		int column=sc.nextInt();
		
		int[][] seat=new int[row][column];
		
		FileWriter fwTheater=new FileWriter(theaterseat);
		BufferedWriter bwTheater = new BufferedWriter(fwTheater);
		
		for(int i=0; i<seat.length; i++)
		{
			int j;
			for(j=0; j<seat[i].length; j++)
			{
				seat[i][j]=sum+j;
			}
			seatrow=(char)(i+65);
			System.out.println(seatrow+Arrays.toString(seat[i]));
			bwTheater.write(seatrow+Arrays.toString(seat[i]));
			bwTheater.newLine();
		}
		bwTheater.close();
		fwTheater.close();	
	}
	public void login()
	{
		
	}
	
}

class Member extends AbstractMenu{
	private String filename = "src/project/reservation.txt";
	File filereservation = new File(filename);
	
	FileReader frreserve = new FileReader(filereservation);
	BufferedReader brreserve = new BufferedReader(frreserve);
	ArrayList<String> reservation = new ArrayList<String>();
	String data=null;
	Scanner sc = new Scanner(System.in);
	
	Member()throws IOException
	{
		File filereservation = new File(filename);
		FileReader frreader = new FileReader(filereservation);
		BufferedReader brreader = new BufferedReader(frreader);
	}
	
	void memberMenu() throws IOException
	{
		System.out.println("메뉴를 선택해주세요. [1] 영화예매 [2] 예매 현황 [3] 영화 삭제 [4] 메뉴로 돌아가기 [0] 전체종료");
		int selectnum=sc.nextInt();
		switch(selectnum)
		{
		case 1:{
			getReservation();
			break;
		}
		case 2:{
			seeReservation();
			break;
		}
		case 3:
		{
			delReservation();
			break;
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
		try
		{
			File movies = new File("src/project/movies.txt");
			FileReader frmovies = new FileReader(movies);
			BufferedReader brmovies = new BufferedReader(frmovies);
			String str=null;
			ArrayList<String> moviearrays=new ArrayList<String>();
			String data=null;
			
			while((data=brmovies.readLine())!=null)
			{
				moviearrays.add(data);
			}
			
			FileWriter fwreserve = new FileWriter(filereservation);
			BufferedWriter bwreserve = new BufferedWriter(fwreserve);
			int j=0;
			int i=0;
			
			do
			{
				System.out.println("영화를 예매하시겠습니까? [1] 예매 [2] 취소");
				System.out.println("===================================");
				
				int selection = sc.nextInt();
				if(selection==1)
				{
					System.out.println("장소를 선택해주세요. 띄어쓰기는 하지 말아주세요.");
					String place=sc.next();
					
					for(i=0; i<moviearrays.size(); i++)
					{
						System.out.println("["+(i+1)+"번]"+moviearrays.get(i));
					}
					int purchase=sc.nextInt();
					String movienum=moviearrays.get(purchase-1);
					System.out.println("["+purchase+"번] 영화를 선택했습니다.\n=========================");
					
					File fileseats = new File("src/project/seats.txt");
					FileReader frseats = new FileReader(fileseats);
					BufferedReader brseats = new BufferedReader(frseats);
					ArrayList<String> seatarrays = new ArrayList<String>();
					
					while((str=brseats.readLine())!=null)
					{
						seatarrays.add(str);
						System.out.println(str);
					}
					System.out.println("==========================");
					System.out.println("영화 좌석을 선택해주세요.");
					System.out.println("원하는 좌석 행을 선택해주세요. A-Z 순으로 번호를 입력해주세요.");
					
					int row=sc.nextInt();
					String row2=seatarrays.get(row-1);
					char alphabet=row2.charAt(0);
					System.out.println(alphabet+"행을 선택하셨습니다.");
					System.out.println("원하시는 열을 선택해주세요.");
					
					int column=sc.nextInt();
					char column2=row2.charAt(3*column-1);
					String seatnumber=alphabet+"-"+column2;
					
					bwreserve.write(place+", "+System.currentTimeMillis()+", "+row2+", "+seatnumber);
					bwreserve.newLine();
					System.out.println("영화예매를 종료합니다.");
				}
				else if(selection==2)
				{
					System.out.println("영화 예매를 취소했습니다.");
					break;
				}
				
			}while((j++)<moviearrays.size());
			bwreserve.close();
			fwreserve.close();
			System.out.println("영화예매를 종료합니다.");
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
		memberMenu();
	}
	
	void delReservation() throws IOException
	{
		int i=0;
		System.out.println("취소할 영화를 선택해주세요.\n=================");
		
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
			for(i=0; i<reservation.size(); i++) {
				bwreserve.write(reservation.get(i));
				bwreserve.newLine();
			}
			break;
		}
		bwreserve.close();
		fwreserve.close();
		
		System.out.println("삭제 후 새로운 영화 파일 완성");
		memberMenu();
	}
	
	void seeReservation() throws IOException
	{
		while((data=brreserve.readLine())!=null)
		{
			System.out.println(data);
		}
		System.out.println("=============================");
		memberMenu();
	}
	
	public void login()
	{
		
	}
	
	
}

interface Menu{
	public abstract void login();
}

abstract class AbstractMenu implements Menu{
	public abstract void login();
	
//	
}