package gejzer.test;

import gejzer.engine.renderer.*;
import gejzer.maths.Vector3;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class RendererTest extends Renderer {

  Random random = new Random();
  Triangle triangle;
  int xs[], ys[];

  public RendererTest(int WIDTH, int HEIGHT) {
    super(WIDTH, HEIGHT);
    for (int i = 0; i < WIDTH * HEIGHT; i++) {
      pixels[i] = random.nextInt();
    }
    Vector3 verticies[] = { new Vector3(0, 0, 0), new Vector3(1, -1, 0), new Vector3(-1, -1, 0) };
    int colors[] = new int[3];
    triangle = new Triangle(verticies, colors);
    xs = new int[3];
    ys = new int[3];
    for (int i = 0; i < 3; i++) {
      xs[i] = (int) (1 - triangle.verticies[i].x) * WIDTH / 2;
    }
    for (int i = 0; i < 3; i++) {
      ys[i] = (int) (1 - triangle.verticies[i].y) * HEIGHT / 2;
    }
  }

  public void render(BufferedImage screen) {
    screen.getGraphics().setColor(Color.red);
    ((Graphics2D) screen.getGraphics()).drawPolygon(xs, ys, 3);
  }
}
