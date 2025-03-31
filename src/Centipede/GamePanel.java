package Centipede;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
    private Centipede centipede;
    private LinkedList<Point> bullets = new LinkedList<>();
    private int playerX = 400;
    private int level = 1;
    private boolean easyMode = true;
    private boolean running = true;
    private int pWidth = 50;
    private int pHeight = 35;

    private Timer timer = new Timer(200, this);

    public GamePanel() {
        setBackground(Color.BLACK);
        centipede = new Centipede(0, 100, 20);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Draw centipede
        Segment current = centipede.head;
        g.setColor(Color.GREEN);
        while (current != null) {
            g.fillOval(current.x, current.y, 15, 15);
            current = current.next;
        }

        //draw player
        g.setColor(Color.BLUE);
        g.fillRect(playerX, 550, pWidth, pHeight);

        //draw bullets
        g.setColor(Color.RED);
        for(Point b:bullets){
            g.fillRect(b.x, b.y, 5, 10);
        }
                //"GAME OVER"
                Font gamefont = new Font("Arial", Font.BOLD, 30);
                g.setFont(gamefont);

                if (!running) {
                    g.setColor(Color.RED);
                    g.drawString("GAME OVER", getWidth() / 2 - (25*5), getHeight() / 2);
                }
            }

            private void checkCollisions () {
                LinkedList<Point> toRemove = new LinkedList<>();

                for (Point bullet : bullets) {
                    Segment current = centipede.head;
                    while (current != null) {
                        double dist = bullet.distance(current.x + 10, current.y + 10);

                        if (dist < 15) {
                            if (current == centipede.head) {
                                level++;
                                centipede = new Centipede(0, 100, 10 * level);
                            } else {
                                if (easyMode) {
                                    centipede.split(current);
                                } else {
                                    //hard mode
                                }
                            }
                            toRemove.add(bullet);
                            break;
                        }
                        current = current.next;
                    }
                }
                bullets.removeAll(toRemove);
            }
            private void checkShipCollision () {
                Rectangle shipRect = new Rectangle(playerX, 550, 50, 35);

                //check segment of each snake
                Segment current = centipede.head;
                while (current != null) {
                    Rectangle segmentRect = new Rectangle(current.x, current.y, 15, 15);
                    if (shipRect.intersects(segmentRect)){
                        running = false;
                        timer.stop();
                        return;
                    }
                    current = current.next;
                }
            }

            @Override
            public void actionPerformed (ActionEvent e){
                centipede.move();
                centipede.CheckAndTurn(getWidth(), getHeight());

                //bullet speed
                for (Point b : bullets) {
                    b.y -= 15;

                }

                checkCollisions();
                checkShipCollision();
                repaint();

            }

            @Override
            public void keyTyped (KeyEvent e){

            }

            @Override
            public void keyPressed (KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    playerX = Math.max(0, playerX - 50);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    playerX = Math.min(getWidth() - pWidth, playerX + 50);
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    bullets.add(new Point(playerX + 20, 540));
                }

            }

            @Override
            public void keyReleased (KeyEvent e){

            }
    }
