package br.com.ByteNest.PropertEase.models.employees;

public record RegisterEmployeeData(
        String name,
        String role,
        String email,
        String password
) {
}
