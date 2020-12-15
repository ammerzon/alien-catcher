package com.ammerzon.aliencatcher.part4.aliens;

import com.ammerzon.aliencatcher.part4.helper.AlienListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class Blob implements Alien {
  protected final List<AlienListener> listeners = new ArrayList<>();
  private final Color color;
  private final int midX;
  private final int midY;
  private final int fledThreshold;
  private final int radiusReduce;
  private int radius;

  public Blob(Color color, int radius, int x, int y, int fledThreshold, int radiusReduce) {
    this.color = color;
    this.radius = radius;
    this.midX = x;
    this.midY = y;
    this.fledThreshold = fledThreshold;
    this.radiusReduce = radiusReduce;
  }

  @Override
  public void hit(int x, int y) {
    if (!isHit(x, y)) {
      return;
    }

    listeners.forEach(l -> l.alienCaptured(this));
  }

  @Override
  public boolean isHit(int x, int y) {
    return Math.pow((x - midX), 2) + Math.pow((y - midY), 2) <= Math.pow(radius, 2);
  }

  @Override
  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

  @Override
  public List<AlienListener> getAlienListeners() {
    return listeners;
  }

  @Override
  public synchronized void addAlienListener(AlienListener listener) {
    listeners.add(listener);
  }

  @Override
  public synchronized void removeAlienListener(AlienListener listener) {
    listeners.remove(listener);
  }

  @Override
  public void update() {
    if (this.getRadius() < fledThreshold) {
      this.setRadius(0);
      listeners.forEach(l -> l.alienFled(this));
    } else {
      this.setRadius(this.getRadius() - radiusReduce);
    }
  }

  @Override
  public void paint(Graphics gr) {
    var g2d = (Graphics2D) gr;
    var circle = new Ellipse2D.Double(midX, midY, radius, radius);
    g2d.setColor(color);
    g2d.fill(circle);
  }
}
