package com.estsoft.jpabookmall.domain;

import javax.persistence.Column;
//이건 jpa를 사용하는 것임
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/*
 * 이걸 쓰면 hibernate의 독자적인 기능을 이용하는 것임
 * import org.hibernate.annotations.Entity;
*/
//이 class는 sql 결과로 값을 받는 entity가 아니라 domain역할을 할 것임
//class와 table을 mapping하는 것을 JPA에게 알려주는 것을 의미함 ---> ENTITY CLASS
@Entity
// table이 되었을 때의 이름 / 안쓰면 classname으로 생성됨
@Table(name = "book")
public class Book {
	// 안써주면 table의 동일한 이름의 column과 mapping됨
	@Column(name = "no")
	// primary key
	@Id
	//PRIMARY KEY의 AUTO-INC. 확인
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long no;
	@Column(name = "title")
	private String title;
	@Column(name = "price")
	private Long price;
	//constraint : null이안됨
	@Column(name = "description", nullable=false)
	private String description;
	//객체가 있으면 test가 있는데, table에 test field가 없도록! transient를 붙여줌
	//transient: 영속화 시키지 않겠다!(db에 넣지않겠다!!!!)
	@Transient
	private String test;	 

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Book [no=" + no + ", title=" + title + ", price=" + price + ", description=" + description + ", test="
				+ test + "]";
	}




}
