package cn.dreampie.lesscss.compiler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by wangrenhui on 2014/7/22.
 */
public class LessExecuteListener implements Observer {

  private Logger logger = LoggerFactory.getLogger(getClass());
  private LessExecuteThread lessExecuteThread;

  public LessExecuteListener(LessExecuteThread lessExecuteThread) {
    this.lessExecuteThread = lessExecuteThread;
  }

  @Override
  public void update(Observable o, Object arg) {
    lessExecuteThread.addObserver(this);
    new Thread(lessExecuteThread).start();
    logger.error("LessExecuteThread is start");
  }
}
