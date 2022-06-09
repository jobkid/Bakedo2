package project;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Member mem=new Member();
		//mem.readMovies();
		//mem.getReservation();
		mem.getReservation();
	}

}

class Member{
	
	File reserve = new File("src/project/reservation.txt");
	FileWriter fwReserve = new FileWriter(reserve);
	BufferedWriter bwReserve = new BufferedWriter(fwReserve);
	
	File movies=new File("src/project/movies.txt");
	FileReader frMovie = new FileReader(movies);
	BufferedReader brMovie=new BufferedReader(frMovie);
	ArrayList<String> rsv=new ArrayList<String>();
	ArrayList<String> seat=new ArrayList<String>();
	
	String datastr="";
	String merge="";
	
	Member() throws IOException
	{
		FileWriter fwReserve = new FileWriter(reserve);
		BufferedWriter bwReserve = new BufferedWriter(fwReserve);
		
		FileReader frMovie = new FileReader(movies);
		BufferedReader brMovie=new BufferedReader(frMovie);
		ArrayList<String> rsv=new ArrayList<String>();
		ArrayList<String> seat=new ArrayList<String>();
	}
	
	void readMovies()throws IOException
	{
		
		while((datastr=brMovie.readLine())!=null)
		{
			System.out.println(datastr);
		}
		//brMovie.close();
		//frMovie.close();
	}
	
	private void setReservation() throws IOException
	{
		this.rsv=rsv;
		int i=1;
		
		System.out.println("영화를 예매하시겠습니까? [1] 예매 [2] 메뉴");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		
		if(num==1)
		{
			while((datastr=brMovie.readLine())!=null)
			{
				rsv.add(datastr);
				System.out.println("["+(i++)+"번] "+datastr);
			}
			
			while(true)
			{
				System.out.println("영화 번호를 입력해주세요.");
				int movienum=sc.nextInt();
				bwReserve.write(System.currentTimeMillis()+", "+rsv.get(movienum-1));
				bwReserve.newLine();
				
				System.out.println("추가 예매하시겠습니까? [1]예 [2] 아니오");
				int num2=sc.nextInt();
				if(num2==1)
				{	
					System.out.println("영화 목록입니다. 번호를 선택해주세요.");
					int j=0;
					while((datastr=brMovie.readLine())!=null)
					{
						System.out.println("["+(j++)+"번] "+datastr);
					}
					
					int movienum2=sc.nextInt();
					this.merge=System.currentTimeMillis()+", "+rsv.get(movienum2-1);
					bwReserve.write(merge);
					bwReserve.newLine();
					
				}
				break;
			}
		}
		else;
		
		
		//bwReserve.close();
		//fwReserve.close();
		
	}
	
	void getReservation() throws IOException
	{
		setReservation();
	}
	
	void selectSeat()
	{
		
	}
	
}