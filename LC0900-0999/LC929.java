// Unique Email Addresses

@EASY
public class LC929 {

	@String
	public int numUniqueEmails(String[] emails) {
		Set<String> seen = new HashSet<>();
		
		for (String email : emails) {
			int i = email.indexOf('@');
			String alias = email.substring(0, i);
			String domain = email.substring(i);

			if (alias.contains("+")) {
				alias = alias.substring(0, alias.indexOf('+'));
			}
			alias = alias.replace(".", "");
			seen.add(alias + domain);
		}

		return seen.size();
	}
}
