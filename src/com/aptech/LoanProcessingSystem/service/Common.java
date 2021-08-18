package com.aptech.LoanProcessingSystem.service;

import java.text.DecimalFormat;

public class Common {
	public static String formatNumber(double number) {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return df.format(number);
	}
}
