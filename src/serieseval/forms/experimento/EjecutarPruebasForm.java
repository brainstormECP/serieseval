/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serieseval.forms.experimento;

import serieseval.forms.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.SpinnerUI;
import serieseval.ProcessArff;
import serieseval.controller.ArffController;
import serieseval.model.Datasource;
import serieseval.model.Experimentgroup;
import weka.classifiers.trees.DecisionStump;

/**
 *
 * @author Laura
 */
public class EjecutarPruebasForm extends javax.swing.JPanel {

    Experimentgroup experiment;

    /**
     * Creates new form CargarAffForm
     */
    public EjecutarPruebasForm(Experimentgroup experiment) {
        this.experiment = experiment;
        initComponents();
        //pathTextbox.setText("C:\\experimentos\\" + experiment.getDescription() + "\\" + datasourse.getName());
        fromSpinner.setValue(2);
        toSpinner.setValue(3);
        CrossValidationParamSpinner.setValue(10);
        PercentageSplitParamSpinner.setValue(60);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        testOptionsBtnGroup = new javax.swing.ButtonGroup();
        seriesevalPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("seriesevalPU").createEntityManager();
        algorithmQuery = java.beans.Beans.isDesignTime() ? null : seriesevalPUEntityManager.createQuery("SELECT a FROM Algorithm a");
        algorithmList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : algorithmQuery.getResultList();
        proccessButton = new javax.swing.JButton();
        toSpinner = new javax.swing.JSpinner();
        fromSpinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        algorithmListBox = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        testRadioBtn = new javax.swing.JRadioButton();
        crossvalidationRadioBtn = new javax.swing.JRadioButton();
        browserTestBtn = new javax.swing.JButton();
        pathTestTextbox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PercentageSplitRadioBtn = new javax.swing.JRadioButton();
        CrossValidationParamSpinner = new javax.swing.JSpinner();
        PercentageSplitParamSpinner = new javax.swing.JSpinner();
        cancelarBtn = new javax.swing.JButton();
        browserButton1 = new javax.swing.JButton();
        pathTextbox = new javax.swing.JTextField();

        proccessButton.setText("Procesar");
        proccessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proccessButtonActionPerformed(evt);
            }
        });

        fromSpinner.setName(""); // NOI18N

        jLabel2.setText("Hasta");

        jLabel1.setText("Desde");

        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, algorithmList, algorithmListBox);
        bindingGroup.addBinding(jListBinding);

        jScrollPane1.setViewportView(algorithmListBox);

        jLabel3.setText("Algoritmos a usar");

        testOptionsBtnGroup.add(testRadioBtn);
        testRadioBtn.setText("Test");
        testRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testRadioBtnActionPerformed(evt);
            }
        });

        testOptionsBtnGroup.add(crossvalidationRadioBtn);
        crossvalidationRadioBtn.setText("Cross Validation");
        crossvalidationRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crossvalidationRadioBtnActionPerformed(evt);
            }
        });

        browserTestBtn.setText("...");
        browserTestBtn.setEnabled(false);
        browserTestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browserTestBtnActionPerformed(evt);
            }
        });

        pathTestTextbox.setEnabled(false);

        jLabel4.setText("Metodos de prueba");

        testOptionsBtnGroup.add(PercentageSplitRadioBtn);
        PercentageSplitRadioBtn.setSelected(true);
        PercentageSplitRadioBtn.setText("Percentage Split");
        PercentageSplitRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PercentageSplitRadioBtnActionPerformed(evt);
            }
        });

        CrossValidationParamSpinner.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(testRadioBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(browserTestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pathTestTextbox, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PercentageSplitRadioBtn)
                                    .addComponent(crossvalidationRadioBtn))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CrossValidationParamSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PercentageSplitParamSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 286, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(testRadioBtn)
                    .addComponent(browserTestBtn)
                    .addComponent(pathTestTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crossvalidationRadioBtn)
                    .addComponent(CrossValidationParamSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PercentageSplitRadioBtn)
                    .addComponent(PercentageSplitParamSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        browserButton1.setText("...");
        browserButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browserButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fromSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(toSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(cancelarBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(proccessButton)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pathTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(browserButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browserButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(proccessButton)
                        .addComponent(cancelarBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void proccessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proccessButtonActionPerformed
        // TODO add your handling code here:
        if (!pathTextbox.getText().equals("")) {
            ArffController c = new ArffController();
            if (testRadioBtn.isSelected()) {
                c.ExecuteExperiment(algorithmListBox.getSelectedValuesList(), pathTextbox.getText(), (Integer) fromSpinner.getValue(), (Integer) toSpinner.getValue(), pathTestTextbox.getText(), experiment);
            }
            if (crossvalidationRadioBtn.isSelected()) {
                c.ExecuteExperiment(algorithmListBox.getSelectedValuesList(), pathTextbox.getText(), (Integer) fromSpinner.getValue(), (Integer) toSpinner.getValue(), (Integer) CrossValidationParamSpinner.getValue(), "CrossValidation", experiment);
            }
            if (PercentageSplitRadioBtn.isSelected()) {
                c.ExecuteExperiment(algorithmListBox.getSelectedValuesList(), pathTextbox.getText(), (Integer) fromSpinner.getValue(), (Integer) toSpinner.getValue(), (Integer) PercentageSplitParamSpinner.getValue(), "PercentageSplit", experiment);
            }
            EditarExperiment u = new EditarExperiment(experiment);
            u.setVisible(true);

            Container container = this.getParent();
            container.removeAll();
            container.setLayout(new BorderLayout());
            container.add(u);
            container.setSize(300, 300);
            container.revalidate();
            container.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un fichero ARFF de series temporales.");
        }
    }//GEN-LAST:event_proccessButtonActionPerformed

    private void browserTestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browserTestBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Ficheros ARFF", "arff"));
        int returnVal = fc.showOpenDialog(EjecutarPruebasForm.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            this.pathTestTextbox.setText(file.getPath());
        } else {

        }
    }//GEN-LAST:event_browserTestBtnActionPerformed

    private void testRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testRadioBtnActionPerformed
        // TODO add your handling code here:
        if (testRadioBtn.isSelected()) {
            browserTestBtn.setEnabled(true);
            pathTestTextbox.setEnabled(true);
            CrossValidationParamSpinner.setEnabled(false);
            PercentageSplitParamSpinner.setEnabled(false);
        } else {
            browserTestBtn.setEnabled(false);
            pathTestTextbox.setEnabled(false);
        }
        Container c = this.getParent();
        c.revalidate();
        c.repaint();
    }//GEN-LAST:event_testRadioBtnActionPerformed

    private void crossvalidationRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crossvalidationRadioBtnActionPerformed
        // TODO add your handling code here:
        if (crossvalidationRadioBtn.isSelected()) {
            browserTestBtn.setEnabled(false);
            pathTestTextbox.setEnabled(false);
            CrossValidationParamSpinner.setEnabled(true);
            PercentageSplitParamSpinner.setEnabled(false);
        } else {
            CrossValidationParamSpinner.setEnabled(false);
        }
        Container c = this.getParent();
        c.revalidate();
        c.repaint();
    }//GEN-LAST:event_crossvalidationRadioBtnActionPerformed

    private void PercentageSplitRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PercentageSplitRadioBtnActionPerformed
        // TODO add your handling code here:
        if (PercentageSplitRadioBtn.isSelected()) {
            PercentageSplitParamSpinner.setEnabled(true);
            browserTestBtn.setEnabled(false);
            pathTestTextbox.setEnabled(false);
            CrossValidationParamSpinner.setEnabled(false);
        } else {
            PercentageSplitParamSpinner.setEnabled(false);
        }
        Container c = this.getParent();
        c.revalidate();
        c.repaint();
    }//GEN-LAST:event_PercentageSplitRadioBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        // TODO add your handling code here:
        EditarExperiment u = new EditarExperiment(experiment);
        u.setVisible(true);

        Container c = this.getParent();
        c.removeAll();
        c.setLayout(new BorderLayout());
        c.add(u);
        c.setSize(300, 300);
        c.revalidate();
        c.repaint();
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void browserButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browserButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Ficheros ARFF", "arff"));
        int returnVal = fc.showOpenDialog(EjecutarPruebasForm.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            this.pathTextbox.setText(file.getPath());
            try {
                FileReader t = new FileReader(file);
                BufferedReader reader = new BufferedReader(t);
                String line = reader.readLine();
                if (line != null) {
                    String[] ent = line.split(" ");
                    if (!ent[1].equals("timeserie")) {
                        throw new Exception("El fichero no es una serie temporal");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_browserButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner CrossValidationParamSpinner;
    private javax.swing.JSpinner PercentageSplitParamSpinner;
    private javax.swing.JRadioButton PercentageSplitRadioBtn;
    private java.util.List<serieseval.model.Algorithm> algorithmList;
    private javax.swing.JList algorithmListBox;
    private javax.persistence.Query algorithmQuery;
    private javax.swing.JButton browserButton1;
    private javax.swing.JButton browserTestBtn;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JRadioButton crossvalidationRadioBtn;
    private javax.swing.JSpinner fromSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField pathTestTextbox;
    public javax.swing.JTextField pathTextbox;
    private javax.swing.JButton proccessButton;
    private javax.persistence.EntityManager seriesevalPUEntityManager;
    private javax.swing.ButtonGroup testOptionsBtnGroup;
    private javax.swing.JRadioButton testRadioBtn;
    private javax.swing.JSpinner toSpinner;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}