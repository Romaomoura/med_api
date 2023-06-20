package dev.romoura.api.domain.record;

import dev.romoura.api.domain.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoRecord(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotBlank
       // @Pattern(regexp = "\\d{4,6}")
        String telefone,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        EnderecoRecord endereco) {
}
