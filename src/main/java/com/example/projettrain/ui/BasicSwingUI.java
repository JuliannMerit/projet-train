package com.example.projettrain.ui;

import com.example.projettrain.entities.Gares;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

/**
 * UI desktop minimale (Swing) pour démonstration.

 * Objectif: fournir une "petite interface graphique très basique" qui lance une fenêtre,
 * affiche une liste de gares, et un bouton.

 * Note: ce code ne démarre pas Spring Boot. Il s'exécute séparément.
 */
public final class BasicSwingUI {

    private BasicSwingUI() {
    }

    public static void main(String[] args) {
        // Swing doit être initialisé sur l'EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(BasicSwingUI::createAndShow);
    }

    private static void createAndShow() {
        JFrame frame = new JFrame("Projet Train - UI basique");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(12, 12));

        JLabel title = new JLabel("UI basique (Swing) - Exemple");
        frame.add(title, BorderLayout.NORTH);

        // Exemple de données (mock) : vous pourrez le remplacer par un appel à la BDD plus tard.
        List<Gares> gares = List.of(
                new Gares(1L, "Gare du Nord", "Paris", 36),
                new Gares(2L, "Lyon Part-Dieu", "Lyon", 16),
                new Gares(3L, "Gare Saint-Charles", "Marseille", 15)
        );

        JList<Gares> list = new JList<>(gares.toArray(Gares[]::new));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setVisibleRowCount(8);

        // Par défaut, JList affiche toString(). On ajoute un rendu simple via toString() ci-dessous.
        frame.add(new JScrollPane(list), BorderLayout.CENTER);

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btn = new JButton("Afficher sélection");
        JLabel status = new JLabel(" ");

        btn.addActionListener(e -> {
            Gares selected = list.getSelectedValue();
            if (selected == null) {
                status.setText("Aucune gare sélectionnée");
            } else {
                status.setText("Sélection : " + selected.nomGare + " (" + selected.ville + ")");
            }
        });

        actions.add(status);
        actions.add(btn);
        frame.add(actions, BorderLayout.SOUTH);

        frame.setPreferredSize(new Dimension(520, 320));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
