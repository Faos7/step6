package com.ekey.validator;


import com.ekey.models.create.UserCreateForm;
import com.ekey.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class UserCreateFormValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCreateFormValidator.class);
    private final UserRepository userRepository;

    @Autowired
    public UserCreateFormValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
        UserCreateForm form = (UserCreateForm) target;
        validateEmail(errors, form);
        //validateRFID(errors, form);
        validatePhone(errors, form);
    }

    private void validatePhone(Errors errors, UserCreateForm form){
        if (userRepository.findOneByPhoneNumb(form.getPhoneNumb()).isPresent()){
            errors.reject("phone.exists", "User with this phone already exists");
        }
    }

    private void validateEmail(Errors errors, UserCreateForm form) {
        if (!userRepository.findOneByUsername(form.getEmail()).equals(null)) {
            errors.reject("email.exists", "User with this email already exists");
        }
    }

    private void validateRFID(Errors errors, UserCreateForm form){
        if (userRepository.findOneByNumberRFID(form.getNumberRFID()).isPresent()){
            errors.reject("RFID.exists", "User with this this RFID already exists");
        }
    }
}
