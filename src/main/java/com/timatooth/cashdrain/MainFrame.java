package com.timatooth.cashdrain;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFileChooser;
import javax.swing.JViewport;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
//</editor-fold>

/**
 * Main window class.
 * @author Tim Sullivan <tsullivan@timatooth.com>
 */
public class MainFrame extends javax.swing.JFrame {

    private TableRowSorter tblSorter;
    private DefaultTableModel dataModel;

    public MainFrame() {
        initComponents();
        setupTable();
        setupDnd();
    }

    //Da da da dunt. Can't touch this.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFilePath = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();
        lblCashdrain = new javax.swing.JLabel();
        txtInclude = new javax.swing.JTextField();
        scrollTablePane = new javax.swing.JScrollPane();
        tblBankData = new javax.swing.JTable();
        lblInclude = new javax.swing.JLabel();
        tabPane = new javax.swing.JTabbedPane();
        statPanel = new javax.swing.JPanel();
        lblBank = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        lblBalance = new javax.swing.JLabel();
        lblBalanceValue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cashdrain");

        lblFilePath.setText("Choose a bank CSV file");

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        lblCashdrain.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        lblCashdrain.setText("Cashdrain");

        txtInclude.setEnabled(false);
        txtInclude.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIncludeKeyReleased(evt);
            }
        });

        tblBankData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Drag CSV here", "", null, null, null}
            },
            new String [] {
                "Type", "Description", "Reference", "Amount", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBankData.setDragEnabled(true);
        tblBankData.setDropMode(javax.swing.DropMode.ON_OR_INSERT);
        scrollTablePane.setViewportView(tblBankData);

        lblInclude.setText("Filter:");

        lblBank.setText("Bank");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ANZ", "ASB", "BNZ", "Westpac" }));

        lblBalance.setText("Balance");

        lblBalanceValue.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblBalanceValue.setText("0.00");

        javax.swing.GroupLayout statPanelLayout = new javax.swing.GroupLayout(statPanel);
        statPanel.setLayout(statPanelLayout);
        statPanelLayout.setHorizontalGroup(
            statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statPanelLayout.createSequentialGroup()
                        .addComponent(lblBank)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(statPanelLayout.createSequentialGroup()
                        .addComponent(lblBalance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBalanceValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );
        statPanelLayout.setVerticalGroup(
            statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBank)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBalance)
                    .addComponent(lblBalanceValue))
                .addContainerGap(296, Short.MAX_VALUE))
        );

        tabPane.addTab("Inspector", statPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCashdrain, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBrowse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblInclude)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtInclude, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollTablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCashdrain)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBrowse)
                            .addComponent(lblFilePath))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInclude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInclude))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(tabPane))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollTablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV", "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            lblFilePath.setText(chooser.getSelectedFile().getName());
            loadFile(chooser.getSelectedFile());

        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void txtIncludeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIncludeKeyReleased
        try {
            tblSorter.setRowFilter(RowFilter.regexFilter("(?i).*" + txtInclude.getText() + ".*"));
            if (!txtInclude.getText().isEmpty()) {
                lblInclude.setForeground(Color.blue);
            } else {
                lblInclude.setForeground(Color.black);
            }
            /* Update the balance label */
            calculateBalance();
        } catch (PatternSyntaxException pse) {
            lblInclude.setForeground(Color.red);
        }
    }//GEN-LAST:event_txtIncludeKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         *
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                //System.out.println("Look and feel installed: " + info.getClassName());
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        */

        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    /**
     * Calculates the balance of a given visible table result set. Sets the
     * lblBalanceValue text.
     */
    private double calculateBalance() {
        double sum = 0;
        DefaultTableModel model = (DefaultTableModel) tblBankData.getModel();

        for (int i = 0; i < tblBankData.getRowCount(); i++) {
            int dataIndex = tblBankData.convertRowIndexToModel(i);
            double val = (Double) model.getValueAt(dataIndex, 3);
            sum += val;
        }
        lblBalanceValue.setText(String.format("%.2f", sum));

        return sum;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblBalanceValue;
    private javax.swing.JLabel lblBank;
    private javax.swing.JLabel lblCashdrain;
    private javax.swing.JLabel lblFilePath;
    private javax.swing.JLabel lblInclude;
    private javax.swing.JScrollPane scrollTablePane;
    private javax.swing.JPanel statPanel;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JTable tblBankData;
    private javax.swing.JTextField txtInclude;
    // End of variables declaration//GEN-END:variables

    /**
     * Attach to drop events when a CSV file is dropped.
     */
    private void setupDnd() {
        tblBankData.setDropTarget(new DropTarget() {
            @Override
            public synchronized void drop(DropTargetDropEvent dtde) {
                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                Transferable t = dtde.getTransferable();
                List<File> fileList = new ArrayList<>();
                try {
                    fileList = (List) t.getTransferData(DataFlavor.javaFileListFlavor);
                } catch (UnsupportedFlavorException | IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                File file = (File) fileList.get(0);
                FileFilter filter = new FileNameExtensionFilter("CSV", "csv");
                if(filter.accept(file)){
                    loadFile(file);
                }
            }
        });
    }
    
    /**
     * Override the NetBeans generated version for DnD.
     */
    private void setupTable() {
        dataModel = new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Drag CSV here", "", null, null, null}
            },
            new String [] {
                "Type", "Description", "Reference", "Amount", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.util.Date.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };

        /* Support DnD on empty JTable hack 
         https://www.java.net/node/651550
         */
        tblBankData = new javax.swing.JTable() {
            @Override
            public boolean getScrollableTracksViewportHeight() {
                if (getParent() instanceof JViewport) {
                    return (((JViewport) getParent()).getHeight() > getPreferredSize().height);
                }
                return false;
            }
        };

        tblBankData.setModel(dataModel);
        tblBankData.setDragEnabled(true);
        tblBankData.setDropMode(javax.swing.DropMode.ON_OR_INSERT);
        scrollTablePane.setViewportView(tblBankData);
    }

    private void loadFile(File selectedFile) {
        //empty the any data inside the table first
        dataModel.setRowCount(0);
        
        CSVParser parser = new CSVParser(selectedFile);
        //TODO: absract this in parser depending on bank.
        for (ArrayList<String> row : parser.getData()) {
            Date date = null;
             try {
                 date = new SimpleDateFormat("dd/M/yyyy", Locale.ENGLISH).parse(row.get(6));
             } catch (ParseException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                date = new Date();
            }
            Object[] data = new Object[]{
                row.get(0),
                row.get(1),
                row.get(4),
                Double.parseDouble(row.get(5)),
                date
            };
            
            dataModel.addRow(data);
        }
        lblFilePath.setText(selectedFile.getName());
        tblSorter = new TableRowSorter(tblBankData.getModel());
        tblBankData.setRowSorter(tblSorter);
        txtInclude.setEnabled(true);
        calculateBalance();
    }
}
