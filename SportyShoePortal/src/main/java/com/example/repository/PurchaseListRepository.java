package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pojo.PurchaseList;
@Repository

public interface PurchaseListRepository extends JpaRepository <PurchaseList,Integer>{

}
