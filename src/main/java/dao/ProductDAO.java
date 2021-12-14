package dao;

import base.BaseDAO;
import dto.CommentsOfProductDTO;
import dto.ProductCommentCountDTO;
import dto.ProductDetailDTO;
import entity.Product;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDAO extends BaseDAO {
    //private SessionFactory sessionFactory;

    public ProductDAO() {
        //this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Product> findAll() {
        //Session session = sessionFactory.openSession();
        //Query query = session.createQuery("select product from Product product");
        Query query =getCurrentSession().createQuery("select product from Product product");
        return query.list();

    }
    public List<ProductDetailDTO> findAllProductDetailDTOByCategoryKirilim(Long kirilim) {

        String sql = " select " +
                " new dto.ProductDetailDTO( product.name, category.name, product.price ) " +
                " from Product product " +
                " left join Category category  on product.category.id = category.id " +
                " where category.kirilim = :kirilim ";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("kirilim", kirilim);

        return query.list();
    }

    public List<CommentsOfProductDTO> getCommentsByProductId(Long id) {

        String sql = " select " +
                " new dto.CommentsOfProductDTO( product.name, category.name, product.price, user.name, user.surname, user.email, user.phone, comment.comment, comment.commentDate ) " +
                " from  Category category " +
                " right join Product product  on product.category.id = category.id " +
                " right join CommentOfProduct comment  on product.id = comment.product.id " +
                " left join User user  on comment.user.id = user.id " +
                " where product.id = :id ";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("id", id);

        return query.list();
    }
    public List<ProductCommentCountDTO> getProductCommentCount() {

        String sql = " select " +
                " new dto.ProductCommentCountDTO( product.id, product.name, product.price,COUNT(comment.product.id)) " +
                " from  Product product " +
                " left join CommentOfProduct comment  on product.id = comment.product.id " +
                " group by product.id";

        Query query = getCurrentSession().createQuery(sql);
        //query.setParameter("id", id);

        return query.list();
    }
}
