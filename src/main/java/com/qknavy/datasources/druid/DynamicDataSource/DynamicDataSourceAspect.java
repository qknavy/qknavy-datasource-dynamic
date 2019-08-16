package com.qknavy.datasources.druid.DynamicDataSource;//package com.qknavy.datasources.druid.DynamicDataSource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.expression.spel.ast.Identifier;
import org.springframework.stereotype.Component;
import java.lang.reflect.Parameter;

@Aspect
@Order(-1)// 保证该AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);
    String datasource = null;

    @Before("@annotation(ds)")
    public void changeDataSource(JoinPoint point, Dynamic ds) throws Throwable {
        Object[] args = point.getArgs();
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Parameter[] parameters = methodSignature.getMethod().getParameters();
        for (int i = 0 ; i < parameters.length ; i ++) {
            if (parameters[i].isAnnotationPresent(DynamicIdentifier.class)){
                //一个方法最多只允许一个动态数据源
                datasource = (String)args[i];
            }
        }
        if (!DynamicDataSourceContextHolder.containsDataSource(datasource)) {
            logger.error("数据源[{}]不存在，使用默认数据源 > {}", datasource, point.getSignature());
        } else {
            logger.debug("Use DataSource : {} > {}", datasource, point.getSignature());
            DynamicDataSourceContextHolder.setDataSourceType(datasource);
        }
    }

    @After("@annotation(ds)")
    public void restoreDataSource(JoinPoint point, Dynamic ds) {
        logger.debug("Revert DataSource : {} > {}", datasource, point.getSignature());
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
}
