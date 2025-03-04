/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package friends;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;
import javax.swing.JOptionPane;
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtNumber = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name");

        jLabel2.setText("Number");

        txtNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberActionPerformed(evt);
            }
        });

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnRead.setText("Read");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(txtName)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreate)
                        .addGap(68, 68, 68)
                        .addComponent(btnRead)
                        .addGap(58, 58, 58)
                        .addComponent(btnUpdate)
                        .addGap(55, 55, 55)
                        .addComponent(btnDelete)))
                .addGap(47, 47, 47)
                .addComponent(btnClear)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnRead)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnUpdate))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
   try { 
            String newName = txtName.getText();
            long newNumber = Long.parseLong(txtNumber.getText());
            String nameNumberString;
            int index;
            String name;
            long number;
            
            File file = new File("friendsContact.txt");
            
            if(!file.exists()== false){
                file.createNewFile();
            }
            
            RandomAccessFile raf = new  RandomAccessFile(file, "rw");
            boolean found = false;
            JOptionPane.showMessageDialog(null,"Contacto añadido","INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            while ((raf.getFilePointer() < raf.length())== true) {
                
                nameNumberString = raf.readLine();
                
                String[] lineSplit = nameNumberString.split("!");
                
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
                
                if (name.equals(newName)|| number == newNumber){
                   found = true;
                   
                    
                   break;
               
                }
            }
            
            if (found == false) {

				
		nameNumberString = newName + "!" + String.valueOf(newNumber);

				
		raf.writeBytes(nameNumberString);

				
		raf.writeBytes(System.lineSeparator());

				
		
                txtName.setText("");
                txtNumber.setText("");

				
		raf.close();
	}
            else {

		raf.close();

				
		
	 }
     }

     catch (IOException ioe) {

	System.out.println(ioe);
     }
     catch (NumberFormatException nef) {

	System.out.println(nef);
     }
   
     
    }//GEN-LAST:event_btnCreateActionPerformed

    private void txtNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        try {

            String newName = txtName.getText();
	    String nameNumberString;
	    long number;
            String name;
	    int index;

			
	    File file = new File("friendsContact.txt");

	    if (!file.exists()) {

				
		file.createNewFile();
	    }
            RandomAccessFile raf = new RandomAccessFile(file, "r");
	    boolean found = false;
             
			
	    while (raf.getFilePointer() < raf.length()) {
                
		nameNumberString = raf.readLine();		
		String[] lineSplit = nameNumberString.split("!");		
		name = lineSplit[0];
		number = Long.parseLong(lineSplit[1]);

		if(name.equals(newName)){
                    found = true;
                   txtName.setText(String.valueOf(name));
                   txtNumber.setText(String.valueOf(number));
                   }		
               
            }  
                
                    
            if(found== false){
                
                  txtName.setText("");
                   txtNumber.setText("");
                }
            }

		catch (IOException ioe)
		{

		  System.out.println(ioe);
                ;
		}
		catch (NumberFormatException nef)
		{
                   
		   System.out.println(nef);
		}
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    try {

			
	String newName = txtName.getText();
	long newNumber = Long.parseLong(txtNumber.getText());
	
        String nameNumberString;
        String name;
	int index;
        long number ;
		
	File file = new File("friendsContact.txt");

	if (!file.exists()) {			
	     file.createNewFile();
	}

			
	RandomAccessFile raf = new RandomAccessFile(file, "rw");
	boolean found = false;

			
	while (raf.getFilePointer() < raf.length()) {

				
	     nameNumberString = raf.readLine();		
             String[] lineSplit = nameNumberString.split("!");

	     name = lineSplit[0];
	     number = Long.parseLong(lineSplit[1]);

				
	    if (name.equals(newName) && number== newNumber) {
		found = true;
		break;
		}
			
        
         }

			
	if (found == true) {

	     File tmpFile = new File("temp.txt");
	   
             RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");

	     raf.seek(0);

				
	     while (raf.getFilePointer()< raf.length()) {

					
		  nameNumberString = raf.readLine();
                  String[] lineSplit2 = nameNumberString.split("!");

		  
		  name =  lineSplit2[0];
                  number = Long.parseLong(lineSplit2[1]);

					
                    if (name.equals(newName) && number== newNumber) {			
		         continue;
		  }

	
			  tmpraf.writeBytes(nameNumberString);

					
			  tmpraf.writeBytes(System.lineSeparator());
	                }

				
			raf.seek(0);
			tmpraf.seek(0);

				
			while (tmpraf.getFilePointer()< tmpraf.length()) {
					raf.writeBytes(tmpraf.readLine());
					raf.writeBytes(System.lineSeparator());
			}

				
				raf.setLength(tmpraf.length());

				
				tmpraf.close();
				raf.close();

				
				tmpFile.delete();

				 JOptionPane.showMessageDialog(null,"contacto eliminado",
                                 "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                                 txtName.setText("");
                                 txtNumber.setText("");
			}

			
			
			else {

				
				raf.close();

				 
                                 
                                 
			}
		}

		catch (IOException ioe) {
			System.out.println(ioe);
		}
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
     
        try {
            String nametoUpdate = txtName.getText();
            long numbertoUpdate = Long.parseLong(txtNumber.getText());

            String nameNumberString;
            String name;
            long number;
            int index;

            File file = new File("friendsContact.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;

            while (raf.getFilePointer() < raf.length()) {
                nameNumberString = raf.readLine();
                String[] lineSplit = nameNumberString.split("!");

                if (lineSplit.length < 2) continue;

                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);

                if (name.equals(nametoUpdate)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                File tmpFile = new File("temp.txt");
                RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");

                raf.seek(0);

                while (raf.getFilePointer() < raf.length()) {
                    nameNumberString = raf.readLine();
                    index = nameNumberString.indexOf('!');
                    name = nameNumberString.substring(0, index);

                    if (name.equals(nametoUpdate)) {
                        nameNumberString = name + "!" + numbertoUpdate;
                    }

                    tmpraf.writeBytes(nameNumberString);
                    tmpraf.writeBytes(System.lineSeparator());
                }

                raf.seek(0);
                tmpraf.seek(0);

                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }

                raf.setLength(tmpraf.length());

                tmpraf.close();
                raf.close();
                tmpFile.delete();

                JOptionPane.showMessageDialog(null,"Friend Updated",
                 "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            } else {
                raf.close();
                JOptionPane.showMessageDialog(null,"El contacto no existe",
                 "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        } catch (NumberFormatException nef) {
            System.out.println(nef);
        }
    
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtName.setText("");
        txtNumber.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables
}
