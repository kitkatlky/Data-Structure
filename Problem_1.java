//Problem 1 : Calculating Stacks

import java.io.*;
import java.util.*;

public class Problem_1{
	public static void main(String args[]){
		Stack<Integer> s=new Stack<Integer> ();
		String[] operator={"+","-","*","/","%"};

		System.out.println("Enter integer like 1, 64738 and -42 \n\tor operation like  +, -, *, /, and %\n");
		System.out.println("Enter ? if you want to print the current state of the stack");
		System.out.print("Enter ^ if you want to pop the top element off the stack and");
		System.out.println("\n\tprint only that element (not the entire stack)");
		System.out.println("Enter ! if you want to exit the program\n");

		Scanner sc=new Scanner(System.in);
		String a[];
		List<String> list;

		do{
			a=sc.nextLine().split(" ");//if user done "fast", store it as array
			for(int i=0;i<a.length;i++){//go through each element in array

				if(Arrays.asList(operator).contains(a[i])){
					//check if element contain operator
					s=operation(s,a[i]);
				}

				else if(a[i].equals("?")){
					System.out.println(s);
				}

				else if(a[i].equals("^")){
					System.out.println(s.pop());
				}
				else if(a[i].equals("!")){
					i=a.length;//immediate stop all action
				}
				else{
					/*if not equals to all above
					is the element is an integer? */
					try{
						int x=Integer.parseInt(a[i]);
						s.push(x);
						}

					catch(NumberFormatException e){
						//element is not any specific operator and integer
						System.out.println("#INVALID INPUT");
						}
				}

			}//close for loop
			list=Arrays.asList(a);

		}while(!list.contains("!"));

		System.out.println("BYE");

	}//close main

public static Stack operation(Stack<Integer> s,String a){
	Stack<Integer> backUp=new Stack<Integer>();
	while(!s.isEmpty()){
		//inverse stack s and store in backUp
		int z=s.pop();
		backUp.push(z);
		}

		if(backUp.size()>=2){
			/*get top element of backUp
			which means original first and second number in stack s*/
			int num_1=backUp.pop();
			int num_2=backUp.pop();

			//return all element from backUp to s
			while(!backUp.isEmpty()){
				s.push(backUp.pop());
				}

			if (a.equals("+")){
				s.push(num_1+num_2);
			}
			else if(a.equals("-")){
				s.push(num_1-num_2);
			}
			else if(a.equals("*")){
				s.push(num_1*num_2);
			}
			else{
				//check is valid to undergo division or modulo
				if(num_2==0){
					System.out.println("#ERROR DUE TO DIVIDING ZERO");
				}
				else{
					if(a.equals("/")){
						s.push(num_1/num_2);
						}
					else{
						//a equals "%"
						s.push(num_1%num_2);
					}

				}//close (num_2==0)

			}//close else operator

		}//close  if backUp>2

		else{
			//backUp less than 2 elements
			System.out.println("#Not enough argument");

			//return all element to s
			while(!backUp.isEmpty()){
				s.push(backUp.pop());
				}
			}

		return s;
	}//close operation

}//close class
