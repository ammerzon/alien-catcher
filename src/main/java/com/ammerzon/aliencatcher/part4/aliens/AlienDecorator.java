package com.ammerzon.aliencatcher.part4.aliens;

import com.ammerzon.aliencatcher.part4.helper.AlienListener;
import com.ammerzon.aliencatcher.part4.helper.Environment;
import java.awt.Graphics;
import java.util.List;

public abstract class AlienDecorator implements Alien {
  protected Alien alien;
  private final Environment env;

  public AlienDecorator(Alien alien, Environment env) {
    this.alien = alien;
    this.env = env;
  }

  @Override
  public void hit(int x, int y) {
    if (!isHit(x, y)) {
      return;
    }

    alien.getAlienListeners().forEach(l -> l.alienCaptured(this));
  }

  @Override
  public boolean isHit(int x, int y) {
    return alien.isHit(x, y);
  }

  @Override
  public void paint(Graphics gr) {
    alien.paint(gr);
  }

  @Override
  public void update() {
    if (this.getRadius() < env.getFledThreshold()) {
      alien.setRadius(0);
      alien.getAlienListeners().forEach(l -> l.alienFled(this));
    } else {
      alien.setRadius(this.getRadius() - env.getRadiusReduce());
    }
  }

  @Override
  public int getRadius() {
    return alien.getRadius();
  }

  @Override
  public void setRadius(int radius) {
    alien.setRadius(radius);
  }

  @Override
  public void addAlienListener(AlienListener listener) {
    alien.addAlienListener(listener);
  }

  @Override
  public void removeAlienListener(AlienListener listener) {
    alien.removeAlienListener(listener);
  }

  @Override
  public List<AlienListener> getAlienListeners() {
    return alien.getAlienListeners();
  }
}
