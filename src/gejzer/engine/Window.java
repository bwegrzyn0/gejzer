package gejzer.engine;

import javax.swing.JFrame;

import gejzer.engine.renderer.Renderer;

public class Window {

  public Window(String TITLE, Renderer renderer) {
    JFrame frame = new JFrame(TITLE);
    frame.setSize(renderer.WIDTH, renderer.HEIGHT);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.add(renderer);
    frame.setVisible(true);
  }

}
