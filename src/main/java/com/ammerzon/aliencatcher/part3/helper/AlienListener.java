package com.ammerzon.aliencatcher.part3.helper;

import com.ammerzon.aliencatcher.part3.aliens.Alien;

public interface AlienListener {
  void alienCaptured(Alien source);

  void alienFled(Alien source);
}
