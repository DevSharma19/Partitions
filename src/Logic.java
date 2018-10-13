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

	public static int numOfPartitions(int realNum, int num) {
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

		for(int numCopy = num, inc = 0; numCopy > 0; numCopy--, inc++) {

			int difference = num - numCopy;

			if(difference <= numCopy) {

				if(difference <= 1) {

					partitions[inc][0] = numCopy;

					if(difference != 0)
						partitions[inc][1] = difference;
				} else {

					int[][] partitionsOfDifference = partitions(difference);
					for(int i = 0; i < partitionsOfDifference.length; i++) {

						partitions[inc][0] = numCopy;
						for(int j = 1; j <= partitionsOfDifference[0].length; j++) {

							partitions[inc][j] = partitionsOfDifference[i][j - 1];
						}

						if(i != partitionsOfDifference.length - 1)
							inc++;
					}
				}
			} else {
			}
		}

		return partitions;
	}
}
