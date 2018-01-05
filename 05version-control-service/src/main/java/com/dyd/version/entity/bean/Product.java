package com.dyd.version.entity.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Product {
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final Long id;
	/**
	 * 公司名称
	 */
	private String company;
	/**
	 * 产品线名称
	 */
	private String productLine;
	/**
	 * 产品名称
	 */
	private String product;
	/**
	 * 产品版本
	 */
	private String productVersion;
	/**
	 * 产品版本格式，供String.format使用
	 */
	private String productVersionFormat;
	/**
	 * 产品子特性
	 */
	private String feature;
	/**
	 * 产品子特性版本
	 */
	private String featureVersion;
	/**
	 * 产品子特性版本格式，供String.format使用
	 */
	private String featureVersionFormat;

	/**
	 * git服务器上的ssh地址
	 */
	private String sshAddress;
	/**
	 * 产品的git分支
	 */
	@OneToMany
	@JoinColumn(name = "product_id")
	private List<GitBranch> gitBranchs;
}
