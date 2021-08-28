package com.smartvoicenet.processor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class DateTimeProcessor {

	public LocalDateTime processDateTime(String date) {
		if(date!=null) {
			return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss"));
		}else
			return null;
		

		/*
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")
		  DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
		  LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
		  return dateTime;
		 */
	}

}
