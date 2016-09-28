package com.moon.vip.infra.vo.sys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class DynameicMenuVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3565610688424196036L;
	
	public String v;
	public String n;
	public String pId;
	public List<DynameicMenuVO> s = new ArrayList<DynameicMenuVO>();
	
	public DynameicMenuVO(String id, String name, String pId) {
		this.v = id;
		this.n = name;
		this.pId = pId;
	}
	
	public DynameicMenuVO(String id, String name, String pId, DynameicMenuVO... menuVo) {
		this.v = id;
		this.n = name;
		this.pId = pId;
		if(menuVo == null) {
			return;
		}
		for(DynameicMenuVO vo : menuVo){
			if(vo != null) {
				this.s.add(vo);
			}
		}
	}
	
	public void addDynameicMenuVO(DynameicMenuVO menuVo) {
		if(menuVo != null) {
			s.add(menuVo);
		}
	}
	public static void main(String[] args) {
		//大数据事业部相关父、子节点
		DynameicMenuVO uttuy = new DynameicMenuVO("526", "5uttuy", "34", null);
		DynameicMenuVO dsj = new DynameicMenuVO("129", "大数据", "34", null);
		DynameicMenuVO dba = new DynameicMenuVO("414", "DBA", "34", uttuy);
		DynameicMenuVO dsjb = new DynameicMenuVO("34", "大数据事业部", "3", dsj, dba);
		DynameicMenuVO rj = new DynameicMenuVO("3", "软件集群", "1", dsjb);
		
		System.out.println(JSON.toJSONString(rj));
		
		Integer a = 1;
		String b = "1";
		System.out.println(a.toString().equals(b));
	}

	@Override
	public String toString() {
		return "DynameicMenuVO [v=" + v + ", n=" + n + ", pId=" + pId + ", s=" + s + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((n == null) ? 0 : n.hashCode());
		result = prime * result + ((pId == null) ? 0 : pId.hashCode());
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		result = prime * result + ((v == null) ? 0 : v.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DynameicMenuVO other = (DynameicMenuVO) obj;
		if (n == null) {
			if (other.n != null)
				return false;
		} else if (!n.equals(other.n))
			return false;
		if (pId == null) {
			if (other.pId != null)
				return false;
		} else if (!pId.equals(other.pId))
			return false;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		if (v == null) {
			if (other.v != null)
				return false;
		} else if (!v.equals(other.v))
			return false;
		return true;
	}
}
