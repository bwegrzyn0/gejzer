package gejzer.test;

import gejzer.engine.Engine;
import gejzer.engine.Window;

public class MainTest {
  public static void main(String[] args) {
    RendererTest renderer = new RendererTest(1920, 1080);
    new Window("test", renderer);
    LogicTest logic = new LogicTest();
    Engine engine = new Engine(renderer, logic);
    engine.start();
  }
}
