package com.ammerzon.aliencatcher.part3.helper;

import io.github.cdimascio.dotenv.Dotenv;
import java.awt.Color;

public class LocalEnvironment implements Environment {

  private final int redrawInterval;
  private final int radiusReduce;
  private final int fledThreshold;
  private final Color alienColor;
  private final int minRadius;
  private final int maxRadius;
  private final int startingLives;
  private final int fieldWidth;
  private final int fieldHeight;
  private final int maxAmountOfAliens;

  public LocalEnvironment() {
    Dotenv dotenv = Dotenv.load();
    redrawInterval = Integer.parseInt(dotenv.get("REDRAW_INTERVAL"));
    radiusReduce = Integer.parseInt(dotenv.get("RADIUS_REDUCE"));
    fledThreshold = Integer.parseInt(dotenv.get("FLED_THRESHOLD"));
    alienColor = colorFromHex(dotenv.get("ALIEN_COLOR"));
    minRadius = Integer.parseInt(dotenv.get("MIN_RADIUS"));
    maxRadius = Integer.parseInt(dotenv.get("MAX_RADIUS"));
    startingLives = Integer.parseInt(dotenv.get("STARTING_LIVES"));
    fieldWidth = Integer.parseInt(dotenv.get("FIELD_WIDTH"));
    fieldHeight = Integer.parseInt(dotenv.get("FIELD_HEIGHT"));
    maxAmountOfAliens = Integer.parseInt(dotenv.get("MAX_AMOUNT_OF_ALIENS"));
  }

  @Override
  public int getRedrawInterval() {
    return redrawInterval;
  }

  @Override
  public int getRadiusReduce() {
    return radiusReduce;
  }

  @Override
  public int getFledThreshold() {
    return fledThreshold;
  }

  @Override
  public Color getAlienColor() {
    return alienColor;
  }

  @Override
  public int getMinRadius() {
    return minRadius;
  }

  @Override
  public int getMaxRadius() {
    return maxRadius;
  }

  @Override
  public int getStartingLives() {
    return startingLives;
  }

  @Override
  public int getFieldWidth() {
    return fieldWidth;
  }

  @Override
  public int getFieldHeight() {
    return fieldHeight;
  }

  @Override
  public int getMaxAmountOfAliens() {
    return maxAmountOfAliens;
  }

  private Color colorFromHex(String hex) {
    return new Color(
        Integer.valueOf(hex.substring(1, 3), 16),
        Integer.valueOf(hex.substring(3, 5), 16),
        Integer.valueOf(hex.substring(5, 7), 16));
  }
}
