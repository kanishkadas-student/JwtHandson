package com.cognizant.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	
	public  CountryController() {
		LOGGER.debug("Inside Country Controller Constructor");
	}
	@Autowired
	private CountryService countryService;
	
	@RequestMapping(value="/country", method = RequestMethod.GET)
	@ResponseBody
	public Country getCountryIndia() {		
		LOGGER.info("START");		
		return countryService.getCountryIndia();
	}
	
	@GetMapping("/countries")
	@ResponseBody
	public List<Country> getAllCountries() {		
		LOGGER.info("START");
		return countryService.getAllCountries();
	}
	
	@GetMapping("/countries/{code}")
	@ResponseBody
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {		
		LOGGER.info("START");
		return countryService.getCountry(code);
	}
	
	
}
