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
				
				numOfPartitions += numOfPartitions(difference, i);
			}
		}
		
		return numOfPartitions;
	}
	
	private static int numOfPartitions(int realNum, int num) {
		int numOfPartitions = 0;
		
		for(int i = num; i > 0; i--) {
			
			int difference = realNum - i;
			
			if(difference <= i) {
				
				if(difference <= 1) {
					
					numOfPartitions++;
				} else {
					
					numOfPartitions += numOfPartitions(difference);
				}
			} else {
				
				numOfPartitions += numOfPartitions(difference, i);
			}
		}
		
		return numOfPartitions;
	}
	
	public static int[][] partitions(int num) {
		int[][] partitions = new int[numOfPartitions(num)][num];
		
		for(int numCopy = num, inc = 0; numCopy > 0 && inc < partitions.length; numCopy--, inc++) {
			
			int difference = num - numCopy;
			
			if(difference <= numCopy) {
				
				if(difference <= 1) {
					
					partitions[inc][0] = numCopy;
					
					if(difference != 0)
						partitions[inc][1] = difference;
				} else {
					
					int[][] partitionsOfDifference = partitions(difference);
					for(int[] i : partitionsOfDifference) {
						
						partitions[inc][0] = numCopy;
						for(int j = 1; j <= i.length; j++) {
							
							partitions[inc][j] = i[j - 1];
						}
						
						inc++;
					}
				}
			} else {
				
				int[][] partitionsOfDifference = partitions(difference, numCopy);
			}
		}
		
		return partitions;
	}
	
	private static int[][] partitions(int realNum, int num) {
		int[][] partitions = new int[numOfPartitions(realNum) - 1][realNum];
		
		for(int numCopy = num, inc = 0; numCopy > 0; numCopy--, inc++) {
			
			int difference = realNum - numCopy;
			
			if(difference <= numCopy) {
				
				if(difference <= 1) {
					
					partitions[inc][0] = numCopy;
					
					if(difference != 0)
						partitions[inc][1] = difference;
				} else {
					
					int[][] partitionsOfDifference = partitions(difference);
					for(int[] i : partitionsOfDifference) {
						
						partitions[inc][0] = numCopy;
						for(int j = 1; j <= i.length; j++) {
							partitions[inc][j] = i[j - 1];
						}
						inc++;
					}
				}
			} else {
				

				int[][] partitionsOfDifference = partitions(difference, numCopy);
			}
		}
		
		return partitions;
	}
}
