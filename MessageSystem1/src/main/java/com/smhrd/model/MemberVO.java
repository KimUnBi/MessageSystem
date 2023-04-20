package com.smhrd.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class MemberVO {
	
	private String email;
	private String pw;
	private String tel;
	private String address;

}
