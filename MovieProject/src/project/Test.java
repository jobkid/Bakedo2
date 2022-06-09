package project;
import java.io.*;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName="src/project/movie.txt";
		FileReader fr=new FileReader(fileName);
		
		int data=0;
		
		while((data=fr.read())!=-1)
		{
			System.out.print((char)data);
			//System.out.println();
			
		}
		fr.close();

	}

}
