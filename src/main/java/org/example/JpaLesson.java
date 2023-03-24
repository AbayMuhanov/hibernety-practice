package org.example;

import javax.persistence.*;

public class JpaLesson {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager manager = factory.createEntityManager();

//        Category category = manager.find(Category.class, 2L);
//        System.out.println(category.getName());

//        Product product = manager.find(Product.class,3L);
//        System.out.println(product.getCategory().getName());
//        System.out.println(product.getName());
//        System.out.println(product.getPrice());

//        Category category = manager.find(Category.class, 1L);
//        List<Product> products = category.getProducts();
//        System.out.printf("%s:%n",category.getName());
//        for (Product product : products) {
//            System.out.printf("- %s(%d)%n", product.getName(),product.getPrice());
//        }


//            Category category = new Category();
//            category.setName("Мониторы");
//            manager.persist(category);

//            Category category = manager.find(Category.class, 3L);
//            manager.remove(category);

//            Product product = new Product();
//            Category category = manager.find(Category.class, 2L);
//            product.setCategory(category);
//
//            product.setName("Kingston HyperX Cloud 2");
//            product.setPrice(98990);
//
//            manager.persist(product);

//            Product product = manager.find(Product.class, 5L);
//            product.setPrice((int)(product.getPrice() * 1.05));
//

//        try {
//            manager.getTransaction().begin();
//            Query query = manager.createQuery(
//                    "update Product p set p.price = p.price * 1.1 where p.category.id= 2"
//            );
//            query.executeUpdate();
//
//            manager.getTransaction().commit();
//        } catch (Exception e) {
//            manager.getTransaction().rollback();
//            e.printStackTrace();
//        }


//        TypedQuery<Category> categoryTypedQuery = manager.createQuery(
//                "select c from Category c order by c.name", Category.class
//        );
//        List<Category> categories = categoryTypedQuery.getResultList();
//        for (Category category : categories) {
//            System.out.printf("%s:%n", category.getName());
//            for (Product product : category.getProducts()) {
//                System.out.printf("- %s(%d)%n", product.getName(), product.getPrice());
//            }
//        }

//        int minPrice = 100_000;
//        int maxPrice = 200_000;
//
//        TypedQuery<Product> productTypedQuery = manager.createQuery(
////                "select p from Product p where p.price between ?1 and ?2", Product.class
//                "select p from Product p where p.price between :min_price and :max_price", Product.class
//        );
//
////        productTypedQuery.setParameter(1, minPrice);
////        productTypedQuery.setParameter(2, maxPrice);
//
//        productTypedQuery.setParameter("min_price", minPrice);
//        productTypedQuery.setParameter("max_price", maxPrice);
//
//        List<Product> products = productTypedQuery.getResultList();
//        for (Product product : products) {
//            System.out.printf("%s (%d)%n", product.getName(), product.getPrice());
//        }

        int minPrice = 100_000;
        int maxPrice = 200_000;

        TypedQuery<Long> productTypeQuery = manager.createQuery(
                "select count (p.id) from Product p where p.price between ?1 and ?2", Long.class
        );

        productTypeQuery.setParameter(1, minPrice);
        productTypeQuery.setParameter(2, maxPrice);
        long productCount = productTypeQuery.getSingleResult();
        System.out.println(productCount);

    }
}