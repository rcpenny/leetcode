// H-Index

@MEDIUM
public class LC274 {
  
  @HashTable
  public int hIndex(int[] citations) {
    int n = citations.length;

    // papers[i] number of papers with more citations than i
    int[] papers = new int[n + 1];

    for (int c : citations) {
      papers[Math.min(n, c)]++;
    }

    int k = n;
    for (int i = papers[n]; k > i; i += papers[k]) {
      k--;
    }

    return k;
  }
}
