import java.util.*;

public class Group_Anagrams {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = new ArrayList<>();
        System.out.println(GroupAnagrams(strs));
    }

    /**
     * 字母异位词分组
     * */
    public static List<List<String>> GroupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);
            List<String> list = map.getOrDefault(str, new ArrayList<>());
            list.add(strs[i]);
            map.put(str, list);
        }
        return map.values().stream().toList();
    }
}
