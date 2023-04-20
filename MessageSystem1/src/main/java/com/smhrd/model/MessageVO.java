package com.smhrd.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class MessageVO {
	
	private int num;
	private String send_name;
	private String receive_email;
	private String content;
	private String sendDate;

}
