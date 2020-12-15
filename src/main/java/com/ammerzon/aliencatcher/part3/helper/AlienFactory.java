package com.ammerzon.aliencatcher.part3.helper;

import com.ammerzon.aliencatcher.part3.aliens.Alien;

public interface AlienFactory {
  Alien create(int maxX, int maxY);
}
