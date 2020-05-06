package rmi;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FireAlarmSensor extends javax.swing.JFrame {

    private Connection con;
    private int alarmId;
    
    
    public FireAlarmSensor() {
        initComponents();

        try {
            
            //Connection to the MySQL Database

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firealarmdb", "root", "");
            System.out.println("Connection Established!");
            
        } catch (Exception ex) {

            System.out.println(ex);

        }
        
        DatabaseConnection db = DatabaseConnection.getDatabaseConnection();
        con = db.getConnection();
        
        //Auto refresh the table in every 15 seconds
        
        setalarmTable();
        
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){    
                    try {
                        int time = 15000;
                        Thread.sleep(time);
                        System.out.println("Refreshed in 15 seconds!");
                        setalarmTable();
                        
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
                  
        });
        
        t.start();

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alarmTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sensor_id = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        smoke_level = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        Floor_no = new javax.swing.JComboBox<>();
        Room_no = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        alarmTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        alarmTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alarmTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(alarmTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Sensor ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Floor Number");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Room Number");

        sensor_id.setEditable(false);
        sensor_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        add.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        edit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Fire Alarm Sensor Details");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Smoke Level");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Status");

        smoke_level.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        status.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Floor_no.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        Room_no.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S01", "S02", "S03", "S04", "S05", "S06", "S07", "S08", "S09", "S10" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel6)))
                                .addGap(76, 76, 76))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(add)
                                .addGap(67, 67, 67)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(edit)
                                .addGap(69, 69, 69)
                                .addComponent(delete))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Room_no, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sensor_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                .addComponent(smoke_level, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(status, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Floor_no, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sensor_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Room_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(Floor_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(smoke_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(edit)
                    .addComponent(delete))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1096, 747));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        
        if(alarmId!=0){
            
            try{
                
                //Delete the firealarm sensor details from the database when selected from the table  by Id
                
                Statement s = con.createStatement();
                s.execute("delete from sensors where id="+alarmId);
                JOptionPane.showMessageDialog(this, "Record Are Deleted!");
                
                setalarmTable();
                resetData();
                alarmId=0;
            
            }
            catch(Exception ex){
                
                JOptionPane.showMessageDialog(this, "Can't Delete Records!");
            }
        }
        
    }//GEN-LAST:event_deleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        int floorNos = Integer.parseInt(Floor_no.getSelectedItem().toString());
        String roomNos = Room_no.getSelectedItem().toString();
        int smokeLevels = Integer.parseInt(smoke_level.getText());
        String sensorStatus = status.getText();

        try {
            
            //Adding new fire alarm sensors to the database.
            //Admin need to provide the floor no (Integer value), room no(String value), smoke level(Integer value) and status(String value) of the firelalrams.
            //No need to provide Sensor ID as it is autogenerated.

            Statement s = con.createStatement();
            s.execute("INSERT INTO sensors(floorNo,roomNo,smokeLevel,status) values(" + floorNos + ",'" + roomNos + "'," + smokeLevels + ",'" + sensorStatus + "')");

            JOptionPane.showMessageDialog(this, "Records Are Submitted!");

            setalarmTable();
            s.close();
            resetData();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, ex);
           
        }

    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed

        if (alarmId != 0) {

            int floorNos = Integer.parseInt(Floor_no.getSelectedItem().toString());
            String roomNos = Room_no.getSelectedItem().toString();
            int smokeLevels = Integer.parseInt(smoke_level.getText());
            String sensorStatus = status.getText();
            
            try{
                
                //Edit the fire alarm sensor details in the database
                
                Statement s = con.createStatement();
                s.execute("update sensors set floorNo="+floorNos+",roomNo='"+roomNos+"',smokeLevel = "+smokeLevels+",status='"+sensorStatus+"' where id="+alarmId);
                JOptionPane.showMessageDialog(this, "Records Are Updated!");
                
                setalarmTable();
                resetData();
                alarmId=0;
                
            }
            catch(Exception ex){
                
                JOptionPane.showMessageDialog(this, "Can't Update Records!");
                
            }

        }

    }//GEN-LAST:event_editActionPerformed

    private void alarmTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alarmTableMouseClicked

        try {

            //When selected a row from the table, the details of the fire alarm sensor should display on the text boxes and combo boxes
            
            alarmId = Integer.parseInt(alarmTable.getValueAt(alarmTable.getSelectedRow(), 0).toString());
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from sensors where id=" + alarmId);

            if (rs.next()) {

                sensor_id.setText(rs.getInt(1) + "");
                Floor_no.setSelectedItem(rs.getString(2));
                Room_no.setSelectedItem(rs.getString(3));
                smoke_level.setText(rs.getString(4) + "");
                status.setText(rs.getString(5));
                
                
                int smokeLevels = Integer.parseInt(smoke_level.getText());
                
                if(smokeLevels>=5){
           
                    //When the smoke level is greater than or equal to 5, then the status textfield should appear in red colour
                    
                    status.setBackground(Color.red);
                                                      
                }
                
                else{
                    
                    //When the smoke level is less than 5, then the status textfield should appear in green colour
                    
                    status.setBackground(Color.GREEN);
                    
                }

            }
                     
            rs.close();
            s.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_alarmTableMouseClicked

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
            java.util.logging.Logger.getLogger(FireAlarmSensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FireAlarmSensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FireAlarmSensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FireAlarmSensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FireAlarmSensor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Floor_no;
    private javax.swing.JComboBox<String> Room_no;
    private javax.swing.JButton add;
    private javax.swing.JTable alarmTable;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField sensor_id;
    private javax.swing.JTextField smoke_level;
    private javax.swing.JTextField status;
    // End of variables declaration//GEN-END:variables

    private void resetData() {

        sensor_id.setText("");
//        floor_no.setText("");
//        room_no.setText("");
        smoke_level.setText("");
        status.setText("");
        
    }

    private void setalarmTable() {

        try {

            int rows = 0;
            int rowIndex = 0;

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from sensors order by id desc");

            if (rs.next()) {

                rs.last();
                rows = rs.getRow();
                rs.beforeFirst();
            }

            String[][] data = new String[rows][5];

            while (rs.next()) {

                data[rowIndex][0] = rs.getInt(1) + "";
                data[rowIndex][1] = rs.getInt(2) + "";
                data[rowIndex][2] = rs.getString(3);
                data[rowIndex][3] = rs.getInt(4) + "";
                data[rowIndex][4] = rs.getString(5);

                rowIndex++;

            }

            String[] cols = {"ID", "Floor No", "Room No", "Smoke Level", "Status"};
            DefaultTableModel model = new DefaultTableModel(data, cols);
            alarmTable.setModel(model);

            
            rs.close();
            s.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, "Can't Retrieve Data!");

        }

    }
    

}
