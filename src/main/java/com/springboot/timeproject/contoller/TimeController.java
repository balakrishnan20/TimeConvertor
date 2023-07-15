package com.springboot.timeproject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.timeproject.exception.TimeException;
import com.springboot.timeproject.service.SpeakingClockServiceimpl;

@RestController
public class TimeController {

	@Autowired
	private SpeakingClockServiceimpl timeConverter;

	@GetMapping("/time/now")
	public String getCurrentTimeInWords() {
		try {
			String timeInWords = timeConverter.convertTimeToWords();
			return "It's " + timeInWords;
		} catch (Exception e) {
			throw new TimeException("Exception occured in get current time in words with current time method");
		}
	}

	@GetMapping("/time/{timeString}")
	public String getTimeInWords(@PathVariable String timeString) {
		try {
			String[] timeParts = timeString.split(":");
			String hours = timeConverter.convertNumberToWords(Integer.parseInt(timeParts[0]));
			String minutes = timeConverter.convertNumberToWords(Integer.parseInt(timeParts[1]));
			if (hours.equals("twelve") && minutes.equals("")) {
				return "It's Midday";
			} else if (hours.equals("twelve") && minutes.equals("")) {
				return "It's Midnight";
			} else {
				return "It's " + hours + " " + minutes;
			}
		} catch (Exception e) {
			throw new TimeException("Exception occured in get time in word input time value method", e);
		}
	}
}
