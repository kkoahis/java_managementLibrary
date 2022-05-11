package My_Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyễn Văn Khoa
 */
public class Issue_Book {

    private int book_id;
    private int member_id;
    private String status;  //issue - return - lost
    private String issue_date;
    private String return_date;
    private String note;

    public Issue_Book() {
    }

    public Issue_Book(int book_id, int member_id, String status, String issue_date, String return_date, String note) {
        this.book_id = book_id;
        this.member_id = member_id;
        this.status = status;
        this.issue_date = issue_date;
        this.return_date = return_date;
        this.note = note;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    My_Classes.Book book = new My_Classes.Book();

    public void addIssue(int _book_id, int _member_id, String _status, String _date_issue, String _date_return, String _note) throws SQLException {
        String insertQuery = "INSERT INTO `issue_book`(`book_id`, `member_id`, `status`, `issue_date`, `return_date`, `note`) VALUES ( ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);

            ps.setInt(1, _book_id);
            ps.setInt(2, _member_id);
            ps.setString(3, _status);
            ps.setString(4, _date_issue);
            ps.setString(5, _date_return);
            ps.setString(6, _note);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Issue Book is added", "add issue book", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Issue Book is not added", "add issue book", 0);
            }
        } catch (SQLException e) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //check if this book is available
    public boolean checkBookAvailability(int _book_id) {

        boolean availaility = false;

        try {
            //first get the book quality
            Book selectedBook = book.getBookById(_book_id);
            int quanlity = selectedBook.getQuanlity();

            //get the number of books issue (the same book)
            int issue_book_count = countData(_book_id);

            if (quanlity > issue_book_count) {
                availaility = true;
            } else {
                availaility = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Issue_Book.class.getName()).log(Level.SEVERE, null, ex);
        }

        return availaility;
    }

    //creat a func to count the number of data
    public int countData(int _book_id) {
        int total = 0;
        ResultSet rs;
        PreparedStatement ps;

        try {
            ps = DB.getConnection().prepareStatement("SELECT COUNT(*) as total FROM `issue_book` WHERE book_id = ? AND `status` = 'issue'");
            ps.setInt(1, _book_id);
            rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Issue_Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    //func to populate an arraylist with issued/ retruned/ losted book
    public ArrayList<Issue_Book> issuedBooksList(String _status) {

        ArrayList<Issue_Book> issueBookListt = new ArrayList<>();
        Func_Class func = new Func_Class();
        String query;

        if (_status.equals("")) {    //if the status emmty then show all data
            query = "SELECT * FROM `issue_book`";
        } else {                    //show data depending on the selected status
            query = "SELECT * FROM `issue_book` WHERE `status` = '" + _status + "'";
        }

        try {
            ResultSet rs = func.getData(query);

            Issue_Book issbook;

            while (rs.next()) {
                issbook = new Issue_Book(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
                issueBookListt.add(issbook);
            }

        } catch (SQLException sQLException) {
            Logger.getLogger(Issue_Book.class.getName()).log(Level.SEVERE, null, sQLException);
        }
        return issueBookListt;
    }

    public void updateIssue(int _book_id, int _member_id, String _status, String _date_issue, String _date_return, String _note) throws SQLException {
        String updateQuery = "UPDATE `issue_book` SET `status`= ?,`return_date`=?,`note`=? WHERE `book_id` = ? AND `member_id` = ? AND `issue_date` = ?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(updateQuery);

            ps.setString(1, _status);
            ps.setString(2, _date_return);
            ps.setString(3, _note);
            ps.setInt(4, _book_id);
            ps.setInt(5, _member_id);
            ps.setString(6, _date_issue);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Status update", "issue book", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Status update is not update", "issue book", 0);
            }
        } catch (SQLException e) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //remove issue book using the book id - member id and issue date
    //you can add a collum id (make it as the key) into the table and delete using it
    public void deleteBookFromIssueTable(int _book_id, int _member_id, String _date_issue) {
        String removeQuery = "DELETE FROM `issue_book` WHERE `book_id` = ? AND `member_id` = ? AND `issue_date` = ? ";

        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);

            ps.setInt(1, _book_id);
            ps.setInt(2, _member_id);
            ps.setString(3, _date_issue);

            if (ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Deleted Successfully", "delete book", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Not Deleted", "delete book", 0);
            }
        } catch (SQLException e) {
            Logger.getLogger(Issue_Book.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
