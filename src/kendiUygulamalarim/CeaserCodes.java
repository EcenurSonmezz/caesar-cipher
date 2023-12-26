package kendiUygulamalarim;

import javax.swing.*;
import java.awt.event.*;

public class CeaserCodes {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Metin �ifreleme Uygulamas�");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel metinLabel = new JLabel("Metni Girin:");
        metinLabel.setBounds(10, 20, 80, 25);
        panel.add(metinLabel);

        JTextField metinField = new JTextField(20);
        metinField.setBounds(100, 20, 250, 25);
        panel.add(metinField);

        JLabel sifreliMetinLabel = new JLabel("�ifreli Metin:");
        sifreliMetinLabel.setBounds(10, 50, 80, 25);
        panel.add(sifreliMetinLabel);

        JTextField sifreliMetinField = new JTextField(20);
        sifreliMetinField.setBounds(100, 50, 250, 25);
        panel.add(sifreliMetinField);

        JButton sifreleButton = new JButton("�ifrele");
        sifreleButton.setBounds(100, 80, 80, 25);
        panel.add(sifreleButton);

        JButton cozButton = new JButton("�ifreyi ��z");
        cozButton.setBounds(200, 80, 120, 25);
        panel.add(cozButton);

        JLabel cozulmusMetinLabel = new JLabel("��z�len Metin:");
        cozulmusMetinLabel.setBounds(10, 110, 100, 25);
        panel.add(cozulmusMetinLabel);

        JTextField cozulmusMetinField = new JTextField(20);
        cozulmusMetinField.setBounds(120, 110, 230, 25);
        panel.add(cozulmusMetinField);

        sifreleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String metin = metinField.getText();
                String sifreliMetin = serzarSifrele(metin);
                sifreliMetinField.setText(sifreliMetin);
            }
        });

        cozButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sifreliMetin = sifreliMetinField.getText();
                String cozulmusMetin = serzarCoz(sifreliMetin);
                cozulmusMetinField.setText(cozulmusMetin);
            }
        });
    }

    private static String serzarSifrele(String metin) {
        // Serzar �ifreleme i�lemini ger�ekle�tir
        // Bu k�s�mda �ifreleme algoritmas�n� uygula
        // �rnek olarak, her harfi bir sonraki harfle de�i�tirebilirsin
        StringBuilder sifreliMetin = new StringBuilder();

        for (int i = 0; i < metin.length(); i++) {
            char karakter = metin.charAt(i);

            // �rnek �ifreleme: Her harfi bir sonraki harfe d�n��t�rme
            if (Character.isLetter(karakter)) {
                if (Character.isLowerCase(karakter)) {
                    karakter = (char) ('a' + (karakter - 'a' + 1) % 26);
                } else if (Character.isUpperCase(karakter)) {
                    karakter = (char) ('A' + (karakter - 'A' + 1) % 26);
                }
            }
            sifreliMetin.append(karakter);
        }

        return sifreliMetin.toString();
    }

    private static String serzarCoz(String sifreliMetin) {
        // Serzar �ifresini ��zme i�lemini ger�ekle�tir
        // �ifreleme algoritmas�n�n tersini uygula
        // �rne�in, her harfi bir �nceki harfe d�n��t�rebilirsin
        StringBuilder cozulmusMetin = new StringBuilder();

        for (int i = 0; i < sifreliMetin.length(); i++) {
            char karakter = sifreliMetin.charAt(i);

            // �rnek �ifre ��zme: Her harfi bir �nceki harfe d�n��t�rme
            if (Character.isLetter(karakter)) {
                if (Character.isLowerCase(karakter)) {
                    karakter = (char) ('a' + (karakter - 'a' - 1 + 26) % 26);
                } else if (Character.isUpperCase(karakter)) {
                    karakter = (char) ('A' + (karakter - 'A' - 1 + 26) % 26);
                }
            }
            cozulmusMetin.append(karakter);
        }

        return cozulmusMetin.toString();
    }
}
