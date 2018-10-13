import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number");
		int choice = sc.nextInt();
		
		int numOfPartitions = Logic.numOfPartitions(choice);
		System.out.println(choice + " has " + numOfPartitions + " partitions");
		
		int[][] partitions = Logic.partitions(choice);
		for (int[] i : partitions) {
			
			System.out.println();
			for (int j : i) {
				
				if(j != 0)
					System.out.print(j + ", ");
			}
		}
		
		sc.close();
	}
}
