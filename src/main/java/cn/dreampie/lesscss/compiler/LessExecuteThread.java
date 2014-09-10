package cn.dreampie.lesscss.compiler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Observable;

/**
 * Created by wangrenhui on 2014/7/22.
 */
public class LessExecuteThread extends Observable implements Runnable {
  private Logger logger = LoggerFactory.getLogger(getClass());
  private int restartInterval = 1000;

  private LessCssCompiler lessCssCompiler;

  public LessExecuteThread(LessCssCompiler lessCssCompiler, int restartInterval) {
    this.lessCssCompiler = lessCssCompiler;
    this.restartInterval = restartInterval;
  }

  // 此方法一经调用，等待restartInterval时间之后可以通知观察者，在本例中是监听线程
  public void doBusiness() {
    logger.error("LessExecuteThread is dead");
    try {
      Thread.sleep(restartInterval);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    if (true) {
      super.setChanged();
    }
    notifyObservers();
  }

  @Override
  public void run() {
    try {
      lessCssCompiler.execute();
    } catch (LessCssException e) {
      e.printStackTrace();
      doBusiness();
    }
  }
}
