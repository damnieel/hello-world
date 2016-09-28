package com.moon.vip.infra.vo.sys.roleManage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @ClassName: TreeVO 
 * @Description: 显示树结构
 * @author 大枫
 * @date 2016年1月16日 下午3:31:47 
 *
 */
public class TreeVO implements Serializable{

	private static final long serialVersionUID = -2009139626267156094L;
	/**
	 * 叶子id
	 */
	private Integer id;
	/**
	 * 叶子名称
	 */
	private String name;
	/**
	 * 枝干
	 */
	List<TreeVO> tree;
	
	@Override
	public String toString() {
		return "TreeVO [id=" + id + ", name=" + name + ", tree=" + tree + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TreeVO> getTree() {
		if(tree == null) {
			tree = new ArrayList<TreeVO>();
		}
		return tree;
	}
	public void setTree(List<TreeVO> tree) {
		this.tree = tree;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
