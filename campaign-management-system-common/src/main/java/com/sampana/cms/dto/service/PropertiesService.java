package com.sampana.cms.dto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidatorContext;

import org.passay.CharacterRule;
import org.passay.DictionaryRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sampana.cms.dto.ResponseDTO;
import com.sampana.cms.utils.CustomHttpStatus;

@Service
public class PropertiesService {
	
	/**
	 * @author Sudhanshu Chaturvedi
	 *
	 *
	 */
	
	public boolean validatePassword(String password,DictionaryRule dictionaryRule,ConstraintValidatorContext context) {
		
		PasswordValidator passwordValidator = new PasswordValidator(Arrays.asList(

                // at least 8 characters
                new LengthRule(6, 30),
                
                // at least one digit character
                new CharacterRule(EnglishCharacterData.Digit, 1),

               /* // at least one upper-case character
                new CharacterRule(EnglishCharacterData.UpperCase, 1),

                // at least one lower-case character
                new CharacterRule(EnglishCharacterData.LowerCase, 1),

               

                // at least one symbol (special character)
                new CharacterRule(EnglishCharacterData.Special, 1),*/

                // no whitespace
                new WhitespaceRule(),
                
                

                // no common passwords
                dictionaryRule
        ));	
		
		RuleResult result = passwordValidator.validate(new PasswordData(password));

        if (result.isValid()) {
            return true;
        }
		
        List<String> messages = passwordValidator.getMessages(result);
        String messageTemplate = messages.stream().collect(Collectors.joining(","));
        context.buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;

		
		
	}
}
