package gejzer.maths;

public class Vector3 {

  public float x, y, z;

  public Vector3(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public Vector3(Vector3 vector3) {
    x = vector3.x;
    y = vector3.y;
    z = vector3.z;
  }

  public void add(Vector3 vector3) {
    x += vector3.x;
    y += vector3.y;
    z += vector3.z;
  }

  public Vector3 added(Vector3 vector3) {
    return new Vector3(x + vector3.x, y + vector3.y, z + vector3.z);
  }

  public void multiply(float a) {
    x *= a;
    y *= a;
    z *= a;
  }

  public Vector3 multiplied(float a) {
    return new Vector3(x * a, y * a, z * a);
  }

  public float magnitude() {
    return (float) Math.sqrt(x * x + y * y + z * z);
  }

  public Vector3 normalized() {
    float mag = magnitude();
    return new Vector3(x / mag, y / mag, z / mag);
  }

  public float dot(Vector3 vector3) {
    return x * vector3.x + y * vector3.y + z * vector3.z;
  }

  public Vector3 cross(Vector3 vector3) {
    return new Vector3(y * vector3.z - z * vector3.y, -x * vector3.z + z * vector3.x, x * vector3.y - y * vector3.x);
  }
}
