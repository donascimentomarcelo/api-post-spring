package br.com.wikicode.resource;

import br.com.wikicode.domain.Comment;
import br.com.wikicode.dto.CommentDTO;
import br.com.wikicode.service.BaseService;
import br.com.wikicode.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/comments")
public class CommentResource {

    @Autowired
    private BaseService baseService;

    @Autowired
    private CommentService commentService;

    @PostMapping
    ResponseEntity<?> save(@RequestBody CommentDTO dto) {
        Comment comment =  commentService.save(dto);
        URI uri = baseService.returnUri(comment.getId());
        return ResponseEntity.created(uri).build();
    }
}
