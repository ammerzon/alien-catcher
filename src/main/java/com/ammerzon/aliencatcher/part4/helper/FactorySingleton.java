package com.ammerzon.aliencatcher.part4.helper;

import com.ammerzon.aliencatcher.part4.aliens.Alien;

public enum FactorySingleton implements AlienFactory {
  ALIEN;

  private AlienFactory factory;

  @Override
  public Alien create(int maxX, int maxY) {
    if (factory == null) {
      factory = new BlobFactory(new LocalEnvironment());
    }

    return factory.create(maxX, maxY);
  }
}
