package com.springboot.timeproject.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class SpeakingClockServiceimpl{

	public String convertNumberToWords(int number) {
		 final String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};
		 final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty"};
	        if (number < 10) {
	            return units[number];
	        } 
	        else if (number < 20) {
	            return units[number];
	        }
	        else {
	            return tens[number / 10] + ((number % 10 != 0) ? " " : "") + units[number % 10];
	            
	        }
	}

	public String convertTimeToWords() {
		LocalTime currentTime = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
		String timeString = currentTime.format(formatter);
		String[] timeParts= timeString.split(":");
		String hours = convertNumberToWords(Integer.parseInt(timeParts[0]));
		String min = convertNumberToWords(Integer.parseInt(timeParts[1]));
		return hours + "  "+min;
	}

}
