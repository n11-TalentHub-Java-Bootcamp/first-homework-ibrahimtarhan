package entityService;

import dao.CategoryDAO;
import entity.Category;

import java.util.List;

public class CategoryEntityService {
    private CategoryDAO categoryDAO;

    public CategoryEntityService() {
        this.categoryDAO  = new CategoryDAO();
    }

    public List<Category> findAll(){
        return  categoryDAO.findAll();
    }
}
