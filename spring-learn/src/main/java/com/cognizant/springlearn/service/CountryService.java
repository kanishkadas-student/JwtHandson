package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	
	public Country getCountry(String code) throws CountryNotFoundException{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");		
		//Country country = (Country) context.getBean(code);
		@SuppressWarnings("unchecked")
		List<Country> countryList = (List<Country>) context.getBean("countryList");
		Country response = null;
		for (Country country : countryList) {
			if(country.getCode().equalsIgnoreCase(code)) {
				response = country;
			}
				
		}
		if(response == null) {
			throw new CountryNotFoundException();
		}
		return response;
	}
	
	public List<Country> getAllCountries() {		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");		
		@SuppressWarnings("unchecked")
		List<Country> countries = (List<Country>) context.getBean("countryList");
		return countries;
	}
	public Country getCountryIndia() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");		
		Country country = (Country) context.getBean("in");
		return country;
	}
}