package com.dyd.version.entity.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.dyd.version.def.BranchType;

import lombok.Data;

@Entity
@Data
public class GitBranch {
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final Long id;
	/**
	 * 分支类型
	 */
	private BranchType type;

	/**
	 * 分支名称
	 */
	private String name;

	/**
	 * 最新构建版本基于的提交代码编号。
	 */
	private String lastBuildPushId;

	/**
	 * 分支的构建记录
	 */
	@OneToMany
	@JoinColumn(name = "git_branch_id")
	private List<BranchBuild> branchBuilds;

}
