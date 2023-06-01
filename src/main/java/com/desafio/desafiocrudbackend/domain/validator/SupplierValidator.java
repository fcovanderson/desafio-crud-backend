package com.desafio.desafiocrudbackend.domain.validator;

import java.util.Locale;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.desafio.desafiocrudbackend.api.dto.form.SupplierForm;
import com.desafio.desafiocrudbackend.domain.enums.SupplierType;
import com.desafio.desafiocrudbackend.domain.exception.BirthDateOrRGNotInformedException;
import com.desafio.desafiocrudbackend.domain.exception.InvalidCEPException;
import com.desafio.desafiocrudbackend.domain.util.CEPUtil;

@Component
public class SupplierValidator extends GenericValidator implements EntityValidator<SupplierForm> {
	
	@Override
	public void validate(SupplierForm supplierForm) {
		this.validateDataForNaturalPerson(supplierForm);
		this.validateCEP(supplierForm);
	}
	
	
	private void validateDataForNaturalPerson(SupplierForm supplierForm) {
		if (supplierForm.getSupplierType().equals(SupplierType.NATURAL_PERSON)) {
			if ((Objects.isNull(supplierForm.getRg()) || Objects.isNull(supplierForm.getBirthDate()))
					|| (supplierForm.getBirthDate().isBlank() || supplierForm.getRg().isBlank())) {
				throw new BirthDateOrRGNotInformedException(this.getMessageSource().getMessage("message.exception.supplier.data.not.informed", null, Locale.getDefault()));
			}
		}
	}
	
	private void validateCEP(SupplierForm supplierForm) {
		try {
			CEPUtil.getAddress(supplierForm.getCep());
		}catch(Exception e){
			throw new InvalidCEPException(this.getMessageSource().getMessage("message.exception.invalid.cep", null, Locale.getDefault()));
		}
	}
}
