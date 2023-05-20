package lt.vu.usecases;

import lt.vu.interceptors.LoggedInvocation;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Specializes;
import java.time.LocalDateTime;

@Dependent
@Specializes
public class SpecialDefaultName extends DependentDefaultName{
    @Override
    public String getDefaultName() {
        return "Special name" + LocalDateTime.now();
    }
}
