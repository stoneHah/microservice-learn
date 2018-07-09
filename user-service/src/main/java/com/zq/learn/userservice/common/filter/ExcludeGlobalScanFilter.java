package com.zq.learn.userservice.common.filter;

import com.zq.learn.userservice.common.ExcludeGlobalScan;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 非全局配置文件过滤器
 *
 * @author qun.zheng
 * @create 2018/7/9
 **/
public class ExcludeGlobalScanFilter extends TypeExcludeFilter {

    public ExcludeGlobalScanFilter() {
        System.out.println("+++++++++++++ ExcludeGlobalScanFilter construct +++++++++++++");
    }

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        if (isNonGlobalConfiguration(metadataReader)) {
            return true;
        }

        return false;
    }

    private boolean isNonGlobalConfiguration(MetadataReader metadataReader) {
        return metadataReader.getAnnotationMetadata().isAnnotated(ExcludeGlobalScan.class.getName());
    }
}
