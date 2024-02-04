package gejzer.engine;

import gejzer.engine.renderer.Renderer;

public class Engine implements Runnable {

  private Thread thread;
  private boolean running = false;
  Renderer renderer;
  Logic logic;

  public Engine(Renderer renderer, Logic logic) {
    this.logic = logic;
    this.renderer = renderer;
  }

  public void start() {
    thread = new Thread(this);
    thread.start();
    running = true;
  }

  public void stop() {
    try {
      thread.join();
    } catch (Exception e) {
      e.printStackTrace();
    }
    running = false;
  }

  public void run() {
    long lastTime = System.nanoTime();
    double fixedDeltaTime = 1.0f / 60.0f;
    double renderTime = 1.0f / 120.0f;
    double accumulatedTime = 0.0f;
    double accumulatedRenderTime = 0.0f;
    long timer = System.currentTimeMillis();
    int FPS = 0;

    while (running) {
      long now = System.nanoTime();
      double deltaTime = (now - lastTime) / 1.0e9;
      lastTime = now;

      accumulatedTime += deltaTime;
      accumulatedRenderTime += deltaTime;

      while (accumulatedTime >= fixedDeltaTime) {
        logic.update();
        accumulatedTime -= fixedDeltaTime;
      }

      while (accumulatedRenderTime >= renderTime) {
        renderer.render();
        FPS++;
        accumulatedRenderTime -= renderTime;
      }

      if (System.currentTimeMillis() - timer >= 1000) {
        System.out.println("FPS: " + FPS);
        FPS = 0;
        timer = System.currentTimeMillis();
      }

    }
  }
}
