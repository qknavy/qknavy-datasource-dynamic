package com.qknavy.datasources.druid.DynamicDataSource;//package com.qknavy.datasources.druid.DynamicDataSource;

import java.lang.annotation.*;

/**
 * 动态数据源的标志，根据这个注解的参数路由不同的数据库
 */
@Target({ ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicIdentifier
{
}