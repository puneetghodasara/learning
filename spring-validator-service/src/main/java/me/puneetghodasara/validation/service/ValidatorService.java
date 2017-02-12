package me.puneetghodasara.validation.service;

import java.util.List;

/**
 * Service to validate beans
 * 
 * @author I324801
 *
 */
public interface ValidatorService {

	/**
	 * Will validate and return list of problem descriptions
	 * 
	 * @param object
	 * @return
	 */
	List<String> validate(Object object);

}
