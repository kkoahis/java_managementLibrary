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
public class Member {

    private int Id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String gender;
    private byte[] picture;

    public Member() {
    }

    public Member(int id, String firstName, String lastName, String phone, String email, String gender, byte[] picture) {
        this.Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.picture = picture;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void addMember(String _firstName, String _lastName, String _phone, String _email, String _gender, byte[] _picture) throws SQLException {
        String insertQuery = "INSERT INTO `members`(`firstName`, `lastName`, `phone`, `email`, `gender`, `picture`) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);

            ps.setString(1, _firstName);
            ps.setString(2, _lastName);
            ps.setString(3, _phone);
            ps.setString(4, _email);
            ps.setString(5, _gender);
            ps.setBytes(6, _picture);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Members is added", "add member", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Members is not added", "add member", 0);
            }

        } catch (SQLException e) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void editMember(Integer _id, String _firstName, String _lastName, String _phone, String _email, String _gender, byte[] _picture) throws SQLException {
        String updateQuery = "";
        PreparedStatement ps;

        try {
            if (_picture != null) {   //if you want to update the image
                updateQuery = "UPDATE `members` SET `firstName`= ?,`lastName`= ?,`phone`= ?,`email`= ?,`gender`= ?,`picture`= ? WHERE `id_Member` = ?";
                ps = DB.getConnection().prepareStatement(updateQuery);

                ps.setString(1, _firstName);
                ps.setString(2, _lastName);
                ps.setString(3, _phone);
                ps.setString(4, _email);
                ps.setString(5, _gender);
                ps.setBytes(6, _picture);
                ps.setInt(7, _id);
            } else {        //else not update
                updateQuery = "UPDATE `members` SET `firstName`= ?,`lastName`= ?,`phone`= ?,`email`= ?,`gender`= ? WHERE `id_Member` = ?";
                ps = DB.getConnection().prepareStatement(updateQuery);

                ps.setString(1, _firstName);
                ps.setString(2, _lastName);
                ps.setString(3, _phone);
                ps.setString(4, _email);
                ps.setString(5, _gender);
                ps.setInt(6, _id);
            }

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Book is edited", "edit book", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Book is not edit", "edit book", 0);
            }
        } catch (SQLException e) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void deleteMember(int _id) throws SQLException {
        String insertQuery = "DELETE FROM `members` WHERE `id_Member` = ?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);

            ps.setInt(1, _id);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Member is deleted", "delete member", 1);
            } else {
                JOptionPane.showMessageDialog(null, "No Member ID In System", "delete member", 0);
            }

        } catch (SQLException e) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Member getMemberById(Integer _id) throws SQLException {
        Func_Class func = new Func_Class();
        String Query = "SELECT * FROM `members` WHERE `id_Member` = " + _id;
        ResultSet rs = func.getData(Query);

        if (rs.next()) {
            return new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBytes(7));
        } else {
            return null;
        }
    }

    public ArrayList<Member> membersList(String query) {
        ArrayList<Member> memLists = new ArrayList<>();

        My_Classes.Func_Class func = new Func_Class();

        try {
            if (query.equals("")) {
                query = "SELECT * FROM `members`";  //if the user empty String then use defaut select
            }

            ResultSet rs = func.getData(query);

            Member member;

            while (rs.next()) {
                member = new Member(rs.getInt("id_Member"), rs.getString("firstName"), rs.getString("lastName"),
                        rs.getString("phone"), rs.getString("email"), rs.getString("gender"), rs.getBytes("picture"));
                memLists.add(member);
            }

        } catch (SQLException sQLException) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, sQLException);
        }
        return memLists;
    }
}
