import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        System.out.println("Mayın tarlasına hoş geldiniz.");
        System.out.println("Haritanın boyutlarını giriniz.");
        System.out.print("Satır sayısı:");
        int row=scan.nextInt();
        System.out.print("Sütün sayısı:");
        int col=scan.nextInt();

        Mayin mayinTarlasi=new Mayin(row,col);
        mayinTarlasi.run();
    }
}
