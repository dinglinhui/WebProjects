package com.kingnod.tool;

public class Setting {
	
	/**
	 * 操作类型
	 * @author JCN
	 *
	 */
	public enum ActionType{
		create("创建"),update("修改"),view("视图");
		private final String typeName;
		ActionType(final String typeName){
			this.typeName=typeName;
		} 
		public String getTypeName(){
			return typeName;
		}
	}

}
