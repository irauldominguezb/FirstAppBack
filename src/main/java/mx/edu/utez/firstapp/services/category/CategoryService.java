package mx.edu.utez.firstapp.services.category;

import mx.edu.utez.firstapp.models.category.Category;
import mx.edu.utez.firstapp.models.category.CategoryRepository;
import mx.edu.utez.firstapp.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Category>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false, 200, "OK"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Category> getOne(Long id) {
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false, 200, "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Category> insert(Category category) {
        if (this.repository.existsByName(category.getName()))
            return new CustomResponse<>(
                    null, true, 400,
                    "La categoría ya se ha registrado"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(category),
                false, 200,
                "Categoría registrada correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Category> update(Category category) {
        if (!this.repository.existsById(category.getId()))
            return new CustomResponse<>(
                    null, true, 400,
                    "La categoría no existe"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(category),
                false, 200,
                "Categoría registrada correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    @Modifying
    public CustomResponse<Boolean> changeStatus(Category category) {
        if (!this.repository.existsById(category.getId()))
            return new CustomResponse<>(
                    null, true, 400,
                    "La categoría no existe"
            );
        return new CustomResponse<>(
                this.repository.updateStatusById(
                        category.getStatus(), category.getId()) == 1,
                false, 200,
                "Categoría registrada correctamente"
        );
    }

}
