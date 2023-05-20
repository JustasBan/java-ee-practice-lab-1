package lt.vu.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Interceptor
@LoggedInvocation
public class PerformanceInterceptor implements Serializable {
    private static final ConcurrentHashMap<String, AtomicLong> counts = new ConcurrentHashMap<>();

    @AroundInvoke
    public Object measureMethodExecutionTime(InvocationContext context) throws Exception {
        long startTime = System.nanoTime();

        Object result = context.proceed();

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;  // Convert to milliseconds

        String methodName = context.getMethod().getName();
        counts.putIfAbsent(methodName, new AtomicLong(0));
        long count = counts.get(methodName).incrementAndGet();

        System.out.printf("Method %s execution time: %d ms. Called %d times.\n", methodName, duration, count);

        return result;
    }
}
