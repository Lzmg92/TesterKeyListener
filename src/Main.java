/**
 * Created by Leslie on 26/03/14.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;

public class Main extends JPanel implements ActionListener, KeyListener {

    private Timer timer;
    int xa = 0;
    int x = 30;

    public void actionPerformed(ActionEvent e){
        if (x + xa> 310 || x + xa < 30){
            xa = 0;
        }
        x = x + xa;
        repaint();
    }

    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            xa = 70;
        }
        if (key == KeyEvent.VK_LEFT) {
            xa = -70;
    }}
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            xa = 0;
        }
        if (key == KeyEvent.VK_LEFT) {
            xa = 0;
        }}

     public Main() {
        setBackground(Color.green);
        addKeyListener(this);
        setFocusable(true);
        timer = new Timer(100, this);
        timer.start();
    }


    public void paint( Graphics g ){     // lo primero q hic fue crear lo grafico.. cree un cuadro con posicion en y fija (360) y x variable
        Graphics2D g2d = ( Graphics2D ) g;
        super.paint(g);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.black);
        g2d.fillRect(x, 360, 40, 60);
    }

    public static void main(String args[]) {
        JFrame jframe=new JFrame();
        jframe.setSize(400, 480);
        jframe.setLocationRelativeTo(null);
        Main game = new Main();
        jframe.setResizable(false);
        jframe.add(game);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
