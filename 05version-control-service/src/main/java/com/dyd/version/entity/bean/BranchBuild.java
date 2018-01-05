package com.dyd.version.entity.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * 分支构建记录
 * 
 * @author HuangXiao
 *
 */
@Entity
@Data
public class BranchBuild {
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final Long id;

	private Long startTime;

	private Long endTime;

	private boolean success;
}
