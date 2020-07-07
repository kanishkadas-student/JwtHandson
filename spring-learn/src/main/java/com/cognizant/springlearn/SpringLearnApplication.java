package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("Start of Main");
		//displayDate();
		displayCountry();
		displayCountries();
		LOGGER.info("End of main");
	}
	
	public static void displayDate() throws ParseException {
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format =context.getBean("dateFormat", SimpleDateFormat.class);
		Date date = format.parse("31/12/2018");
		//System.out.println(date);
		LOGGER.debug("Date : {}",date);
		LOGGER.info("End");
	}
	public static void displayCountry() {
		LOGGER.info("START");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml"); 
		Country country = (Country) context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		LOGGER.debug("country:{}",anotherCountry.toString());
		LOGGER.info("END");
	}
	public static void displayCountries() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml"); 
		ArrayList<Country> countries = (ArrayList<Country>) context.getBean("countryList");
		LOGGER.debug("Countries : {}", countries);
		LOGGER.info("END");
	}

}
