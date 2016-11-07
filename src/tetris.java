
import java.awt.Font;
import javax.swing.JFrame;

public class tetris {

    //ticking variables
    static final int TICK_MIN = 100;
    static final int TICK_INT = 20;
    static int tickCount = 0;
    static double difficultyFactor = 0.90;
    static int tickTime = 1000;

    //lose variable
    static boolean lose = false;

    //initalize the world
    static world w = new world();

    //create an object to represent the players current shape
    static shape playerShape = createShape();

    //setup the display
    static tetrisPanel tp;
    static JFrame frame = new JFrame("Tetris");

    public static void main(String[] args) {
        //initialize the display 
        initFrame();

        //calls the method responsible for running the game
        runGame();

        //what happens on lose goes here
    }

    static void runGame() {
        while (!lose) {
            try {
                Thread.sleep(tickTime);
            } catch (Exception e) {
                System.out.println("Sleep failed!");
            }

            tick();

            if (tickCount == TICK_INT) {
                tickCount = 0;
                minusTickTime();
            } else {
                tickCount++;
            }
        }
        lose();
    }

    static void tick() {
        if (!playerShape.fall()) {
            w.checkLines();
            if (w.lose()) {
                System.out.println("You lose!");
                playerShape = new loseShape();
                lose = true;
                return;
            }
            playerShape = createShape();
        }
        if (!lose) {
            tp.repaint();
        }
    }

    static void minusTickTime() {
        tickTime = (int) ((double) tickTime * difficultyFactor);
        if (tickTime < TICK_MIN) {
            tickTime = TICK_MIN;
        }
    }

    static void minusTickTime(int minus) {
        tickTime = tickTime - minus;
        if (tickTime < TICK_MIN) {
            tickTime = TICK_MIN;
        }
    }

    static void initFrame() {
        tp = new tetrisPanel(w);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().add(tp);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(w.dim * world.MAX_X + (frame.getInsets().left + frame.getInsets().right),
                w.dim * (world.MAX_Y - 3) + (frame.getInsets().top + frame.getInsets().bottom));
    }

    static shape createShape() {
        double r = Math.random();

        if (r < 0.1428) {
            return new squareShape();
        } else if (r < 0.2857) {
            return new L_Shape_Left();
        } else if (r < 0.4285) {
            return new L_Shape_Right();
        } else if (r < 0.5714) {
            return new plusShape();
        } else if (r < 0.7142) {
            return new zigShape();
        } else if (r < 0.8571) {
            return new zagShape();
        } else {
            return new longShape();
        }
    }

    static void lose() {
        Font f = new Font(Font.MONOSPACED, Font.BOLD, w.dim);
        tp.setFont(f);
        tp.getGraphics().drawString("YOU LOSE!", w.dim * 2, w.dim * 5);
    }
}
