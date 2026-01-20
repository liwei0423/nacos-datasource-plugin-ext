package com.alibaba.nacos.plugin.datasource.impl.postgresql;

import com.alibaba.nacos.plugin.datasource.enums.TrustedPostgresqlFunctionEnum;
import com.alibaba.nacos.plugin.datasource.mapper.AbstractMapper;

public abstract class AbstractMapperByPostgresql extends AbstractMapper {

    @Override
    public String getFunction(String functionName) {
        return TrustedPostgresqlFunctionEnum.getFunctionByName(functionName);
    }
}