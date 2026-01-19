package com.alibaba.nacos.plugin.datasource.impl.postgresql;

import com.alibaba.nacos.plugin.datasource.constants.DatabaseTypeConstant;
import com.alibaba.nacos.plugin.datasource.mapper.TenantInfoMapper;

public class TenantInfoMapperByPostgresql extends PostgresqlAbstractMapper
		implements TenantInfoMapper {

	@Override
	public String getDataSource() {
		return DatabaseTypeConstant.POSTGRESQL;
	}

}
