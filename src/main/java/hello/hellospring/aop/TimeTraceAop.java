package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // aop관련
@Component // Bean으로 등록해서 써도되고 Coponent 어노테이션을 붙여도 된다
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))") // 어디에다가 쓸건지
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Start: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("End: " + joinPoint.toString() + " " + timeMs + "ms");
        }

    }
}
