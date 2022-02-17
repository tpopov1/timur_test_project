package Figures;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Methods implements Serializable {

    private ArrayList<Object> inClassArray = new ArrayList<>();

    public ArrayList<Object> getInClassArray() {
        return inClassArray;
    }

    public void setInClassArray(ArrayList<Object> inClassArray) {
        this.inClassArray = inClassArray;
    }

    public static void serializeArray(ArrayList methodList) {
        try {
            FileOutputStream fos = new FileOutputStream("figuresfile.bin"); //Создание файла
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(methodList.size());
            for (int i = 0; i < methodList.size(); i++) {
                oos.writeObject(methodList.get(i));
            }
            fos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла");
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeFile(File file, ArrayList methodList) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            int arraysFigureCount = ois.readInt(); // количество элементов в файле
            //System.out.println(arraysFigureCount); //вывести на экран количество объектов
            for (int i = 0; i < arraysFigureCount; i++) {
                methodList.add(ois.readObject());
            }
            // System.out.println(methodList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static double checkDouble() {

        boolean b = false;
        double k = 0.01;
        while (b == false) {
            try {
                Scanner scanner = new Scanner(System.in);
                k = scanner.nextDouble();
                b = true;

            } catch (InputMismatchException e) {
                System.out.println("Введено не число. Введите число.");
            }
        }
        return k;
    }

    public static double checkValueIsRight(){
        double d = Methods.checkDouble();
        while(d<=0){
            System.out.println("Число должно быть положительным. Введите число.");
            d = Methods.checkDouble();
        }
        return d;
    }
}
