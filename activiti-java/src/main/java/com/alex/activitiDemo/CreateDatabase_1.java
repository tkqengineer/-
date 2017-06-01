package com.alex.activitiDemo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

/**
 * Created by Alex on 2017/6/1.
 * <p>
 * 初始化工作流引擎的数据库的两种配置方式
 */
public class CreateDatabase_1 {
	
	@Test
	public void createDatabaseByCode() {
		
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		
		configuration.setJdbcUsername("root");
		configuration.setJdbcPassword("shuaigeteng");
		configuration.setJdbcUrl("jdbc:mysql://localhost:3306/activiti");
		configuration.setJdbcDriver("com.mysql.jdbc.Driver");
		configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		configuration.buildProcessEngine();
		
	}
	
	@Test
	public void createDatabaseByXML() {
		
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		
	}
	
}
