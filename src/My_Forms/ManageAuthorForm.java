package My_Forms;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.Notification;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyễn Văn Khoa
 */
public class ManageAuthorForm extends javax.swing.JFrame {

    /**
     * Creates new form ManageGenresForm
     */
    My_Classes.Author authors = new My_Classes.Author();

    public ManageAuthorForm() {
        initComponents();
        this.setLocationRelativeTo(null);

        Border panelHeaderBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(1, 50, 67));
        jPanel1.setBorder(panelHeaderBorder);

        //display image
        My_Classes.Func_Class func = new My_Classes.Func_Class();
        func.displayImage(60, 60, null, "/My_Images/icons8_user_typing_using_typewriter_80px.png", jLabel_Form_Title);

        //custon the table
        func.customTable(jTable_Author);

        //custom the headertable
        func.customTableHeader(jTable_Author, new Color(199, 21, 133), 15);

        //hide the jlable "empty name message"
        jLabel_EmptyFirstName_.setVisible(false);
        jLabel_EmptyLastName_.setVisible(false);

        //show all genres from sql
        populateJtableWithAuthor("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel_Form_Title = new javax.swing.JLabel();
        jLabel_Close = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_ID = new javax.swing.JTextField();
        jTextField_FirstName = new javax.swing.JTextField();
        jButton_Add_ = new javax.swing.JButton();
        jButton_Delete_ = new javax.swing.JButton();
        jButton_Edit_ = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Author = new javax.swing.JTable();
        jLabel_EmptyFirstName_ = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Expertise = new javax.swing.JTextField();
        jLabel_EmptyLastName_ = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_LastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_About = new javax.swing.JTextField();
        jLabel_MemberID = new javax.swing.JLabel();
        jTextField_Search = new javax.swing.JTextField();
        jButton_Search = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel_Form_Title.setBackground(new java.awt.Color(102, 69, 142));
        jLabel_Form_Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel_Form_Title.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Form_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Form_Title.setText("Manage Author");
        jLabel_Form_Title.setOpaque(true);

        jLabel_Close.setBackground(new java.awt.Color(102, 69, 142));
        jLabel_Close.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel_Close.setForeground(new java.awt.Color(255, 102, 102));
        jLabel_Close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Close.setText("X");
        jLabel_Close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Close.setOpaque(true);
        jLabel_Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_CloseMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("First Name:");

        jTextField_ID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField_FirstName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton_Add_.setBackground(new java.awt.Color(153, 255, 153));
        jButton_Add_.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_Add_.setText("ADD");
        jButton_Add_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Add_ActionPerformed(evt);
            }
        });

        jButton_Delete_.setBackground(new java.awt.Color(255, 153, 153));
        jButton_Delete_.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_Delete_.setText("DELETE");
        jButton_Delete_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Delete_ActionPerformed(evt);
            }
        });

        jButton_Edit_.setBackground(new java.awt.Color(255, 255, 153));
        jButton_Edit_.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_Edit_.setText("EDIT");
        jButton_Edit_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Edit_ActionPerformed(evt);
            }
        });

        jTable_Author.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable_Author.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_Author.setAutoscrolls(false);
        jTable_Author.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable_Author.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_AuthorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Author);

        jLabel_EmptyFirstName_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_EmptyFirstName_.setForeground(new java.awt.Color(255, 102, 102));
        jLabel_EmptyFirstName_.setText("* Enter the first name");
        jLabel_EmptyFirstName_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EmptyFirstName_MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Expertise:");

        jTextField_Expertise.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel_EmptyLastName_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_EmptyLastName_.setForeground(new java.awt.Color(255, 102, 102));
        jLabel_EmptyLastName_.setText("* Enter the last name");
        jLabel_EmptyLastName_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EmptyLastName_MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Last Name:");

        jTextField_LastName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_LastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_LastNameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("About:");

        jTextField_About.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel_MemberID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_MemberID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_MemberID.setText("Values To Search:");

        jTextField_Search.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton_Search.setBackground(new java.awt.Color(0, 153, 102));
        jButton_Search.setText("Search");
        jButton_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel_Form_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Close, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_EmptyFirstName_)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_ID)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton_Add_, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_About)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel_EmptyLastName_)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton_Delete_, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton_Edit_, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 30, Short.MAX_VALUE))
                                    .addComponent(jTextField_Expertise)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(20, 20, 20)
                                .addComponent(jTextField_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_MemberID)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton_Add_, jButton_Delete_, jButton_Edit_});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_Close, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(jLabel_Form_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_MemberID))
                        .addGap(3, 3, 3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_EmptyFirstName_)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_EmptyLastName_)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Expertise, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_About, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_Add_)
                            .addComponent(jButton_Delete_)
                            .addComponent(jButton_Edit_)))
                    .addComponent(jScrollPane1))
                .addGap(39, 39, 39))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton_Delete_, jButton_Edit_});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CloseMouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel_CloseMouseClicked

    private void jButton_Add_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Add_ActionPerformed
        String firstName = jTextField_FirstName.getText();
        String lastName = jTextField_LastName.getText();
        String expertise = jTextField_Expertise.getText();
        String about = jTextField_About.getText();

        if (firstName.trim().isEmpty()) {
            jLabel_EmptyFirstName_.setVisible(true);

        } else if (lastName.trim().isEmpty()) {
            jLabel_EmptyLastName_.setVisible(true);
        } else {
            try {
                authors.addAuthor(firstName, lastName, expertise, about);

                //refresh the jtable after we add
                populateJtableWithAuthor("");

                jLabel_EmptyFirstName_.setVisible(false);
                jLabel_EmptyLastName_.setVisible(false);

                //after refresh the table we clear the textfield
                jTextField_ID.setText("");
                jTextField_FirstName.setText("");
                jTextField_LastName.setText("");
                jTextField_Expertise.setText("");
                jTextField_About.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(ManageAuthorForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton_Add_ActionPerformed

    private void jButton_Edit_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Edit_ActionPerformed

        String firstName = jTextField_FirstName.getText();
        String lastName = jTextField_LastName.getText();
        String expertise = jTextField_Expertise.getText();
        String about = jTextField_About.getText();

        if (firstName.trim().isEmpty()) {
            jLabel_EmptyFirstName_.setVisible(true);
        } else if (lastName.trim().isEmpty()) {
            jLabel_EmptyLastName_.setVisible(true);
        } else {
            try {
                try {
                    int id = Integer.parseInt(jTextField_ID.getText());
                    authors.editAuthor(id, firstName, lastName, expertise, about);

                    //refresh the jtable after we edit
                    populateJtableWithAuthor("");
                    jLabel_EmptyFirstName_.setVisible(false);
                    jLabel_EmptyLastName_.setVisible(false);

                } catch (SQLException ex) {
                    Logger.getLogger(ManageAuthorForm.class.getName()).log(Level.SEVERE, null, ex);

                    
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Author ID - " + ex.getMessage(), "Error", 0);

            }
        }
    }//GEN-LAST:event_jButton_Edit_ActionPerformed

    private void jButton_Delete_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Delete_ActionPerformed
        try {
            int id = Integer.parseInt(jTextField_ID.getText());
            authors.deleteAuthor(id);

          

            //refresh the jtable after we delete
            populateJtableWithAuthor("");
            jTextField_ID.setText("");
            jTextField_FirstName.setText("");
            jTextField_LastName.setText("");
            jTextField_Expertise.setText("");
            jTextField_About.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(ManageAuthorForm.class.getName()).log(Level.SEVERE, null, ex);

            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Deleted UnSuccess");
            panel.showNotification();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Genre ID" + e.getMessage(), "Error", 0);
            
        }
    }//GEN-LAST:event_jButton_Delete_ActionPerformed

    private void jTable_AuthorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_AuthorMouseClicked
        //display the selected genres
        //get the selected row index
        int index = jTable_Author.getSelectedRow();

        //get values;
        String id = jTable_Author.getValueAt(index, 0).toString();
        String firstName = jTable_Author.getValueAt(index, 1).toString();
        String lastName = jTable_Author.getValueAt(index, 2).toString();
        String expertise = jTable_Author.getValueAt(index, 3).toString();
        String about = jTable_Author.getValueAt(index, 4).toString();

        //show data in textfield
        jTextField_ID.setText(id);
        jTextField_FirstName.setText(firstName);
        jTextField_LastName.setText(lastName);
        jTextField_Expertise.setText(expertise);
        jTextField_About.setText(about);

    }//GEN-LAST:event_jTable_AuthorMouseClicked

    public void populateJtableWithAuthor(String query) {
        ArrayList<My_Classes.Author> authorsList = authors.authorsList(query);

        //jtable collums
        String[] colNames = {"ID_AUTHOR", "FIRST_NAME", "LAST_NAME", "EXPERTISE", "ABOUT"};
        //jtable row
        Object[][] rows = new Object[authorsList.size()][colNames.length];

        for (int i = 0; i < authorsList.size(); i++) {
            rows[i][0] = authorsList.get(i).getId();
            rows[i][1] = authorsList.get(i).getFirstName();
            rows[i][2] = authorsList.get(i).getLastName();
            rows[i][3] = authorsList.get(i).getField_Of_Expertise();
            rows[i][4] = authorsList.get(i).getAbout();
        }

        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        jTable_Author.setModel(model);
    }

    private void jLabel_EmptyFirstName_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EmptyFirstName_MouseClicked
        //hide this jlable on click 
        jLabel_EmptyFirstName_.setVisible(false);
        jLabel_EmptyLastName_.setVisible(false);
    }//GEN-LAST:event_jLabel_EmptyFirstName_MouseClicked

    private void jLabel_EmptyLastName_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EmptyLastName_MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_EmptyLastName_MouseClicked

    private void jTextField_LastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_LastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_LastNameActionPerformed

    private void jButton_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SearchActionPerformed
        //search and display the data on the table
        String value = jTextField_Search.getText();
        String query = "SELECT * FROM `author` WHERE `firstName` LIKE '%" + value + "%' OR `lastname` LIKE '%text%'";
        populateJtableWithAuthor(query);
    }//GEN-LAST:event_jButton_SearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Add_;
    private javax.swing.JButton jButton_Delete_;
    private javax.swing.JButton jButton_Edit_;
    private javax.swing.JButton jButton_Search;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_Close;
    private javax.swing.JLabel jLabel_EmptyFirstName_;
    private javax.swing.JLabel jLabel_EmptyLastName_;
    private javax.swing.JLabel jLabel_Form_Title;
    private javax.swing.JLabel jLabel_MemberID;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Author;
    private javax.swing.JTextField jTextField_About;
    private javax.swing.JTextField jTextField_Expertise;
    private javax.swing.JTextField jTextField_FirstName;
    private javax.swing.JTextField jTextField_ID;
    private javax.swing.JTextField jTextField_LastName;
    private javax.swing.JTextField jTextField_Search;
    // End of variables declaration//GEN-END:variables
}
