package gejzer.maths;

public class Quaternion {

  public Vector3 u;
  public float s;

  public Quaternion(float s, Vector3 u) {
    this.s = s;
    this.u = u;
  }

  public void add(Quaternion quaternion) {
    s += quaternion.s;
    u.add(quaternion.u);
  }

  public void multiply(float a) {
    s *= a;
    u.multiply(a);
  }

  public float magnitude() {
    return (float) Math.sqrt(s * s + u.dot(u));
  }

  public Quaternion conjugate() {
    return new Quaternion(s, u.multiplied(-1));
  }

  public Quaternion inverse() {
    Quaternion inv = conjugate();
    inv.multiply(magnitude() * magnitude());
    return inv;
  }

  public Quaternion multiply(Quaternion quaternion) {
    Vector3 nu = quaternion.u.multiplied(s);
    nu.add(u.multiplied(quaternion.s));
    nu.add(u.cross(quaternion.u));
    return new Quaternion(s * quaternion.s - u.dot(quaternion.u), nu);
  }

  public static Vector3 rotate(Vector3 vector3, Vector3 rotationAxis, float angle) {
    Vector3 nra = rotationAxis.normalized();
    Quaternion vq = new Quaternion(0, vector3);
    Quaternion rq = new Quaternion((float) Math.cos(angle / 2), nra.multiplied((float) Math.sin(angle / 2)));
    Quaternion rot = (rq.multiply(vq)).multiply(rq.inverse());
    return rot.u;
  }
}
