package fr.insee.demo.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public String getMessageByID(String id) throws Exception {
		try {
			String qString = "SELECT message FROM demo WHERE id=?";
			String q = jdbcTemplate.queryForObject(qString, new Object[] { id }, String.class);
			return q;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

}
