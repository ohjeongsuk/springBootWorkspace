package com.zeus.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Member {
	//userId가 null이 아니고 trim한 길이가(공백을 제외) 0보다 크다는 것을 검사
	@NotBlank
	private String userId; 
	private String password; 
	@NotBlank
	@Size(max = 3)
	private String userName;
	@Email
	private String email;
	private String introduction;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	private boolean foreigner;
	private List<String> hobbyList;
	private List<String> hobbyValue;
	private Map<String, String> hobbyMap;
	
//	private List<CodeLabelValue> hobbyList;
	
	
}
