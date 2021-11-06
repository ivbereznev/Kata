package kata.task;

public class Roman {
    public static String ToArabianString (String s) throws Exception {
        //int a = 0;
        //int b = 0;
        String sign = "0";
        String first = "";
        String second = "";
        for (int i=0; i<s.length(); i++)
        {
    if (Character.isDigit(s.charAt(i))) throw new Exception("Некорректный ввод, т.к. используются одновременно разные системы счисления");
    else if (Character.isLetter(s.charAt(i))&&sign.contains("0")) first=first+s.charAt(i);
    else if (!Character.isLetter(s.charAt(i))&&sign.contains("0")) sign = ""+s.charAt(i);
    else if (Character.isLetter(s.charAt(i))&&!sign.contains("0")) second=second+s.charAt(i);
    else throw new Exception(" формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (sign.contains("0")) throw new Exception("Строка не является математической операцией");
        s=ToArabian(first)+sign+ToArabian(second);
        return s;
    }
    public static String ToArabian (String roman){
        String ArabStr = "";
        int i = 0;
        int arabic = 0;
        roman=roman.toUpperCase();
        while (i<roman.length()){
            char letter = roman.charAt(i);
            int number = letterToNumber(letter);
            i++;
            if (i == roman.length()) {
                arabic += number;
            }
            else {
                int nextNumber = letterToNumber(roman.charAt(i));
                if (nextNumber > number) {
                    arabic += (nextNumber - number);
                    i++;
                }
                else {
                    arabic += number;
                }
            }
        }
        ArabStr=Integer.toString(arabic);
        return ArabStr;
    }
    public static int letterToNumber(char letter) {
        switch (letter) {
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
            default:
                throw new NumberFormatException("Некорректный символ \"" + letter + "\" для римской системы счисления");
        }
    }
    public static String RomanResult (int z) throws Exception
    {
        if (z<0)throw new Exception("В римской системе нет отрицательных чисел");
        if (z<1)throw new Exception("Результат вычисления меньше единицы, неприемлемо для римской системы счисления");
        String result = "";
        StringBuilder sb = new StringBuilder();
        int[]    ints = { 1,4,5,9,10,40,50,90,100 };
        String[] romans = { "I","IV","V","IX","X","XL","L","XC","C" };
        int times =0;
        for (int i = ints.length - 1; i >= 0; i--) {
            times = z / ints[i];
            z %= ints[i];
            while (times > 0) {
                sb.append(romans[i]);
                times--;
            }
        }
        result=sb.toString();
        return result;
    }

}
