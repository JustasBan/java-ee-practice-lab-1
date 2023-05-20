package lt.vu.usecases;

import javax.enterprise.context.Dependent;

@Dependent
public class DependentDefaultName implements IDefaultName{
    @Override
    public String getDefaultName() {
        return "Dependent name";
    }
}
