package com.example.admin.drinkshopserver.Utils;

import com.example.admin.drinkshopserver.Model.Category;
import com.example.admin.drinkshopserver.Model.Drink;
import com.example.admin.drinkshopserver.Model.Order;
import com.example.admin.drinkshopserver.Retrofit.FCMRetrofitClient;
import com.example.admin.drinkshopserver.Retrofit.IDrinkShopAPI;
import com.example.admin.drinkshopserver.Retrofit.IFCMServices;
import com.example.admin.drinkshopserver.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

public class Common {

    public static Category currentCategory;
    public static Drink currentDrink;
    public static Order currentOrder;

    public static List<Category> menuList = new ArrayList<>();

    public static final String BASE_URL = "http://androidnetworking.dakdesign.net/drinkshop/";
    public static final String FCM_URL = "https://fcm.googleapis.com/";

    public static IDrinkShopAPI getAPI()
    {
        return RetrofitClient.getClient(BASE_URL).create(IDrinkShopAPI.class);

    }
    public static IFCMServices getFCMAPI()
    {
        return FCMRetrofitClient.getClient(FCM_URL).create(IFCMServices.class);

    }

    public static String convertCodeToStatus(int orderStatus){
        switch (orderStatus){
            case 0:
                return "Placed";
            case 1:
                return "Processed";
            case 2:
                return "Shipping";
            case 3:
                return "Shiped";
            case -1:
                return "Cancelled";
            default:
                return "Order Error";
        }
    }

    public static String convertCodeToSatus(int orderstatus) {
        switch (orderstatus)
        {
            case 0:
                return "Placed";
            case 1:
                return "Processed";
            case 2:
                return "Shipping";
            case 3:
                return "Shipped";
            case -1:
                return "Cancelled";
            default:
                return "Order Error";
        }
    }
}
