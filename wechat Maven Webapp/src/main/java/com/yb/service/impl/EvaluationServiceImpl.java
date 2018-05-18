package com.yb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yb.dao.EvaluationDao;
import com.yb.entity.Evaluation;
import com.yb.service.EvaluationService;

@Service
public class EvaluationServiceImpl implements EvaluationService{

	@Autowired
	private EvaluationDao evaluationDao;
	@Override
	public Evaluation queryById(String id) {
		// TODO Auto-generated method stub
		Evaluation queryEvaluation = evaluationDao.queryEvaluation(id);
		return queryEvaluation;
	}

}
