package jeco.core.algorithm;

import jeco.core.problem.Problem;
import jeco.core.problem.Solutions;
import jeco.core.problem.Variable;
import jeco.core.util.observer.AlgObservable;

/**
 *
 * @author José L. Risco-Martín
 *
 */
abstract class AbstractAlgorithm<V extends Variable<?>> extends AlgObservable {

  protected Problem<V> problem = null;
  // Attribute to stop execution of the algorithm.
  protected boolean stop = false;
  
  /**
   * Allows to stop execution after finishing the current generation; must be
   * taken into account in children classes.
   */
  public void stopExection() {
      stop = true;
  }

  public boolean isStopped() {
    return this.stop;
  }

  public AbstractAlgorithm(Problem<V> problem) {
    this.problem = problem;
  }

  public void setProblem(Problem<V> problem) {
    this.problem = problem;
  }

  public abstract void initialize();

  public abstract void step();

  public abstract Solutions<V> execute();
}
