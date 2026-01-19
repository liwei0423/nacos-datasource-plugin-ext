package com.alibaba.nacos.plugin.datasource.impl.postgresql;

import com.alibaba.nacos.plugin.datasource.constants.DatabaseTypeConstant;
import com.alibaba.nacos.plugin.datasource.mapper.ConfigInfoGrayMapper;
import com.alibaba.nacos.plugin.datasource.model.MapperContext;
import com.alibaba.nacos.plugin.datasource.model.MapperResult;

import java.util.Collections;

public class ConfigInfoGrayMapperByPostgresql extends PostgresqlAbstractMapper implements ConfigInfoGrayMapper {

	@Override
	public MapperResult findAllConfigInfoGrayForDumpAllFetchRows(MapperContext context) {
		String sql = "SELECT id,data_id,group_id,tenant_id,gray_name,gray_rule,app_name,content,md5,gmt_modified "
				+ "FROM config_info_gray ORDER BY id LIMIT " + context.getPageSize() + " OFFSET "
				+ context.getStartRow();
		return new MapperResult(sql, Collections.emptyList());
	}

	@Override
	public String getDataSource() {
		return DatabaseTypeConstant.POSTGRESQL;
	}

}
