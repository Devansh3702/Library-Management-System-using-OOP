package Library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Database {

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<String> userNames = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<String> bookNames = new ArrayList<>();

    //    private File usersFile = new File(Main.class.getClassLoader().getResource("Users").getFile());
    private File usersFile = new File("src/Users");
    private File booksFile = new File("src/Books");

    public Database() {
        if (!usersFile.exists()) {
            usersFile.mkdirs();
        }
        if (!booksFile.exists()) {
            booksFile.mkdirs();
        }
        getUsers();
        getBooks();

    }


    protected void addUser(User s) {
        users.add(s);
        userNames.add(s.getName());
        saveUsers();
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

    public void addBook(Book book) {
        books.add(book);
        bookNames.add(book.getName());
        saveBooks();
    }

    private void getUsers() {
        String text1 = "";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(usersFile));
            String s1;
            while ((s1 = br1.readLine()) != null) {
                text1 = text1 + s1;

            }
            br1.close();

        } catch (Exception e) {
            System.err.println(e.toString());
        }

        if (!text1.matches("") || !text1.isEmpty()) {
            String[] a1 = text1.split("<NewUser/>");

            for (String s : a1) {
                String[] a2 = s.split("<N/>");
                User user;
                if (a2[3].matches("Admin")) {
                    user = new Admin(a2[0], a2[1], a2[2]);

                } else {
                    user = new NormalUser(a2[0], a2[1], a2[2]);
                }
                addUser(user);
            }
        }
    }

    private void saveUsers() {
        String text1 = "";

        for (User user : users) {
            text1 = text1 + user.toString() + "<NewUser/>\n";
        }

        try {
            PrintWriter pw = new PrintWriter(usersFile);
            pw.print(text1);
            pw.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    private void getBooks() {
        String text1 = "";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(booksFile));
            String s1;
            while ((s1 = br1.readLine()) != null) {
                text1 = text1 + s1;

            }
            br1.close();

        } catch (Exception e) {
            System.err.println(e.toString());
        }

        if (!text1.matches("") || !text1.isEmpty()) {
            String[] a1 = text1.split("<NewBook/>");

            for (String s : a1) {
                addBook(parseBook(s));
            }
        }
    }

    private void saveBooks() {
        String text1 = "";

        for (Book book : books) {
            text1 = text1 + book.toString2() + "<NewBook/>\n";
        }

        try {
            PrintWriter pw = new PrintWriter(booksFile);
            pw.print(text1);
            pw.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public Book parseBook(String s) {
        String[] a = s.split("<N/>");
        Book book = new Book();
        book.setName(a[0]);
        book.setAuthor(a[1]);
        book.setPublisher(a[2]);
        book.setAddress(a[3]);
        book.setQty(Integer.parseInt(a[4]));
        book.setPrice(Double.parseDouble(a[5]));
        book.setCopiesToBorrow(Integer.parseInt(a[6]));
        return book;
    }
}
