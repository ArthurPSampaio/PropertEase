package br.com.ByteNest.PropertEase.models.employees;

import jakarta.validation.constraints.NotBlank;

public record RegisterEmployeeData (
        @NotBlank
        String name,
        @NotBlank
        String role,
        @NotBlank
        String email,
        @NotBlank
        String password,
        Boolean deleted
) {
}
