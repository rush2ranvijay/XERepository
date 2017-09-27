package com.rps.xe;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.rps.xe.model.CurrencyQuery;
import com.rps.xe.model.Role;
import com.rps.xe.model.User;
import com.rps.xe.repository.ICurrencyQueryRepository;
import com.rps.xe.repository.IRoleRepository;
import com.rps.xe.repository.IUserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class XeRepositoriesTest {

	@Autowired
    private IUserRepository userRepository;
	@Autowired
    private IRoleRepository roleRepository;
	@Autowired
	ICurrencyQueryRepository currencyQueryRepository;
	@Autowired
    private TestEntityManager entityManager;
	
	@Test
	public void testFindAdminRole() {
	      Role testRole = roleRepository.findByRole("ADMIN");
		  assertEquals("ADMIN", testRole.getRole());
	    }
	
	 @Test
	 public void testCreateUser() {
		  User user=new User();
		  user.setEmail("ranvijay@sharklasers.com");
		  user.setFirstName("Ranvijay Pratap");
		  user.setLastName("Singh");
		  user.setPassword("test1");
	      user.setActive(1);
	      Role userRole = roleRepository.findByRole("ADMIN");
	      user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		  User testUser = userRepository.save(user);
		  assertEquals("Ranvijay Pratap Singh", testUser.getFirstName()+ " "+testUser.getLastName());
	    }
	 
	@Test
	public void testFindUserByEmail() {
		  User user=new User();
		  user.setEmail("test@sharklasers.com");
		  user.setFirstName("Test");
		  user.setLastName("User");
		  user.setPassword("test1");
	      user.setActive(1);
	      Role userRole = roleRepository.findByRole("ADMIN");
	      user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		  entityManager.persist(user);
		  User testUser = userRepository.findByEmail("test@sharklasers.com");
		  assertEquals("test@sharklasers.com", testUser.getEmail());
		}
	@Test
	public void testSaveCurrencyQuery() {
			CurrencyQuery testCurrencyQuery = new CurrencyQuery();
			testCurrencyQuery.setEnterAmount(10);
			testCurrencyQuery.setFromCurrency("USD");
			testCurrencyQuery.setToCurrency("INR");
			testCurrencyQuery.setConvertedAmount(new BigDecimal(64.667));
			User testUser = new User();
			testUser.setEmail("test@sharklasers.com");
			testCurrencyQuery.setUser(testUser);
			CurrencyQuery cq = entityManager.persist(testCurrencyQuery);
			assertEquals(testCurrencyQuery.getFromCurrency(), cq.getFromCurrency());
		}

}
