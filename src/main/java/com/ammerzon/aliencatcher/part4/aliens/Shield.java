package com.ammerzon.aliencatcher.part4.aliens;

import com.ammerzon.aliencatcher.part4.helper.Environment;
import com.ammerzon.aliencatcher.part4.helper.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class Shield extends AlienDecorator {
  private final List<Point> points = new ArrayList<>();

  public Shield(Alien alien, Environment env) {
    super(alien, env);
  }

  @Override
  public void hit(int x, int y) {
    if (super.isHit(x, y)) {
      points.add(new Point(x, y));
    }

    if (points.size() >= 3) {
      super.hit(x, y);
    }
  }

  @Override
  public void paint(Graphics gr) {
    super.paint(gr);
    var g2d = (Graphics2D) gr;
    points.forEach(
        p -> {
          var circle = new Ellipse2D.Double(p.getX(), p.getY(), 5, 5);
          g2d.setColor(Color.black);
          g2d.fill(circle);
        });
  }
}
