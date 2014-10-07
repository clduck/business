package com.business.util.tree;

import java.util.ArrayList;
import java.util.List;

import com.business.util.common.ConstConfig;

public class EasyUITreeUtils {

	/**
	 * 把原来一维的list转为多维list
	 * @param oldlist 原来列表
	 * @param pid 如果不为null ，则只需要第一层中父id为pid的节点
	 * @return List 多维列表
	 */
	public static List<EasyUITreeBean> makeDwrChildTree(List<EasyUITreeBean> oldlist,String pid){
       List<EasyUITreeBean> retl = new ArrayList<EasyUITreeBean>();
		
		if(oldlist==null) return retl;
		//pid list  父节点id列表
		List<String> pidlist = new ArrayList<String>();
		for (EasyUITreeBean tb : oldlist) {
			pidlist.add(tb.getPid());
		}
		//获取第一级的节点进行遍历，若不是第一级节点则继续
		for (int i = 0; i < pidlist.size(); i++) {
			if (pidlist.get(i).equals(pid)) {
				EasyUITreeBean tbean = oldlist.get(i);
				tbean.setState(ConstConfig.EASYUI_TREE_STATE_OPEN);
				addChildren(pidlist,oldlist,tbean);
				retl.add(tbean);
			}else continue;
		}
		return retl;
	}
	/**
	 * 向tbean中添加他的孩子 ，孩子下标从pidlist中取,实体从oldlist中取，pidlist与oldlist下标一致
	 * @param pidlist 父级id列表
	 * @param oldlist 实体列表
     * @param tbean 树Bean
	 */
	private static void addChildren(List<String> pidlist,List<EasyUITreeBean> oldlist, EasyUITreeBean tbean) {
		for (int i = 0; i < pidlist.size(); i++) {
			if(pidlist.get(i).equals(tbean.getId())){
				EasyUITreeBean bean = oldlist.get(i);
				addChildren(pidlist,oldlist,bean);
				tbean.appendChildren(bean);
			}
		}
	}
	public static void main(String[] args) {
		List<EasyUITreeBean> l = new ArrayList<EasyUITreeBean>();
		EasyUITreeBean b = new EasyUITreeBean();
		
		b = new EasyUITreeBean();
		b.setId("1");
		b.setPid("0");
		l.add(b);
		
			b = new EasyUITreeBean();
			b.setId("11");
			b.setPid("1");
			l.add(b);
			
			b = new EasyUITreeBean();
			b.setId("12");
			b.setPid("1");
			l.add(b);
			
				b = new EasyUITreeBean();
				b.setId("121");
				b.setPid("12");
				l.add(b);
				
					b = new EasyUITreeBean();
					b.setId("1211");
					b.setPid("121");
					l.add(b);
			
		b = new EasyUITreeBean();
		b.setId("2");
		b.setPid("0");
		l.add(b);
		
			b = new EasyUITreeBean();
			b.setId("21");
			b.setPid("2");
			l.add(b);
		
		b = new EasyUITreeBean();
		b.setId("3");
		b.setPid("-1");
		l.add(b);
		
		
		//List<DwrTreeBean> retl = makeDwrChildTree(l, null);
		List<EasyUITreeBean> retl = makeDwrChildTree(l, "0");
		
		//expandedTree(6,retl);
		
		
		for (EasyUITreeBean bb : retl) {
			System.out.println(bb.getPid()+"  "+bb.getId()+"  "+bb.getState());
			
			for (int j=0;j< bb.getChildren().size();j++){
				EasyUITreeBean bb2 = bb.getChildren().get(j);
				System.out.println("  child"+bb2.getPid()+"  "+bb2.getId()+"  "+bb2.getState());
				
				for (EasyUITreeBean bb3 : bb2.getChildren()) {
					System.out.println("    child"+bb3.getPid()+"  "+bb3.getId()+"  "+bb3.getState());
					
					for (EasyUITreeBean bb4 : bb3.getChildren()) {
						System.out.println("        child"+bb4.getPid()+"  "+bb4.getId()+"  "+bb4.getState());
					}
					
				}
			}
		}
	}
}
