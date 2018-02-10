package com.m.g.string;

public class ExcelNumberToString {

    public static void main(String[] args) {

        String inputString = "52";
        Integer inputNumber = Integer.parseInt(inputString);
        String result = convertInExcelWay(inputNumber);
        System.out.println("Result :: " + result);

    }

    private static String convertInExcelWay(Integer inputNumber) {

        String result = "";
        // if the number is between 1 and 26 this condition is executed.
        if (isInbound(inputNumber)) {
            result = getInbound(inputNumber) + result;
            return result;
        }
        else {
            while (inputNumber / 26 > 26) {
                int temp = inputNumber % 26;
                result = getInbound(temp) + result;
                if (inputNumber / 26 > 26) {
                    inputNumber = inputNumber / 26;
                }

            }

            int remainderVal = inputNumber % 26;
            result = getInbound(remainderVal) + result;
            int firstVal = 0;
            if (remainderVal == 0)

            {
                firstVal = (inputNumber / 26) - 1;
            } else {
                firstVal = inputNumber / 26;
            }

            result = getInbound(firstVal) + result;
        }
        return result.toString();

    }

    private static boolean isInbound(Integer inputNumber) {
        return (inputNumber >= 1 && inputNumber <= 26);
    }

    private static char getInbound(int number) {

        if (number == 0)
            return 90;

        char c = ' ';
        if (number >= 1 && number <= 26) {
            c = (char) (64 + number);
            return c;
        }

        return c;

    }


}
