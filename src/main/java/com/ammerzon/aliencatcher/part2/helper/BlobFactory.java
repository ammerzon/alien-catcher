package com.ammerzon.aliencatcher.part2.helper;

import com.ammerzon.aliencatcher.part2.aliens.Alien;
import com.ammerzon.aliencatcher.part2.aliens.Blob;
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
    return new Blob(
        env.getAlienColor(),
        radius,
        random.nextInt(0, maxX),
        random.nextInt(0, maxY),
        env.getFledThreshold(),
        env.getRadiusReduce());
  }
}
