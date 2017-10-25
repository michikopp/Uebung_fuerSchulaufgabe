package com.sabel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Fenster extends JFrame{

    private JRadioButton[] jRadioButtons;
    private JLabel jLabel;
    private JPanel jPanelEast,jPanelWest, jPanelNorth, jPanelSouth;
    private JButton jButtonBildModus, jButtonZufallsfarbeModus, jButtonvorherBild, jButtonnaechstesBild;
    private JScrollPane jScrollPane;
    private ButtonGroup buttonGroup;
    private JComboBox jComboBox;
    private String[] liste = {"Bild1", "Bild2", "Bild3", "Bild4"};

    public Fenster(){
        super("Uebung");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        //this.setSize(400, 400);
        this.initEvents();
        this.initialComponents();
        this.pack();
        this.setVisible(true);
    }

    private void initialComponents() {
        //Buttons auf der Linken Seite
        jPanelWest = new JPanel();
        jPanelWest.setLayout(new BoxLayout(jPanelWest, BoxLayout.Y_AXIS));
        jRadioButtons = new JRadioButton[4];
        buttonGroup = new ButtonGroup();
        for (int i = 0; i < jRadioButtons.length; i++) {
            jRadioButtons[i] = new JRadioButton("Bild" + i);
            buttonGroup.add(jRadioButtons[i]);
            jPanelWest.add(jRadioButtons[i]);
        }
        jRadioButtons[0].setSelected(true);

        //Auswahlknöpfe rechts
        jPanelEast = new JPanel();
        jPanelEast.setLayout(new BoxLayout(jPanelEast, BoxLayout.Y_AXIS));
        jButtonBildModus = new JButton("Bilder");
        jButtonZufallsfarbeModus = new JButton("ZuFarbe");
        jPanelEast.add(jButtonBildModus);
        jPanelEast.add(jButtonZufallsfarbeModus);

        //Auswahl unten
        jPanelSouth = new JPanel();
        jButtonnaechstesBild = new JButton("Naechstes Bild");
        jButtonvorherBild = new JButton("Vorheriges Bild");
        jPanelSouth.add(jButtonnaechstesBild);
        jPanelSouth.add(jButtonvorherBild);


        //JComobBox
        jPanelNorth = new JPanel();
        jComboBox = new JComboBox(liste);
        jComboBox.setSelectedIndex(0);
        jPanelNorth.add(jComboBox);

        //ScrollPane
        jLabel = new JLabel();
        jScrollPane = new JScrollPane(jLabel);



        //Panel hinzugefügt
        this.add(jScrollPane, BorderLayout.CENTER);
        this.add(jPanelNorth, BorderLayout.NORTH);
        this.add(jPanelWest, BorderLayout.WEST);
        this.add(jPanelSouth, BorderLayout.SOUTH);
        this.add(jPanelEast, BorderLayout.EAST);

    }

    private void initEvents() {

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Wollen Sie das Fenster wirklich schließen", "Bestaetigungsfenster",JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){
                    System.exit(NORMAL);
                }
            }
        });

        /**
         * Anforderung: Bei den RadioButtons und bei nächste und vorheriges Bild sollen die Bilder durchgewächselt werden
         * Dies gilt auch für das Dropdown-Menü
         *
         * Wird jedoch auf der Rechten Seite ZuFarbe ausgewählt, soll jedes mal anstelle eines Bildes im JScrollPane
         * Die Farbe zufällig geändert werden.
         */

    }


}
