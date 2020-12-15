package com.ammerzon.aliencatcher.part4.helper;

import com.ammerzon.aliencatcher.part4.aliens.Alien;

public interface AlienFactory {
  Alien create(int maxX, int maxY);
}
