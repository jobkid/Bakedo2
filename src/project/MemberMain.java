package project;

import java.util.Arrays;

public class MemberMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char a=' ';
		int sum=1;
		int[][] seat=new int[6][5];
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

}
