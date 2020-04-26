package com.example.oraclemergedemo.bo;

public class GenericBo {
	
	private static String batchNumber;

	public static String getBatchNumber() {
		return batchNumber;
	}

	public static void setBatchNumber(String batchNumber) {
		GenericBo.batchNumber = batchNumber;
	}
	
	

}
