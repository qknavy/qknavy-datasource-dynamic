package com.qknavy.datasources.druid.DynamicDataSource;//package com.qknavy.datasources.druid.DynamicDataSource;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用动态数据源
 */
@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DynamicDataSourceRegister.class)
public @interface EnableDynamicDatasource
{
}