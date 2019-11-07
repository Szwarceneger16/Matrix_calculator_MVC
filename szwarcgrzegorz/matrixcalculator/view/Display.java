package szwarcgrzegorz.matrixcalculator.view;

import szwarcgrzegorz.matrixcalculator.controller.Operations;
import szwarcgrzegorz.matrixcalculator.model.Matrix;

import java.util.Locale;
import java.util.Scanner;

public class Display {
    private static Locale locale;
    private static Matrix a;
    private static Matrix b;
    private static Matrix c;
    private static Scanner in;
    static Operations oper;

    public static void main(String[] args){
        locale = new Locale("Polish");
        in = new Scanner(System.in);
        oper = new Operations();



        while (true)
        {
            System.out.println("Witaj uzytkowniku. Wybierz operacje (podajac numer operacji) ktorej chialbys dokonac:");
            System.out.println("0. Wyjscie z programu");
            System.out.println("1. Wprowadz macierze");
            System.out.println("2. Operacje artymetyczne");
            System.out.println("3. Wysweitl macierze");

            int select = in.nextInt();
            switch (select) {
                case 1:
                    makeMatrix();
                    insertMatrix(a);
                    insertMatrix(b);
                    break;
                case 2:
                    System.out.println("Wybierz operacje (podajac numer operacji) ktorej chialbys dokonac:");
                    System.out.println("2.1 Transponuj macierze wejsciowe");
                    System.out.println("2.2 Pomnóż macierze wejściowe");
                    System.out.println("2.3 Transponuj macierz wynikową");
                    int select2 = in.nextInt();
                    switch (select2) {
                        case 1:
                            if (a == null) System.out.println("Macierz A jest pusta!");
                            else a = oper.transpose(a);
                            if (b == null) System.out.println("Macierz B jest pusta!");
                            else b = oper.transpose(b);

                            break;
                        case 2:
                            if(a == null || b == null) System.out.println("Macierz A lub B jest pusta!");
                            else
                            {
                                c = new Matrix(a.getRows(),a.getRows(),"C");
                                oper.multiply(a,b,c);
                            }

                            break;
                        case 3:
                            if (c == null) System.out.println("Macierz C jest pusta!");
                            else c = oper.transpose(c);

                            break;
                    }
                    break;
                case 3:

                    System.out.println("Wybierz co chciałbyś wyświetlić:");
                    System.out.println("3.1 Wyświetl macierze wejsciowe");
                    System.out.println("3.2 Wyświetl macierz wynikową");
                    select = in.nextInt();
                    switch (select) {
                        case 1:
                            if (a == null) System.out.println("Macierz A jest pusta!");
                            else printMatrix(a);
                            if (b == null) System.out.println("Macierz B jest pusta!");
                            else printMatrix(b);

                            break;
                        case 2:
                            if (c == null) System.out.println("Macierz C jest pusta!");
                            else printMatrix(c);

                            break;
                    }
                    break;
                default:
                        return;
            }
        }

    }

    private static void makeMatrix(){
        int row,column;

        System.out.println("Podaj wymiary macierzy wejsciowej A oraz B");

        System.out.print("Podaj liczbe wierszy dla macierzy A (jednoczesnie bedzie to liczba kolumn macierzy B): ");
        row = in.nextInt();
        System.out.print("Podaj liczbe kolumn dla macierzy A (jednoczesnie bedzie to liczba wierszy macierzy B): ");
        column = in.nextInt();

        a = new Matrix(row,column,"A");
        b = new Matrix(column,row,"B");

    }

    private static void insertMatrix(Matrix actual){
        System.out.println("Podaj po spacjach kolejno elementy macierzy " + actual.getName() + " :");
        int val;

        for (int i = 0; i < actual.getRows();i++)
        {
            for (int j=0;j < actual.getColumns();j++)
            {
                val = in.nextInt();
                actual.setElement(i,j,val);
            }
        }

        return;
    }



    private static void printMatrix(Matrix actual){

        System.out.println("Wyświetlam macierz "+actual.getName() +" :");
        for (int i = 0; i < actual.getRows();i++)
        {
            for (int j=0;j < actual.getColumns();j++)
            {
                System.out.print(actual.getElement(i,j)+" ");
            }
            System.out.println("");
        }
    }

    private static void print_err(String in){
        System.err.println(in);
    }

}
