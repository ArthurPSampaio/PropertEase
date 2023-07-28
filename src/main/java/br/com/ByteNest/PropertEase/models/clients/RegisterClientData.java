package br.com.ByteNest.PropertEase.models.clients;


public record RegisterClientData(

        String name,
        String email,
        String phone,
        String preferences) {

}
