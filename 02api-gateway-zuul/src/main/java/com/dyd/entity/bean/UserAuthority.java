package com.dyd.entity.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthority implements GrantedAuthority {
	private static final long serialVersionUID = 3280007457965658783L;
	@Id
	private String role;

	@Override
	public String getAuthority() {
		return role;
	}

}
