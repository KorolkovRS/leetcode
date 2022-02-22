import java.util.*;

//class Solution {
//    private boolean identity = false;
//    private boolean isGood = true;
//
//    public int rotatedDigits(int n) {
//        int count = 0;
//
//        for (int i = 1; i <= n; i++) {
//            if (checkDigit(i)) {
//                if (!identity) {
//                    count++;
//                }
//            }
//            identity = false;
//            isGood = true;
//        }
//        return count;
//    }
//
//    private boolean checkDigit(int n) {
//        if (!isGood) {
//            return false;
//        }
//        int ost = n%10;
//        n/=10;
//        if (n < 1) {
//            if (ost == 2 || ost == 5 || ost == 6 || ost == 9) {
//                identity = false;
//                return true;
//            }
//            if(ost == 1 || ost == 0) {
//                identity = true;
//                return true;
//            }
//            return false;
//        } else {
//            if (ost == 4 || ost == 7) {
//                return false;
//            }
//            if(n == 1 || n == 0) {
//                identity = true;
//            } else {
//                identity = false;
//            }
//            return checkDigit(n);
//        }
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.rotatedDigits(30));
//    }
//}

import java.util.*;

class Solution {
    private final Map<Character, Character> DIGITS = new HashMap<Character, Character>()
    {{
        put('0', '0');
        put('1', '1');
        put('8', '8');
        put('2', '5');
        put('5', '2');
        put('6', '9');
        put('9', '6');
    }};
    public int rotatedDigits(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (checkDigit(i)) {
                count++;
                System.out.println(i);
            }
        }
        return count;
    }

    private boolean checkDigit(int n) {
        String original = String.valueOf(n);
        char[] digits = original.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            if (!DIGITS.containsKey(digits[i])) {
                return false;
            }
            sb.append(DIGITS.get(digits[i]));
        }

        if (original.equals(sb.toString())) {
            return false;
        }
        return true;
    }
        public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rotatedDigits(30));
    }
}

//    x is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from x.
//    Each digit must be rotated - we cannot choose to leave it alone.
//
//        A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other
//        (on this case they are rotated in a different direction,
//        in other words 2 or 5 gets mirrored); 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
//
//        Now given a positive number n, how many numbers x from 1 to n are good?
//
//        Example:
//        Input: 10
//        Output: 4
//        Explanation:
//        There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
//        Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
//        Note:
//
//        n will be in range [1, 10000].