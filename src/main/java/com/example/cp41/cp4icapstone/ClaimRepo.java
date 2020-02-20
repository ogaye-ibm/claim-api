package com.example.cp41.cp4icapstone;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ClaimRepo extends CrudRepository<Claim, Long> {
}


