import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        char[] charS = s.toCharArray();
        char[] charG = goal.toCharArray();

        if (s.equals(goal)) {
            Set<Character> characterSet = new HashSet<>(charS.length);
            for (int i = 0; i < charS.length; i++) {
                if (characterSet.contains(charS[i])) {
                    return true;
                }
                characterSet.add(charS[i]);
            }
        }

        List<Character> diffS = new ArrayList<>(2);
        List<Character> diffG = new ArrayList<>(2);
        for (int i = 0; i < charS.length; i++) {
            if (charG[i] != charS[i]) {
                if (diffS.size() == 2) {
                    return false;
                }
                diffS.add(charS[i]);
                diffG.add(charG[i]);
            }
        }
        if (diffS.size() == 2) {
            if (diffG.get(0) == diffS.get(1) && diffS.get(0) == diffG.get(1)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.buddyStrings("abcd", "cbad"));
        System.out.println(solution.buddyStrings("ab", "ba"));
        System.out.println(solution.buddyStrings("ab", "ab"));
        System.out.println(solution.buddyStrings("aa", "aa"));
        System.out.println(solution.buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }
}


//    Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
//
//        Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
//
//        For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
//
//
//        Example 1:
//
//        Input: s = "ab", goal = "ba"
//        Output: true
//        Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
//        Example 2:
//
//        Input: s = "ab", goal = "ab"
//        Output: false
//        Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
//        Example 3:
//
//        Input: s = "aa", goal = "aa"
//        Output: true
//        Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
//        Example 4:
//
//        Input: s = "aaaaaaabc", goal = "aaaaaaacb"
//        Output: true
//
//
//        Constraints:
//
//        1 <= s.length, goal.length <= 2 * 104
//        s and goal consist of lowercase letters.