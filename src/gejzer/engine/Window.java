package gejzer.engine;

import javax.swing.*;
import java.awt.*;

import gejzer.engine.renderer.Renderer;

public class Window {

  public Window(String TITLE, Renderer renderer) {
    JFrame frame = new JFrame(TITLE);
    Container c = frame.getContentPane();
    c.setPreferredSize(new Dimension(renderer.WIDTH, renderer.HEIGHT));
    frame.pack();
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.add(renderer);
    frame.setVisible(true);
  }

}
