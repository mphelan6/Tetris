
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class tetrisPanel extends JPanel implements KeyListener {

    private world w;

    public tetrisPanel(world newWorld) {
        super();
        w = newWorld;

        this.addKeyListener(this);

        setLayout(null);
        setSize(w.dim * world.MAX_X + (tetris.frame.getInsets().left + tetris.frame.getInsets().right),
                w.dim * world.MAX_Y + (tetris.frame.getInsets().top + tetris.frame.getInsets().bottom));

        setLocation(0, (w.dim * -3));

        setFocusable(true);
        setVisible(true);
        repaint();
        requestFocus();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        w.draw(g);
        setSize(w.dim * world.MAX_X + (tetris.frame.getInsets().left + tetris.frame.getInsets().right),
                w.dim * world.MAX_Y + (tetris.frame.getInsets().top + tetris.frame.getInsets().bottom));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //no implementation
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            tetris.playerShape.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            tetris.playerShape.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            tetris.playerShape.fall();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            tetris.playerShape.rotate();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            tetris.playerShape.speed();
        } else {
            System.out.println("Wrong key!");
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //no implementation
    }
}
