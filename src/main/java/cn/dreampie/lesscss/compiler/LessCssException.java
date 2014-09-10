package cn.dreampie.lesscss.compiler;

public class LessCssException extends RuntimeException {
  public LessCssException(String message) {
    super(message);
  }

  public LessCssException(String message, Throwable cause) {
    super(message, cause);
  }
}
