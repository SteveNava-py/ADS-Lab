package Centipede;

import javax.swing.*;

public class CentipedeGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("The Centipede of Chaos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new GamePanel());
        frame.setVisible(true);
    }
}
