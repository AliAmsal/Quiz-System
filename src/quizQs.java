
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class quizQs extends javax.swing.JFrame {

    Quizzes Q;
    int qsNo = 0;
    char Ans;
    public quizQs(Quizzes q) throws NullPointerException, FileNotFoundException, IOException{
        Q = new Quizzes(q.getId(),q.getTotalQs(),q.getSubject(),q.getTopic());
        System.out.println(q.getId() + " " + q.getTotalQs());
        array = new Question[q.getTotalQs()];
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        qsTxt = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        aTF = new javax.swing.JTextField();
        bTF = new javax.swing.JTextField();
        cTF = new javax.swing.JTextField();
        dTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        A = new javax.swing.JButton();
        B = new javax.swing.JButton();
        C = new javax.swing.JButton();
        D = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        bar = new javax.swing.JProgressBar();
        qNum = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        QNO = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        detailTxt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        qsTxt.setColumns(20);
        qsTxt.setRows(5);
        jScrollPane1.setViewportView(qsTxt);

        jLabel1.setText("Enter question: ");

        jLabel2.setText("Enter Options:");

        cTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTFActionPerformed(evt);
            }
        });

        jLabel3.setText("A");

        jLabel4.setText("B");

        jLabel5.setText("C");

        jLabel6.setText("D");

        jLabel7.setText("Enter Answer:");

        A.setText("A");
        A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AActionPerformed(evt);
            }
        });

        B.setText("B");
        B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActionPerformed(evt);
            }
        });

        C.setText("C");
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CActionPerformed(evt);
            }
        });

        D.setText("D");
        D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DActionPerformed(evt);
            }
        });

        jLabel8.setText("QuizID: " + Q.getId());

        QNO.setText("Question 1/10");

        jLabel9.setText("Enter question detail:");

        detailTxt.setColumns(20);
        detailTxt.setRows(5);
        jScrollPane2.setViewportView(detailTxt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(id)
                                        .addComponent(jLabel8)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(A, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(B, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(C, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(D, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bTF, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(aTF, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cTF, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dTF, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(qNum)
                                .addComponent(QNO)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(id)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(QNO)
                .addGap(9, 9, 9)
                .addComponent(qNum)
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A)
                    .addComponent(B)
                    .addComponent(C)
                    .addComponent(D))
                .addGap(18, 18, 18)
                .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cTFActionPerformed

    private void AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AActionPerformed
        int dialogresult = JOptionPane.showConfirmDialog(null, "Are you sure this is the correct answer?","Warning",JOptionPane.YES_NO_OPTION);
            if(dialogresult == JOptionPane.YES_NO_OPTION) {
                isPressed = true;
                
                Ans = 'a';
                nextQs();
            }
    }//GEN-LAST:event_AActionPerformed

    private void BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActionPerformed
         int dialogresult = JOptionPane.showConfirmDialog(null, "Are you sure this is the correct answer?","Warning",JOptionPane.YES_NO_OPTION);
            if(dialogresult == JOptionPane.YES_NO_OPTION) {
                isPressed = true;
                Ans = 'b';
                nextQs();
            }
    }//GEN-LAST:event_BActionPerformed

    private void CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CActionPerformed
         int dialogresult = JOptionPane.showConfirmDialog(null, "Are you sure this is the correct answer?","Warning",JOptionPane.YES_NO_OPTION);
            if(dialogresult == JOptionPane.YES_NO_OPTION) {
                isPressed = true;
                
                Ans = 'c';
                nextQs();
            }
    }//GEN-LAST:event_CActionPerformed

    private void DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DActionPerformed
         int dialogresult = JOptionPane.showConfirmDialog(null, "Are you sure this is the correct answer?","Warning",JOptionPane.YES_NO_OPTION);
            if(dialogresult == JOptionPane.YES_NO_OPTION) {
                isPressed = true;
                
                Ans = 'd';
                nextQs();
            }
    }//GEN-LAST:event_DActionPerformed
    
    public void nextQs() {
        if(qsTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Question cannot be empty");
        }
        else if( aTF.getText().equals("") || bTF.getText().equals("") || cTF.getText().equals("") || dTF.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All answer options should be filled");
        }
        else if(isPressed == false) {
            JOptionPane.showMessageDialog(this, "Please click the button above to record the correct answer");
        }
        else {
            //id.setText("Quiz ID: " + Q.getId());
            if(qsNo < 9) {
                QNO.setText("Question " + (qsNo+2) + "/" + Q.getTotalQs());
            }
            bar.setMaximum(Q.getTotalQs());
            bar.setMinimum(0);
            try {
                Question qs = new Question();
                qs.setQues(qsTxt.getText());
                if(detailTxt.getText().equals("")) {
                    qs.setDetails("Teacher has not added any detail for this Question");
                }
                else {
                    qs.setDetails(detailTxt.getText());
                }
                
                String[] optsArr = {aTF.getText(), bTF.getText(), cTF.getText(), dTF.getText()};
                qs.setOptions(optsArr);
                qs.setAns(Ans);
                array[qsNo] = qs;
                JOptionPane.showMessageDialog(this, "Question successfully added to the quiz");

            } catch (FileNotFoundException ex) {
                Logger.getLogger(quizQs.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            qsTxt.setText("");
            detailTxt.setText("");
            aTF.setText("");
            bTF.setText("");
            cTF.setText("");
            dTF.setText("");
            qsNo++;
            bar.setValue(qsNo);
        
        
        if(qsNo == Q.getTotalQs()) {
                try {
                    RandomAccessFile idsFile = new RandomAccessFile("ids.dat","rw");
                    JOptionPane.showMessageDialog(this, "Quiz created successfully");
                    idsFile.seek(idsFile.length());
                    idsFile.writeInt(Q.getId());
                    Q.writeQuizDetails();
                    Q.writeQuestions(array);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(quizQs.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(quizQs.class.getName()).log(Level.SEVERE, null, ex);
                }
         
            
            quiz q = new quiz();
            q.setVisible(true);
            this.setVisible(false);
        }
       
    }
                
              isPressed = false;  
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws FileNotFoundException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new quizQs(new Quizzes()).setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(quizQs.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException ex) {
                    Logger.getLogger(quizQs.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(quizQs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private boolean isPressed = false;
    private Question[] array;
    //private Quizzes Q;
    //private char Ans;
    //private int qsNo = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton A;
    private javax.swing.JButton B;
    private javax.swing.JButton C;
    private javax.swing.JButton D;
    private javax.swing.JLabel QNO;
    private javax.swing.JTextField aTF;
    private javax.swing.JTextField bTF;
    private javax.swing.JProgressBar bar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JTextField cTF;
    private javax.swing.JTextField dTF;
    private javax.swing.JTextArea detailTxt;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel qNum;
    private javax.swing.JTextArea qsTxt;
    // End of variables declaration//GEN-END:variables
}
