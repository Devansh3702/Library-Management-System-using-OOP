package Library;

import java.util.Scanner;

public class DeleteBook implements IOOperation {
    @Override
    public void oper(Database db, User user) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter book name: ");
        String name = s.next();

        int bookNdx = db.getBook(name);
        if (bookNdx > -1) {
            db.deleteBook(bookNdx);
            System.out.println("Book Deleted Successfully.");
        } else {
            System.out.println("No Book Found");
        }
        user.menu(db, user);

    }
}
