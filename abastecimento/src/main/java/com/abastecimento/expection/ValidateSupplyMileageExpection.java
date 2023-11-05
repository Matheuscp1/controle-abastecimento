package com.abastecimento.expection;

public class ValidateSupplyMileageExpection extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public ValidateSupplyMileageExpection(String message) {
		super(message);
	}
}
