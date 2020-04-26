package com.example.oraclemergedemo.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.oraclemergedemo.service.TestService;

@Component
public class BatchScheduler {
	
	@Autowired
	private TestService testService;
	
	@Scheduled(cron = "0 13 0 1/1 * *")
	public void taskScheduler() {
		System.out.println("STARTING JOB");
		testService.processData();
		System.out.println("JOB FINSISHED");
	}

}
