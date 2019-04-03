package com.cremoso.resources;

import com.cremoso.model.Tag;
import com.cremoso.repository.TagRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tags")
public class TagResource {

    private TagRepository repository;

    public TagResource(TagRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Tag> getAll(){
        return repository.findAll();
    }

    @PostMapping
    @PreAuthorize("isAnonymous()")
    public Tag create(@RequestBody Tag tag){
        return repository.save(tag);
    }
}
