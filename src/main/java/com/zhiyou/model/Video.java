package com.zhiyou.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    
	private Integer id;
	private String course_tittle;
	private String course_desc;
	private Integer subject_id;
	
}
