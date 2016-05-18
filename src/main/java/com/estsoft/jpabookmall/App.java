package com.estsoft.jpabookmall;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.estsoft.jpabookmall.domain.Book;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// 1. 엔티티 매니저 팩토리 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabookmall");

		// 2. 엔티티 매니저 생성
		EntityManager em = emf.createEntityManager();

		// 3. 트랜잭션 받기
		EntityTransaction tx = em.getTransaction();

		// 4. 트랜젹션 시작
		tx.begin();

		// 5. 비지니스 코드 실행
		try {
			// logic( em );
		insertLogic(em);
	//	InsertAndUpdateLogic(em);
		FindOneLogic(em);
	//	FindListLogic(em);
	//	FindOneAndDeleteLogic(em);
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		}
		// 6. 트랜잭션 커밋
		tx.commit(); // transaction logic에서 쓴 query들이 db에 반영되도록 함

		// 7. 엔티티 매니저 종료
		em.close();

		// 8. 엔티티 매니저 팩토리 닫기
		emf.close();

	}
	
	//insert logic!
	public static void insertLogic( EntityManager em ) {
	    Book book = new Book();
	  // book.setNo( 1L );
	    book.setTitle( "자바의 신" );
	    book.setDescription("자바책이당");
	    book.setPrice( 20000L );
	    
	    // 저장	
	    em.persist( book );
	}
	public static void InsertAndUpdateLogic( EntityManager em ) {
	    Book book = new Book();
	    book.setNo( 2L );
	    book.setTitle( "자바의 정석" );
	    book.setPrice( 30000L );
	    	
	    // 저장
	    em.persist( book );
	    	
	   // 가격 Update
	   book.setPrice( 50000L );
	}
	public static void FindOneLogic( EntityManager em ) {
	    // 조회
	    Book book = em.find( Book.class, 1L );
	    System.out.println( book );

	    book.setTitle("바꼈지롱");
	    System.out.println( book );
	}
	public static void FindListLogic( EntityManager em ) {
		   // 목록조회(JPQL)
		//entitymanager는  list가 없음 -> JPQL(Java Persistence Query Language)이용
		//b.*가 아님, book이 아니라 Book임(객체이름)
		//반드시 alias 이용해야함
		   TypedQuery<Book> query = em.createQuery( "select b from Book b", Book.class );
		    List<Book> list = query.getResultList();
		    	
		    for( Book book : list ) {
		          System.out.println( book );
		    }
		}
	public static void FindOneAndDeleteLogic( EntityManager em ) {
	    // 조회
	    Book book = em.find( Book.class, 2L );
	    	
	    // 삭제
	    em.remove( book );
	}

}
