import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of skyscrapers: ");
        int n = scanner.nextInt(), x1, x2, height;
        Skyscraper[] skyscrapers = new Skyscraper[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Point " + (i + 1));
            System.out.print("Enter x1: ");
            x1 = scanner.nextInt();
            System.out.print("Enter height: ");
            height = scanner.nextInt();
            System.out.print("Enter x2: ");
            x2 = scanner.nextInt();
            skyscrapers[i] = new Skyscraper(height, x1, x2);
        }
        Skyline.drawSkyline(skyscrapers);
        FxClass.launchApplication(args);
    }
}