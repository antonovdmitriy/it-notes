package org.example;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeGame {

    private Snake snake = new Snake();

    private Map<Direction, Integer[]> delta = new HashMap<>();

    public SnakeGame() {

        snake.setBody(new Integer[][]{new Integer[]{4, 1}, new Integer[]{4, 2}, new Integer[]{4, 3}, new Integer[]{4, 4},});

        delta.put(Direction.UP, new Integer[]{-1, 0});
        delta.put(Direction.DOWN, new Integer[]{1, 0});
        delta.put(Direction.LEFT, new Integer[]{0, -1});
        delta.put(Direction.RIGHT, new Integer[]{0, 1});

    }

    private static class Snake {

        private Integer[][] body;

        public Integer[][] getBody() {
            return body;
        }

        public void setBody(Integer[][] body) {
            this.body = body;
        }
    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT;
    }

    public void move(Direction direction) {

        Integer[][] currentBody = snake.getBody();

        Integer[] currentHead = currentBody[currentBody.length - 1];
        int currentHeadRow = currentHead[0];
        int currentHeadColumn = currentHead[1];

        Integer[] currentDelta = delta.get(direction);

        Integer[] newHead = new Integer[]{currentHeadRow + currentDelta[0], currentHeadColumn + currentDelta[1]};


        Integer[][] newBody = new Integer[snake.getBody().length][2];
        System.arraycopy(snake.getBody(), 1, newBody, 0, snake.getBody().length - 1);
        newBody[newBody.length - 1] = newHead;
        snake.setBody(newBody);
    }

    public void draw(Terminal terminal) {

        clearScreen(terminal);

        List<List<String>> grid = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                row.add(" ");
            }
            grid.add(row);
        }

        for (Integer[] pos : snake.getBody()) {

            int row = pos[0];
            int col = pos[1];

            grid.get(row).set(col, "0");
        }

        grid.stream().forEach(System.out::println);
    }

    private static void clearScreen(Terminal terminal) {
        if (terminal != null) {
            try {
                terminal.puts(org.jline.utils.InfoCmp.Capability.clear_screen);
                terminal.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static volatile Direction currentDirection = Direction.RIGHT; // Default direction


    public static void main(String[] args) {
        try {
            SnakeGame game = new SnakeGame();

            Terminal terminal = TerminalBuilder.terminal();
            game.draw(terminal);

            terminal.enterRawMode();
            NonBlockingReader reader = terminal.reader();

            Thread moveThread = new Thread(() -> {
                while (true) {
                    try {
                        game.move(currentDirection);
                        game.draw(terminal);
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    } catch (Exception ex) {
                        System.out.println("GAME OVER");
                        return;
                    }
                }
            });

            moveThread.start();

            int ch;
            while ((ch = reader.read()) != -1) {
                switch (ch) {
                    case 'w':
                        currentDirection = Direction.UP;
                        break;
                    case 'a':
                        currentDirection = Direction.LEFT;
                        break;
                    case 's':
                        currentDirection = Direction.DOWN;
                        break;
                    case 'd':
                        currentDirection = Direction.RIGHT;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("GAME OVER");
        }
    }

}
