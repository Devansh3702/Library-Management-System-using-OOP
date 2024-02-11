package Library;

import java.util.Scanner;

public class AddBook implements IOOperation {
    @Override
    public void oper(Database db, User user) {
        Scanner s = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Enter book name: ");
        String name = s.next();
        if (db.getBook(name) > -1) {
            System.out.println("Book Already Exists.");
            user.menu(db, user);
            return;
        } else {
            book.setName(name);
            System.out.println("Enter book author: ");
            book.setAuthor(s.next());
            System.out.println("Enter book publisher: ");
            book.setPublisher(s.next());
            System.out.println("Enter book collection address: ");
            book.setAddress(s.next());
            System.out.println("Enter qty: ");
            book.setQty(s.nextInt());
            System.out.println("Enter price: ");
            book.setPrice(s.nextDouble());
            System.out.println("Enter borrowing copies: ");
            book.setCopiesToBorrow(s.nextInt());


            db.addBook(book);
            System.out.println("Book Added Successfully.\n");
            user.menu(db, user);
        }


    }
}
