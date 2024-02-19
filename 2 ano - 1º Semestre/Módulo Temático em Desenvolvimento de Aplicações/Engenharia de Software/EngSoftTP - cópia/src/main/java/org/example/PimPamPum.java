package org.example;


public class PimPamPum {
    public static String Verificacoes(double number) {
        StringBuilder result = new StringBuilder();

        result.append(Divisibilidade(number));
        result.append(Presenca(number));

        return result.toString();
    }

    public static String Divisibilidade(double number) {
        StringBuilder result = new StringBuilder();

        boolean divpor3 = number % 3 == 0;
        boolean divpor5 = number % 5 == 0;
        boolean divpor7 = number % 7 == 0;

        if (divpor3) {
            result.append("Pim");
        }
        if (divpor5) {
            result.append("Pam");
        }
        if (divpor7) {
            result.append("Pum");
        }

        return result.toString();
    }

    public static String Presenca(double number) {
        StringBuilder result = new StringBuilder();
        String numberStr = String.valueOf(number);
        boolean contem357 = numberStr.contains("3") || numberStr.contains("5") || numberStr.contains("7");

        for (char digit : numberStr.toCharArray()) {
            if (digit == '3') {
                result.append("Pim");
            } else if (digit == '5') {
                result.append("Pam");
            } else if (digit == '7') {
                result.append("Pum");
            }
        }

        if (!contem357) {
            if (number % 1 == 0 ) {
                result.setLength(0);
                result.append((int) number);
            } else {
                result.append(number);
            }
        }

        return result.toString();
    }
}
