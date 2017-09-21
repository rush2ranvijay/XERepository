package com.zooplus.xe.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CurrencyQuery")
public class CurrencyQuery {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "query_id")
	private int id;
	
	@Column(name = "from_currency")
	@NotEmpty(message = "*Please provide an from currency")
	private String fromCurrency;
	
	@Column(name = "to_currency")
	@NotEmpty(message = "*Please provide an to currency")
	private String toCurrency;
	
	@Column(name = "enter_amount")
	@Min(value = 1, message = "The value must be greater than or equal to 1")
	@NotNull(message = "*Please enter amount")
	private Integer enterAmount;
	
	@Column(name = "converted_amount")
	private BigDecimal convertedAmount;
	
	@Column(name = "queryDate")
    @DateTimeFormat(pattern="MM/dd/yyyy")
	private Date queryDate = new Date();
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	

	public Integer getEnterAmount() {
		return enterAmount;
	}

	public void setEnterAmount(Integer enterAmount) {
		this.enterAmount = enterAmount;
	}


	public Date getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(Date queryDate) {
		this.queryDate = queryDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BigDecimal getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(BigDecimal convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	
}
