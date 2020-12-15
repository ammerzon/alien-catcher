package com.ammerzon.aliencatcher.part2.helper;

import com.ammerzon.aliencatcher.part2.aliens.Alien;

public interface AlienListener {
  void alienCaptured(Alien source);

  void alienFled(Alien source);
}
