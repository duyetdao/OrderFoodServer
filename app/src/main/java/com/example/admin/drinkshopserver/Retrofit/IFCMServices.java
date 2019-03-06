package com.example.admin.drinkshopserver.Retrofit;

import com.example.admin.drinkshopserver.Model.DataMessage;
import com.example.admin.drinkshopserver.Model.MyResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IFCMServices {
    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAsqLPxI0:APA91bHzrbV3L4LNMkNUi5wydrN-rBBDUbVzgXeXDb3UJYgH2T1AkjJ4E_a9lWXXOym0trrw6FqffGW-uYc75jzIM0DdMlCthgiX39XjarFyBY1VZuUF7MVxjUXdOrvc6j8QfW-jfVlm"
    })
    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body DataMessage body);
}
