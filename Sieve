//Problem 2 : Find the Prime

import java.util.Queue;
import java.util.LinkedList;

public class Sieve{
	private boolean call;
	private Queue<Integer> prime=new LinkedList<Integer>();
	private int x;

	public void computeTo(int n)throws IllegalArgumentException{
		this.x=n;//so that n can pass to getMax()
		if(n<2){
			throw new IllegalArgumentException("Number is less than 2");
		}

		Queue<Integer> num=new LinkedList<Integer>();
		for(int i=2;i<=n;i++){//a queue that store integers from 2 to n
			num.add(i);
		}

		while(!prime.isEmpty()){//make sure prime is an empty queue
			prime.remove();
		}
		int p;
		do{
			p=num.remove();//get first element of num
			prime.add(p);
			Queue<Integer> backUp=new LinkedList<Integer>();
			while(!num.isEmpty()){
				int temp=num.remove();//get second element
				if(temp%p!=0){
					backUp.add(temp);//store element to backUp if not divisible by p
				}
				}//close for loop

			while(!backUp.isEmpty()){
				/*add remaining number back to num
				so now number in num is undivisible by temp just now*/
				num.add(backUp.remove());
			}
		}while(p<Math.sqrt(n));
		/*now remaining number in num is confirm a prime number
		transfer them to prime*/
		while(!num.isEmpty()){
			prime.add(num.remove());
		}
		call=true;
	}

	public void reportResults(){
		if(!call){
			throw new IllegalStateException("Please enter value of n");
		}

		System.out.println("Primes up to "+getMax()+" are as follow:");
		int count=0;
		Queue<Integer> backUp=new LinkedList<Integer>();

		while(!prime.isEmpty()){
			//remove number from front and print it out
			int temp=prime.remove();
			System.out.print(temp+" ");
			count++;
			//store the remove number in backUp
			backUp.add(temp);
			if(count==12){
				//so that each line contain 12 numbers
				System.out.println();
				count=0;
			}
		}
		System.out.println();

		//store back all number to prime
		while(!backUp.isEmpty()){
			prime.add(backUp.remove());
		}
	}

	public int getMax(){
		if(!call){
			throw new IllegalStateException("Please enter value of n");
		}
		return this.x;
	}

	public int getCount(){
		if(!call){
			throw new IllegalStateException("Please enter value of n");
		}
		return prime.size();
	}

}//close class
