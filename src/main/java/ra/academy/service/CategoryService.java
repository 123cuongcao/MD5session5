package ra.academy.service;

import lombok.RequiredArgsConstructor;
import ra.academy.repository.ICategoryRepository;

@RequiredArgsConstructor
public class CategoryService implements ICategoryService{
    private final ICategoryRepository iCategoryRepository;
}
