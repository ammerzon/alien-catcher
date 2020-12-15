package com.ammerzon.aliencatcher.part2.helper;

import com.ammerzon.aliencatcher.part2.aliens.Alien;

public interface AlienFactory {
  Alien create(int maxX, int maxY);
}
