// Median of Two Sorted Arrays 寻找两个有序数组的中位数

@HARD
public class LC4 {
  
  @BinarySearch
	public double findMedianSortedArrays(int[] A, int[] B) {
		int L = A.length + B.length;

		if (L % 2 == 1) return kthLargest(A, B, L / 2 + 1) * 1.0;
	
		int a = kthLargest(A, B, L / 2); // 第L/2个, index L/2 - 1
		int b = kthLargest(A, B, L / 2 + 1);
		return (a + b) / 2.0;
	}

	private int kthLargest(int[] A, int[] B, int k) {
		if (A.length == 0) return B[k - 1];
		if (B.length == 0) return A[k - 1];

		int start = Math.min(A[0], B[0]);
		int end = Math.max(A[A.length - 1], B[B.length - 1]);

		// find first x that >= k numbers is smaller or equal to x
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (countSmallerOrEqual(A, mid) + countSmallerOrEqual(B, mid) < k)
				start = mid;
			else
				end = mid;
		}

		if (countSmallerOrEqual(A, start) + countSmallerOrEqual(B, start) >= k)
			return start;
		return end;
	}

	private int countSmallerOrEqual(int[] array, int number) {
		int start = 0;
		int end = array.length - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;

			if (array[mid] <= number) start = mid;
			else end = mid;
		}

		if (array[start] > number) return start;
		if (array[end] > number) return end;

		return array.length;
	}
}
