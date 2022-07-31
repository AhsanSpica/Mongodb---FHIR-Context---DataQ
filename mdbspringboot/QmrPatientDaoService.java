package com.example.mdbspringboot;

import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

        @Repository
        @Transactional
        public class QmrPatientDaoService {
        @PersistenceContext
            private EntityManager entityManager;
        public long insert(Patient patient)
        {
            entityManager.persist(patient);
            return patient.getId();
        }

        }
