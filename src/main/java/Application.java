import dao.CategoryDAO;
import dao.ProductDAO;
import dto.CommentsOfProductDTO;
import dto.ProductCommentCountDTO;
import dto.ProductDetailDTO;
import entity.Category;
import entity.Product;
import entityService.CategoryEntityService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        //CategoryDAO categoryDAO = new CategoryDAO();
        //categoryDAO.findAll();

        CategoryEntityService categoryEntityService = new CategoryEntityService();
        ProductDAO productDAO = new ProductDAO();

        List<Product> products = productDAO.findAll();
        for(Product product : products){
            //System.out.println(product.toString()+product.getCategory().getName() + product.getCategory().getParentCategory().getName());
        }
        //Long a = Long.valueOf(1);
        List<ProductDetailDTO> productdetail = productDAO.findAllProductDetailDTOByCategoryKirilim(3L);
        for(ProductDetailDTO productDetailDTO : productdetail){
           // System.out.println(productDetailDTO.toString());
        }

        List<CommentsOfProductDTO> commentList = productDAO.getCommentsByProductId(1L);
        for(CommentsOfProductDTO commentsOfProductDTO : commentList){
            System.out.println(commentsOfProductDTO.toString());
        }

        List<Category> categoryList = categoryEntityService.findAll();
        for(Category category : categoryList){
            //System.out.println(category.toString());
        }

        List<ProductCommentCountDTO> productCommentCountDTOList = productDAO.getProductCommentCount();
        for(ProductCommentCountDTO commentCountDTO : productCommentCountDTOList){
            System.out.println(commentCountDTO.getProductId() + commentCountDTO.getProductName() + commentCountDTO.getPrice() + "--"+commentCountDTO.getCommentCount());
        }
    }
}
