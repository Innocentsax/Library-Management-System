package dev.Innocent.Services.ServiceImpl;

import dev.Innocent.Services.BookService;
import dev.Innocent.Services.CategoryService;
import dev.Innocent.Services.HomeService;
import dev.Innocent.Services.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class HomeServiceImpl implements HomeService {


    private MemberService memberService;
    private CategoryService categoryService;
    private BookService bookService;

    @Autowired
    public HomeServiceImpl(MemberService memberService, CategoryService categoryService, BookService bookService) {
        this.memberService = memberService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public Map<String, Long> getTopTilesMap() {
        Map<String, Long> map = new HashMap<String, Long>();
        map.put("totalMembers", memberService.getTotalCount());
        map.put("totalStudents", memberService.getStudentsCount());
        map.put("totalCategories", categoryService.getTotalCount());
        map.put("totalBooks", bookService.getTotalCount());
        map.put("totalIssuedBooks", bookService.getTotalIssuedBooks());
        return map;
    }
}
