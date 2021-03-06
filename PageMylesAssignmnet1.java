import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
Myles Page
Cs 1450 002
Monday - Wednesday
Due 
Assignment 1
1-27-2021
Understand Loops 
*/
public class PageMylesAssignmnet1 {
	
	 public static void main(String[] args) throws FileNotFoundException {
		 //variables used through out the program 
		 int[] array = {1, 18, 10, 2, 16, 8, 15, 9, 9, 17, 14, 18, 1, 19, 18, 2, 1};
		 int size = 0; 
		 int oddTotal = 0;
		 int evenTotal = 0;
		 
		 //Task 1
		 //_________________________________________________________________________________
		 
		 size = 0; 
		 //prints the array spot by spot
		 while(size < array.length) {
			 System.out.println("Array "+ size + ": = " + array[size]);
			 size++;
		 }
		 //sorts the array 
		 Arrays.sort(array);
		 
		 //Task 2
		 //_________________________________________________________________________________
		 
		 //Makes the file
		 File arrayFile = new File("assignment1.txt");
		 PrintWriter outputFile = new PrintWriter (arrayFile);
		 size = 0;
		 //prints the array to the file and sorts by even or odd
		 while(size < array.length) {
			//if even 
			if(array[size] % 2 == 0) {
				evenTotal++;
				outputFile.println(array[size]);
		 	}
			//else odd
			else {
				oddTotal++;
				outputFile.println(array[size]);
			}
			size++;
		 }
		 //prints the values
		 System.out.println("\n\nValues Added To File");
		 System.out.println("Total values: " + size);
		 System.out.println("Total Even Values: " + evenTotal);
		 System.out.println("Total Odd Values: " + oddTotal); 
		 //closes the file
		 outputFile.close();
		 
		 //Task 3
		 //_________________________________________________________________________________
		 //opens the file to be read
		 File assignment1 = new File("assignment1.txt");
		 Scanner read = new Scanner(assignment1);
		 //placeholder array
		 int[] placeholder = new int[size];
		 //variables
		 size = 0;
		 int last = 0;
		 oddTotal = 0;
		 evenTotal = 0;
		 //read in 
		 while(read.hasNext()){
			 //set the current
			 int current = read.nextInt();
			 //checks if duplicate 
			 if(last != current) {
				 if(current % 2 == 0) {
					 evenTotal++;
				 }
				 else {
					 oddTotal++;
				 }
				 placeholder[size] = current;
				 size++;
				 last = current;
			 } 
		 }
		 
		 //variables
		 int x = 0;
		 int[] evenArray = new int[evenTotal];
		 int[] oddArray = new int[oddTotal];
		 int evenPlace = 0;
		 int oddPlace = 0;
		 
		 //fills the array based on even or odd
		 while(x < size) {
			 if(placeholder[x] % 2 == 0) {
				evenArray[evenPlace] = placeholder[x];
				evenPlace++;
				x++;
			 }	
			 else {
				oddArray[oddPlace] = placeholder[x];
				oddPlace++;
				x++;
			}
		 }
		 
		 //prints even
		 size = 0; 
		 System.out.println("\n\nEven Array\n-----------");
		 while(size < evenArray.length) {
			 System.out.println("Even ["+ size + "] = " + evenArray[size]);
			 size++;
		 }
		 
		 //prints odd
		 size = 0;
		 System.out.println("\n\nOdd Array\n-----------");
		 while(size < oddArray.length) {
			 System.out.println("Odd ["+ size + "] = " + oddArray[size]);
			 size++;
		 }
		 //closes scanner
		 read.close();
	 }
}
