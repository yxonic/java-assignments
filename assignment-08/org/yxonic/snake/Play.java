package org.yxonic.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

interface GameListener {
    void onUpdate(int score);
    void onDead();
}

class GameDraw extends JLabel {
    public static final int[] speedFactor = {10, 12, 15, 20};
    public static final int[] mapFactor = {0, 10, 10, 15, 20};
    public static final int GRID_SIZE = 20;
    private Snake snake;
    private SnakeTimer timer;
    private Queue<Integer> instructions = new LinkedList<Integer>(); 
    private GameListener gameListener;
    private int speed, map;
 
    public GameDraw(GameListener gl) {
        this(SnakeTimer.NORMAL, 0, gl);
    }

    public GameDraw(int speed, int map, GameListener gl) {
        this.clear();
        setSpeed(speed);
        setMap(map);
        gameListener = gl;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
        snake.setFactor(speedFactor[speed] + mapFactor[map]);
        timer = new SnakeTimer(speed, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Integer x = instructions.poll();
                    if (x != null)
                        snake.changeDirection(x);
                    if (!snake.move()) die();
                    else {
                        repaint();
                        gameListener.onUpdate(snake.score());
                    }
                }
            });
    }

    public void setMap(int map) {
        this.map = map;
    }

    public void changeDirection(int d) {
        if (isRunning())
            instructions.add(d);
    }

    public void clear() {
        snake = new Snake(speedFactor[speed]);
    }
    
    public void addMap(int[] map) {
        snake.addMap(map);
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void die() {
        stop();
        gameListener.onDead();
    }

    public boolean isRunning() {
        return timer.isRunning();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        Rectangle2D rect = new Rectangle2D.Double(0, 0, 800, 600);
        g2.setPaint(Color.white);
        g2.fill(rect);

        int[] state = snake.getState();
        for (int i = 0; i < snake.HEIGHT; i++)
            for (int j = 0; j < snake.WIDTH; j++) {
                int pos = i * snake.WIDTH + j;
                int x = state[pos];
                if (x == 1) {
                    int s = GRID_SIZE;
                    Rectangle2D r = 
                        new Rectangle2D.Double(j * s, i * s, s, s);
                    g2.setPaint(Color.black);
                    g2.fill(r);
                } else if (x > 1 && x < 5) {
                    int s = GRID_SIZE;
                    Rectangle2D r = 
                        new Rectangle2D.Double(j * s, i * s, s, s);
                    g2.setPaint(Color.gray);
                    g2.fill(r);
                } else if (x == 5) {
                    int s = GRID_SIZE;
                    Ellipse2D e =
                        new Ellipse2D.Double(j * s, i * s, s, s);
                    g2.setPaint(Color.red);
                    g2.fill(e);
                }
            }
    }
}

public class Play extends JFrame {
    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 675;
    static String easy = new String("Easy");
    static String normal = new String("Normal");
    static String hard = new String("Hard");
    static String insane = new String("Insane");
    private int score;
    private int speed = SnakeTimer.NORMAL;
    private int[] currentMap = Maps.NONE;
    private final GameDraw content = new GameDraw(new SnakeListener());
    private final JButton start = new JButton("Start");        
    private final JButton reset = new JButton("Reset");
    private final JLabel scoreLabel = new JLabel("  You've scored: 0 pts.");
    private class SnakeListener implements GameListener {
        public void onUpdate(int s) {
            score = s;
            setTitle("YSnake  Score: " + score + " pts.");
            scoreLabel.setText("  You've scored: " + score + " pts.");
        }
        public void onDead() {
            String message = "Final score: " + score + " pts.";
            JOptionPane.showMessageDialog(Play.this, "You're dead!", message,
                                          JOptionPane.PLAIN_MESSAGE);
            gameReset();
        }
    }
    public Play() {
        setTitle("YSnake");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setResizable(false);
        setLocationByPlatform(true);

        final JPanel panel = new JPanel();

        start.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (content.isRunning()) {
                        start.setText("Start");
                        content.stop();
                    } else {
                        start.setText("Pause");
                        content.setSpeed(speed);
                        content.start();
                    }
                }
            });
        setFocusable(true);
        start.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                    case KeyEvent.VK_W: case KeyEvent.VK_UP:
                        content.changeDirection(0);
                        break;
                    case KeyEvent.VK_A: case KeyEvent.VK_LEFT:
                        content.changeDirection(3);
                        break;
                    case KeyEvent.VK_S: case KeyEvent.VK_DOWN:
                        content.changeDirection(2);
                        break;
                    case KeyEvent.VK_D: case KeyEvent.VK_RIGHT:
                        content.changeDirection(1);
                        break;
                    }
                }
            });
        reset.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    gameReset();
                }
            });

        JRadioButton easyButton = new JRadioButton(easy);
        easyButton.setMnemonic(KeyEvent.VK_E);
        easyButton.setActionCommand(easy);

        JRadioButton normalButton = new JRadioButton(normal);
        normalButton.setMnemonic(KeyEvent.VK_N);
        normalButton.setActionCommand(normal);
        normalButton.setSelected(true);
        
        JRadioButton hardButton = new JRadioButton(hard);
        hardButton.setMnemonic(KeyEvent.VK_H);
        hardButton.setActionCommand(hard);

        JRadioButton insaneButton = new JRadioButton(insane);
        insaneButton.setMnemonic(KeyEvent.VK_I);
        insaneButton.setActionCommand(insane);
        
        RadioListener myListener = new RadioListener();
        easyButton.addActionListener(myListener);
        normalButton.addActionListener(myListener);
        hardButton.addActionListener(myListener);
        insaneButton.addActionListener(myListener);

        ButtonGroup group = new ButtonGroup();
        group.add(easyButton);
        group.add(normalButton);
        group.add(hardButton);
        group.add(insaneButton);

        JPanel radioPanel = new JPanel(new GridLayout(1, 0));
        radioPanel.add(easyButton);
        radioPanel.add(normalButton);
        radioPanel.add(hardButton);
        radioPanel.add(insaneButton);

        String[] maps = {"None", "Box", "Lines", "Hall", "Rooms"};
        JComboBox mapList = new JComboBox(maps);
        mapList.addActionListener(new ComboListener());
            
        panel.add(mapList);
        panel.add(radioPanel);
        panel.add(start);
        panel.add(reset);
        panel.add(scoreLabel);

        add(panel, BorderLayout.SOUTH);
        add(content);
        gameReset();
    }

    class RadioListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
             if (e.getActionCommand() == easy) {
                 speed = SnakeTimer.EASY;
             } else if (e.getActionCommand() == normal) {
                 speed = SnakeTimer.NORMAL;
             } else if (e.getActionCommand() == hard) {
                 speed = SnakeTimer.HARD;
             } else {
                 speed = SnakeTimer.INSANE;
             }
        }
    }
    
    class ComboListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String map = (String)cb.getSelectedItem();
            changeMap(map);
        }
    }

    public void changeMap(String map) {
        if (map.equals("None")) {
            currentMap = Maps.NONE;
            content.setMap(0);
            gameReset();
        } else if (map.equals("Box")) {
            currentMap = Maps.BOX;
            content.setMap(1);
            gameReset();
        } else if (map.equals("Lines")) {
            currentMap = Maps.LINES;
            content.setMap(2);
            gameReset();

        } else if (map.equals("Hall")) {
            currentMap = Maps.HALL;
            content.setMap(3);
            gameReset();
        } else {
            currentMap = Maps.ROOMS;
            content.setMap(4);
            gameReset();
        }
    }

    public void gameReset() {
        start.setText("Start");
        content.stop();
        content.clear();
        content.addMap(currentMap);
        content.repaint();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable()
            {
                public void run() {
                    Play game = new Play();
                    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    game.setVisible(true);
                }
            });
    }
}
