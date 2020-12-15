package com.ammerzon.aliencatcher.part4.helper;

import com.ammerzon.aliencatcher.part4.aliens.Alien;
import com.ammerzon.aliencatcher.part4.aliens.Blob;
import com.ammerzon.aliencatcher.part4.aliens.Shield;
import java.util.concurrent.ThreadLocalRandom;

public class BlobFactory implements AlienFactory {

  private final Environment env;

  public BlobFactory(Environment env) {
    this.env = env;
  }

  @Override
  public Alien create(int maxX, int maxY) {
    var random = ThreadLocalRandom.current();
    var radius = random.nextInt(env.getMinRadius(), env.getMaxRadius());
    return new Shield(
        new Blob(
            env.getAlienColor(),
            radius,
            random.nextInt(0, maxX),
            random.nextInt(0, maxY),
            env.getFledThreshold(),
            env.getRadiusReduce()),
        env);
  }
}
