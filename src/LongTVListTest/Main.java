import java.util.Random;

public class Main {
	public static void main(String[] args) {
		orderInsert(100000);
	}

	private static void orderInsert(int size) {
		long totalTime = 0;
		for (int j = 0; j < 10; j++)
		{
			long startTime = System.currentTimeMillis();
			LongTVList tvList = new LongTVList();
			for (int i = 0; i < size; i++)
			{
				tvList.putLong(i, Long.valueOf(i));
			}
			long endTime = System.currentTimeMillis();
			totalTime += endTime - startTime;
		}

		System.out.println("total: " + (totalTime) + "ms");
		System.out.println("avg: " + (totalTime) / 10.0 + "ms");
	}

	private static void randomInsert(int size) {
		long insertTime = 0;
		long sortTime = 0;
		Random random = new Random();

		for (int j = 0; j < 10; j++) {
			int[] dataList = new int[size];
			for (int i = 0; i < size; i++) {
				dataList[i] = i;
				if (i > 0) {
					int swapIndex = random.nextInt(i);
					int tmp = dataList[swapIndex];
					dataList[swapIndex] = dataList[i];
					dataList[i] = tmp;
				}
			}

			long startTime = System.currentTimeMillis();
			LongTVList tvList = new LongTVList();
			for (int i = 0; i < size; i++) {
				tvList.putLong(dataList[i], Long.valueOf(dataList[i]));
			}
			long endTime = System.currentTimeMillis();
			insertTime += endTime - startTime;

			startTime = System.currentTimeMillis();
			tvList.sort();
			endTime = System.currentTimeMillis();
			sortTime += endTime - startTime;
		}

		System.out.println("insert total: " + (insertTime) + "ms");
		System.out.println("insert avg: " + (insertTime) / 10.0 + "ms");
		System.out.println("sort total: " + (sortTime) + "ms");
		System.out.println("sort avg: " + (sortTime) / 10.0 + "ms");
		System.out.println("total: " + (insertTime + sortTime) + "ms");
		System.out.println("avg: " + (insertTime + sortTime) / 10.0 + "ms");
	}
}