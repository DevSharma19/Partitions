public class Logic {
	
	public static int numOfPartitions(int num) {
		int numOfPartitions = 0;
		
		for(int i = num; i > 0; i--) {
			
			int difference = num - i;
			
			if(difference <= i) {
				
				
				if(difference <= 1) {
					
					numOfPartitions++;
				} else {
					
					numOfPartitions += numOfPartitions(difference);
				}
			} else {
				
				numOfPartitions += numOfPartitionsAfterNum(difference, i);
			}
		}
		
		return numOfPartitions;
	}
	
	private static int numOfPartitionsAfterNum(int num, int realNum) {
		int numOfPartitions = 0;
		
		for(int i = realNum; i > 0; i--) {
			
			int difference = num - i;
			
			if(difference <= i) {
				if(difference <= 1) {
					
					numOfPartitions++;
				} else {
					
					numOfPartitions += numOfPartitions(difference);
				}
			} else {
				
				numOfPartitions += numOfPartitions(i);
			}
		}
		
		return numOfPartitions;
	}
}
