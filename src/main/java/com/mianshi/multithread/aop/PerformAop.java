package com.mianshi.multithread.aop;



import com.mianshi.multithread.service.ResultServiceV1;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;



import java.text.SimpleDateFormat;
import java.util.Date;


@Component
@Aspect
public class PerformAop {
    private Logger logger = LoggerFactory.getLogger(PerformAop.class);
    @Pointcut("execution(* com.mianshi.multithread.service..*.*(..))")
    public void pointcut(){

    }

    @After("pointcut()")
    public void before(JoinPoint joinPoint){

        //用户[ip地址]，在[xxx时间] 访问了[com.lican.community.service.impl.xxx()]


        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String target = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();

        logger.info("在{}，访问了{}",now,target);


    }


    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){

        //用户[ip地址]，在[xxx时间] 访问了[com.lican.community.service.impl.xxx()]
        long start = System.currentTimeMillis();
        String methodName = "-";
        Object result = "Y";
        try {
            methodName = proceedingJoinPoint.getSignature().toShortString();
            result = proceedingJoinPoint.proceed();


        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            long end = System.currentTimeMillis();
            logger.info("{};{};{}ms", methodName, result, (end - start));
        }
        return result;
    }
}
