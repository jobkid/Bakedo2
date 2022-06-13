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
		
		System.out.println("�����ϼ̽��ϴ�. ������ [1], �̿��� [2], ��ü���� [3]");
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
				System.out.println("��ü �����մϴ�.");
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
		System.out.println("������ �޴��Դϴ�. [1]�α��� [2]��ȭ ��� [3]��ȭ �߰� [4]��ȭ ��� [5]��ȭ ���� [6]��ü ���� [7] �¼� ���� [8] �޴��� ���ư��� [0] ����");
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
			System.out.println("�����մϴ�.");
			break;	
		}
		
		
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
		
		System.out.println("��ȭ ��� ����\n==================");
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
		
		System.out.println("��ȭ ��� ���� ����\n============================");
		managerMenu();
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
		
		System.out.println("��ȭ �߰� ����\n===========================");
		managerMenu();
	}
	
	void delMovie() throws IOException
	{
		System.out.println("������ ��ȭ�� �������ּ���.\n================");
		ArrayList<String> movielists=new ArrayList<String>();
		
		FileReader fr=new FileReader(fileName);
		BufferedReader br=new BufferedReader(fr);
		
		int j=0;
		int num=1;
		while((dataStr=br.readLine())!=null)
		{	
			
			movielists.add(dataStr);
			
			System.out.println("["+(num++)+"]"+"�� "+movielists.get(j++));
			
		}
		
		System.out.println("��ȣ�� �Է����ּ���.\n===========");
	
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
		System.out.println("��ȭ ���� ����\n================================");
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
		//2�� �迭�� ���� �¼��� �����. ���� ���ĸ�, ���� ���ڷ� �����.
		System.out.println("�¼��� ��� ���� �������ּ���.");
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
				System.out.println("������ �α��� ȭ���Դϴ�.");
				System.out.println("������ ID�� �Է����ּ��� ");
				String inputId=sc.nextLine();
				System.out.println("=======================================");
				System.out.println("������ ��й�ȣ�� �Է����ּ���.");
				String inputPass=sc.nextLine();
				System.out.println("=======================================");
				
				System.out.println("���Ḧ ���Ͻø� 0�� �����ֽð� �״�� ������ 1�� �����ּ���.");
				int ending = sc.nextInt();
				if(inputId.equals(adminid)&&inputPass.equals(password)&&ending==1)
				{
					System.out.println("���ӵǾ����ϴ�.");
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
					System.out.println("id�� ��й�ȣ�� �߸��Է��ϼ̽��ϴ�.");
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
		System.out.println("�޴��� �������ּ���. [1] ��ȭ���� [2] ���� ��Ȳ [3] ��ȭ ���� [4] �޴��� ���ư��� [0] ��ü����");
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
				System.out.println("��ȭ�� �����Ͻðڽ��ϱ�? [1] ���� [2] ���");
				System.out.println("===================================");
				
				int selection = sc.nextInt();
				if(selection==1)
				{
					System.out.print("��Ҹ� �������ּ���. ����� ���� �����ּ���.");
					String place=sc.next();
					
					for(i=0; i<moviearrays.size(); i++)
					{
						System.out.println("["+(i+1)+"��]"+moviearrays.get(i));
					}
					int purchase=sc.nextInt();
					String movienum=moviearrays.get(purchase-1);
					System.out.println("["+purchase+"��]"+"��ȭ�� �����߽��ϴ�.");
					
					
					FileReader frseats = new FileReader(fileseat);
					BufferedReader brseats = new BufferedReader(frseats);
					ArrayList<String>seatarrays = new ArrayList<String>();
					
					while((data=brseats.readLine())!=null)
					{
						seatarrays.add(data);
						System.out.println(data);
					}
					System.out.println("====================================");
					System.out.print("��ȭ �¼��� �������ּ���.\n");
					System.out.print("���ϴ� �¼� ���� �������ּ���. A-Z ������ ��ȣ�� �Է����ּ���. ex) A=1, B=2, C=3");
					
					int row=sc.nextInt();
					String row2 = seatarrays.get(row-1);
					
					char alphabet = row2.charAt(0);
					System.out.println(alphabet+"���� �����ϼ̽��ϴ�.");
					System.out.println("====================================");
					System.out.println("���Ͻô� ���� �������ּ���.");
					
					int column = sc.nextInt();
					char column2 = row2.charAt(column*3-1);
					
					System.out.println(column2+"���� �����ϼ̽��ϴ�.");
					String seatnumber=alphabet+"-"+column2;
					
					bwreserve.write(place+", "+System.currentTimeMillis()+", "+movienum+", "+seatnumber);
					bwreserve.newLine();
					System.out.println("��ȭ���Ÿ� �����մϴ�.");
				}
				else if(selection==2)
				{
					System.out.println("��ȭ���Ÿ� ����߽��ϴ�.");
					break;
				}
			}while((j++)<moviearrays.size());
			bwreserve.close();
			fwreserve.close();
			System.out.println("��ȭ ���Ÿ� �����մϴ�.");
			
		}catch(FileNotFoundException e)
		{
			System.out.println("������ ã�� ���� �����ϴ�.");
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("������ �ʰ��߽��ϴ�. �ٽ� �������ּ���.");
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
		System.out.println("����� ��ȭ�� �������ּ���.\n===================");
	
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
			System.out.println("��ȭ�� �����߽��ϴ�.");
			
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
			
			System.out.println("���� �� ���ο� ��ȭ ���� �ϼ�");
			memberMenu();
		}catch(FileNotFoundException e)
		{
			System.out.println("���� ������ ã�� ���� �����ϴ�.");
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
			System.out.println("������ ã�� ���� �����ϴ�.");
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
			
			System.out.println("��ȸ���̸� [1] ȸ���̸� [2]�� �Է����ּ���.");
			yn=sc.nextInt();
			
				if(yn==1)
				{
					System.out.println("ȸ�������� �����մϴ�.");
						
					
					System.out.println("ȸ�������� �Է����ּ���.");
					System.out.println("�̸��� �Է����ּ���.");
					mname=sc.next();
							
					System.out.println("��й�ȣ�� �Է����ּ���.");
					mpass=sc.next();
							
					String information = mname+", "+mpass+", ";
					bwlogindata.write(information);
					bwlogindata.newLine();
							
					bwlogindata.close();
					fwlogindata.close();
						
				}
				else if(yn==2)
					{
						System.out.println("=====�α��� ȭ������ �̵��մϴ�.=====");
						FileReader frlogindata = new FileReader(filelogindata);
						BufferedReader brlogindata = new BufferedReader(frlogindata);
						
						while((buf=brlogindata.readLine())!=null)
						{
							member=buf.split(", ");
								
							if(mname.equals(member[0])&&mpass.equals(member[2]))
							{
								System.out.println("\n"+"������"+mname+"�� ȯ���d�ϴ�."+"������");
								tf=false;
							}
							if(tf!=false)
							{
								System.out.println("ȸ�� ������ ��ġ���� �ʽ��ϴ�.");
							}
						}
										
					
						
						System.out.println("�޴��� �̵��մϴ�.");
						memberMenu();
					}
							
				else
				{
					System.out.println("��Ȯ�� ���ڸ� �Է��ϼ���.");
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
		
		System.out.println("�̸��� �Է��ϼ���");
		name = sc.next();
		
		System.out.println("��ȭ��ȣ�� �Է��ϼ���(-����)");
		phone = sc.nextLine();
		
		System.out.println("��й�ȣ�� �Է��ϼ���.(���ڸ�)");
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
