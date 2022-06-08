package project;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

public class MemberMain {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		
		Member reserv = new Member();
		reserv.getSeat();
		reserv.readMovies();

	}

}

class Member{
	
	File fileName = new File("src/project/movies.txt");
	
	private void setSeat()
	{
		System.out.println("좌석을 선택해주세요.");
		char a=' ';
		int sum=1;
		Scanner sc=new Scanner(System.in);
		int row = sc.nextInt();
		int column =sc.nextInt();
		
		int[][] seat=new int[row][column];
		for(int i=0; i<seat.length; i++)
		{
			int j;
			for(j=0; j<seat[i].length; j++)
			{
				seat[i][j]=j+sum;
			}
			char seatrow=(char)(i+65);
			
			System.out.println("===============");
			System.out.println(seatrow+Arrays.toString(seat[i]));
		}
	}
	
	void getSeat()
	{
		setSeat();
	}
	
	void readMovies() throws IOException
	{
		ArrayList<String> rsv=new ArrayList<String>();
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		br.close();
		fr.close();
		
				
	}
	
}