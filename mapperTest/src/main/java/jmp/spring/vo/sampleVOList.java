package jmp.spring.vo;

import java.util.ArrayList;

import lombok.Data;

@Data
public class sampleVOList {
	ArrayList<sampleVO> list;
	
	public void SampleVOList() {
		list = new ArrayList<sampleVO>();
		System.out.println("list : " + list);
	}
}
