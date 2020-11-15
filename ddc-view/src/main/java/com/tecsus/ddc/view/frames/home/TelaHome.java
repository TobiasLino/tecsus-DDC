/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsus.ddc.view.frames.home;

import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.repository.*;
import com.tecsus.ddc.controller.service.AbstractBillService;
import com.tecsus.ddc.controller.service.EnergyBillService;
import com.tecsus.ddc.controller.service.WaterBillService;
import com.tecsus.ddc.factory.*;
import com.tecsus.ddc.query.EnergyBillQueryFactory;
import com.tecsus.ddc.query.ProductQueryFactory;
import com.tecsus.ddc.query.TariffFlagQueryFactory;
import com.tecsus.ddc.query.WaterBillQueryFactory;
import com.tecsus.ddc.utils.AbstractBillQueryFactory;
import com.tecsus.ddc.view.frames.energy.Energia;
import com.tecsus.ddc.view.frames.water.Agua;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author Wallace
 */
public class TelaHome extends javax.swing.JFrame {

    /**
     * Creates new form TelaHome
     */
    private final ConnectionImpl connection;

    public static boolean waterFrameisNotOpened = true;

    public TelaHome(final Connector connector) {
        connection = connector.getConnection();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktop = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        jMenuItem2 = new JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopLayout = new javax.swing.GroupLayout(jDesktop);
        jDesktop.setLayout(jDesktopLayout);
        jDesktopLayout.setHorizontalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 973, Short.MAX_VALUE)
        );
        jDesktopLayout.setVerticalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Água");
        editMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuActionPerformed(evt);
            }
        });
        editMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editMenuKeyPressed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem1.setText("Água");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem1);

        menuBar.add(editMenu);

        // Energy
        editMenu.setText("Contas");
        editMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                energyBillActionPerformed(evt);
            }
        });
        editMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                energyMenuKeyPressed(evt);
            }
        });

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem2.setText("Energia");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem2);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void abrirAgua() {
        if (waterFrameisNotOpened) {
            final WaterBillFactory waterBillFactory = new WaterBillFactory();
            final WaterBillQueryFactory waterBillQueryFactory = new WaterBillQueryFactory();
            final WaterBillRepository waterBillRepository = new WaterBillRepository(connection, waterBillQueryFactory, waterBillFactory);
            final WaterBillService waterBillService = new WaterBillService(waterBillRepository);
            Agua waterScreen = new Agua(waterBillService);
            jDesktop.add(waterScreen);
            waterScreen.setVisible(true);
            waterFrameisNotOpened = false;
        }
    }

    private void openEnergyBillRegistryForm() {
        final BillFactory abstractBillFactory = new BillFactory();
        final EnergyBillFactory energyBillFactory = new EnergyBillFactory();
        final ProductFactory productFactory = new ProductFactory();
        final TariffFlagFactory tariffFlagFactory = new TariffFlagFactory();

        final AbstractBillQueryFactory abstractBillQueryFactory = new AbstractBillQueryFactory();
        final EnergyBillQueryFactory energyBillQueryFactory = new EnergyBillQueryFactory();
        final ProductQueryFactory productQueryFactory = new ProductQueryFactory();
        final TariffFlagQueryFactory tariffFlagQueryFactory = new TariffFlagQueryFactory();

        final BillRepository billRepository = new BillRepository(connection, abstractBillQueryFactory, abstractBillFactory);
        final ProductRepository productRepository = new ProductRepository(connection, productQueryFactory, productFactory);
        final EnergyBillRepository energyBillRepository = new EnergyBillRepository(connection, energyBillQueryFactory, energyBillFactory, abstractBillFactory);
        final TariffFlagRepository tariffFlagRepository = new TariffFlagRepository(connection, tariffFlagQueryFactory, tariffFlagFactory);

        final EnergyBillService energyBillService = new EnergyBillService(energyBillRepository, billRepository, productRepository, tariffFlagRepository);

        final Energia energyBillFrame = new Energia(energyBillService);
        jDesktop.add(energyBillFrame);
        energyBillFrame.setVisible(true);
    }
    
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void editMenuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editMenuKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_F5){
            abrirAgua();
        }
    }//GEN-LAST:event_editMenuKeyPressed

    private void editMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuActionPerformed
        abrirAgua();
    }//GEN-LAST:event_editMenuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        abrirAgua();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        openEnergyBillRegistryForm();
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    private void energyMenuKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            openEnergyBillRegistryForm();
        }
    }

    private void energyBillActionPerformed(ActionEvent e) {
        openEnergyBillRegistryForm();
    }

    public static void main(String[] args) {
        Connector connector = new Connector();

        java.awt.EventQueue.invokeLater(() -> new TelaHome(connector.connect()).setVisible(true));
    }

    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JDesktopPane jDesktop;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuBar menuBar;
}
