package kata.task;

public class Arabian {

    public static int calculate(String s) throws Exception {
        String first = "";
        String second = "";
        String sign = "0";
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (Character.isLetter(s.charAt(i))) throw new Exception("Некорректный ввод, т.к. используются одновременно разные системы счисления");
            else if (Character.isDigit(s.charAt(i)) && i < 2) first = first + s.charAt(i);
            else if (!Character.isLetterOrDigit(s.charAt(i))&&sign.contains("0")) sign = "" + s.charAt(i);
            else if (Character.isDigit(s.charAt(i)) && !sign.contains("0")) second = second + s.charAt(i);
            else throw new Exception(" формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (sign.contains("0")) throw new Exception("Строка не является математической операцией");
        a = Integer.parseInt(first);
        b = Integer.parseInt(second);
        if (a>10 || b>10) throw new Exception("Некорректный ввод, каждое из чисел должно быть не больше 10 (X)");

        switch (sign) {
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
            case "/":
                try {
                    c = a / b;
                } catch (ArithmeticException e) {
                    System.out.println("Ошибка!попытка деления на 0");
                }
                break;
            default:
                System.out.println("Неправильно указано арифметическое действие!");
        }
        return c;
    }
}
