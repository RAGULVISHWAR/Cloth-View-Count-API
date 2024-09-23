package com.example.ragulshop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.ragulshop.Entity.Clothes;

import jakarta.transaction.Transactional;

public interface ShopRepo extends JpaRepository<Clothes,Integer>{
	@Modifying
	@Transactional
	@Query(value="update clothes c set c.cviewcount = ?1 where c.id = ?2",nativeQuery=true)
	int updateview(int viewcount,int id);
	@Query(value="select * from clothes where cviewcount = (select max(cviewcount) from clothes)",nativeQuery=true)
	public  List<Clothes> Maxviewcount();

}
//id int auto_increment primary key,
//cname varchar(225),
//cprice decimal(10,2),
//cviewcount int default 0