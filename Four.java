import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Four {
    public static void main(String[]args){
        System.out.println("1. " + bessy(10, 7, "hello my name is Bessie and this is my essay"));
        System.out.println("2. " + split("((())())(()(()()))"));
        System.out.println("3. " + toCamelCase("hello_edabit"));
        System.out.println("   " + toSnakeCase("helloEdabit"));
        double[] array1 = {9, 17, 30, 1.5};
        System.out.println("4. " + overTime(array1));
        System.out.println("5. " + BMI("205 pounds", "73 inches"));
        System.out.println("   " + BMI("55 kilos", "1.65 meters"));
        System.out.println("   " + BMI("154 pounds", "2 meters"));
        System.out.println("6. " + bugger(39));
        System.out.println("7. " + toStarShorthand("abbccc"));
        System.out.println("8. " + doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println("9. " + trouble(666789, 12345667));
        System.out.println("10. " + countUniqueBooks("AZYWABBCATTTA", 'A'));
    }
    public static String bessy(int n, int k, String str) {
        String[] text = str.split(" ");
        String line = "";
        String result = "";

        for (int i = 0; i < n; i++) {
            if (line.length() + text[i].length() > k) {
                result = result.trim() + "\r\n" + text[i] + " ";
                line = text[i];
            } else {
                result += text[i] + " ";
                line += text[i];
            }
        }

        return result.trim();
    }
    
    // группирует строку в кластер скобок
    public static String[] split(String str) {
        List<String> list = new ArrayList<>();
        int m = 0;
        int i = 0;
        String string = str;
        while (string.length() > 0) {
            if (string.charAt(i) == '(') m++;
            else m--;

            if (m == 0) {
                list.add(string.substring(0, i + 1));
                string = string.substring(i + 1);
                i = 0;
                continue;
            }
            i++;
        }
        return list.toArray(new String[list.size()]);
    }
    
    // две функции toCamelCase () и toSnakeCase (), каждая из которых берет
    //одну строку и преобразует ее либо в camelCase, либо в snake_case
    public static String toCamelCase(String str) {
        String[] tokens = str.split("_");
        for (int i = 1; i < tokens.length; i++) {
            tokens[i] = Character.toUpperCase(tokens[i].charAt(0)) + tokens[i].substring(1);
        }
        return String.join("", tokens);
    }

    public static String toSnakeCase(String str) {
        return str.replaceAll("([A-Z])", "_$0").toLowerCase();
    }

    //вычисляет сверхурочную работу и оплату, связанную с сверхурочной работой
    public static String overTime(double[] work) {
        double sum;
        if (work[1] <= 17) {
            sum = (work[1] - work[0]) * work[2];
        } else {
            sum = (17 - work[0]) * work[2] + (work[1] - 17) * work[2] * work[3];
        }

        return ('$' + String.valueOf(sum));
    }

    //принимает вес и рост (в килограммах, фунтах,
    //метрах или дюймах) и возвращает ИМТ и связанную с ним категорию
    public static String BMI(String weight, String height) {
        double amountOfWeight = Double.parseDouble(weight.split(" ")[0]);
        double amountOfHeight = Double.parseDouble(height.split(" ")[0]);
        String out = " ";

        if (weight.contains("pounds"))
            amountOfWeight = amountOfWeight * 0.45;

        if (height.contains("inches"))
            amountOfHeight *= 0.0254;

        double BMI = Math.round((amountOfWeight / (amountOfHeight * amountOfHeight)) * 10.0) / 10.0;

        if (BMI < 18.5)
            out = BMI + " Underweight";

        if (BMI >= 18.5 && BMI <= 24.9)
            out = BMI + " Normal weight";

        if (BMI > 25)
            out = BMI + " Overweight";

        return out;
    }

    //принимает число и возвращает его мультипликативное
    //постоянство, которое представляет собой количество раз, которое вы должны
    //умножать цифры в num, пока не достигнете одной цифры.
    public static int bugger(int num) {
        int count = 0;
        int number = num;

        while (number > 9) {
            int chnum = 1;
            while (number > 0) {
                chnum *= number % 10;
                number /= 10;
            }
            number = chnum;
            count++;
        }
        return count;
    }

    //преобразует строку в звездную стенографию. 
    //Если символ повторяется n раз, преобразуйте его в символ*n.
    public static String toStarShorthand(String str) {
        int count = 1;
        char let = str.charAt(0);
        String newStr = "";

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != let) {
                if (count != 1)
                    newStr += let + "*" + count;
                else
                    newStr += let;
                let = str.charAt(i);
                count = 1;
            } else
                count++;
        }
        if (count != 1)
            newStr += let + "*" + count;
        else
            newStr += let;
        return newStr;
    }

    //возвращает true, если две строки рифмуются, и false в противном случае
    public static boolean doesRhyme(String str1, String str2) {
        str1 = str1.substring(str1.lastIndexOf(" ") + 1);
        str2 = str2.substring(str2.lastIndexOf(" ") + 1);
        String let = "aeiouyAEIOUY";
        String res1 = "", res2 = "";

        for (int i = 0; i < str1.length(); i++) {
            if (let.indexOf(str1.charAt(i)) != -1)
                res1 += str1.charAt(i);
        }

        for (int i = 0; i < str2.length(); i++) {
            if (let.indexOf(str2.charAt(i)) != -1)
                res2 += str2.charAt(i);
        }

        return res1.equalsIgnoreCase(res2);
    }

    //я принимает два целых числа и возвращает true, если
    //число повторяется три раза подряд в любом месте в num1 и то же самое число
    //повторяется два раза подряд в num2
    public static boolean trouble(long a, long b) {
        String aa = Long.toString(a);
        String bb = Long.toString(b);
        int num = 0;

        for (int i = 2; i < aa.length(); i++) {
            if (aa.charAt(i) == aa.charAt(i - 1) && aa.charAt(i) == aa.charAt(i - 2))
                num = aa.charAt(i);
        }

        for (int i = 0; i < bb.length(); i++) {
            if (bb.charAt(i) == num && bb.charAt(i + 1) == num)
                return true;
        }

        return false;
    }

    //возвращает общее количество уникальных символов между всеми парами концов книги
    public static int countUniqueBooks(String str, char c) {
        Map<Character, Integer> values = new HashMap<>();
        boolean start = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c && start) {
                i++;
                while (str.charAt(i) != c) {
                    Integer n = values.get(str.charAt(i));
                    if (n == null) values.put(str.charAt(i), 1);
                    i++;
                }

                start = false;
            }

            if (str.charAt(i) == c)
                start = true;
        }

        return values.size();
    }
}
