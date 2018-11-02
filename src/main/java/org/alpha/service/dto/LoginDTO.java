package org.alpha.service.dto;

import org.alpha.config.Constants;

import org.alpha.domain.Authority;
import org.alpha.domain.LoginDomain;
import org.alpha.domain.User;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO representing a user, with his authorities.
 */
public class LoginDTO {

    private String id;
    
    private String username;

    private String password;

    public LoginDTO() {
         }
    
    public LoginDTO(LoginDomain domain) {
        this(domain.getId(),domain.getUsername(),domain.getPassword());
    }

    public LoginDTO(String id,String username,String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
