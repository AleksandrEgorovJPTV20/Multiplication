/*
Создайте программу-тест для проверки знаний таблицы 
умножения. С помощью случайных чисел создайте 5 примеров. 
При правильном ответе — на экране пишется Правильно зеленым 
цветом, при неправильном — Ошибка красным цветом. Также 
программа в зависимости от результата прохождения тест должна 
выставить оценку прохождения теста: если количество 
правильных ответов=5, то Молодец, 3 или 4, то Надо бы еще 
поучить, меньше 2 — Срочно нужно учить таблицу умножения.
Aleksandr Egorov JPTV20
*/
package multiplication;
import java.util.Random;
import java.util.Scanner;


public class Multiplication {
    // Переменные строк с цветом
    public static final String resetColor = "\033[0m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m"; 

    public static void main(String[] args) {
        int correct = 0; // Правильные ответы.
        int tries = 0; // Переменная ответов. По условию while, значение tries не может быть больше 5.
        Random randomNum = new Random(); // Переменная рандом
        Scanner scan = new Scanner(System.in);
        int[] num = new int[2]; //Массив с двумя ячейками
        
        System.out.println("Давайте решим 5 примеров с умножением!");
        // Когда значение tries не ровно 5, то цикл работает. Если = 5 то перестаёт работать
        while(tries != 5) {
            num[0] = randomNum.nextInt(10); //Две ячейки, каждому из двух придаётся два случайных числа при помощи целого индекса
            num[1] = randomNum.nextInt(10); 
            System.out.print(num[0] + " * " + num[1] + " = "); // Вид наших примеров
            int userInput = scan.nextInt();
            tries = tries + 1; //1+ в переменную tries
            if(userInput == num[0]*num[1]) { // Если ответ пользователя = умножению обеих цифр, то работает ветка if 
                System.out.println(green + "Правильно!" + resetColor);
                correct = correct + 1; //1+ в переменную  correct
            }
            else
                System.out.println(red + "Неправильно!" + resetColor);
        }
        //После цикла, работает switch. По дефолту (если нет правильных ответов или меньше 3)
        switch (correct) {  // Если correct = 5, то молодец, 3 или 4 = ещё поучить...
            case 5:
                System.out.println("\nМолодец!");
                break;
            case 3:
            case 4:
                System.out.println("\nНадо бы ещё поучить");
                break;
            default:
                System.out.println("\nСрочно нужно учить таблицу умножения!");
                break;
        }
    }
}
