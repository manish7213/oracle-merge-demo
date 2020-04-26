package com.example.oraclemergedemo.service;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.oraclemergedemo.bo.GenericBo;

import java.util.UUID;

@Service
public class BatchService {

	@Qualifier("customerJob")
    @Autowired
    private Job job;
	@Qualifier("personJob")
    @Autowired
    private Job job1;
    @Autowired
    private SimpleJobLauncher simpleJobLauncher;

    public void processBatchJob() {

        JobParameters param = new JobParametersBuilder()
                .addString("JobID",String.valueOf(System.currentTimeMillis()))
                .addString("Id", UUID.randomUUID().toString()).toJobParameters();
        System.out.println(GenericBo.getBatchNumber()+" BATCH IS RUNNING");
        try {
        	if(GenericBo.getBatchNumber().equals("First Batch")) {
        		JobExecution execution = simpleJobLauncher.run(job,param);
        	}
        	if(GenericBo.getBatchNumber().equals("Second Batch")) {
        		JobExecution execution = simpleJobLauncher.run(job1,param);
        	}
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        }
    }
}
