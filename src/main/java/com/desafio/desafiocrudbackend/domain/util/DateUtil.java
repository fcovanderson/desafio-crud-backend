package com.desafio.desafiocrudbackend.domain.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import com.desafio.desafiocrudbackend.domain.exception.InvalidBirthDateFormatException;

public class DateUtil {
	
	public static Date convertFormatedDateToDateFormat(String data) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		if (Objects.nonNull(data)) {
			try {
				Date dataFormatada = format.parse(data);
				return dataFormatada;
			} catch (ParseException e) {
				e.printStackTrace();
				throw new InvalidBirthDateFormatException(e.getMessage());
			}
		}
		return null;
	}
}
