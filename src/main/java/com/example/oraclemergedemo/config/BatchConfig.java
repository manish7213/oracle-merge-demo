package com.example.oraclemergedemo.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.example.oraclemergedemo.bo.Customer;
import com.example.oraclemergedemo.bo.CustomerImport;
import com.example.oraclemergedemo.bo.PersonDestination;
import com.example.oraclemergedemo.bo.PersonSource;
import com.example.oraclemergedemo.service.PersonProcessService;
import com.example.oraclemergedemo.service.ProcessService;

@Configuration
public class BatchConfig {

	private static final String SELECTQUERY = "SELECT CUSTOMER_ID,FIRST_NAME,LAST_NAME,ADDRESS_STATE,EMAIL_ADDRESS FROM CUSTOMER_IMPORT";

//	private static final String INSERTQUERY = "INSERT INTO CUSTOMER(CUSTOMER_ID,FIRST_NAME,LAST_NAME,ADDRESS_STATE,EMAIL_ADDRESS) values (:CUSTOMER_ID,:FIRST_NAME,:LAST_NAME,:ADDRESS_STATE,:EMAIL_ADDRESS)";
//    private static final String INSERTQUERY = "merge into CUSTOMER using (select CUSTOMER_ID as cid, FIRST_NAME as fn,LAST_NAME as ln,ADDRESS_STATE as ass,EMAIL_ADDRESS as ea from CUSTOMER_IMPORT) on (CUSTOMER.CUSTOMER_ID = cid) when matched then update set CUSTOMER.FIRST_NAME = fn,CUSTOMER.LAST_NAME = ln,CUSTOMER.ADDRESS_STATE = ass,CUSTOMER.EMAIL_ADDRESS = ea when not matched then insert (CUSTOMER.CUSTOMER_ID, CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME,CUSTOMER.ADDRESS_STATE,CUSTOMER.EMAIL_ADDRESS) values (:cid, :fn, :ln,:ass,:ea)";
//    private static final String INSERTQUERY = "UPDATE CUSTOMER SET CUSTOMER_ID = :CUSTOMER_ID,FIRST_NAME = :FIRST_NAME ,LAST_NAME = :LAST_NAME,ADDRESS_STATE = :ADDRESS_STATE,EMAIL_ADDRESS = :EMAIL_ADDRESS";
	private static final String SELECTPERSONQUERY = "SELECT PERSON_ID,FIRST_NAME,LAST_NAME FROM PERSON_SOURCE";

	private static final String INSERTPERSONQUERY = "INSERT INTO PERSON_DESTINATION(PERSON_ID,FIRST_NAME,LAST_NAME) VALUES (:PERSON_ID,:FIRST_NAME,:LAST_NAME)";
	@Autowired
	private JobBuilderFactory jobs;
	@Autowired
	private StepBuilderFactory steps;
	private String jobName = "DBTODBJOB";
	private String stepName = "DBTOSBSTEP";
	
	private String personjobName = "PERSONDBTODBJOB";
	private String personstepName = "PERSONDBTOSBSTEP";
	@Autowired
	private DataSource dataSource;
	@Autowired
	private DBWriter writer;

	@Qualifier("customerJob")
	@Bean
	public Job importUserJob() {
		return jobs.get(jobName).incrementer(new RunIdIncrementer()).start(step1()).build();
	}
	
	
	@Qualifier("personJob")
	@Bean
	public Job importUserJob1() {
		return jobs.get(personjobName).incrementer(new RunIdIncrementer()).start(personStep()).build();
	}
	 

	@Bean
	Step step1() {
		return steps.get(stepName).<CustomerImport, Customer>chunk(1000).reader(reader()).processor(process())
				.writer(writer).build();
	}

	@Bean
	Step personStep() {
		return steps.get(personstepName).<PersonSource, PersonDestination>chunk(1000).reader(personReader())
				.processor(personProcess()).writer(personWriter()).build();
	}

	@Bean
	ItemWriter<PersonDestination> personWriter() {
		
		JdbcBatchItemWriter<PersonDestination> writer = new JdbcBatchItemWriter<PersonDestination>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<PersonDestination>());
		writer.setSql(INSERTPERSONQUERY);
		writer.setDataSource(dataSource);
		return writer;
	}

	@Bean
	ItemProcessor<CustomerImport, Customer> process() {

		return new ProcessService();
	}

	@Bean
	ItemProcessor<PersonSource, PersonDestination> personProcess() {

		return new PersonProcessService();
	}

	@Bean
	ItemStreamReader<CustomerImport> reader() {
		JdbcCursorItemReader<CustomerImport> reader = new JdbcCursorItemReader<>();
		reader.setDataSource(dataSource);
		reader.setSql(SELECTQUERY);
		reader.setRowMapper(new BeanPropertyRowMapper<>(CustomerImport.class));
		return reader;
	}

	@Bean
	ItemStreamReader<PersonSource> personReader() {
		JdbcCursorItemReader<PersonSource> reader = new JdbcCursorItemReader<>();
		reader.setDataSource(dataSource);
		reader.setSql(SELECTPERSONQUERY);
		reader.setRowMapper(new BeanPropertyRowMapper<>(PersonSource.class));
		return reader;
	}

	@Bean
	SimpleJobLauncher simpleJobLauncher(JobRepository jobRepository) {
		SimpleJobLauncher launcher = new SimpleJobLauncher();
		launcher.setJobRepository(jobRepository);
		return launcher;
	}

}
