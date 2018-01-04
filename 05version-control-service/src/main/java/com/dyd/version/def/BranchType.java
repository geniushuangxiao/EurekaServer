package com.dyd.version.def;

public enum BranchType {
	/**
	 * 主分支,永久性分支。合并代码及时构建
	 */
	MASTER,
	/**
	 * 开发分支，永久性分支。每天1个版本，冒烟，集成测试。
	 */
	DEVELOP,
	/**
	 * 功能分支，临时分支。每个IR一个分支，用于特性开发，特性问题单修改。每个特性测试通过后合入develop分支
	 */
	FEATURE,
	/**
	 * 线上问题修复分支。修复&测试完毕后，合入主分支 & 开发分支。并在主分支打标签
	 */
	HOTFIX
}
