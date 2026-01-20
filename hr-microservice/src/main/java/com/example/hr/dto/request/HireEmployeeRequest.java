package com.example.hr.dto.request;

import java.util.List;

import com.example.constraints.Iban;
import com.example.constraints.TcKimlikNo;
import com.example.hexagonal.helper.DataTransferObject;
import com.example.hexagonal.helper.TransferDirectionType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@DataTransferObject(TransferDirectionType.INBOUND)
public record HireEmployeeRequest(
		@TcKimlikNo
		String identity, 
		@Size(min = 2)
		String firstName, 
		@Size(min = 2)
		String lastName, 
		@Iban
		String iban,
		@Min(30_000)
		double salary,
		@NotBlank
		String currency,
		@Email
		String email,
		@Max(2010)
		int birthYear, 
		@NotBlank
		String jobStyle, 
		List<String> departments,		
		String photo
) {

}
