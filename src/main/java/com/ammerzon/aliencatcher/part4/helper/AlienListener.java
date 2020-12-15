package com.ammerzon.aliencatcher.part4.helper;

import com.ammerzon.aliencatcher.part4.aliens.Alien;

public interface AlienListener {
  void alienCaptured(Alien source);

  void alienFled(Alien source);
}
