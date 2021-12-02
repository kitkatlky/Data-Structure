# Data-Structure
A variety of algorithmic techniques will be introduced in this course and students will gain an appreciation of the use and importance of data structures. A range of well-established data structures will be examined, and their properties are described so that it becomes clear which representations are appropriate under which circumstances. In addition to gaining a conceptual understanding of how data can be organized, a much more efficient common data processing tasks such as sorting and searching strategies will also be presented.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

ASSIGNMENT 1 Linked list manipulations

[ASSIGNMENT 1 (Q1-10).pdf](https://github.com/kitkatlky/Data-Structure/files/7598099/ASSIGNMENT.1.Q1-10.pdf)

[assignment 1 complete.pdf](https://github.com/kitkatlky/Data-Structure/files/7598101/assignment.1.complete.pdf)

The first 20 exercises on this page are quite short. They will help you master basic linked list operations. The last 2 programming assignments are more
challenging. They will help you become comfortable designing and implementing robust algorithms to manipulate linked lists.

Use this declaration of the Node class:


final class Node
{
  char info;
  Node next;
    public Node(char letter, Node node)
    {
      info = letter;
      next = node;
    }
}

                             Construct                           Examples
                        1. Assignment                   n1 = n4.next; n1.next = null;
                        2. Node instantiation           n3.next.next = new Node('B',null);
                        3. Assignment                   n1.info = n4.next.info; n1.next.info = 'C';
                        4. If statement                 if (n1==null) {...} else {...}
                        5. While loop                   while ( (n1!=null) && (n1.info=='A') ) {...}
                        
Short exercises
For each exercise:
- Write the Java statements that will produce the "initial setup"
- Write the Java statements that will transform the inital setup into the "final configuration."
User the Java Visualizer to execute your solution and visualize the data structures.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

ASSIGNMENT 2 Stack and Queue

[Assignment 2-Stack and Queue Assignment.pdf](https://github.com/kitkatlky/Data-Structure/files/7598123/Assignment.2-Stack.and.Queue.Assignment.pdf)

Problem 1: Calculating Stacks

Your first task is to implement a basic RPN calculator that supports integer operands like 1, 64738, and -42 as well as the (binary) integer operators +, -, *, /, and %. The style of arithmetic expressions our calculator will evaluate is also called a post-fix notation. Stacks are great for doing this job!

Your program should work as follows:

    • The user enters input consisting of operands and operators, presumably in post-fix notation. We have also included some extra operators to get information about results 
      and the current state of the stack.
      
    • If the user enters a valid integer, you push that integer onto the stack.
    
    • If the user enters a valid operator, you pop two integers off the stack, perform the requested operation, and push the result back onto the stack.
    
    • If the user enters the symbol ? (that’s a question mark), you print the current state of the stack followed by a new line.
    
    • If the user enters the symbol ^ (that’s a caret), you pop the top element off the stack and print only that element (not the entire stack) followed by a new line.
    
    • If the user enters the symbol ! (that’s an exclamation mark or bang), you exit the program.
    
Note that there are several error conditions that your program must deal with gracefully for full credit. We’ll give you two examples for free, you’ll have to figure out any further error conditions for yourself:

    • If the user enters blah or 1.5 or anything else that doesn’t make sense for an integer calculator as specified above, your program should make it clear that it can’t do 
      anything helpful with that input; but it should not stop at that point.
    • If the user requests an operation for which there are not enough operands on the stack, your program should notify the user of the problem but leave the stack unchanged;
      again, it should certainly not stop at that point.
      
All error messages must start with the symbol # (that’s a hash sign) and be followed by a new line!

Examples

Here are two examples for interacting with Calc that will hopefully help you understand what you’re trying to achieve. First a “slow” example:

$ java Calc

?

[]

10

?

[10]

20 30

?

[10, 20, 30]

*

?

[30, 600]

+

?

[630]

^

630

?

[]

!

$

Here $ is the shell prompt. After starting the program, the first command was ? to print the stack (which is empty at this point, hence [] is the output). Then the user typed 10 followed by ? and we see that the stack now holds that number: [10]. Now the user typed two numbers 20 30 in sequence before hitting return. When we check the stack now using ? we get the answer [10, 20, 30] so obviously the “top” of the stack is to the right. Then we see the * operator being typed, which will multiply the top two numbers. We use ? again to check the result: [30, 600]. This is followed by the + operator, which will add the top two numbers. Again we check with ? and get [630] as we’d expect. The ^ command prints the same result 630 and pops if off the stack. So the next ? shows an empty stack again. Finally the user typed the ! command to quit, returning us to the shell. Here’s the same example, done “fast” this time:

$ java Calc

? 10 ? 20 30 ? * ? + ? ^ ? !

[]

[10]

[10, 20, 30]

[30, 600]

[630]

630

[]

$

As you can see, if the entire sequence of integers, operators, and commands is entered on a single line, they are all executed in order. It’s like having our own little programming language! Finally, here’s an example for the sample error conditions described above:

$ java Calc

1 2 blah 1.0 3 ?

#Invalid input.

#Invalid input.

[1, 2, 3]

+ + ?

[6]

+ + ?

#Not enough arguments.

#Not enough arguments.

[6]

!

$

Note that blah and 1.0 lead to error messages but are otherwise ignored (the program doesn’t stop); same for the two + operations when the stack only has a single element (the program doesn’t even modify the stack in that case).

Note: Original question can be found in the url below. The questions were tailored as how we discussed and implement stack in class.
http://www.cs.jhu.edu/~cs226/assignment-stack-queue-v2.html


Problem 2: Find the Prime

This assignment will give you practice with queues. You are going to implement a class that computes all the primes up to some integer n. The technique you are to use was developed by a Greek named Eratosthenes who lived in the third century BC. The technique is known as the Sieve of Eratosthenes.

The algorithm is described by the following pseudocode:

create a queue and fill it with the consecutive integers 2 through n inclusive. 

create an empty queue to store primes. 

do { 

      obtain the next prime p by removing the first value in the queue of numbers. 
      
      put p into the queue of primes. 
      
      go through the queue of numbers, eliminating numbers divisible by p. 
      
  } while (p < sqrt(n)) 

all remaining values in numbers queue are prime, so transfer them to primes queue

You are to use the Queue interface provided by Java. When you want to construct a Queue 'object', you must make it of type LinkedList (also provided by Java)

You should define a class called Sieve with the following public methods:

                  Method                                          Description
                  
            Sieve()                            Constructs a sieve object.
          void computeTo(int n)              This is the method that should implement the sieve algorithm. All prime computations must be implemented using this algorithm. 
                                              The method should compute all primes up to and including n. It should throw an IllegalArgumentException if n is less than 2.
          void reportResults()               This method should report the primes to System.out. It should throw an IllegalStateException if no legal call has been made yet on
                                              the computeTo method. It is okay for it to have an extra space at the end of each line.
          int getMax()                       This is a convenience method that will let the client find out the value of n that was used the last time computeTo was called. It
                                              should throw an IllegalStateException if no legal call has been made yet on the computeTo method.
          int getCount()                     This method should return the number of primes that were found on the last call on computeTo. It should throw an
                                              IllegalStateException if no legal call has been made yet on the computeTo method.

Your reportResults method should print the maximum n used and should then show a list of the primes, 12 per line with a space after each prime. Notice that there is no guarantee that the number of primes will be a multiple of 12. The calls on reportResults must exactly reproduce the format of the sample log (see below). The final line of output that appears in the log reporting the percentage of primes is generated by the main program, not by the call on reportResults.

Make sure you use references of type Queue for this assignment. You should also be sure to specify that we want queues of "Integer" (Queue<Integer> and LinkedList<Integer>). If you fail to specify this properly, the compiler will warn you that you are using "unsafe" operations.

You must guarantee that your object is never in a corrupt state. For example, your sieve object might be asked to compute up to one value of n and then asked to compute up to a different value of n without a call on reportResults ever being made. Similarly, your object might be asked to compute up to some value of n and then be asked to reportResults more than once. Each call on reportResults, getMax and getCount should behave appropriately given the previous call on computeTo, no matter how often they are called or in what order. Finally, notice that if reportResults, getMax or getCount are called before a legal call on computeTo, they throw an exception to indicate that the operation is not legal given the object’s state.

In terms of correctness, your class must provide all of the functionality described above. In terms of style, you will be graded on your use of comments, good variable names, consistent indentation and good coding style to implement these operations. You will lose points if you declare unnecessary data fields (redundant fields or variables that can be local to a method).

Use SieveMain.java (given below) that constructs a sieve object and makes calls on it based on values entered by the user. You can use this program to test your class, but keep in mind that it does not test the internal consistency of your object.

//
  
// author: Stuart Reges 4/18/05
  
//
  
// This program computes all the prime numbers up to a given integer n. It
  
// uses the classic "Sieve of Eratosthenes" to do so.
  
import java.util.*;
  
public class SieveMain {
  
    public static void main(String[] args) {
  
        System.out.println("This program computes all prime numbers up to a");
  
        System.out.println("maximum using the Sieve of Eratosthenes.");
  
        System.out.println();
  
        Scanner console = new Scanner(System.in);
  
        Sieve s = new Sieve();
  
        for(;;) {
  
            System.out.print("Maximum n to compute (0 to quit)? ");
  
            int max = console.nextInt();
  
            if (max == 0)
  
                break;
  
            System.out.println();
  
            s.computeTo(max);
  
            s.reportResults();
  
            int percent = s.getCount() * 100 / s.getMax();
  
            System.out.println("% of primes = " + percent);
  
             System.out.println();
  
          }
  
     }
  
}

  
Sample of Log of Execution (user responses underlined)
  
This program computes all prime numbers up to a
maximum using the Sieve of Eratosthenes.
  
Maximum n to compute (0 to quit)? 20
  
Primes up to 20 are as follows:
  
2 3 5 7 11 13 17 19
  
% of primes = 40
  
Maximum n to compute (0 to quit)? 100
  
Primes up to 100 are as follows:
  
2 3 5 7 11 13 17 19 23 29 31 37
  
41 43 47 53 59 61 67 71 73 79 83 89
  
97
  
% of primes = 25
  
Maximum n to compute (0 to quit)? 0
  
Note: Original question can be found in the url below. The questions were tailored as how we discussed and implement queue in class.
http://penguin.ewu.edu/cscd300/Summer_11/Assignments/prog3.html
  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

ASSIGNMENT 3 Recursion (hourglass, commas) 
  
  [Recursion Assignments.pdf](https://github.com/kitkatlky/Data-Structure/files/7598212/Recursion.Assignments.pdf)
  
In these assignments, you will write Java programs that each contain a recursive method.
  
The first, Hourglass, prints a symmetric graphic using simple text output. The second, Commas, prints a long integer with commas in the correct places. The
names of the classes containing main should start with upper case letters: Hourglass, and Commas.
  
Classes (other than the class containing main), arrays, loops, stacks, queues, and linked lists are inappropriate here and should not be used in the
recursive methods. The Hourglass program should not contain any loops. None. The Commas program will have an input loop but no other loops. Do not use
data structures beyond Strings in the Hourglass program. Include comments at the top of your programs and on any method other than main.
  
Carefully note the restrictions on language feature use in the specifications for each program.
