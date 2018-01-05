package com.dyd.version.def;

public enum BranchType {
	/**
	 * <h2>主分支,永久性分支。</h2><br>
	 * <li>合并代码时及时构建</li>
	 */
	MASTER,
	/**
	 * <h2>开发分支，永久性分支。</h2>
	 * <li>每天1个版本。</li>
	 * <li>冒烟，集成测试。</li>
	 */
	DEVELOP,
	/**
	 * <h2>功能分支，临时分支。</h2>
	 * <li>每个IR一个分支，用于特性开发，特性问题单修改。</li>
	 * <li>每个特性测试通过后合入develop分支,并删除此分支。</li>
	 */
	FEATURE,
	/**
	 * <h2>线上问题修复分支。</h2>
	 * <li>修复&测试完毕后，合入主分支 & 开发分支。</li>
	 * <li>若主分支==线上问题的版本分支，则在主分支打小版本号标签，并删除线上问题分支。</li>
	 * <li>若主分支！=线上问题的版本分支，则保留线上问题分支，并在线上问题分支上打小版本号标签。</li>
	 */
	HOTFIX
}
