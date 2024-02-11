package Library;

import java.util.ArrayList;

public class ViewBooks implements IOOperation {

    @Override
    public void oper(Database db, User user) {
        ArrayList<Book> books = db.getAllBooks();
        System.out.println("Name\t\tAuthor\t\tPublisher\t\tAddress\t\tQuantity\t\tPrice\t\tCopies to Borrow");

        for (Book b : books) {
            System.out.println(b.getName() + "\t\t" + b.getAuthor() + "\t\t" + b.getPublisher() + "\t\t" + b.getAddress() + "\t\t" +
                    b.getQty() + "\t\t" + b.getPrice() + "\t\t" + b.getCopiesToBorrow());
        }


        user.menu(db, user);
    }
}
