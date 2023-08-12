package com.HTT.company.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.HTT.company.entity.Product;
import com.HTT.company.entity.Users;

@Transactional
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
	
	@Query(value = "SELECT * FROM Product", nativeQuery=true)
	List<Product> findAllUsers();

	@Query(value = "SELECT * FROM Product WHERE product_id = :product_id", nativeQuery=true)
	Product findByProductId(@Param("product_id") String product_id);
	
	@Modifying
	@Query(value = 
			 "UPDATE Users "
						+ "SET [; = :#{#entity.usersId}, "
						+ "product_color = :#{#entity.account_balance}, "
						+ "product_size = :#{#entity.number_phone}, "
						+ "product_amount = :#{#entity.number_phone}, "
						+ "product_tag = :#{#entity.number_phone}, "
						+ "product_category = :#{#entity.number_phone}, "
						+ "product_brand = :#{#entity.number_phone}, "
						+ "product_price = :#{#entity.number_phone}, "
						+ "product_rate_star = :#{#entity.number_phone}, "
						+ "product_video = :#{#entity.number_phone}, "
						+ "product_image = :#{#entity.number_phone}, "
						+ "product_thumnail = :#{#entity.number_phone}, "
						+ "product_description = :#{#entity.number_phone}, "
						+ "additional_infomation = :#{#entity.number_phone}, "
						+ "discount_time = :#{#entity.number_phone}, "
						+ "date_update = :#{#entity.number_phone}"
						+ "WHERE product_id = :#{#entity.user_name}" ,nativeQuery=true)
	Integer updateProduct(@Param("entity") Product product);
	
	
//	
//	@Query(value = "SELECT * FROM Users WHERE gmail = :gmail", nativeQuery=true)
//	Users findByGmail(@Param("gmail") String gmail);
//	
//	@Query(value = "SELECT * FROM Users WHERE gmail = :gmail", nativeQuery=true)
//	Users findByGmailAddress(@Param("gmail") String gmail);
//	
//	
//	@Modifying
//	@Query(value = 
//		  "INSERT INTO Users (user_name, pass_word, account_name, number_phone, gmail, avatar)"
//		+ "VALUES "
//		+ "(:#{#entity.username}, :#{#entity.password}, :#{#entity.accountName},:#{#entity.numberPhone}, :#{#entity.gmail}, :#{#entity.avatar})" ,nativeQuery=true)
//	Integer createUsers(@Param("entity") Users user);
//	
//	@Modifying
//	@Query(value = 
//		  "UPDATE Users "
//		+ "SET account_name = :#{#entity.account_name}, account_balance = :#{#entity.account_balance}, number_phone = :#{#entity.number_phone}, "
//		+ "avatar =  :#{#entity.avatar}, dataupdate = curdate() "
//		+ "WHERE user_name = :#{#entity.user_name}" ,nativeQuery=true)
//	Integer updateUsers(@Param("entity") Users user);
//	
//	@Modifying
//	@Query(value = 
//		  "UPDATE Users "
//		+ "SET is_exist = 0 WHERE account_name = :account_name", nativeQuery=true)
//	Integer deleteUsers(@Param("account_name") String codeDelete);
//	
}
