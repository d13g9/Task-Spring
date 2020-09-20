package com.dw3.app.controller;

public class TaksNotfoundExcpetion extends Exception {

	public TaksNotfoundExcpetion(Long id) {
		super("Cannot find the task id: "+id);
	}
		
}
