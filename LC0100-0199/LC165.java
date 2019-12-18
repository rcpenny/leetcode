// Compare Version Numbers

@MEDIUM
public class LC165 {

	@String
	public int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		
		int m = v1.length;
		int n = v2.length;

		for (int i = 0; i < Math.max(m, n); i++) {
			int num1 = i < m ? Integer.valueOf(v1[i]) : 0;
			int num2 = i < n ? Integer.valueOf(v2[i]) : 0;

			if (num1 != num2) {
				return num1 > num2 ? 1 : -1;
			}
		}

		return 0;
	}
}
