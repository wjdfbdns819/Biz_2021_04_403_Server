package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok을 이용해서 getter, setter 등을 세팅
@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
public class BookVO {

	// table의 칼럼이름과 같은 방식으로 사용하기 (헷갈리지 않게)
	private String bk_isbn;
	private String bk_title;
	private String bk_ccode;
	private String bk_acode;
	private String bk_date;
	
	// 0으로 초기화
	private Integer bk_price = 0;
	private Integer bk_pages = 0;
	
	// private으로 만들면 접근하기 위해 getter와 setter를 만들어야 함
}
