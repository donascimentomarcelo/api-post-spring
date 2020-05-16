package br.com.wikicode.serviceImpl;

import br.com.wikicode.domain.Comment;
import br.com.wikicode.domain.Post;
import br.com.wikicode.dto.CommentDTO;
import br.com.wikicode.dto.PostDTO;
import br.com.wikicode.reposiroty.CommentRepository;
import br.com.wikicode.service.CommentService;
import br.com.wikicode.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostService postService;

    @Override
    public Comment save(final CommentDTO dto) {
        final Post post = postService.findOne(dto.getPostId());
        Comment comment = new Comment(dto.getUserId(), dto.getUserName(), dto.getText(), new Date());
        comment = commentRepository.save(comment);
        post.addComment(comment);
        postService.update(post);
        return comment;
    }
}
