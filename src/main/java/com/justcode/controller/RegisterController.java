package com.justcode.controller;

import com.justcode.model.User;
import com.justcode.model.UserRole;
import com.justcode.service.UserService;
import com.justcode.support.data.RegisterData;
import com.justcode.support.validator.RegisterValidator;
import com.justcode.support.validator.ValidateResult;
import java.util.Collections;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class RegisterController {

    @Autowired
    private RegisterValidator registerValidator;
    @Autowired
    private UserService userService;

    private Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String validateUserRegister(@ModelAttribute RegisterData registerData, HttpServletRequest request,
        ModelMap modelMap) {
        registerValidator.setRegisterData(registerData);
        registerValidator.setLocale(RequestContextUtils.getLocale(request));
        ValidateResult validateResult = registerValidator.validate();

        if (!validateResult.isValid()) {
            modelMap.put("errorMessageContent", validateResult.getMessage());
            modelMap.put("registerData", registerData);
            return "register";
        }

        User user = new User();
        UserRole userRole = new UserRole();

        user.setUsername(registerData.getUsername());
        user.setEmail(registerData.getEmail());
        user.setPassword(md5PasswordEncoder.encodePassword(registerData.getPassword(), null));
        user.setUserRoles(Collections.singletonList(userRole));
        user.setPoints(100);
        userRole.setRole("ROLE_USER");
        userRole.setUser(user);

        userService.save(user);

        return "loginPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String userRegister() {
        return "register";
    }
}
