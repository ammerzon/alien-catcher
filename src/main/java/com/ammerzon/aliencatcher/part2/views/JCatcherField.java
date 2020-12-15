package com.ammerzon.aliencatcher.part2.views;

import com.ammerzon.aliencatcher.part2.aliens.Alien;
import com.ammerzon.aliencatcher.part2.helper.Environment;
import java.awt.Component;
import java.awt.Graphics;
import java.util.List;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JCatcherField extends JPanel {

  private final Environment env;
  private final JLabel label;
  private List<Alien> aliens;
  private int lives;
  private int score;

  public JCatcherField(Environment env) {
    this.env = env;
    this.lives = env.getStartingLives();
    this.score = 0;
    var box = Box.createVerticalBox();
    this.label = new JLabel("Lives: %d Score: %d".formatted(lives, score));
    label.setAlignmentX(Component.LEFT_ALIGNMENT);
    box.add(label);
    add(box);
  }

  public int getLives() {
    return lives;
  }

  public void setLives(int lives) {
    this.lives = lives;
  }

  public void decrementLives() {
    this.lives = this.lives - 1;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void incrementScore() {
    this.score = this.score + 1;
  }

  public void setAliens(List<Alien> aliens) {
    this.aliens = aliens;
  }

  @Override
  protected void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    this.label.setText("Lives: %d Score: %d".formatted(lives, score));
    aliens.forEach(a -> a.paint(gr));
  }
}
