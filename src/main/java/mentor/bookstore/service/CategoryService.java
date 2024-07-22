package mentor.bookstore.service;

import lombok.RequiredArgsConstructor;
import mentor.bookstore.dto.requestdto.CategoryRequestDto;
import mentor.bookstore.dto.responsedto.CategoryResponseDto;
import mentor.bookstore.entity.Category;
import mentor.bookstore.repo.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;

    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = modelMapper.map(categoryRequestDto, Category.class);
        return modelMapper.map(categoryRepo.save(category), CategoryResponseDto.class);
    }

    public List<CategoryResponseDto> getAllCategories() {
        List<Category> categoryList = categoryRepo.findAll();
        return categoryList.stream()
                .map(e -> modelMapper.map(e, CategoryResponseDto.class))
                .toList();
    }

    public CategoryResponseDto getCategoryById(Long id) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        return modelMapper.map(category, CategoryResponseDto.class);
    }

    public CategoryResponseDto deleteCategoryById(Long id) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        categoryRepo.deleteById(id);
        return modelMapper.map(category, CategoryResponseDto.class);
    }
}
