import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();

        int actionIndex=-1;
        for (int i = 0; i < actions.length; i++) {
            if(exp.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }

        if(actionIndex==-1) {
            System.out.println("Некорректное выражение");
            return;
        }




        String[] data = exp.split(regexActions[actionIndex]);

        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
            int a,b;

            boolean isRoman = converter.isRoman(data[0]);
            if(isRoman){

                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);

            }else{

                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }

            int result;
            switch (actions[actionIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                case "/":
                    if (b == 0) {
                        System.out.println("Ошибка на 0 делить нельзя");
                        result=0;
                        System.exit(0);
                    } else
                        result = a/b;
                    break;
                default:result=0;
            }


                if (isRoman) {
                    if (result<=0) {
                        System.out.println("В римской системе нет отрицательных чисел");
                    }else {
                        System.out.println(converter.intToRoman(result));
                    }
                } else {
                    System.out.println(result);
                }


        }else{
            System.out.println("Числа должны быть в одном формате");
        }





    }
}