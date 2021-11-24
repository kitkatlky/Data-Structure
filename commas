import java.util.*;
import java.io.File;

public class commas{
	public static void main(String[] args) throws Exception {
		File file=new File("numbers.txt");
		Scanner console=new Scanner(file);

		while(console.hasNextLong()){//loop while still have next value
			long input=console.nextLong();
			System.out.println("Original: "+input);
			addComma(input);
			System.out.println("\n");//complete print output
		}
	}//close main

	public static void addComma(long x){
		if(x<0){
			//print -ve sign ang call addComma with positive value
			System.out.print("-");
			addComma(-x);
		}
		else{
			if(x<1000){
				System.out.print(x);
			}
			else{
				long q=x/1000;
				long r=x%1000;
				addComma(q);//call addComma to check is q>1000

				//print remainder
				if(r<10){//remainder 0-9
					System.out.print(",00"+r);
				}
				else if(r<100){//remainder 0-99
					System.out.print(",0"+r);
				}
				else{//remainder 0-999
					System.out.print(","+r);
				}
			}//close x>=1000
		}//close x>=0
	}//close addComma

}//close class
