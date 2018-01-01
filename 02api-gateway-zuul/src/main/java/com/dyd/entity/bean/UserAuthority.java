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
		if (role.startsWith("ROLE_")) { // 若数据库中添加了ROLE_前缀，可直接返回给权限校验
			return role;
		}
		return String.format("ROLE_%s", role);// 数据库中没加ROLE_前缀，权限校验时，须要加前缀
	}

}
