package com.ammerzon.aliencatcher.part1.aliens;

import com.ammerzon.aliencatcher.part1.helper.AlienListener;
import java.awt.Graphics;

public interface Alien {
  void hit(int x, int y);

  boolean isHit(int x, int y);

  void paint(Graphics gr);

  void update();

  int getRadius();

  void addAlienListener(AlienListener listener);

  void removeAlienListener(AlienListener listener);
}
