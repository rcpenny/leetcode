// Find Duplicate File in System 在系统中查找重复文件

@MEDIUM
public class LC609 {

  @Design
  public List<List<String>> findDuplicate(String[] paths) {
		List<List<String>> dupeFiles = new ArrayList<>();
		Map<String, List<String>> contentToPaths = new HashMap<>();

		for (String path : paths) {
			String[] strs = path.split(" ");

			String dir = strs[0] + "/";
			FileInfo info;

			for (int i = 1; i < strs.length; i++) {
        info = getFileInfo(strs[i]);
        contentToPaths.putIfAbsent(info.fileContent, new ArrayList<>());
        contentToPaths.get(info.fileContent).add(dir + info.fileName);
      }
		}

    for (String content : contentToPaths.keySet()) {
      if (contentToPaths.get(content).size() > 1)
        dupeFiles.add(new ArrayList<>(contentToPaths.get(content)));
    }

		return dupeFiles;
	}

	private FileInfo getFileInfo(String file) {
		int index = file.indexOf('(');
		return new FileInfo(file.substring(0, index), file.substring(index + 1));
	}
}

class FileInfo {
	String fileName;
	String fileContent;

	FileInfo(String name, String content) {
		this.fileName = name;
		this.fileContent = content;
	}
}