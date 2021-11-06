package kata.task;

import java.io.*;

public class Calculator {
    public static void main(String[] args) throws Exception {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Введите в одну строку первое число, арифметическую операцию и второе число");
    String line = bufferedReader.readLine();
    line = line.replace(" ","");
    if (Character.isDigit(line.charAt(0))) System.out.println(Arabian.calculate(line));
    else System.out.println(Roman.RomanResult(Arabian.calculate(Roman.ToArabianString(line))));
    bufferedReader.close();
    }
}
