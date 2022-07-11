package com.aizoon.project.model;

public interface IEntity<DREQ,DRES> {
	
	public DRES copyTo();
	
	public void copyFrom(DREQ req);
	
}
