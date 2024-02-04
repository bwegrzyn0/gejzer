package gejzer.maths;

public class Test {

  public static void main(String[] args) {
    Vector3 vector3 = new Vector3(1, 1, 1);
    Vector3 axis = new Vector3(0, 0, 1);
    Vector3 result = Quaternion.rotate(vector3, axis, (float) Math.PI);
    System.out.println(result.x + ", " + result.y + ", " + result.z);
  }

}
