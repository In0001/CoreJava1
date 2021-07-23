import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Aspect
public class PrintLog {
    static Logger logger;

    static {
        try (FileInputStream ins = new FileInputStream("C:\\Users\\DNS\\IdeaProjects\\CoreJava1\\log.config")) {
            LogManager.getLogManager().readConfiguration(ins);
            logger = Logger.getLogger(Main.class.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Around("@annotation(ExecutionTime)")
    public void executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        joinPoint.proceed();
        logger.info("Выполнен метод" + joinPoint.getSignature().getName() + ". Время выполнения: " + (System.currentTimeMillis() - start) + " мс");
    }
}
