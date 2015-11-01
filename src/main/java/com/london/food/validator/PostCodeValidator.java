package com.london.food.validator;

import org.springframework.stereotype.Component;

import com.london.food.exception.ValidationException;

@Component
public class PostCodeValidator{

	public static final String ERROR_INVALID_POSTCODE = "Error while validating postcode. Postcode doesn't fit with the standard UK postcode";
	public static final String ERROR_EMPTY_POSTCODE = "Error: Postcode can't be empty";
	public static final String POSTCODE_REGULAR_EXPRESION = "^([A-PR-UWYZa-pr-uwyz0-9][A-HK-Ya-hk-y0-9][AEHMNPRTVXYaehmnprtvxy0-9]?[ABEHMNPRVWXYabehmnprvwxy0-9]{1,2}[0-9][ABD-HJLN-UW-Zabd-hjln-uw-z]{2}|GIR 0AA)$";
	
	public void validate(String target) throws ValidationException {
		
		if(target.equals(""))
			throw new ValidationException(ERROR_EMPTY_POSTCODE);
		
		if(!target.matches(POSTCODE_REGULAR_EXPRESION)){
			throw new ValidationException(ERROR_INVALID_POSTCODE);
		}
	}
}
