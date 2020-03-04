// Reorder Data in Log Files 重新排列日志文件

@EASY
public class LC937 {

	@Sorting
	public String[] reorderLogFiles(String[] logs) {
		String[] result = new String[logs.length];

		List<Log> letterLogs = new ArrayList<>();
		List<Log> digitLogs = new ArrayList<>();

		for (String log : logs) {
			Log tmp = generateLog(log);
			if (isLetterLog(tmp)) letterLogs.add(tmp);
			else digitLogs.add(tmp);
		}

		Collections.sort(letterLogs, (a, b) -> {
			if (!a.log.equals(b.log)) return a.log.compareTo(b.log);
			return a.id.compareTo(b.id);
		});

		int index = 0;
		for (Log log : letterLogs) result[index++] = log.id + " " + log.log;
		for (Log log : digitLogs) result[index++] = log.id + " " + log.log;

    return result;
	}
	
	private Log generateLog(String s) {
		int sp_index = s.indexOf(' ');
		return new Log(s.substring(0, sp_index), s.substring(sp_index + 1));
	}

	private boolean isLetterLog(Log log) {
		return Character.isLetter(log.log.charAt(0));
	}
}

class Log {
	String id;
	String log;
	Log(String id, String log) {
		this.id = id;
		this.log = log;
	}
}
