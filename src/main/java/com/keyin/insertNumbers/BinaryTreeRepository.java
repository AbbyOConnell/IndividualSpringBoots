package com.keyin.insertNumbers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinaryTreeRepository extends CrudRepository<BinarySearchTree, Long> {
}
