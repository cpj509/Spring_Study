package org.pj.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleVO {	//AllArgsConstructor는 모든 속성을 사용하는 생성자, NoArgsConstructor는 비어있는 생성자를 만들기 위해 사용.
	private Integer mno;
	private String firstName;
	private String lastName;
}
