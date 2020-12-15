package com.ammerzon.aliencatcher.part3.helper;

import java.awt.Color;

public interface Environment {
  int getRedrawInterval();

  int getRadiusReduce();

  int getFledThreshold();

  Color getAlienColor();

  int getMinRadius();

  int getMaxRadius();

  int getStartingLives();

  int getFieldWidth();

  int getFieldHeight();

  int getMaxAmountOfAliens();
}
