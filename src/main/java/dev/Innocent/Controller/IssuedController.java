package dev.Innocent.Controller;

import dev.Innocent.Model.Category;
import dev.Innocent.Model.Issued;
import dev.Innocent.Services.CategoryService;
import dev.Innocent.Services.IssuedService;
import dev.Innocent.Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/issued")
public class IssuedController {

    private IssuedService issueService;
    private CategoryService categoryService;

    @Autowired
    public IssuedController(IssuedService issueService, CategoryService categoryService) {
        this.issueService = issueService;
        this.categoryService = categoryService;
    }

    @GetMapping("/memberTypes")
    public ResponseEntity<List<String>> getMemberTypes() {
        List<String> memberTypes = Constants.MEMBER_TYPES;
        return new ResponseEntity<>(memberTypes, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.getAllBySort();
    }

    @GetMapping({"/", "/list"})
    public ResponseEntity<List<Issued>> listIssues() {
        List<Issued> issues = issueService.getAllUnreturned();
        return new ResponseEntity<>(issues, HttpStatus.OK);
    }
}
