import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.get();
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        int listSize;
        int numBorder;

        // начало работы программы
        try(Scanner scan = new Scanner(System.in)) {
            // размер списка
            logger.add("Просим пользователя ввести входные данные для списка");
            System.out.println("Введите размер списка чисел:");
            listSize = scan.nextInt();
            logger.add("Введите размер списка чисел:"+listSize);
            // граница значений
            System.out.println("Введите верхнюю границу значений:");
            numBorder = scan.nextInt();
            logger.add("Введите верхнюю границу значений:"+numBorder);
            // генерация списка
            logger.add("генерация списка");
            for (int i = 0; i < listSize; i++) {
                numbers.add(random.nextInt(numBorder));
            }
            logger.add("Сгенерированный список:"+numbers.toString());
            // фильтр значений
            logger.add("Просим пользователя ввести входные данные для фильтрации");
            System.out.println("Введите число для фильтрации списка:");
            numBorder = scan.nextInt();
            logger.add("Введите число для фильтрации списка:"+numBorder);
            // фильтр
            Filter filter = new Filter(numBorder);
            // получим отфильтрованный список
            List<Integer> numbersFiltred = filter.filterOut(numbers);
            logger.add("Отфильтрованный список:"+numbersFiltred.toString());
            // вывод на экран отфильтрованного списка
            logger.add("вывод на экран отфильтрованного списка");
            numbersFiltred.forEach(System.out::println);
        } catch (Exception exp) {
            logger.add("Ошибка:"+exp.getMessage());
            exp.printStackTrace();
        }

    }
}
