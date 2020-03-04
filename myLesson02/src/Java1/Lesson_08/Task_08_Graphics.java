package Java1.Lesson_08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;

public class Task_08_Graphics {

    private static final int SIZE = 3;
    private static final int winLength = 3;

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    public static final String EMPTY_COLUMN_TITLE = "  ";

    private static char[][] map;
    private static Random random = new Random();

    private static int buttonCount = SIZE * SIZE;


    static class MyWindow extends JFrame {


        JLabel label = new JLabel();
        JButton[] jbs = new JButton[buttonCount];

        public MyWindow() {
            setSize(800,500);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            setLayout(new BorderLayout());

            JPanel pan = new JPanel();
            add(pan, BorderLayout.PAGE_START);

            pan.add(label);
            //add(label,  BorderLayout.PAGE_START);
            label.setText("Ход пользователя");

            JPanel pan2 = new JPanel();
            add(pan2, BorderLayout.CENTER);
            pan2.setBackground(Color.CYAN);

            pan2.setLayout(new GridLayout(SIZE, SIZE));


            for (int i = 0; i < buttonCount; i++) {
                jbs[i] = createButton();
                //jbs[i].setEnabled(false);
                jbs[i].setActionCommand(String.valueOf(i));
                pan2.add(jbs[i]);
            }

            setVisible(true);
        }

        private JButton createButton() {
            return new JButton() {
                private boolean flag = false;
                private boolean isInit = true;
                private String btnName;
                private int btnID;
                private int row;
                private int col;


                //Constructor for anon class
                {
                    addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //flag = !flag;
                            isInit = false;
                            btnID =  Integer.parseInt(e.getActionCommand());
                        }
                    });

                }


                @Override
                public void paint(Graphics graphics) {
                    super.paint(graphics);
                    int  margin = 40;
                    int buttonNum;
                    int isEnd;
                    if (isInit)  return;

                    row = btnID / SIZE;
                    col = btnID % SIZE;

                    if (getText() == "O") {
                        draw_O(graphics, margin);
                        map[row][col] = DOT_O;
                        this.setEnabled(false);
                        isEnd = checkEnd(DOT_O);
                        if (isEnd != 0) {
                            if (isEnd == 1)  label.setText("Компьютер выиграл. Игра окончена");
                            if (isEnd == -1)  label.setText("Ничья. Игра окончена");
                            blockAllButton();
                        }
                    }
                    else {
                        draw_X((Graphics2D) graphics, margin);
                        if (map[row][col] != DOT_X) {
                            map[row][col] = DOT_X;
                            this.setEnabled(false);
                            isEnd = checkEnd(DOT_X);
                            if (isEnd != 0) {
                                if (isEnd == 1) label.setText("Пользователь выиграл. Игра окончена");
                                if (isEnd == -1)  label.setText("Ничья. Игра окончена");
                                blockAllButton();
                            } else {
                                buttonNum = ComputerTurn();
                                jbs[buttonNum].setText("O");
                                jbs[buttonNum].doClick();
                            }
                        }
                    }
                    //draw_X((Graphics2D) graphics, margin);


                }

                private void draw_X(Graphics2D graphics, int margin) {
                    Graphics2D g2d = graphics;
                    g2d.setStroke(new BasicStroke(10));
                    g2d.setColor(Color.BLUE);
                    g2d.drawLine(margin, margin, this.getWidth() - margin, this.getHeight() - margin);
                    g2d.drawLine(this.getWidth() - margin, margin, margin, this.getHeight() - margin);
                }

                private void draw_O(Graphics graphics, int margin) {
                    graphics.setColor(Color.RED);
                    graphics.fillOval(margin / 2, margin / 2, getWidth() - margin, getHeight() - margin);
                    graphics.setColor(Color.BLUE);
                    graphics.drawOval(margin / 2, margin / 2, getWidth() - margin, getHeight() - margin);
                }
                
                private void blockAllButton(){
                    for (JButton but : jbs) {
                        but.setEnabled(false);
                    }
                }
            };

        }

    }


    public static void main(String[] args){
        new MyWindow();
        initMap();
    }

    private static int checkEnd(char symbol) {
        if (checkWin(symbol)) {
            //System.out.println(winMessage);
            return 1;
        }
        if (isMapFull()) {
            //System.out.println("Ничья!");
            return -1;
        }
        return 0;
    }

    private static boolean isMapFull()
    {
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                if (map[i][j] == DOT_EMPTY)
                {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char symbol)
    {
        if (findRowWin(symbol)) return true;
        if (findColWin(symbol)) return true;
        if (findDiagonalWin_1(symbol)) return true;
        if (findDiagonalWin_2(symbol)) return true;

        return false;
    }

    private static boolean findRowWin(char symbol)      // Поиск выигрышной позиции в строках
    {
        int countDot = 0;
        for (int i = 0; i < SIZE ; i++)
        {
            for (int j = 0; j < SIZE ; j++)
            {
                if (map[i][j] == symbol) countDot++;
                else countDot = 0;
                if (countDot >= winLength) return true;
            }
        }
        return false;
    }

    private static boolean findColWin(char symbol)      // Поиск выигрышной позиции в колонках
    {
        int countDot;
        for (int i = 0; i < SIZE ; i++)
        {
            countDot = 0;
            for (int j = 0; j < SIZE ; j++)
            {
                if (map[j][i] == symbol) countDot++;
                else countDot = 0;
                if (countDot >= winLength) return true;
            }
        }
        return false;
    }

    private static boolean findDiagonalWin_1(char symbol)       // Поиск выигрышной позиции по прямой диагонали
    {
        int countDot = 0;
        for (int i = 0; i <= (SIZE - winLength) ; i++)
        {
            for (int j = 0; j < SIZE ; j++)
            {
                if ((j+i) >= SIZE) break;
                if (map[j][j+i] == symbol) countDot++;
                else countDot = 0;
                if (countDot >= winLength) return true;
            }
        }

        for (int i = 1; i <= (SIZE - winLength); i++)
        {
            for (int j = 0; j < SIZE - i; j++)
            {
                if ((j+i) >= SIZE) break;
                if (map[j+i][j] == symbol) countDot++;
                else countDot = 0;
                if (countDot >= winLength) return true;
            }
        }
        return false;
    }

    private static boolean findDiagonalWin_2(char symbol)   // Поиск выигрышной позиции по обратной диагонали
    {
        int countDot = 0;
        for (int i = 0; i <= (SIZE - winLength) ; i++)
        {
            for (int j = 0; j < SIZE ; j++)
            {
                if ((SIZE -1 - j - i) < 0 ) break;
                if (map[j][SIZE -1 - j - i] == symbol) countDot++;
                else countDot = 0;
                if (countDot >= winLength) return true;
            }
        }

        for (int i = 1; i <= (SIZE - winLength); i++)
        {
            for (int j = 0; j < SIZE - i; j++)
            {
                if (((j+i) >= SIZE) || ((SIZE -1 - j) < 0)) break;
                if (map[j+i][SIZE -1 - j ] == symbol) countDot++;
                else countDot = 0;
                if (countDot >= winLength) return true;
            }
        }
        return false;
    }

    private static int ComputerTurn()
    {
        int butNum;
        //System.out.println("Ход компьютера");
        int rowNumber, colNumber;
        do {
            rowNumber = random.nextInt(SIZE) + 1;
            colNumber = random.nextInt(SIZE) + 1;
        } while (!isCellValid(rowNumber, colNumber));

        map[rowNumber - 1][colNumber - 1] = DOT_O;
        butNum = (rowNumber - 1) * SIZE + (colNumber - 1);      // вычисляем нмер кнопки, на которой нужно нарисовать нолик
        return butNum;
    }

    private static boolean isCellValid(int rowNumber, int colNumber)
    {
        if (rowNumber < 1 || rowNumber > SIZE)  return false;
        if (colNumber < 1 || colNumber > SIZE)  return false;

        return map[rowNumber - 1][colNumber - 1] == DOT_EMPTY;
    }

    private static void initMap()
    {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

}
