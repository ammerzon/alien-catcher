package com.ammerzon.aliencatcher.part4.aliens;

import com.ammerzon.aliencatcher.part4.helper.AlienListener;
import java.awt.Graphics;
import java.util.List;

public interface Alien {
  void hit(int x, int y);

  boolean isHit(int x, int y);

  void paint(Graphics gr);

  void update();

  int getRadius();

  void setRadius(int radius);

  void addAlienListener(AlienListener listener);

  void removeAlienListener(AlienListener listener);

  List<AlienListener> getAlienListeners();
}
