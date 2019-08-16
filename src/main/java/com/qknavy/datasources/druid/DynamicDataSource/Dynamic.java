package com.qknavy.datasources.druid.DynamicDataSource;//package com.qknavy.datasources.druid.DynamicDataSource;

import java.lang.annotation.*;

/**
 * 标识使用动态数据源，配合@DynamicIdentifier使用
 */
@Target({ ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Dynamic
{
}