package com.JinWook.Toy.WebService.JinWookWebPj.Repository;

import com.JinWook.Toy.WebService.JinWookWebPj.Dto.BoardDto;
import com.JinWook.Toy.WebService.JinWookWebPj.Dto.QBoardDto;
import com.JinWook.Toy.WebService.JinWookWebPj.Dto.SearchBoardParamDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.JinWook.Toy.WebService.JinWookWebPj.Entity.QBoard.board;

@Repository
@RequiredArgsConstructor
public class BoardQuery {

	private final JPAQueryFactory query;
	private final EntityManager em;

	public List<BoardDto> findBoard(SearchBoardParamDto paramDto){
		return query.select(new QBoardDto(
						board.id,
						board.title,
						board.author
		)).from(board)
						.fetch();
	}

}
