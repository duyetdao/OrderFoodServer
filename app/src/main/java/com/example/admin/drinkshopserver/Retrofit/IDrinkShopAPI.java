package com.example.admin.drinkshopserver.Retrofit;

import com.example.admin.drinkshopserver.Model.Category;
import com.example.admin.drinkshopserver.Model.Drink;
import com.example.admin.drinkshopserver.Model.Order;
import com.example.admin.drinkshopserver.Model.Token;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface IDrinkShopAPI {
    /*
        Category
    */

    @GET("getmenu.php")
    Observable<List<Category>> getMenu();

    @FormUrlEncoded
    @POST("server/category/add_category.php")
    Observable<String> addNewCategory(@Field("name") String name,@Field("imgPath") String imgPath);

    @Multipart
    @POST("server/category/upload_category_img.php")
    Call<String> uploadCategoryFile(@Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("server/category/update_category.php")
    Observable<String> updateCategory(@Field("id") String id,
                                      @Field("name") String name,
                                      @Field("imgPath") String imgPath);

    @FormUrlEncoded
    @POST("server/category/delete_category.php")
    Observable<String> deleteCategory(@Field("id") String id);

    /*
        Drink
    */
    @FormUrlEncoded
    @POST("getdrink.php")
    Observable<List<Drink>> getDrink(@Field("menuid") String menuID);

    @FormUrlEncoded
    @POST("server/product/add_product.php")
    Observable<String> addNewProduct(@Field("name") String name,
                                     @Field("imgPath") String imgPath,
                                     @Field("price") String price,
                                     @Field("menuId") String menuId);

    @Multipart
    @POST("server/product/upload_product_img.php")
    Call<String> uploadProductFile(@Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("server/product/update_product.php")
    Observable<String> updateProduct(@Field("id") String id,
                                     @Field("name") String name,
                                     @Field("imgPath") String imgPath,
                                     @Field("price") String price,
                                     @Field("menuId") String menuId);

    @FormUrlEncoded
    @POST("server/product/delete_product.php")
    Observable<String> deleteProduct(@Field("id") String id);

    /*
       Order
   */
    @FormUrlEncoded
    @POST("server/order/getorder.php")
    Observable<List<Order>> getAllOrder(@Field("status") String status);

    @FormUrlEncoded
    @POST("server/order/update_order_status.php")
    Observable<String> updateOrderStatus(@Field("phone") String phone,
                             @Field("order_id") long orderId,
                             @Field("status") int status);


    /*
       Token Update
   */

    @FormUrlEncoded
    @POST("updatetoken.php")
    Call<String> updateToken(@Field("phone") String phone,
                             @Field("token") String token,
                             @Field("issevertoken") String isServerApp);
    @FormUrlEncoded
    @POST("gettoken.php")
    Call<Token> getToken(@Field("phone") String phone,
                         @Field("issevertoken")String isSeverToken);
}