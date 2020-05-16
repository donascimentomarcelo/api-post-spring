package br.com.wikicode.service;

import br.com.wikicode.domain.Comment;
import br.com.wikicode.dto.CommentDTO;

public interface CommentService {
    Comment save(CommentDTO dto);
}
