import java.util.Arrays;

class Solution {
    public int romanToInt(String s) {
        char[] romanNumbs = s.toCharArray();
        int intNum = 0;
        for (int i = 0; i < romanNumbs.length; ) {
            int current = parse(romanNumbs[i]);
            if (i < romanNumbs.length - 1) {
                int next = parse(romanNumbs[i + 1]);
                if (nextAction(current, next)) {
                    current = next - current;
                    i++;
                }
            }
            intNum += current;
            i++;
        }
        return intNum;
    }

    private int parse(char roman) throws IllegalArgumentException {
        switch (roman) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException();
        }
    }

    private boolean nextAction(int current, int next) {
        if (current == 1 && (next == 5 || next == 10)) {
            return true;
        }
        if (current == 10 && (next == 50 || next == 100)) {
            return true;
        }
        if (current == 100 && (next == 500 || next == 1000)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("VI"));
    }
}

//    Римские цифры представлены семью различными символами: I, V, X, L, C, D и M.
//
//        Значение символа
//        I 1
//        V 5
//        Х 10
//        L 50
//        C 100
//        D 500
//        М 1000
//        Например, 2 записывается как II римской цифрой, просто два единицы складываются вместе. 12 записывается как XII, что означает просто X + II. Число 27 записывается как XXVII, то есть XX + V + II.
//
//        Римские цифры обычно пишутся от наибольшего к наименьшему слева направо. Однако цифра для четырех не является IIII. Вместо этого число четыре записывается как IV. Поскольку единица находится перед пятью, мы вычитаем ее, делая четыре. Тот же принцип применим и к числу девять, которое записывается как IX. Существует шесть случаев, когда используется вычитание:
//
//        Я могу быть помещен перед V (5) и X (10), чтобы сделать 4 и 9.
//        X можно поместить перед L (50) и C (100), чтобы сделать 40 и 90.
//        C можно поместить перед D (500) и M (1000), чтобы сделать 400 и 900.
//        Учитывая римскую цифру, преобразуйте ее в целое число.
//
//
//
//        Пример 1:
//
//        Ввод: s = "III"
//        Выход: 3
//        Пример 2:
//
//        Вход: s = "IV"
//        Выход: 4
//        Пример 3:
//
//        Ввод: s = "IX"
//        Выход: 9
//        Пример 4:
//
//        Входные данные: s = "LVIII"
//        Выход: 58
//        Пояснение: L = 50, V= 5, III = 3.
//        Пример 5:
//
//        Входные данные: s = "MCMXCIV"
//        Выпуск: 1994 год
//        Пояснение: M = 1000, СМ = 900, XC = 90 и IV = 4.
//
//
//        Ограничения:
//
//        1 <= s.длина <= 15
//        с содержит только символы ("I", "V", "X", "L", "C", "D", "M").
//        Гарантируется, что s является допустимой римской цифрой в диапазоне [1, 3999].