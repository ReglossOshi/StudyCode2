package com.humanedu.starbucks.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FreeBoardVO {
	private int num;
	private String id;
	private String pw;
	private String name;
	private String hp;
	private String email;
	private String hompy;
	private String subject;
	private String content;
	private int hit;
	private String regdate;
	private String file1Path;
	private String file2Path;
}
