import Dao.GoodColorDao;
import Domain.GoodColor;
import Domain.GoodGroup;
import Domain.GoodSize;
import Domain.Product;

public class Test {
    public static void main(String[] args) {
        testConfig();
    }

    public static void testConfig(){
        GoodColor goodColor1 = new GoodColor();
        GoodColor goodColor2 = new GoodColor();
        GoodColor goodColor3 = new GoodColor();
        GoodColor goodColor4 = new GoodColor();

        goodColor1.setGoodColorName("No color");
        goodColor2.setGoodColorName("Black");
        goodColor3.setGoodColorName("Green");
        goodColor4.setGoodColorName("Red");

        GoodSize goodSize1 = new GoodSize();
        GoodSize goodSize2 = new GoodSize();
        GoodSize goodSize3 = new GoodSize();
        GoodSize goodSize4 = new GoodSize();

        goodSize1.setGoodSizeName("One size");
        goodSize2.setGoodSizeName("155sm");
        goodSize3.setGoodSizeName("Full");
        goodSize4.setGoodSizeName("Cob");

        GoodGroup goodGroup1 = new GoodGroup();
        GoodGroup goodGroup2 = new GoodGroup();
        GoodGroup goodGroup3 = new GoodGroup();
        GoodGroup goodGroup4 = new GoodGroup();

        goodGroup1.setGoodGroupName("Попоны");
        goodGroup2.setGoodGroupName("Недоуздки");
        goodGroup3.setGoodGroupName("Уздечки");
        goodGroup4.setGoodGroupName("Попоны флисовые");

        Product product1 = new Product(10201, "Недоуздок Full", goodColor2, goodSize3, goodGroup2);
        Product product2 = new Product(10201, "Недоуздок Cob", goodColor3, goodSize4, goodGroup2);
        Product product3 = new Product(10505, "Попона флис", goodColor2, goodSize1, goodGroup1);
        Product product4 = new Product(10502, "Попона дождь", goodColor4, goodSize2, goodGroup1);

        GoodColorDao goodColorDao = new GoodColorDao();
        goodColorDao.create(goodColor1);
        goodColorDao.create(goodColor2);
        goodColorDao.create(goodColor3);
        goodColorDao.create(goodColor4);

        goodColorDao.create(goodSize1);
        goodColorDao.create(goodSize2);
        goodColorDao.create(goodSize3);
        goodColorDao.create(goodSize4);

        goodColorDao.create(goodGroup1);
        goodColorDao.create(goodGroup2);
        goodColorDao.create(goodGroup3);
        goodColorDao.create(goodGroup4);

        goodColorDao.create(product1);
        goodColorDao.create(product2);
        goodColorDao.create(product3);
        goodColorDao.create(product4);


        goodColorDao.readAll("FROM GoodSize");
        goodColorDao.readAll("FROM Product");


        product2.setGoodSize(goodSize3);
        product3.setGoodSize(goodSize2);

        goodColorDao.readAll("FROM Product");
        goodColorDao.readAll("FROM Product P WHERE P.goodSize.Id = 2");

//        goodColorDao.update(product2);
//        goodColorDao.update(product3);
//
//        goodColorDao.readAll("from Product where goodSize.Id = 2");

        goodColorDao.sessionClose();
    }
}
