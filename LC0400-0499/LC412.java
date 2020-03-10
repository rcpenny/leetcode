// Fizz Buzz

@EASY
public class LC412 {

	@Math
	public List<String> fizzBuzz(int n) {
		List<String> results = new ArrayList<String>();
		
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) results.add("FizzBuzz");
			else if (i % 5 == 0) results.add("Buzz");
			else if (i % 3 == 0) results.add("Fizz");
			else results.add(String.valueOf(i));
		}

		return results;
	}
}
