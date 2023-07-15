package com.springboot.timeproject.controller;


	import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.timeproject.contoller.TimeController;

	@SpringBootTest
	public class TimeControllerTest {

	    @Autowired
	    private TimeController timeConverter;
	    
	    
	    
	    @Test
	    public void testGetTimeInWords() {
	        assertEquals("It's one o'clock", timeConverter.getTimeInWords("01:00"));
	        assertEquals("It's two thirty", timeConverter.getTimeInWords("02:30"));
	        assertEquals("It's Midday", timeConverter.getTimeInWords("12:00"));
	        assertEquals("It's Midnight", timeConverter.getTimeInWords("00:00"));
	        assertEquals("It's eleven fifty nine", timeConverter.getTimeInWords("11:59"));
	    }
	    
	    @Test
	    public void testGetTimeInWordsInvalidInput() {
	    	timeConverter.getTimeInWords("25:00");
	    }	
	    
	    @Test
	    public void testGetTimeInWordsInvalidInputMinute() {
	    	timeConverter.getTimeInWords("10:61");
	    }

	    @Test
	    public void testGetTimeInWordsInvalidInputFormat() {
	    	timeConverter.getTimeInWords("100:00");
	    }

	    @Test
	    public void testGetTimeInWordsInvalidInputCharacters() {
	    	timeConverter.getTimeInWords("ab:cd");
	    }
	}

