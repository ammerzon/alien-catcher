package com.ammerzon.aliencatcher.part1;

import com.ammerzon.aliencatcher.part1.helper.Environment;
import com.ammerzon.aliencatcher.part1.helper.LocalEnvironment;
import com.ammerzon.aliencatcher.part1.models.GameModel;
import com.ammerzon.aliencatcher.part1.views.JCatcherField;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public final class Launcher {

  public static void main(String[] args) {
    var env = new LocalEnvironment();
    var field = new JCatcherField(env);
    var gameModel = new GameModel(env, field);
    setup(field, gameModel, env);
  }

  private static void setup(JCatcherField field, GameModel gameModel, Environment env) {
    System.setProperty("apple.laf.useScreenMenuBar", "true");
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Alien Catcher");
    frame.getContentPane().add(field);

    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Game");
    JMenuItem item = new JMenuItem("Restart");
    item.setAccelerator(KeyStroke.getKeyStroke('R'));
    item.addActionListener(
        a -> {
          gameModel.restart();
        });
    menu.add(item);
    menuBar.add(menu);

    frame.setIconImage(
        new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("Icon.png"))
            .getImage());
    frame.setJMenuBar(menuBar);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(env.getFieldWidth(), env.getFieldHeight());
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
