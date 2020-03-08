// Read N Characters Given Read4 用 Read4 读取 N 个字符

@EASY
public class LC157 extends Reader4 {

	@EASY
  public int read(char[] buf, int n) {
    int count = 0;
    int sum = 0;
    char[] temp = new char[4];
    int index = 0;
    
    while(index < n) {
      count = read4(temp);
      
      for(int i = 0; i < count; i++) {
        buf[index + i] = temp[i];
      }
      
      sum += count;
      index += 4;
    }
    
    return sum > n ? n : sum;
  }
}
