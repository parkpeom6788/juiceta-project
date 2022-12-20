package org.kosta.juicetaproject.service;

import org.kosta.juicetaproject.model.mapper.ProductMapper;
import org.kosta.juicetaproject.model.vo.Content;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {
	private final ProductMapper productMapper;

	@Override
	public void writeContent(Content content) {
		productMapper.registerContent(content);
	}

}
