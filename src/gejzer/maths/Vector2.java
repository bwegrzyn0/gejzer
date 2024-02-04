package gejzer.maths;

public class Vector2 {

  public float x, y;

  public Vector2(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public Vector2(Vector2 vector2) {
    x = vector2.x;
    y = vector2.y;
  }

  public void add(Vector2 vector2) {
    x += vector2.x;
    y += vector2.y;
  }

  public void multiply(float a) {
    x *= a;
    y *= a;
  }

  public float magnitute() {
    return (float) Math.sqrt(x * x + y * y);
  }

  public Vector2 normalized() {
    float mag = magnitute();
    return new Vector2(x / mag, y / mag);
  }

  public float dot(Vector2 vector2) {
    return x * vector2.x + y * vector2.y;
  }

  public Vector3 cross(Vector2 vector2) {
    Vector3 v1 = new Vector3(x, y, 0);
    Vector3 v2 = new Vector3(vector2.x, vector2.y, 0);
    return v1.cross(v2);
  }
}
