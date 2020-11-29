package com.waracle.cakemgr.exceptions;

public class CakeIdMismatchException extends Exception {

	private static final long serialVersionUID = -6095032155571823181L;

	public CakeIdMismatchException() {
		super();
	}

	public CakeIdMismatchException(final String message) {
		super(message);
	}

	public CakeIdMismatchException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public CakeIdMismatchException(final Throwable cause) {
		super(cause);
	}
}
