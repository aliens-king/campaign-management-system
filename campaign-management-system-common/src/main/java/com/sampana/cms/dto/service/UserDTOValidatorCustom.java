/**
 * 
 */
package com.sampana.cms.dto.service;

import java.io.FileReader;
import java.io.IOException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.passay.DictionaryRule;
import org.passay.dictionary.WordListDictionary;
import org.passay.dictionary.WordLists;
import org.passay.dictionary.sort.ArraysSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sampana.cms.dto.UserDTO;


/**
 * @author Sudhanshu Chaturvedi
 *
 *
 */
@Component
public class UserDTOValidatorCustom implements ConstraintValidator<IsUserDTOPropertiesValid,UserDTO>{
	
	@Autowired
	private PropertiesService propertiesService;
	
	private DictionaryRule dictionaryRule;

	@Override
	public void initialize(IsUserDTOPropertiesValid object) {
		
		try {
            String invalidPasswordList = this.getClass().getResource("/invalid-password-list.txt").getFile();
            
            System.out.println("gagan "+invalidPasswordList);
            dictionaryRule = new DictionaryRule(
                    new WordListDictionary(WordLists.createFromReader(
                            // Reader around the word list file
                            new FileReader[] {
                                    new FileReader(invalidPasswordList)
                            },
                            // True for case sensitivity, false otherwise
                            false,
                            // Dictionaries must be sorted
                            new ArraysSort()
                    )));
        } catch (IOException e) {
            throw new RuntimeException("could not load word list", e);
        }              
		
	}

	@Override
	public boolean isValid(UserDTO userDto, ConstraintValidatorContext context) {
		boolean status = propertiesService.validatePassword(userDto.getPassword(),dictionaryRule,context);
		return status;
	}

}
