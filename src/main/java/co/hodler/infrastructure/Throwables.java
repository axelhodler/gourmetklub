package co.hodler.infrastructure;

import java.util.concurrent.Callable;

public class Throwables {

  public static interface ExceptionWrapper<E> {
    E wrap(Exception e);
  }

  public static <T> T executeQuery(Callable<T> callable)
      throws RuntimeException {
    return executeQuery(callable, RuntimeException::new);
  }

  public static <T, E extends Throwable> T executeQuery(Callable<T> callable,
      ExceptionWrapper<E> wrapper) throws E {
    try {
      return callable.call();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw wrapper.wrap(e);
    }
  }
}
