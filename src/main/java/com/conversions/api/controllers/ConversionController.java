package com.conversions.api.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conversions.api.ConversionDTO;

@RestController
@RequestMapping("/conversions")
public class ConversionController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConversionController.class);

	@PostMapping("/ktoc")
	public ResponseEntity<?> ktoc(@RequestBody ConversionDTO conversionDTO) {
		long start = System.currentTimeMillis();

		Optional<Double> kelvinOptional = Optional.ofNullable(conversionDTO.getKelvin());
		if (!kelvinOptional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST);
		}

		// calculate ktoc
		double celcius = kelvinOptional.get() - 273.15;
		conversionDTO.setCelcius(celcius);

		// calculate execution duration
		long end = System.currentTimeMillis();
		long time = end - start;

		LOGGER.info("@@@ execution duration in ms ==> " + time);
		return new ResponseEntity<>(conversionDTO, HttpStatus.OK);

	}

	@PostMapping("/ctok")
	public ResponseEntity<?> ctok(@RequestBody ConversionDTO conversionDTO) {
		long start = System.currentTimeMillis();

		Optional<Double> celciusOptional = Optional.ofNullable(conversionDTO.getCelcius());
		if (!celciusOptional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST);
		}

		// calculate ctok
		double kelvin = celciusOptional.get() + 273.15;
		conversionDTO.setKelvin(kelvin);

		// calculate execution duration
		long end = System.currentTimeMillis();
		long time = end - start;

		LOGGER.info("@@@ execution duration in ms ==> " + time);
		return new ResponseEntity<>(conversionDTO, HttpStatus.OK);
	}

	@PostMapping("/mtok")
	public ResponseEntity<?> mtok(@RequestBody ConversionDTO conversionDTO) {
		long start = System.currentTimeMillis();

		Optional<Double> mileOptional = Optional.ofNullable(conversionDTO.getMile());
		if (!mileOptional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST);
		}

		// calculate mtok
		double km = mileOptional.get() * 1.609344;
		conversionDTO.setKm(km);

		// calculate execution duration
		long end = System.currentTimeMillis();
		long time = end - start;

		LOGGER.info("@@@ execution duration in ms ==> " + time);
		return new ResponseEntity<>(conversionDTO, HttpStatus.OK);

	}

	@PostMapping("/ktom")
	public ResponseEntity<?> ktom(@RequestBody ConversionDTO conversionDTO) {

		long start = System.currentTimeMillis();

		Optional<Double> kmOptional = Optional.ofNullable(conversionDTO.getKm());
		if (!kmOptional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST);
		}

		// calculate ktom
		double mile = kmOptional.get() * 0.62137;
		conversionDTO.setMile(mile);

		// calculate execution duration
		long end = System.currentTimeMillis();
		long time = end - start;

		LOGGER.info("@@@ execution duration in ms ==> " + time);

		return new ResponseEntity<>(conversionDTO, HttpStatus.OK);

	}
}
