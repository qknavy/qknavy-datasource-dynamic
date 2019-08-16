package com.qknavy.datasources.druid.DynamicDataSource;//package com.qknavy.datasources.druid.DynamicDataSource;

import java.util.ArrayList;
import java.util.List;

public class DynamicDataSourceContextHolder
{
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static List<String> dataSourceIds = new ArrayList<String>();

    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    public static String getDataSourceType() {
        return contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }

    /**
     * 判断指定DataSrouce当前是否存在
     * @param dbid
     */
    public static boolean containsDataSource(String dbid){
        return dataSourceIds.contains(dbid);
    }
}
