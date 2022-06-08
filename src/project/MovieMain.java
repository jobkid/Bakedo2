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
		bw.write("������");
		
		FileWriter test = new FileWriter("src/project/test.txt");
		BufferedWriter testb =new BufferedWriter(test);
		testb.write("�ȳ��ϼ���.");
		
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
		System.out.println("������ �޴��Դϴ�. [1] ��ȭ ��� [2] ��ȭ �߰� [3] ��ȭ ��� [4] ��ȭ ����");
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
			System.out.println("��ȭ ����, �帣, ���ɴ븦 5�� �ۼ����ּ���. ���� "+i+"�� ���ҽ��ϴ�. �ۼ��� '1' ����� '0'");
			
			Scanner sc = new Scanner(System.in);
			int tmp=sc.nextInt();
			if(tmp==1)
			{
				Scanner moviesc = new Scanner(System.in);
				
				System.out.print("��ȭ�� ����մϴ�.");
				String title=moviesc.nextLine();
				
				System.out.print("�帣�� �Է����ּ���.");
				String genre=moviesc.nextLine();
				
				System.out.print("���ɴ븦 �Է����ּ���.");
				String age=moviesc.nextLine();
			
				System.out.println("========================================");
				
				bw.write(System.currentTimeMillis()+", "+title+", "+genre+", "+age);
				bw.newLine();
			}
			else if(tmp==0)
			{
				System.out.println("��ȭ����� ��ҵǾ����ϴ�.");
			}
			i--;
		}
		bw.close();
		movie.close();
		
		System.out.println("��ȭ ��� ����");

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
		System.out.println("��ȭ�� �߰��Ͻðڽ��ϱ�?");
		
		//String fileName="src/project/movie.txt";
		FileReader fr=new FileReader(fileName);
		BufferedReader br=new BufferedReader(fr);
		
		FileWriter fw=new FileWriter(fileName, true);
		BufferedWriter bw=new BufferedWriter(fw);
		int i=2;
		while(i>0)
		{	
			Scanner sc=new Scanner(System.in);
			
			System.out.print("��ȭ�� ����մϴ�.");
			String movie=sc.nextLine();
			
			
			System.out.print("�帣�� �Է����ּ���.");
			String genre=sc.nextLine();
			
			System.out.print("���ɴ븦 �Է��մϴ�.");
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
		System.out.println("������ ��ȭ�� �������ּ���.\n================");
		ArrayList<String> movielists=new ArrayList<String>();
		
		FileReader fr=new FileReader(fileName);
		BufferedReader br=new BufferedReader(fr);
		
		System.out.println("���� ��ȭ�� �������ּ���.");
		while((dataStr=br.readLine())!=null)
		{
			movielists.add(dataStr);
		}
		
		System.out.println("��ȣ�� �Է����ּ���.\n===========");
	
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
