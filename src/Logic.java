public class Logic {
	
	public static int numOfPartitions(int num) {
		int numOfPartitions = 0;
		
		for(int i = num; i > 0; i--) {
			
			int difference = num - i;
			
			System.out.println("NUM:" + num + ", DIFF:" + difference + ", i:" + i);
			
			if(difference <= i) {
				
				System.out.print("					PASSED\n");
				
				if(difference <= 1) {
					
					numOfPartitions++;
				} else {
					
					numOfPartitions += numOfPartitions(difference);
				}
			} else {
				
				System.out.print("					FAILED\n");
				numOfPartitions += numOfPartitions(i);
			}
		}
		
		return numOfPartitions;
	}
}
