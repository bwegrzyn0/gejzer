package gejzer.test;

import gejzer.engine.renderer.Renderer;
import java.awt.image.BufferedImage;
import java.util.Random;

public class RendererTest extends Renderer {

  Random random = new Random();

  public RendererTest(int WIDTH, int HEIGHT) {
    super(WIDTH, HEIGHT);
    for (int i = 0; i < WIDTH * HEIGHT; i++) {
      pixels[i] = random.nextInt();
    }
  }

  public void render(BufferedImage screen) {
    for (int i = 0; i < WIDTH; i++) {
      for (int j = 0; j < HEIGHT; j++) {
        screen.setRGB(i, j, pixels[WIDTH * j + i]);
      }
    }
  }
}
