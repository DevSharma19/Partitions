import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		System.out.println(num + " has " + Logic.numOfPartitions(num) + " partitions");
		
		sc.close();
	}
}
