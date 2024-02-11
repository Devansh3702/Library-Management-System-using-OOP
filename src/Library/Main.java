package Library;

import java.util.Scanner;

public class Main {
    static Scanner sc;
    static Database db;

    public static void main(String[] args) {

        db = new Database();
        System.out.println("Welcome to Library Management System!");

        int num;
//        do {
        System.out.println("0. Exit\n1. Login\n2. New User");
        sc = new Scanner(System.in);
        num = sc.nextInt();

        switch (num) {
            case 1:
                login();
            case 2:
                newUser();
        }
//        } while (num != 0);
    }

    private static void login() {

        System.out.println("Enter phone number: ");
        String phoneNumber = sc.next();
        System.out.println("Enter email: ");
        String email = sc.next();

        User user = db.login(phoneNumber, email);

        if (user == null) {
            System.out.println("User doesn't exist!");
            return;
        }
        user.menu(db, user);


    }

    private static void newUser() {

        System.out.println("Enter name: ");
        String name = sc.next();
        System.out.println("Enter phone number: ");
        String phoneNumber = sc.next();
        System.out.println("Enter email: ");
        String email = sc.next();
        System.out.println("1. Admin\n2. Normal User");

        int n = sc.nextInt();
        User user;
        if (n == 1) {
            user = new Admin(name, email, phoneNumber);
        } else {
            user = new NormalUser(name, email, phoneNumber);
        }
        db.addUser(user);
        user.menu(db, user);

    }

}
