package com.ammerzon.aliencatcher.part1.models;

import com.ammerzon.aliencatcher.part1.aliens.Alien;
import com.ammerzon.aliencatcher.part1.aliens.Blob;
import com.ammerzon.aliencatcher.part1.helper.AlienListener;
import com.ammerzon.aliencatcher.part1.helper.Environment;
import com.ammerzon.aliencatcher.part1.views.JCatcherField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class GameModel {
  private final Environment env;
  private final Timer timer;
  private final List<Alien> aliens;
  private final List<Alien> removableAliens;
  private final JCatcherField field;

  public GameModel(Environment env, JCatcherField field) {
    this.env = env;
    this.field = field;
    this.aliens = new ArrayList<>();
    this.removableAliens = new ArrayList<>();
    this.timer = new Timer(env.getRedrawInterval(), e -> update());
    field.addMouseListener(
        new MouseAdapter() {
          public void mousePressed(MouseEvent me) {
            aliens.forEach(alien -> alien.hit(me.getX(), me.getY()));
          }
        });
    timer.start();
  }

  Alien create() {
    var random = ThreadLocalRandom.current();
    var radius = random.nextInt(env.getMinRadius(), env.getMaxRadius());
    var maxX = env.getFieldWidth() - (radius / 2);
    var maxY = env.getFieldHeight() - (radius / 2);
    return new Blob(
        env.getAlienColor(),
        radius,
        random.nextInt(0, maxX),
        random.nextInt(0, maxY),
        env.getFledThreshold(),
        env.getRadiusReduce());
  }

  void update() {
    // Update alien position
    aliens.forEach(Alien::update);

    // Generate additional aliens if necessary
    var diff = env.getMaxAmountOfAliens() - aliens.size();
    for (int i = 0; i < diff; i++) {
      Alien alien = create();
      alien.addAlienListener(
          new AlienListener() {
            @Override
            public void alienCaptured(Alien source) {
              field.incrementScore();
              removableAliens.add(source);
            }

            @Override
            public void alienFled(Alien source) {
              field.decrementLives();
              removableAliens.add(source);

              if (field.getLives() == 0) {
                timer.stop();
                JOptionPane.showMessageDialog(
                    null,
                    "Your score: %d".formatted(field.getScore()),
                    "Game Over",
                    JOptionPane.PLAIN_MESSAGE);
              }
            }
          });
      aliens.add(alien);
    }

    // Remove unused aliens
    removableAliens.forEach(aliens::remove);
    removableAliens.clear();

    field.setAliens(aliens);
    field.repaint();
  }

  public void restart() {
    timer.stop();
    aliens.clear();
    field.setAliens(aliens);
    field.setLives(env.getStartingLives());
    field.setScore(0);
    timer.restart();
  }
}
