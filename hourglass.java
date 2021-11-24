import java.util.*;

public class hourglass{
	public static void main(String[] args) {
		System.out.print("Enter an integer :");
		Scanner console=new Scanner(System.in);
		int a=console.nextInt();
		System.out.println();

		//check input from user >=1
		if(a<=0)
			System.out.println("ERROR");
			else
			print(a);

		System.out.println();
	}

	static int count=0;//create a variable as count of space
	public static void print(int x){
		if(x==0){
			return;
		}
		else{
			count++;//add one to count everytime print be call
			space(count," ");
			star(x,"* ");
			System.out.println();//finish print first line

			print(x-1);//call print

			space(count," ");//reach here when x<=1
			star(x,"* ");
			System.out.println();
			count--;//count have to minus one because current count=input a
		}
	}

	public static void star(int a,String b){
		if(a==0){
			return;
		}
		else{
			System.out.print(b);
			star(a-1,b);
		}
	}

	public static void space(int a,String b){
		if(a==1){//not a==0 because first line we do not print any space infront
			return;
		}
		else{
			System.out.print(b);
			space(a-1,b);
			}
	}

}//close class
