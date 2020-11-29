package com.waracle.cakemgr.exceptions;

public class CakeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4989370633682743338L;

	public CakeNotFoundException() {
	}

	public CakeNotFoundException(String message) {
		super(message);
	}

}
