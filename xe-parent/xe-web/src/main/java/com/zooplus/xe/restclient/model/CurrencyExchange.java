package com.zooplus.xe.restclient.model;

import java.math.BigDecimal;
import java.util.HashMap;

public class CurrencyExchange {

	private String timestamp;
	
	private HashMap<String, BigDecimal> quotes = new HashMap<String, BigDecimal>();
	private HashMap<String, String> currencies = new HashMap<String, String>();

	public HashMap<String, BigDecimal> getQuotes() {
		return quotes;
	}

	public void setQuotes(HashMap<String, BigDecimal> quotes) {
		this.quotes = quotes;
	}

	private String source;

	private String terms;

	private String privacy;

	private String success;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "ClassPojo [timestamp = " + timestamp + ", quotes = " + quotes
				+ ", source = " + source + ", terms = " + terms
				+ ", privacy = " + privacy + ", success = " + success + "]";
	}

	public HashMap<String, String> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(HashMap<String, String> currencies) {
		this.currencies = currencies;
	}
}