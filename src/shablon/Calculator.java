package shablon;

import java.util.TreeMap;

public class Calculator {
    public TreeMap<Character, Integer> romeNumber = new TreeMap<>();
    public TreeMap<Integer, String> arabianNumber = new TreeMap<>();
    public Calculator() {
        romeNumber.put('I', 1);
        romeNumber.put('V', 5);
        romeNumber.put('X', 10);
        romeNumber.put('L', 50);
        romeNumber.put('C', 100);

        arabianNumber.put(100, "C");
        arabianNumber.put(90, "XC");
        arabianNumber.put(50, "L");
        arabianNumber.put(40, "XL");
        arabianNumber.put(10, "X");
        arabianNumber.put(9, "IX");
        arabianNumber.put(5, "V");
        arabianNumber.put(4, "IV");
        arabianNumber.put(1, "I");
    }

    public boolean itsRomeNumber(String number) {
        return romeNumber.containsKey(number.charAt(0 ) );
    }

    public String intToRoman(int number) {
        String roman = "";
        int arabianKey;
        do {
            arabianKey = arabianNumber.floorKey(number);
            roman += arabianNumber.get(arabianKey);
            number -= arabianKey;
        } while (number != 0);

        return roman;
    }

    public int romanToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = romeNumber.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = romeNumber.get(arr[i]);
            if (arabian < romeNumber.get(arr[i + 1]) ) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;

    }
}
