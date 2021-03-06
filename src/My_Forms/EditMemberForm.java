package My_Forms;

import My_Classes.Member;
import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Nguyễn Văn Khoa
 */
public class EditMemberForm extends javax.swing.JFrame {

    /**
     * Creates new form ManageGenresForm
     */
    My_Classes.Member member = new My_Classes.Member();

    My_Classes.Func_Class func = new My_Classes.Func_Class();

    //creat a varible to store the profile picture path
    String imagePath = "";

    public EditMemberForm() {
        initComponents();
        this.setLocationRelativeTo(null);

        Border panelHeaderBorder = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.yellow);
        jPanel1.setBorder(panelHeaderBorder);

        //add black border for the jlable image
        Border panelImageBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);
        jLabel_Image.setBorder(panelImageBorder);

        //display image
        My_Classes.Func_Class func = new My_Classes.Func_Class();
        func.displayImage(60, 60, null, "/My_Images/icons8_edit_user_100px.png", jLabel_Form_Title);

        //hide the jlable "empty name message"
        jLabel_EmptyFirstName_.setVisible(false);
        jLabel_EmptyLastName_.setVisible(false);
        jLabel_EmptyPhone_.setVisible(false);

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
        jLabel1 = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jTextField_FirstName1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel_Form_Title = new javax.swing.JLabel();
        jLabel_Close = new javax.swing.JLabel();
        jLabel_FirstName = new javax.swing.JLabel();
        jTextField_ID = new javax.swing.JTextField();
        jButton_Edit_ = new javax.swing.JButton();
        jLabel_EmptyFirstName_ = new javax.swing.JLabel();
        jLabel_Email = new javax.swing.JLabel();
        jTextField_Email = new javax.swing.JTextField();
        jLabel_EmptyPhone_ = new javax.swing.JLabel();
        jLabel_PhoneNumber = new javax.swing.JLabel();
        jTextField_LastName = new javax.swing.JTextField();
        jLabel_LastName = new javax.swing.JLabel();
        jTextField_PhoneNumber = new javax.swing.JTextField();
        jLabel_EmptyLastName_ = new javax.swing.JLabel();
        jLabel_Gender = new javax.swing.JLabel();
        jComboBox_Gender = new javax.swing.JComboBox<>();
        jLabel_Profile = new javax.swing.JLabel();
        jButton_SelectProfile = new javax.swing.JButton();
        jLabel_MemberID = new javax.swing.JLabel();
        jButton_SearchID = new javax.swing.JButton();
        jTextField_FirstName = new javax.swing.JTextField();
        jLabel_Image = new javax.swing.JLabel();
        jLabel_ImagePath = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("jLabel1");

        jTextField_FirstName1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel_Form_Title.setBackground(new java.awt.Color(255, 235, 15));
        jLabel_Form_Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel_Form_Title.setForeground(new java.awt.Color(102, 113, 242));
        jLabel_Form_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Form_Title.setText("EDIT MEMBER");
        jLabel_Form_Title.setOpaque(true);

        jLabel_Close.setBackground(new java.awt.Color(255, 235, 15));
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

        jLabel_FirstName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_FirstName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_FirstName.setText("First Name:");

        jTextField_ID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton_Edit_.setBackground(new java.awt.Color(255, 235, 15));
        jButton_Edit_.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_Edit_.setForeground(new java.awt.Color(102, 113, 242));
        jButton_Edit_.setText("EDIT MEMBER");
        jButton_Edit_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Edit_ActionPerformed(evt);
            }
        });

        jLabel_EmptyFirstName_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_EmptyFirstName_.setForeground(new java.awt.Color(255, 102, 102));
        jLabel_EmptyFirstName_.setText("* Enter the first name");
        jLabel_EmptyFirstName_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EmptyFirstName_MouseClicked(evt);
            }
        });

        jLabel_Email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_Email.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Email.setText("Email:");

        jTextField_Email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel_EmptyPhone_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_EmptyPhone_.setForeground(new java.awt.Color(255, 102, 102));
        jLabel_EmptyPhone_.setText("* Enter the number");
        jLabel_EmptyPhone_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EmptyPhone_MouseClicked(evt);
            }
        });

        jLabel_PhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_PhoneNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_PhoneNumber.setText("Phone:");

        jTextField_LastName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel_LastName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_LastName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_LastName.setText("Last Name:");

        jTextField_PhoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PhoneNumberKeyTyped(evt);
            }
        });

        jLabel_EmptyLastName_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_EmptyLastName_.setForeground(new java.awt.Color(255, 102, 102));
        jLabel_EmptyLastName_.setText("* Enter the last name");
        jLabel_EmptyLastName_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EmptyLastName_MouseClicked(evt);
            }
        });

        jLabel_Gender.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_Gender.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Gender.setText("Gender:");

        jComboBox_Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel_Profile.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_Profile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Profile.setText("Profile Picture:");

        jButton_SelectProfile.setText("Select Profile");
        jButton_SelectProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SelectProfileActionPerformed(evt);
            }
        });

        jLabel_MemberID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_MemberID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_MemberID.setText("Enter Member ID:");

        jButton_SearchID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_SearchID.setText("SEARCH");
        jButton_SearchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SearchIDActionPerformed(evt);
            }
        });

        jTextField_FirstName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel_Image.setBackground(new java.awt.Color(204, 204, 255));
        jLabel_Image.setOpaque(true);

        jLabel_ImagePath.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel_ImagePath.setForeground(new java.awt.Color(0, 0, 255));
        jLabel_ImagePath.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_ImagePath.setText("please choose profile picture");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel_Form_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Close, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_Edit_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_FirstName)
                            .addComponent(jLabel_FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_MemberID)
                            .addComponent(jTextField_PhoneNumber)
                            .addComponent(jTextField_LastName))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_SearchID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel_EmptyPhone_, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_EmptyLastName_, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_EmptyFirstName_, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_LastName)
                            .addComponent(jLabel_PhoneNumber)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_Profile)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_ImagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton_SelectProfile)))))
                        .addGap(0, 15, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextField_Email, jTextField_FirstName, jTextField_LastName, jTextField_PhoneNumber});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Form_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Close, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_MemberID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_ID)
                    .addComponent(jButton_SearchID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel_FirstName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_EmptyFirstName_))
                .addGap(18, 18, 18)
                .addComponent(jLabel_LastName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_EmptyLastName_))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_PhoneNumber)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_EmptyPhone_))
                .addGap(18, 18, 18)
                .addComponent(jLabel_Email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Gender)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_Gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_SelectProfile)
                    .addComponent(jLabel_Profile)
                    .addComponent(jLabel_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_ImagePath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_Edit_)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextField_FirstName, jTextField_ID, jTextField_LastName, jTextField_PhoneNumber});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBox_Gender, jTextField_Email});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    public void setEmpty() {
        jTextField_ID.setText("");
        jTextField_FirstName.setText("");
        jTextField_LastName.setText("");
        jTextField_PhoneNumber.setText("");
        jTextField_Email.setText("");
        jComboBox_Gender.setSelectedItem("Male");
        jLabel_ImagePath.setText("please choose profile picture");
        func.displayImage(238, 177, null, null, jLabel_Image);
    }

    private void jButton_Edit_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Edit_ActionPerformed
        if (!verif()) {
            JOptionPane.showMessageDialog(null, "One Or More Fields Is Empty", "empty data", 2);
        } else {
            try {
                int id = Integer.parseInt(jTextField_ID.getText());
                String firstname = jTextField_FirstName.getText();
                String lastname = jTextField_LastName.getText();
                String phonenumber = jTextField_PhoneNumber.getText();
                String email = jTextField_Email.getText();
                String sex = jComboBox_Gender.getSelectedItem().toString();
                
                Path path = Paths.get(imagePath);

                try {
                    //if the user want to change the image
                    byte[] img = Files.readAllBytes(path);
                    member.editMember(id, firstname, lastname, phonenumber, email, sex, img);
                } catch (IOException e) {   //if not want to change
                    JOptionPane.showMessageDialog(null, "Picture Profile will not edited", "Edit Profile piceture error", 2);
                    member.editMember(id, firstname, lastname, phonenumber, email, sex, null);
                }
            } catch (SQLException ex) {
                Logger.getLogger(EditBookForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "You Enterred Wrong Data In A Number Field", "Wrong data number", 2);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "You Need To Select A Date", "Select date", 2);
            }
        }
    }//GEN-LAST:event_jButton_Edit_ActionPerformed

    public boolean verif() {
        if (jTextField_FirstName.getText().equals("") || jTextField_LastName.getText().equals("")
                || jTextField_PhoneNumber.getText().equals("") || jTextField_Email.getText().equals("")
                || jComboBox_Gender.getSelectedItem().equals("ID")) {
            return false;
        } else {
            return true;
        }
    }

    private void jLabel_EmptyFirstName_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EmptyFirstName_MouseClicked
        //hide this jlable on click 
        jLabel_EmptyFirstName_.setVisible(false);
    }//GEN-LAST:event_jLabel_EmptyFirstName_MouseClicked

    private void jLabel_EmptyPhone_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EmptyPhone_MouseClicked
        //hide this jlable on click 
        jLabel_EmptyPhone_.setVisible(false);
    }//GEN-LAST:event_jLabel_EmptyPhone_MouseClicked

    private void jLabel_EmptyLastName_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EmptyLastName_MouseClicked
        //hide this jlable on click 
        jLabel_LastName.setVisible(false);
    }//GEN-LAST:event_jLabel_EmptyLastName_MouseClicked

    private void jButton_SelectProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SelectProfileActionPerformed
        //select pictuer from the PC
        String path = func.selectImage();
        jLabel_ImagePath.setText(path);
        imagePath = path;

        //display the image when we select in path
        func.displayImage(238, 177, null, path, jLabel_Image);
    }//GEN-LAST:event_jButton_SelectProfileActionPerformed

    private void jButton_SearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SearchIDActionPerformed
        //get member ID
        Member selectedmMember;
        try {
            //search member by ID and print infor 
            Integer id = Integer.parseInt(jTextField_ID.getText());

            selectedmMember = member.getMemberById(id);

            if (selectedmMember != null) {
                jTextField_ID.setText(String.valueOf(selectedmMember.getId()));
                jTextField_FirstName.setText(selectedmMember.getFirstName());
                jTextField_LastName.setText(selectedmMember.getLastName());
                jTextField_PhoneNumber.setText(selectedmMember.getPhone());
                jTextField_Email.setText(selectedmMember.getEmail());
                jComboBox_Gender.setSelectedItem(selectedmMember.getGender());

                //display image:
                byte[] image = selectedmMember.getPicture();
                //we will display the image using the imagebyte
                //so we will made the image path null
                func.displayImage(238, 177, image, "", jLabel_Image);
            } else {
                JOptionPane.showMessageDialog(null, "No Member With This ID Found", "invalid id member", 2);
            }

        } catch (SQLException | NumberFormatException ex) {
            //Logger.getLogger(EditMemberForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Enter a valid Member ID", "invalid id member", 3);
        }
    }//GEN-LAST:event_jButton_SearchIDActionPerformed

    private void jTextField_PhoneNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PhoneNumberKeyTyped
        //allow only numbers on phone jtexfield
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_PhoneNumberKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Edit_;
    private javax.swing.JButton jButton_SearchID;
    private javax.swing.JButton jButton_SelectProfile;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox_Gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Close;
    private javax.swing.JLabel jLabel_Email;
    private javax.swing.JLabel jLabel_EmptyFirstName_;
    private javax.swing.JLabel jLabel_EmptyLastName_;
    private javax.swing.JLabel jLabel_EmptyPhone_;
    private javax.swing.JLabel jLabel_FirstName;
    private javax.swing.JLabel jLabel_Form_Title;
    private javax.swing.JLabel jLabel_Gender;
    private javax.swing.JLabel jLabel_Image;
    private javax.swing.JLabel jLabel_ImagePath;
    private javax.swing.JLabel jLabel_LastName;
    private javax.swing.JLabel jLabel_MemberID;
    private javax.swing.JLabel jLabel_PhoneNumber;
    private javax.swing.JLabel jLabel_Profile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JTextField jTextField_Email;
    private javax.swing.JTextField jTextField_FirstName;
    private javax.swing.JTextField jTextField_FirstName1;
    private javax.swing.JTextField jTextField_ID;
    private javax.swing.JTextField jTextField_LastName;
    private javax.swing.JTextField jTextField_PhoneNumber;
    // End of variables declaration//GEN-END:variables
}
