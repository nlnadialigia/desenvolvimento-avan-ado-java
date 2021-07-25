package nlnadialigia.utils;

import nlnadialigia.utils.internal.DivHelper;
import nlnadialigia.utils.internal.MultiHelper;
import nlnadialigia.utils.internal.SubHelper;
import nlnadialigia.utils.internal.SumHelper;

public class Calculadora {

  private final SumHelper sumHelper;
  private final SubHelper subHelper;
  private final MultiHelper multiHelper;
  private final DivHelper divHelper;

  public Calculadora(){
    sumHelper = new SumHelper();
    subHelper = new SubHelper();
    multiHelper = new MultiHelper();
    divHelper = new DivHelper();
  }

  public int sum(int a, int b) {
    return sumHelper.execute(a, b);
  }

  public int sub(int a, int b) {
    return subHelper.execute(a, b);
  }

  public int multi(int a, int b) {
    return multiHelper.execute(a, b);
  }

  public int div(int a, int b) {
    return divHelper.execute(a, b);
  }
}
