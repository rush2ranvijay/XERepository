package com.rps.xe.repository;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rps.xe.model.CurrencyQuery;

@Repository("currencyQueryRepository")
public interface ICurrencyQueryRepository extends CrudRepository<CurrencyQuery, Long>{

	/**
     * Save user currency queries by using the email as an userId.
     * @param currencyQuery {@link CurrencyQuery}
     * @return  Saved currency query
     *          
     */
	@Override
	public <S extends CurrencyQuery> S save(S currencyQuery);
	
	 /**
     * Finds a the last user queries by using the email as a search criteria.
     * @param email
     * @return  A list of user queries whose email is an exact match with the given user queries.
     *          If no user queries is found, this method returns an empty list.
     */
	@Query("SELECT c FROM CurrencyQuery c WHERE c.user.email = :email order by queryDate desc")
	public List<CurrencyQuery> find(@Param("email") String email, Pageable pageable);
}
