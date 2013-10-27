package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.domain.Scheme;

public interface IDaoOffer extends JpaRepository<Scheme, Long> {

}
