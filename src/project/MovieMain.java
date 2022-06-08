package project;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class MovieMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*
		FileWriter fw = new FileWriter("src/project/c.txt");
		BufferedWriter bw= new BufferedWriter(fw);
		bw.write("이주협");
		
		FileWriter test = new FileWriter("src/project/test.txt");
		BufferedWriter testb =new BufferedWriter(test);
		testb.write("안녕하세요.");
		
		bw.close();
		testb.close();
		*/
		
		Manager admin = new Manager();
		/*
		admin.getMovie();
		System.out.println("=================");
		admin.movieList();
		System.out.println("================");
		admin.addMovie();
		*/
		
		admin.managerMenu();
	}

}

class Manager{
	
	File fileName=new File("src/project/movies.txt");
	String dataStr;
	Manager(){
		
	}
	
	void managerMenu() throws IOException
	{
		System.out.println("관리자 메뉴입니다. [1] 영화 등록 [2] 영화 추가 [3] 영화 목록 [4] 영화 삭제");
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		switch(number)
		{
		case 1: getMovie();
		break;
		
		case 2: addMovie();
		break;
		
		case 3: seeList();
		break;
		
		case 4: delMovie();
		break;
		
		case 0: managerMenu();
		break;
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
		
		System.out.println("영화 등록 종료");

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
	}
	
	void delMovie() throws IOException
	{
		System.out.println("삭제할 영화를 선택해주세요.\n================");
		ArrayList<String> movielists=new ArrayList<String>();
		
		FileReader fr=new FileReader(fileName);
		BufferedReader br=new BufferedReader(fr);
		
		System.out.println("지울 영화를 선택해주세요.");
		while((dataStr=br.readLine())!=null)
		{
			movielists.add(dataStr);
		}
		
		System.out.println("번호를 입력해주세요.\n===========");
	
		Scanner sc=new Scanner(System.in);
		int movenum=sc.nextInt();
		
		movielists.remove(movenum);
		
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
		managerMenu();
		
	}
	
}

class Login{
	
	Scanner sc = new Scanner(System.in);
	
	String id ="manager";
	String pwd="1234";
	
	void setLogin()
	{
		
		
		
		
		
		
		
	}
	
}
