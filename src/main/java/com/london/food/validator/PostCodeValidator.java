package com.london.food.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PostCodeValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return String.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		String postcode = (String) target;
		
		if(!postcode.matches("(GIR 0AA)|((([A-Z-[QVX]][0-9][0-9]?)|(([A-Z-[QVX]][A-Z-[IJZ]][0-9][0-9]?)|(([A-Z-[QVX]][0-9][A-HJKPSTUW])|([A-Z-[QVX]][A-Z-[IJZ]][0-9][ABEHMNPRVWXY])))) [0-9][A-Z-[CIKMOV]]{2})")){
			errors.rejectValue("postCode", "invalid_post_code", new Object[]{"Invalid postal code"}, "Invalid postal code");
		}
	}

}
