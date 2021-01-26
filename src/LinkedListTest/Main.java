import java.util.List;
import java.util.LinkedList;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		randomInsert(1000000);
	}

	private static void orderInsert() {
		long startTime = System.currentTimeMillis();

		for (int j = 0; j < 10; j++)
		{
			LinkedList<Long> list = new LinkedList<>();
			for (int i = 0; i < 1000000; i++)
			{
				list.addLast(Long.valueOf(i));
			}
		}

		long endTime = System.currentTimeMillis();
		System.out.println("total: " + (endTime - startTime) + "ms");
		System.out.println("avg: " + (endTime - startTime) / 10.0 + "ms");
	}

	private static void randomInsert(int size) {
		long totalTime = 0;
		Random random = new Random();

		for (int j = 0; j < 1; j++) {
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
			LinkedList<Long> list = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				if (i > 0) {
					int counter = 0;
					Long tmp = Long.valueOf(dataList[i]);
					for (Long k : list) {
						if (k > tmp) {
							break;
						}
						++counter;
					}
					list.add(counter, tmp);
				}
				else {
					list.addLast(Long.valueOf(dataList[i]));
				}
			}
			long endTime = System.currentTimeMillis();
			totalTime += endTime - startTime;
			for (int i = 1; i < size; i++)
				if (list.get(i) < list.get(i - 1))
					System.out.println("error");
		}

		System.out.println("total: " + (totalTime) + "ms");
		System.out.println("avg: " + (totalTime) / 1.0 + "ms");
	}
}