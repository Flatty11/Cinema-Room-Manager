package cinema;

import java.util.Scanner;

public class Cinema {
    final static Scanner scanner = new Scanner(System.in);
    public static int rows, seats, row, seat, sum, localIncome;
    public static int income, ticket;
    public static int totalSeats;
    public static String[][] seatM;

    public static void main(String[] args) {
        totalSeats = 0;
        localIncome = 0;
        numSeats();
        seatM = new String[rows][seats];
        fillArray(seatM);
        choice();
    }

    public static void choice() {
        int Ke;
        Ke = 1;
        while (Ke != 0) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            Ke = scanner.nextInt();
            switch (Ke) {
                case 1:
                    printSeats(seatM);
                    break;
                case 2:
                    numOfSeat(seatM);
                    break;
                case 3:
                    System.out.println("Number of purchased tickets: " + totalSeats);
                    System.out.printf("Percentage: %.2f", (float) totalSeats*100 / (rows*seats));
                    System.out.println("%");
                    System.out.println("Current income: $" + localIncome);
                    System.out.println("Total income: $" + sum());
                    break;
                case 0:
                    return;
            }
        }
    }
    public static void numSeats() {
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();
    }

    public static void fillArray(String[][] array) {
         for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "S";
            }
        }
    }

    public static void printSeats(String[][] array) {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(" " + i);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            System.out.print(i + 1 + " ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
        }
        System.out.println();
    }


    public static void numOfSeat(String[][] array) {
        System.out.println();
        System.out.println();
        System.out.println("Enter a row number:");
        row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        seat = scanner.nextInt();
        if (row > rows || seat > seats) {
            System.out.println("Wrong input!");
            numOfSeat(seatM);
        } else if (array[row-1][seat-1] == "B") {
            System.out.println("That ticket has already been purchased!");
            numOfSeat(seatM);
        } else {
            array[row-1][seat-1] = "B";
            totalSeats += 1;
            ticketPrice();
        }
    }

    public static int sum() {
        income = 0;
        if (rows * seats <= 60) {
            income = rows * seats * 10;
        } else if (rows % 2 == 0) {
            income = rows / 2 * seats * 10 + seats * rows / 2 * 8;
        }
        else { income = rows / 2 * seats * 10 + seats * (rows / 2 + 1) * 8;
        }
        return income;
    }

    public static void ticketPrice() {
        ticket = 0;
        if (rows * seats <= 60) {
            ticket = 10;
        } else if (row <= rows / 2 ) {
            ticket = 10;
        }
        else { ticket = 8;
        }
        System.out.println();
        System.out.println("Ticket price: $" + ticket);
        localIncome += ticket;
    }

    public static void end() {
        System.out.println("Total income:");
        System.out.println("$" + income);
    }
}
