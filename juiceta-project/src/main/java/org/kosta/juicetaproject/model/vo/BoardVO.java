package org.kosta.juicetaproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BoardVO {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardTime;
	private int hits;
}
