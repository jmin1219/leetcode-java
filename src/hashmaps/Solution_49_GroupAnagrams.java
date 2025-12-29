package hashmaps;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution_49_GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();

    for (int i = 0; i < strs.length; i++) {
      char[] charArray = strs[i].toCharArray();
      Arrays.sort(charArray);
      String sortedString = new String(charArray);

      if (map.containsKey(sortedString)) {
        map.get(sortedString).add(strs[i]);
      } else {
        List<String> newList = new ArrayList<>();
        newList.add(strs[i]);
        map.put(sortedString, newList);
      }
    }
    
    return new ArrayList<>(map.values());
  }
}
