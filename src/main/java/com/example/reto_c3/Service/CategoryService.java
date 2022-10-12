package com.example.reto_c3.Service;

import com.example.reto_c3.Model.Category;
import com.example.reto_c3.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category){
        if (category.getId() == null){
            return categoryRepository.save(category);
        }else {
            Optional<Category> categoryEcncontrado = getCategory(category.getId());
            if (categoryEcncontrado.isEmpty()){
                return categoryRepository.save(category);
            }else {
                return category;
            }
        }
    }

    public Category update(Category category){
        if (category.getId() != null){
            Optional<Category> categoryEncontrado = getCategory(category.getId());
            if (!categoryEncontrado.isEmpty()){
                if (category.getDescription() != null){
                    categoryEncontrado.get().setDescription(category.getDescription());
                }
                if (category.getName() != null){
                    categoryEncontrado.get().setName(category.getName());
                }
                return categoryRepository.save(categoryEncontrado.get());
            }
        }
        return category;
    }

    public boolean delete(int id){
        Boolean respuesta = getCategory(id).map(elemento ->{
            categoryRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
