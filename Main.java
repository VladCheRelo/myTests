import java.util.Scanner;

class Main {
    static int number1, number2;
    static String result;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        calc(scanner.nextLine());
        System.out.println(result);
    }

    public static String calc(String input) throws Exception {
        String[] array = input.split(" ");
        Roman[] rom = Roman.values();
        int sum = 0, resultCalc = 0;
        for (Roman i : rom) {
            String j = i.toString();
            if (j.equals(array[0]) && j.equals(array[2])) sum += 2;
            else if (j.equals(array[0]) || j.equals(array[2])) sum += 1;
        }
        if (sum == 1) throw new Exception("используются одновременно разные системы счисления ");
        else if (sum == 2) {
            number1 = Roman.valueOf(array[0]).getNum();
            number2 = Roman.valueOf(array[2]).getNum();
        } else {
            number1 = Integer.parseInt(array[0]);
            number2 = Integer.parseInt(array[2]);
        }
        if (array.length != 3)
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        if (!(array[1].equals("+")) && !(array[1].equals("-")) && !(array[1].equals("*")) && !(array[1].equals("/")))
            throw new Exception("строка не является математической операцией");
        if ((number1 < 1 || number1 > 10) || (number2 < 1 || number2 > 10))
            throw new Exception("выход за границы диапазона");
        switch (array[1]) {
            case "+" -> resultCalc = number1 + number2;
            case "-" -> resultCalc = number1 - number2;
            case "*" -> resultCalc = number1 * number2;
            case "/" -> resultCalc = number1 / number2;
        }
        if (sum == 2) {
            if (resultCalc < 1) throw new Exception("в римской системе нет отрицательных чисел");
            result = String.valueOf(rom[resultCalc - 1]);
            return result;
        } else {
            result = String.valueOf(resultCalc);
            return result;
        }
    }
}
