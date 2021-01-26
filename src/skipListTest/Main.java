import java.util.Random;

public class Main {

	public static void main(String[] args) {
		randomInsert(1000000);
	}

	private static void orderInsert(int size) {
		long startTime = System.currentTimeMillis();

		for (int j = 0; j < 10; j++)
		{
			SkipList<Long> list = new SkipList<Long>();
			for (int i = 0; i < size; i++)
			{
				list.put(i, Long.valueOf(i * 2));
			}
		}

		long endTime = System.currentTimeMillis();
		System.out.println("total: " + (endTime - startTime) + "ms");
		System.out.println("avg: " + (endTime - startTime) / 10.0 + "ms");
	}

	private static void randomInsert(int size) {
		long totalTime = 0;
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
			SkipList<Long> list = new SkipList<Long>();
			for (int i = 0; i < size; i++) {
				list.put(dataList[i], Long.valueOf(dataList[i]));
			}
			long endTime = System.currentTimeMillis();
			totalTime += endTime - startTime;
		}

		System.out.println("total: " + (totalTime) + "ms");
		System.out.println("avg: " + (totalTime) / 10.0 + "ms");
	}
}