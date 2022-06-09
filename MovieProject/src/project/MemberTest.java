package project;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MemberTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//영화 목록 보기//영화 삭제할 때도 아래 코드 구현 후 선택하기 기능 추가
		ArrayList<String> movie = new ArrayList<String>();
		File movies=new File("src/project/movies.txt");
		FileReader frmovies=new FileReader(movies);
		BufferedReader brmovies=new BufferedReader(frmovies);
		
		String data;
		int i=0;
		while((data=brmovies.readLine())!=null)
		{	
			i++;
			//movie.add(data);
			System.out.println("["+(i)+"] "+data);
			movie.add(data);
			
		}
		
		System.out.println("============================");
		System.out.println("총 "+movie.size()+"개 영화가 있습니다.");
		
		
		brmovies.close();
		frmovies.close();
		
		//영화 선택하기
		System.out.println("예매할 영화를 선택해주세요. 선택은 1번 취소는 2번");
		Scanner sc=new Scanner(System.in);
		int select=sc.nextInt();
		
		for(i=0; i<movie.size(); i++)
		{
			System.out.println("영화를 선택해주세요.");
			if(select==1)
			{
				int j=sc.nextInt();
				System.out.println(movie.get(j-1));
				System.out.println("영화 선택을 취소하려면 0을 눌러주세요");
				int exit=sc.nextInt();
				if(exit==0)
				{
					
				}
			}
			else if(select==2){
				
			}
			
		}
		
		

	}

}
