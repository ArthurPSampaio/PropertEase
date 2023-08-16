package br.com.ByteNest.PropertEase.models.realty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRealtyData(
        @NotBlank
        String title,
        @NotBlank
        String description,
        @NotBlank
        String type,
        @NotBlank
        String address,
        @NotNull
        Double area,
        @NotNull
        Integer rooms,
        @NotNull
        Integer bathroom,
        @NotNull
        Double price,
        Integer status
) {
}
