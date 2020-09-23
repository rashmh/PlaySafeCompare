package com.conversions.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConversionDTO {

	private Double kelvin;

	private Double celcius;

	private Double mile;

	private Double km;

	public ConversionDTO() {
		super();
	}

	public Double getKelvin() {
		return kelvin;
	}

	public Double getCelcius() {
		return celcius;
	}

	public Double getMile() {
		return mile;
	}

	public Double getKm() {
		return km;
	}

	public void setKelvin(Double kelvin) {
		this.kelvin = kelvin;
	}

	public void setCelcius(Double celcius) {
		this.celcius = celcius;
	}

	public void setMile(Double mile) {
		this.mile = mile;
	}

	public void setKm(Double km) {
		this.km = km;
	}

}
