package gejzer.engine.renderer;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public abstract class Renderer extends Canvas {

  public int WIDTH, HEIGHT;
  public int[] pixels;
  public BufferedImage screen;

  public Renderer(int WIDTH, int HEIGHT) {
    this.WIDTH = WIDTH;
    this.HEIGHT = HEIGHT;
    screen = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    pixels = ((DataBufferInt) screen.getRaster().getDataBuffer()).getData();
  }

  public void render() {
    BufferStrategy bs = this.getBufferStrategy();
    if (bs == null) {
      this.createBufferStrategy(3);
      return;
    }
    Graphics graphics = bs.getDrawGraphics();
    render(screen.getGraphics());
    graphics.drawImage(screen, WIDTH, HEIGHT, null);
    graphics.dispose();
    bs.show();
  }

  public abstract void render(Graphics graphics);
}
