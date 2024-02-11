package Library;


import java.util.Scanner;

public class Search implements IOOperation {
    @Override
    public void oper(Database db, User user) {
        Scanner s = new Scanner(System.in);
        System.out.println("\nEnter book name:");
        String name = s.next();

        int bookNdx = db.getBook(name);
        if (bookNdx > -1) {
            System.out.println(db.getBook(bookNdx).toString());
        } else {
            System.out.println("No Book Found");
        }
        user.menu(db, user);


    }
}
