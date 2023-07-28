package br.com.ByteNest.PropertEase.models.realty;

public record RegisterRealtyData(
        String title,
        String description,
        String type,
        String address,
        Double area,
        Integer rooms,
        Integer bathroom,
        Double price,
        Integer status
) {
}
