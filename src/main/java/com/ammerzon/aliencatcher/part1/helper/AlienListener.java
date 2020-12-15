package com.ammerzon.aliencatcher.part1.helper;

import com.ammerzon.aliencatcher.part1.aliens.Alien;

public interface AlienListener {
  void alienCaptured(Alien source);

  void alienFled(Alien source);
}
