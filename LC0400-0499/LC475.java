// Heaters 供暖器

@EASY
public class Heaters {

	@BinarySearch
  public int findRadius(int[] houses, int[] heaters) {
		int max_radius = Integer.MIN_VALUE;
		Arrays.sort(heaters);

		for (int i = 0; i < houses.length; i++)
			max_radius = Math.max(max_radius, closestHeaterDistance(heaters, houses[i]));

		return max_radius;
	}

	public int closestHeaterDistance(int[] heaters, int pos) {
		int start = 0;
		int end = heaters.length - 1;

		while (start + 1 < end) {
			int middle = start + (end - start) / 2;
			if (heaters[middle] == pos) return 0;
			
			if (heaters[middle] > pos) end = middle;
			else start = middle; 
		}

		int start_diff = Math.abs(heaters[start] - pos);
		int end_diff = Math.abs(heaters[end] - pos);
    return Math.min(start_diff, end_diff);
	}
}
