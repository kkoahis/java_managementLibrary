package My_Classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Nguyễn Văn Khoa
 */
public class Book {

    private Integer book_id;
    private String isbn;
    private String name;
    private Integer author_id;
    private Integer genre_id;
    private Integer quanlity;
    private String publisher;
    private double price;
    private String date_received;
    private String description;
    private byte[] cover;

    public Book() {
    }

    public Book(Integer book_id, String isbn, String name, Integer author_id, Integer genre_id, Integer quanlity, String publisher, double price, String date_received, String description, byte[] cover) {
        this.book_id = book_id;
        this.isbn = isbn;
        this.name = name;
        this.author_id = author_id;
        this.genre_id = genre_id;
        this.quanlity = quanlity;
        this.publisher = publisher;
        this.price = price;
        this.date_received = date_received;
        this.description = description;
        this.cover = cover;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate_received() {
        return date_received;
    }

    public void setDate_received(String date_received) {
        this.date_received = date_received;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public Integer getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }

    public Integer getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(Integer quanlity) {
        this.quanlity = quanlity;
    }

    public void addBook(String _isbn, String _name, Integer _author_id, Integer _genre_id, Integer _quanlity, String _publisher, double _price, String _date_received, String _description, byte[] _cover) throws SQLException {
        String insertQuery = "INSERT INTO `books`(`isbn`, `name`, `author_id`, `genre_id`, `quanlity`, `publisher`, `price`, `date_received`, `description`, `cover_image`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);

            ps.setString(1, _isbn);
            ps.setString(2, _name);
            ps.setInt(3, _author_id);
            ps.setInt(4, _genre_id);
            ps.setInt(5, _quanlity);
            ps.setString(6, _publisher);
            ps.setDouble(7, _price);
            ps.setString(8, _date_received);
            ps.setString(9, _description);
            ps.setBytes(10, _cover);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Book is added", "add book", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Book is not added", "add book", 0);
            }
        } catch (SQLException e) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void editBook(int _id, String _name, Integer _author_id, Integer _genre_id, Integer _quanlity, String _publisher, double _price, String _date_received, String _description, byte[] _cover) throws SQLException {
        String updateQuery = "";
        PreparedStatement ps;

        try {
            if (_cover != null) {   //if you want to update the image
                updateQuery = "UPDATE `books` SET `name`= ?,`author_id`= ?,`genre_id`= ?,`quanlity` = ?,`publisher`= ?,`price`= ?,`date_received`= ?,`description`= ?,`cover_image`= ? WHERE `id_book` = ?";
                ps = DB.getConnection().prepareStatement(updateQuery);

                ps.setString(1, _name);
                ps.setInt(2, _author_id);
                ps.setInt(3, _genre_id);
                ps.setInt(4, _quanlity);
                ps.setString(5, _publisher);
                ps.setDouble(6, _price);
                ps.setString(7, _date_received);
                ps.setString(8, _description);
                ps.setBytes(9, _cover);
                ps.setInt(10, _id);
            } else {        //else not update
                updateQuery = "UPDATE `books` SET `name`= ?,`author_id`= ?,`genre_id`= ?,`quanlity` = ?,`publisher`= ?,`price`= ?,`date_received`= ?,`description`= ? WHERE `id_book` = ?";
                ps = DB.getConnection().prepareStatement(updateQuery);

                ps.setString(1, _name);
                ps.setInt(2, _author_id);
                ps.setInt(3, _genre_id);
                ps.setInt(4, _quanlity);
                ps.setString(5, _publisher);
                ps.setDouble(6, _price);
                ps.setString(7, _date_received);
                ps.setString(8, _description);
                ps.setInt(9, _id);
            }

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Book is edited", "edit book", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Book is not edit", "edit book", 0);
            }
        } catch (SQLException e) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void deleteBook(int _id) throws SQLException {
        String insertQuery = "DELETE FROM `books` WHERE `id_book` = ?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);

            ps.setInt(1, _id);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Book is deleted", "delete book", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Book is not deleted", "delete book", 0);
            }
        } catch (SQLException e) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //creat a func to check the ISBN is exists
    public boolean isISBNexists(String _isbn) throws SQLException {
        String query = "SELECT * FROM `books` WHERE `isbn` = '" + _isbn + "'";
        Func_Class func = new Func_Class();
        func.getData(query);
        ResultSet rs = func.getData(query);
        try {
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException sQLException) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, sQLException);
        }
        return true;
    }

    //func to search book by id or isbn
    public Book searchBook(Integer _id, String _isbn) throws SQLException {
        String Query = "SELECT * FROM `books` WHERE `id_book` = '" + _id + "' OR `isbn` = '" + _isbn + "'";

        Func_Class func = new Func_Class();
        ResultSet rs = func.getData(Query);

        if (rs.next()) {
            return new Book(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7),
                    rs.getDouble(8), rs.getString(9), rs.getString(10), rs.getBytes(11));
        } else {
            return null;
        }
    }

    public Book getBookById(Integer _id) throws SQLException {
        Func_Class func = new Func_Class();
        String Query = "SELECT * FROM `books` WHERE `id_book` = " + _id;
        ResultSet rs = func.getData(Query);

        if (rs.next()) {
            return new Book(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7),
                    rs.getDouble(8), rs.getString(9), rs.getString(10), rs.getBytes(11));
        } else {
            return null;
        }
    }

    public ArrayList<Book> booksLists(String query) {
        ArrayList<Book> bList = new ArrayList<>();
        Func_Class func = new Func_Class();

        try {
            if (query.equals("")) {
                query = "SELECT * FROM `books`";  //if the user empty String then use defaut select
            }

            ResultSet rs = func.getData(query);

            Book book;

            while (rs.next()) {
                book = new Book(rs.getInt("id_book"), rs.getString("isbn"),
                        rs.getString("name"), rs.getInt("author_id"),
                        rs.getInt("genre_id"), rs.getInt("quanlity"),
                        rs.getString("publisher"), rs.getDouble("price"),
                        rs.getString("date_received"), rs.getString("description"),
                        rs.getBytes("cover_image"));
                bList.add(book);
            }

        } catch (SQLException sQLException) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, sQLException);
        }
        return bList;
    }

    //creat a func to display the lastest book
    public void displayBooksCover(JLabel[] lable_tab) {
        ResultSet rs;
        Statement st;
        Func_Class func = new Func_Class();

        try {
            st = DB.getConnection().createStatement();
            rs = st.executeQuery("SELECT `cover_image` FROM `books` ORDER BY `id_book` DESC LIMIT 5");
            byte[] image;
            int i = 0;  //to populate the lable_tab itém with image
            while (rs.next()) { //this whill be go through all the data
                image = rs.getBytes("cover_image");
                func.displayImage(lable_tab[i].getWidth(), lable_tab[i].getHeight(), image, name, lable_tab[i]);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Func_Class.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setQuanlity_Minus_One(int _book_id, int _quanlity) {
        String updateQuanlityQuery = "";
        PreparedStatement ps;

        try {

            updateQuanlityQuery = "UPDATE `books` SET `quanlity` = ? WHERE `id_book` = ?";
            ps = DB.getConnection().prepareStatement(updateQuanlityQuery);

            ps.setInt(1, _quanlity);
            ps.setInt(2, _book_id);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "This Book Is Set To Lost => The Quanlity = The Quanlity -1", "edit book quanlity", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Book Quanlity Is Not Edited", "edit book quanlity", 0);
            }
        } catch (SQLException e) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
