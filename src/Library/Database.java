package Library;

import java.io.File;
import java.util.ArrayList;

public class Database {

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<String> userNames = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<String> bookNames = new ArrayList<>();

    private File usersFile = new File(Main.class.getClassLoader().getResource("Users").getFile());
    private File booksFile = new File(Main.class.getClassLoader().getResource("Books").getFile());

    public Database() {
        if(!usersFile.exists()){
            usersFile.mkdirs();
        }
        if(!booksFile.exists()){
            booksFile.mkdirs();
        }

    }


    protected void addUser(User s) {
        users.add(s);
        userNames.add(s.getName());
    }

    public User login(String phoneNumber, String email) {
        for (User s : users) {
            if (s.getPhoneNumber().matches(phoneNumber) && s.getEmail().matches(email)) {
                return s;
            }
        }
        // no such user exists.
        return null;
    }

    public void addBook(Book book){
        books.add(book);
        bookNames.add(book.getName());
    }
}
