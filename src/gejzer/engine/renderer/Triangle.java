package gejzer.engine.renderer;

import gejzer.maths.*;

public class Triangle {

  public Vector3[] verticies;
  public int[] colours;

  public Triangle(Vector3[] verticies, int[] colours) {
    if (verticies.length != 3) {
      throw new IllegalArgumentException("The verticies array needs to have 3 elements.");
    }
    if (colours.length != 3) {
      throw new IllegalArgumentException("The colours array needs to have 3 elements.");
    }
    this.verticies = verticies;
    this.colours = colours;
  }

  public void move(Vector3 displacement) {
    for (int i = 0; i < verticies.length; i++) {
      verticies[i].add(displacement);
    }
  }

  public void rotate(Vector3 rotationAxis, float angle) {
    for (int i = 0; i < verticies.length; i++) {
      verticies[i] = Quaternion.rotate(verticies[i], rotationAxis, angle);
    }
  }
}
