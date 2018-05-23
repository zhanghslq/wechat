package com.yb.service;

import java.util.List;

import com.yb.entity.Banner;

public interface MatchService {
	List<Banner>queryBanner(String code);
}
