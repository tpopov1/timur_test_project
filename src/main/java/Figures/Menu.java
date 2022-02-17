package Figures;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    public static void main(String[] args) {

        ArrayList<Object> writeList = new ArrayList<>();
        // writeList - оперативный список в котором происходят все изменения, после чего список сериализуется в файл

        File f = new File("figuresfile.bin");
        // Создание сущности файла

        if(f.exists() && !f.isDirectory()){
            Methods.deserializeFile(f, writeList); // десериализуем файл в writeList

        }else{
            try {
                f.createNewFile(); // создаём новый файл (в будущем туда будем сериализовывать writeList)
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        String k;

        do{
            System.out.println("Выберите опцию (Введите цифру и нажмите Enter)");
            System.out.println("1 - создание новой фигуры\n" +
                "2 - получить список фигур\n" +
                "3 - удалить фигуру из списка\n" +
                "4 - закрыть программу");
            Scanner scanner = new Scanner(System.in);
            k = scanner.nextLine();
            switch (k){
                case "1":
                    String j;
                    System.out.println("Выберите тип создаваемой фигуры\n");

                    do{
                        System.out.println("1 - создание окружности\n" +
                                "2 - создание треугольника\n" +
                                "3 - создание квадрата\n" +
                                "4 - создание прямоугольника\n" +
                                "5 - назад в главное меню");
                        j = scanner.nextLine();
                        switch (j){
                            case "1":
                                System.out.println("Введите имя окружности");
                                String figureName = scanner.nextLine();
                                System.out.println("Введите радиус окружности");
                                double d = Methods.checkValueIsRight();
                                Figure figure1 = new Circle(d, figureName);
                                writeList.add(figure1);
                                Methods.serializeArray(writeList);
                                System.out.println("Окружность создана");

                                break;
                            case "2":
                                System.out.println("Введите имя треугольника");
                                figureName = scanner.nextLine();

                                System.out.println("Введите первую сторону");
                                double z = Methods.checkValueIsRight();
                                System.out.println("Введите вторую сторону");
                                double x = Methods.checkValueIsRight();
                                System.out.println("Введите третью сторону сторону");
                                double c = Methods.checkValueIsRight();

                                if((z+x)>c & (z+c)>x & (x+c)>z){
                                    Figure figure2 = new Triangle(z, x, c, figureName);
                                    writeList.add(figure2);
                                    Methods.serializeArray(writeList);
                                    System.out.println("Треугольник создан");

                                }else{
                                    System.out.println("Треугольник невозможен. Сумма любых двух строн треугольника должна быть больше третьей стороны.");

                                }break;

                            case "3":
                                System.out.println("Введите имя квадрата");
                                figureName = scanner.nextLine();
                                System.out.println("Введите сторону квадрата");
                                d = Methods.checkValueIsRight();
                                Figure figure3 = new Square(d,figureName);
                                writeList.add(figure3);
                                Methods.serializeArray(writeList);
                                System.out.println("Квадрат создан");
                                break;
                            case "4":
                                System.out.println("Введите имя прямоугольника");
                                figureName = scanner.nextLine();
                                System.out.println("Введите первую сторону");
                                z = Methods.checkValueIsRight();
                                System.out.println("Введите вторую сторону");
                                x = Methods.checkValueIsRight();

                                Figure figure4 = new Rectangle(z, x, figureName);
                                writeList.add(figure4);
                                Methods.serializeArray(writeList);
                                System.out.println("Прямоугольник создан");
                                break;
                            case "5":
                                System.out.println("Возвращаемся в главное меню\n");
                                Methods.serializeArray(writeList);
                                break;
                            default:
                                System.out.println("Введите 1, 2, 3, 4 или 5\n");
                                Methods.serializeArray(writeList);
                        }
                    }while(!j.equals("5"));
                    break;
                case "2":
                    System.out.println("Получение списка фигур\n");
                    Methods.serializeArray(writeList);
                    System.out.println(writeList+"\n");
                    break;
                case "3":
                    System.out.println("Введите критерий по которому должны быть удалены фигуры\n" +
                            "Например для того чтобы удалить все фигуры площадь которых равна 4 нужно ввести \"==4\"\n" +
                            "Все используемые знаки\n" +
                            "==x - равно    " +
                            "!=x - не равно\n" +
                            ">=x - больше либо равно    " +
                            ">x - больше\n" +
                            "<=x - меньше либо равно    " +
                            "<x - меньше\n" +
                            "Любой символ - назад в главное меню");
                    scanner = new Scanner(System.in);
                    k = scanner.nextLine();

                    String compareValueStr;
                    double compareValueD = -0.001; // дал значение compareValueD чтобы компилятор не ругался
                    Pattern pattern = Pattern.compile("[0-9.]+");
                    Matcher matcher = pattern.matcher(k);

                    if (matcher.find())
                    {
                        compareValueStr = k.substring(matcher.start(), matcher.end());
                        try{
                            compareValueD = Double.parseDouble(compareValueStr); //compareValueD - наше число с которым будет сравниваться площадь
                        }catch (NumberFormatException e){
                            System.out.println("Вы ввели неправильное значение. Назад в главное меню\n");
                        }

                    }

                    if(compareValueD !=-0.001 & compareValueD !=0) { // Проверка на то ввёл ли пользователь правильное

                        if (k.matches("^!=[0-9]*$") || k.matches("^!=[0-9]*\\.[0-9]*$")) { // Если мы ввели !=x или !=x.y
                            for (int i = 0; i < writeList.size(); i++) {
                                Figure figure = (Figure) writeList.get(i);
                                if (figure.getArea() != compareValueD) {
                                    writeList.remove(writeList.get(i));
                                    i--;
                                    Methods.serializeArray(writeList);
                                }
                            }
                            System.out.println("Удалены все фигуры площадь которых не равна " + compareValueD);

                        } else if (k.matches("^==[0-9]*$") || k.matches("==[0-9]*\\.[0-9]*$")) {
                            for (int i = 0; i < writeList.size(); i++) {
                                Figure figure = (Figure) writeList.get(i);
                                if (figure.getArea() == compareValueD) {
                                    writeList.remove(writeList.get(i));
                                    i--;
                                    Methods.serializeArray(writeList);
                                }
                            }
                            System.out.println("Удалены все фигуры площадь которых равна " + compareValueD);

                        } else if (k.matches("^>[0-9]*$") || k.matches("^>[0-9]*\\.[0-9]*$")) {
                            for (int i = 0; i < writeList.size(); i++) {
                                Figure figure = (Figure) writeList.get(i);
                                if (figure.getArea() > compareValueD) {
                                    writeList.remove(writeList.get(i));
                                    i--;
                                    Methods.serializeArray(writeList);
                                }
                            }
                            System.out.println("Удалены все фигуры площадь которых больше " + compareValueD);
                        } else if (k.matches("^>=[0-9]*$") || k.matches("^>=[0-9]*\\.[0-9]*$")) {
                            for (int i = 0; i < writeList.size(); i++) {
                                Figure figure = (Figure) writeList.get(i);
                                if (figure.getArea() >= compareValueD) {
                                    writeList.remove(writeList.get(i));
                                    i--;
                                    Methods.serializeArray(writeList);
                                }
                            }
                            System.out.println("Удалены все фигуры площадь которых больше либо равна " + compareValueD);
                        } else if (k.matches("^<[0-9]*$") || k.matches("^<[0-9]*\\.[0-9]*$")) {
                            for (int i = 0; i < writeList.size(); i++) {
                                Figure figure = (Figure) writeList.get(i);
                                if (figure.getArea() < compareValueD) {
                                    writeList.remove(writeList.get(i));
                                    i--;
                                    Methods.serializeArray(writeList);
                                }
                            }
                            System.out.println("Удалены все фигуры площадь которых меньше " + compareValueD);
                        } else if (k.matches("^<=[0-9]*$") || k.matches("^<=[0-9]*\\.[0-9]*$")) {
                            for (int i = 0; i < writeList.size(); i++) {
                                Figure figure = (Figure) writeList.get(i);
                                if (figure.getArea() <= compareValueD) {
                                    writeList.remove(writeList.get(i));
                                    i--;
                                    Methods.serializeArray(writeList);
                                }
                            }
                            System.out.println("Удалены все фигуры площадь которых меньше либо равна " + compareValueD);
                        } else {
                            System.out.println("Вы ввели неправильное значение. Назад в главное меню\n");
                        }
                    }
                    break;

                case "4":
                    System.out.println("Закрытие программы");
                    break;
                default:
                    System.out.println("Введите 1, 2, 3 или 4");
            }
        }while(!k.equals("4"));
    }
}